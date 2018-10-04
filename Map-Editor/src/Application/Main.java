package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Map Editor");
        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(576);
        primaryStage.setScene(new Scene(root, 300, 275));
        //

        //Graph graph= new MultiGraph("mg");

        //FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        //graph.addNode("A");

        //FxViewPanel v =  (FxViewPanel) viewer.addDefaultView( false ) ;

        //primaryStage.setScene(new Scene(v, 800, 600));

        primaryStage.show();
    }


    public static void main(String[] args) {
     //   System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        launch(args);
    }
}
