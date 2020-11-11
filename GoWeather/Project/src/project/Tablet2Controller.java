/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class Tablet2Controller implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private Label Location;
    TabletlocationController loc;
    @FXML
    private Label date;
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
    mainn main;
    Stage pageStage;
    private final ObservableList<String> data = FXCollections.observableArrayList("Stratford", "Mile End");
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // String result= loc.getLocation();
        // System.out.println(result);
        //Display date and time in date label
        Date dNow = new Date();
        SimpleDateFormat getTime = new SimpleDateFormat("E H:mm");
        date.setText(getTime.format(dNow));
        setTemp();

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
    
    
    public void searchFunction(KeyEvent event) {

       
        
    
        

        
        
    }
    
    

    public void onSearch(ActionEvent e) {
        searchField.setVisible(true);
        

    }
    
   

    public void getPage(MouseEvent e) throws IOException {

        share.setOnAction(e1 -> {
            try {
                getSharePage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        saved.setOnAction(e2 -> {
            try {
                getSavedPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        warnings.setOnAction(e3 -> {
            try {
                getWarningPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        edit.setOnAction(e4 -> {
            try {
                getEditPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction(e5 -> {
            try {
                getInfoPage();
            } catch (IOException ex) {
                Logger.getLogger(Tablet2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void getInfoPage() throws IOException {

        loc.closeStage();

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletinfo.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getEditPage() throws IOException {
        loc.closeStage();

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletlocation.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getWarningPage() throws IOException {
        loc.closeStage();

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletwarning.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getSharePage() throws IOException{
        loc.closeStage();

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletshare.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

    public void getSavedPage() throws IOException {

        loc.closeStage();

        pageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("tabletsavedevents.fxml"));
        Scene infoScene = new Scene(root);
        pageStage.setScene(infoScene);
        pageStage.show();

    }

}
