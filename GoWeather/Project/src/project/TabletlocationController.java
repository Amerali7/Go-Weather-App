/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class TabletlocationController implements Initializable {

    @FXML
    public TextField locationField;
    public String home;
    Tablet2Controller move;
    static Stage newStage;
    mainn main;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void locationButton(ActionEvent e) throws IOException {
        main.getMainScreen();
        newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tablet2.fxml"));
        Scene scene3 = new Scene(root);
        newStage.setScene(scene3);
        newStage.show();

    }
    
    public static void closeStage(){
        newStage.hide();
        
        
    }
    
   

    public String getLocation() {
        home = locationField.getText();

        return home;

    }

}
