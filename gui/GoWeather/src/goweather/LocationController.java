/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hanifaaziz
 */
public class LocationController implements Initializable {  

   @FXML
    public TextField locationField;
    public String home;
    GoWeatherMobileAppController move;
    static Stage newStage;
    GoWeatherMobile main;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void locationButton(ActionEvent e) throws IOException {
        Parent sub = FXMLLoader.load(getClass().getResource("GoWeatherMobileApp.fxml"));
        Scene sub_scene = new Scene(sub);
        Stage sub_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        sub_stage.setScene(sub_scene);
        sub_stage.show();

    }
    
    public static void closeStage(){
        newStage.hide();
        
        
    }
    
    public static void showStage(){
        newStage.show();
    }
    
   

    public String getLocation() {
        home = locationField.getText();

        return home;

    }

   
    
}
