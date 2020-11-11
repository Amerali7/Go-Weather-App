/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;

import com.teknikindustries.yahooweather.WeatherDisplay;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class EventsController implements Initializable {

    @FXML
    private Label temp;
    private Label conditions;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSearch(ActionEvent event) {
        
    }
    
    @FXML
    private void setTemp() {
                        WeatherAPI weather = new WeatherAPI("44418");
                       
                        temp.setText(weather.weatherForecastList.get(0).highTemp);
                        conditions.setText(weather.weatherForecastList.get(0).conditionss);
                        
                      
                        
                        
    }
    
}
