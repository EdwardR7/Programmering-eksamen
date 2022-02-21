/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
     TextArea WatchList;
    
    @FXML
    private Button AssetButton;
    
    @FXML
    private Button RemoveAsset;
    
    @FXML
    private Button BubbleAlgoritme;
    
    @FXML
    private Button HeapAlgoritme;
   
   //String Array
   String[] Assets = {"Bitcoin","Ethereum","Cardano","Loopring","Solana", "Binance", "XRP","Dogecoin","Polkadot","SHIBA","Polygon","Polkadot","Cosmos","Chainlink","Algorand","Quant","MANA"};

   
       @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
   
    //AssetList henter og tilføjer alle Items fra String Array'et Assets
    AssetList.getItems().addAll(Assets);
		
}
  
        public void AddAssets(){
                
           //Tilføjer den valgte item fra AssetList til WatchList 
           WatchList.appendText(AssetList.getSelectionModel().getSelectedItem()+ "     ");
           
           //Flere Items kan blive valgt
            AssetList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  
         
       }
 
       public void RemoveAsset(){
       
           //Fjerner Assets man ikke ønsker at se som værende populære
           int AssetSelectionID = AssetList.getSelectionModel().getSelectedIndex();
       AssetList.getItems().remove(AssetSelectionID);
       
       } 
     
     
       @FXML
     public void SorteringsalgoritmeBubble(){
            
         char charArray[] = WatchList.getText().toCharArray();
        int size = charArray.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (charArray[i] > charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;

                }
            }

        }
        WatchList.clear();
        WatchList.setText(new String(charArray));
    }

    
}

    
      
      
      

       
        
        
        
        
     
    

