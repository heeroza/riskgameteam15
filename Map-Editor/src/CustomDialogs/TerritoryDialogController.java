package CustomDialogs;

import Objects.Continent;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class TerritoryDialogController {


        private ObservableList<Continent> continents;

        @FXML ComboBox ContinentComboBox;
    @FXML
    AnchorPane AddTerritoryPane;
    @FXML
    TextField nameTextField;

        private String name;
        private String continentName;

        public TerritoryDialogController(){




        }

        public void show() {




        }

        public void HandleSubmit(){
           /* System.out.println("lol");
            name = nameTextField.getText();
            continentName = BonusTextField.getText();
            // stage.close();*/

            Continent temp =(Continent) ContinentComboBox.getValue();
            System.out.println( temp.getName() );
            name = nameTextField.getText();
            continentName =  temp.getName();
            Stage stage = (Stage) AddTerritoryPane.getScene().getWindow();
            stage.close();
        }
        public String getName(){
            return name;
        }
        public String getContinentName(){
            return continentName;
        }

    public void setContinents( ObservableList<Continent> _continents)
    {
        continents   = _continents;
        ContinentComboBox.setItems(continents);

        ContinentComboBox.setConverter(new StringConverter<Continent>() {

            @Override
            public String toString(Continent object) {
                return object.getName();
            }

            @Override
            public Continent fromString(String string) {
                // Somehow pass id and return bank instance
                // If not important, just return null
                for(Continent continent : continents){
                    if(continent.getName() == string){
                        return continent;
                    }
                }

                return null;
            }
        });
    }

}


