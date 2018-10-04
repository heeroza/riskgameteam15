package CustomDialogs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContinentDialogController {

    private  Stage stage;
    private Parent root;
    @FXML AnchorPane AddConitnentPane;
    @FXML TextField nameTextField;
    @FXML TextField BonusTextField;
    @FXML Button submitBtn;

    private String name;
    private Integer bonus;

   public ContinentDialogController(){

   }

    public void show() {




    }

    public void HandleSubmit(){
        System.out.println("lol");
        name = nameTextField.getText();
        bonus = Integer.parseInt( BonusTextField.getText());
       // stage.close();
        Stage stage = (Stage) AddConitnentPane.getScene().getWindow();
        stage.close();
    }
    public String getName(){
       return name;
    }
    public Integer getBonus(){
        return bonus;
    }


}
