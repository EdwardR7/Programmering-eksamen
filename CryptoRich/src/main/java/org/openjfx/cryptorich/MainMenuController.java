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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
 public class MainMenuController implements Initializable  {

    @FXML
    private ToggleGroup Menu;
    
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
    private LineChart<String, Number> PortfolioGraph;
            
    @FXML
    private Button GraphUpdater;
   
    
    //Assets - String Array
   String[] Assets = {"Bitcoin","Ethereum","Cardano","Loopring","Solana", "Binance", "XRP","Dogecoin","Polkadot","SHIBA","Polygon","Polkadot","Cosmos","Chainlink","Algorand","Quant","MANA"};

   
       @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
   
    //AssetList henter og tilføjer alle Items fra String Array'et Assets
    AssetList.getItems().addAll(Assets);
		
}
  
    @FXML
        public void AddAssets(){
                
           //Tilføjer den valgte item fra AssetList til WatchList 
           WatchList.appendText(AssetList.getSelectionModel().getSelectedItem()+ "     ");
           
           //Flere Items kan blive valgt
            AssetList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  
         
       }
 
    @FXML
       public void RemoveAsset(){
       
           //Fjerner Assets man ikke ønsker at se som værende populære
           int AssetSelectionID = AssetList.getSelectionModel().getSelectedIndex();
       AssetList.getItems().remove(AssetSelectionID);
       
       } 
      
      
   //Sorteringsalgoritme method    
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
     
    
    //LineChart - vores graf 
    //Data -> XYChart 
     public void GraphLoad(){
         
     //Clear data sådan at den kun viser en update pr. gang man kører denne method    
     PortfolioGraph.getData().clear();
     
     //Laver vores series
     XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
     
     //Definerer vores punkter
     series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
     series.getData().add(new XYChart.Data<String, Number>("Feb", 300));
     series.getData().add(new XYChart.Data<String, Number>("Marts", 400));
     series.getData().add(new XYChart.Data<String, Number>("April", 200));
     series.getData().add(new XYChart.Data<String, Number>("Maj", 300));
     series.getData().add(new XYChart.Data<String, Number>("Juni", 400));
     series.getData().add(new XYChart.Data<String, Number>("Juli", 400));
     series.getData().add(new XYChart.Data<String, Number>("Aug", 800));
     series.getData().add(new XYChart.Data<String, Number>("Sep", 700));
     series.getData().add(new XYChart.Data<String, Number>("Okt", 900));
     series.getData().add(new XYChart.Data<String, Number>("Nov", 850));
     series.getData().add(new XYChart.Data<String, Number>("Dec", 1000));
     
    //Giver vores LineChart dataen fra vores series 
    PortfolioGraph.getData().add(series);
     }
     
     
}
        
    


    
      
      
      

       
        
        
        
        
     
    

