/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

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
    private void switchToForventetAfkast() throws IOException {
        App.setRoot("ForventetAfkast");
    }
    
   
    @FXML
    private ListView<String> AssetList;
    
    @FXML
    private TextArea WatchList;
    
    @FXML
    private Button AssetButton;
   
   
   String[] Assets = {"Bitcoin","Ethereum","Cardano","Loopring","Solana", "Binance", "XRP","Dogecoin","Polkadot","SHIBA","Polygon","Polkadot","Cosmos","Chainlink","Algorand","Quant","MANA"};
    
  
   
       @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
   
    AssetList.getItems().addAll(Assets);
		
}
  
        public void AddAssets(){
                
           WatchList.appendText(AssetList.getSelectionModel().getSelectedItem()+ "     ");
  
       }
 
       
        
        
     

}        
        
        
        
        
     
    

