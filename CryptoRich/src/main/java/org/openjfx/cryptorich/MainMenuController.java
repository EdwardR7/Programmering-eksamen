/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
public class MainMenuController {
    
  @FXML
    private void switchToMinMainMenu() throws IOException {
        App.setRoot("MainMenu");
    }
    @FXML
    private void switchToKøbSælg() throws IOException {
        App.setRoot("KøbSælg");
    }
    
    
    //Simulation
    
    
    }
        
        
        
        
     
    

