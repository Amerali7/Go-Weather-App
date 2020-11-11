/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class TabletController implements Initializable {

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
    @FXML
    private Label day1, day2, day3, day4;
    @FXML
    private Label temp1, temp2, temp3, temp4;
    @FXML
    private Label condition1, condition2, condition3, condition4;

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
        WeatherAPI2 weather = new WeatherAPI2("44418");

        mtemp.setText(weather.weatherForecastList.get(0).highTemp);
        conditions.setText(weather.weatherForecastList.get(0).conditionss);

        day1.setText(weather.weatherForecastList.get(1).days);
        day2.setText(weather.weatherForecastList.get(2).days);
        day3.setText(weather.weatherForecastList.get(3).days);
        day4.setText(weather.weatherForecastList.get(4).days);

        temp1.setText(weather.weatherForecastList.get(1).highTemp);
        temp2.setText(weather.weatherForecastList.get(2).highTemp);
        temp3.setText(weather.weatherForecastList.get(3).highTemp);
        temp4.setText(weather.weatherForecastList.get(4).highTemp);

        condition1.setText(weather.weatherForecastList.get(1).conditionss);
        condition2.setText(weather.weatherForecastList.get(2).conditionss);
        condition3.setText(weather.weatherForecastList.get(3).conditionss);
        condition4.setText(weather.weatherForecastList.get(4).conditionss);

        WeatherAPIconditions weathera = new WeatherAPIconditions("44418", "<yweather:astronomy");
        sun.setText(weathera.weatherForecastList.get(0).setsun);

        WeatherAPIconditions weatherb = new WeatherAPIconditions("44418", "<yweather:wind");
        wind.setText(weatherb.weatherForecastList.get(0).windspeed);

        WeatherAPIconditions weatherc = new WeatherAPIconditions("44418", "<yweather:atmosphere");
        vis.setText(weatherc.weatherForecastList.get(0).visible);
    }

    public void searchFunction(KeyEvent event) {

    }

    public void onSearch(ActionEvent e) {
        String statusString = "Searching";

        switch (statusString) {

            case "one": statusString = "Searching";
                break;
            case "two":
                statusString = "Off";
                break;
        }
        
                if (statusString.equals("Searching")) {
                    searchField.setVisible(true);
                    statusString = "Off";
                    
                } else {
                    searchField.setVisible(false);
                }

        
    }
    
   

    

    

    public void getPage(MouseEvent e) throws IOException {

        share.setOnAction(e1 -> {
            try {
                getSharePage();
            } catch (IOException ex) {
                Logger.getLogger(TabletController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        saved.setOnAction(e2 -> {
            try {
                getSavedPage();
            } catch (IOException ex) {
                Logger.getLogger(TabletController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        warnings.setOnAction(e3 -> {
            try {
                getWarningPage();
            } catch (IOException ex) {
                Logger.getLogger(TabletController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        edit.setOnAction(e4 -> {
            try {
                getEditPage();
            } catch (IOException ex) {
                Logger.getLogger(TabletController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        info.setOnAction(e5 -> {
            try {
                getInfoPage();
            } catch (IOException ex) {
                Logger.getLogger(TabletController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void getSharePage() throws IOException {
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
    
    @FXML
    public void changeScreen(ActionEvent e) throws IOException{
        Parent sub = FXMLLoader.load(getClass().getResource("GoWeatherMobileApp.fxml"));
        Scene sub_scene = new Scene(sub);
        Stage sub_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        sub_stage.setScene(sub_scene);
        sub_stage.show();
    }

}
