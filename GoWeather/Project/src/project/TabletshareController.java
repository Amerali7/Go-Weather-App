/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author prarthana
 */
public class TabletshareController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void onFacebook(ActionEvent event) throws URISyntaxException, IOException {
        
         URI uri = new URI("http://wwww.facebook.com");
               Desktop.getDesktop().browse(uri);
    }

    @FXML
    private void onTwitter(ActionEvent event) throws URISyntaxException, IOException {
        
         URI uri = new URI("http://www.twitter.com");
               Desktop.getDesktop().browse(uri);
    }
    
    @FXML
    private void onGoogle(ActionEvent event) throws URISyntaxException, IOException {
        URI uri = new URI("http://plus.google.com");
               Desktop.getDesktop().browse(uri);
      
    }
    
     @FXML
    private void onEmail(ActionEvent event) throws URISyntaxException, IOException {
        URI uri = new URI("http://mail.live.com");
               Desktop.getDesktop().browse(uri);
        
    }
    @FXML
    private void onHome(ActionEvent event)
    {
        
        
        
    }
    
    
    
}
