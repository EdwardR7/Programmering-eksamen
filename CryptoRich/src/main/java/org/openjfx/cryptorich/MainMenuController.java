/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
public class MainMenuController implements Initializable  {
    
  @FXML
    private void switchToMinMainMenu() throws IOException {
        App.setRoot("MainMenu");
    }
    @FXML
    private void switchToKøbSælg() throws IOException {
        App.setRoot("KøbSælg");
    }
    
   
    @FXML
    private ListView<String> AssetList;
    
    String[] Assets = {"Bitcoin","Ethereum","Cardano","Loopring","Solana", "Binance", "XRP","Dogecoin","Polkadot","SHIBA","Polygon","Polkadot","Cosmos","Chainlink","Algorand","Quant","MANA"};
   
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    
    AssetList.getItems().addAll(Assets);
		
		AssetList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
       
                    @Override
        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
            
                        try {
                            throw new Exception("Not supported yet."); 
                            
                        } catch (Exception ex) {
                            
                            ex.printStackTrace();
                        }
        }


    
    //Simulation
            
                  
                });
}
    
}

        
        
        
        
        
     
    

