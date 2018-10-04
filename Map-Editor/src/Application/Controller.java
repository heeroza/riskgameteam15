package Application;

import CustomDialogs.ContinentDialogController;
import CustomDialogs.TerritoryDialogController;
import Objects.Continent;
import Objects.Territory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;



import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private Button addContinentBtn;
    @FXML private Button AddTerritoryBtn;
    @FXML private VBox GraphVBox;
    @FXML private TableView<Territory> TerritoriesTableView;
    @FXML private TableColumn<Territory,String> TerritoriesTableView_Name;
    @FXML private TableColumn<Territory,String> TerritoriesTableView_Continents;

   // Map<String, ArrayList<Territory>> multiMap = new HashMap<>();

    @FXML private TableView<Continent> ContinentTableView;
    @FXML private TableColumn<Continent,String> continentTableView_continentNames;
    @FXML private TableColumn<Continent,Integer> continentTableView_Bonus;

    private Integer i =0;

    private ObservableList<Continent> ContinentList;
    private ObservableList<Territory> TerritoryList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     //  addContinentBtn.setText("Test");
        //GraphTilePane.set
        Graph graph= new MultiGraph("mg");
        ContinentList =  FXCollections.observableArrayList();
        TerritoryList = FXCollections.observableArrayList();

        continentTableView_continentNames.setCellValueFactory(new PropertyValueFactory<>("name"));
        continentTableView_Bonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        ContinentList.add(new Continent("Aisa",1));
        ContinentTableView.setItems(ContinentList);


        TerritoriesTableView_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TerritoriesTableView_Continents.setCellValueFactory(new PropertyValueFactory<>("country"));
        TerritoriesTableView.setItems(TerritoryList);


        FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);

        graph.addNode("A");
        graph.addNode( "B");
        FxViewPanel v =  (FxViewPanel) viewer.addDefaultView( false ) ;

        GraphVBox.getChildren().add(v);

        addContinentBtn.setOnMouseClicked(event -> {
            Parent  root;
            Stage stage = new Stage();
            FXMLLoader loader;
            try{
                loader = new FXMLLoader(getClass().getResource("../CustomDialogs/ContinentDialog.fxml"));
                root = (Parent)loader.load();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.showAndWait();
                ContinentDialogController continentDialogController = loader.getController();
                ContinentList.add(new Continent( continentDialogController.getName(), continentDialogController.getBonus()));
                System.out.println();
            }catch (Exception e){
                System.out.println(e);
            }
        });

        AddTerritoryBtn.setOnMouseClicked(event -> {
            Parent  root;
            Stage stage = new Stage();
            FXMLLoader loader;
            try{
                loader = new FXMLLoader(getClass().getResource("../CustomDialogs/TerritoryDialog.fxml"));
                root = (Parent)loader.load();
                TerritoryDialogController territoryDialogController = loader.getController();
                territoryDialogController.setContinents(ContinentList);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.showAndWait();

                TerritoryList.add(new Territory( territoryDialogController.getName(),   territoryDialogController.getContinentName()));


                //ContinentList.add(new Continent( continentDialogController.getName(), continentDialogController.getBonus()));
               // System.out.println();
            }catch (LoadException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e);
            }

        });


    }
}
