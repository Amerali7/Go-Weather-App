/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Calendar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.logging.Logger;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import java.util.logging.Level;
import javafx.application.Application;




/**
 * FXML Controller class
 *
 * @author hanifaaziz
 */
public class GoWeatherMobileAppController implements Initializable {

    @FXML
    private TextField search;
    
    @FXML
    private Label time;
    
    @FXML
    private Parent root;
    
    @FXML
    private MenuButton menu;
      @FXML
    MenuItem share;
    @FXML
    MenuItem saved;
    @FXML
    MenuItem warnings;
    @FXML
    MenuItem edit;
    @FXML
    MenuItem info;
    @FXML
    private Label mtemp;
    @FXML
    private Label conditions;
      @FXML
    private Label sun;
       @FXML
    private Label wind;
        @FXML
    private Label vis;
    
    Stage pageStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //search.setVisible(false);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        time.setText(sdf.format(cal.getTime()));
        setTemp();
        
      //WeatherAPI weather = new WeatherAPI("44418");
        //temp.setText(weather.weatherForecastList.get(0).highTemp);
        
    }
     @FXML
    private void setTemp() {
                        WeatherAPI weather = new WeatherAPI("44418");
                       
                        mtemp.setText(weather.weatherForecastList.get(0).highTemp);
                        conditions.setText(weather.weatherForecastList.get(0).conditionss);
                        
                        WeatherAPIconditions weathera = new WeatherAPIconditions("44418","<yweather:astronomy");
                        sun.setText(weathera.weatherForecastList.get(0).setsun);
                        
                        WeatherAPIconditions weatherb = new WeatherAPIconditions("44418","<yweather:wind");
                        wind.setText(weatherb.weatherForecastList.get(0).windspeed);
                        
                         WeatherAPIconditions weatherc = new WeatherAPIconditions("44418","<yweather:atmosphere");
                        vis.setText(weatherc.weatherForecastList.get(0).visible);
                        
                                   
    }
    @FXML
    public void searchButton(ActionEvent e) {
        search.setVisible(true);
    }
   /* @FXML
    public void getweather(ActionEvent e){
        WeatherAPI weather = new WeatherAPI("44418");
        mtemp.setText(weather.weatherForecastList.get(0).highTemp);
        
        
}*/
    
    @FXML 
    public void locationButton(ActionEvent e) throws IOException {
        Parent sub = FXMLLoader.load(getClass().getResource("Location.fxml"));
        Scene sub_scene = new Scene(sub);
        Stage sub_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        sub_stage.setScene(sub_scene);
        sub_stage.show();
    }
    
    @FXML
    public void getPage(MouseEvent e) throws IOException {
            
            share.setOnAction(e1 -> {
            try {
                getSharePage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        saved.setOnAction(e2 -> {
            try {
                getSavedPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        warnings.setOnAction(e3 -> {
            try {
                getWarningPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        edit.setOnAction(e4 -> {
            try {
                getEditPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction(e5 -> {
            try {
                getInfoPage();
            } catch (IOException ex) {
                Logger.getLogger(GoWeatherMobileAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void getInfoPage() throws IOException {

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("information.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

    public void getEditPage() throws IOException {

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Location.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

    public void getWarningPage() throws IOException {

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("WeatherWarning.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

    public void getSharePage() throws IOException{

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Share.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

    public void getSavedPage() throws IOException {

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SavedEvents.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();
    }

}
