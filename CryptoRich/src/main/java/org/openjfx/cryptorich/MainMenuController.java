/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
public class MainMenuController implements Initializable {

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
    String[] Assets = {"Bitcoin", "Ethereum", "Cardano", "Loopring", "Solana", "Binance", "XRP", "Dogecoin", "Polkadot", "SHIBA", "Polygon", "Polkadot", "Cosmos", "Chainlink", "Algorand", "Quant", "MANA"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //AssetList henter og tilføjer alle Items fra String Array'et Assets
        AssetList.getItems().addAll(Assets);

    }

    @FXML
    public void AddAssets() {

        //Tilføjer den valgte item fra AssetList til WatchList 
        WatchList.appendText(AssetList.getSelectionModel().getSelectedItem() + "     ");

        //Flere Items kan blive valgt
        AssetList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    @FXML
    public void RemoveAsset() {

        //Fjerner Assets man ikke ønsker at se som værende populære
        int AssetSelectionID = AssetList.getSelectionModel().getSelectedIndex();
        AssetList.getItems().remove(AssetSelectionID);

    }

    //Sorteringsalgoritme method    
    @FXML
    public void SorteringsalgoritmeBubble() {

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

    //Mulige assets at købe
    public double x = Math.floor(Math.random() * (500 - 100 + 1) + 100);
    public double eth = x;
    public double btc = x;
    public double Cardano = x;
    public double Loopring = x;
    public double Solana = x;

    Random r = new Random();
    double chance = (r.nextInt(21) - 10) / 10.0;
    double price = (r.nextInt(100 - 10) + 10);


    public int UpdateAmount = 100;
    public int Initial = 10;
    public double[] test = new double[10];

    //LineChart - vores graf 
    //Data -> XYChart 
    public void GraphLoad() {

        for (int i = 0; i < Initial; i++) {
            double x = eth + (Math.floor(Math.random() * (100 - 0.01 + 1) + 0.01));
            test[i] = test[i] + (x * chance);
        }

        PortfolioGraph.getData().clear();

        //Laver vores series
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

        //Definerer vores punkter
        series.getData().add(new XYChart.Data<String, Number>("1", test[0]));

        series.getData().add(new XYChart.Data<String, Number>("2", test[1]));
        series.getData().add(new XYChart.Data<String, Number>("3", test[2]));
        series.getData().add(new XYChart.Data<String, Number>("4", test[3]));
        series.getData().add(new XYChart.Data<String, Number>("5", test[4]));
        series.getData().add(new XYChart.Data<String, Number>("6", test[5]));
        series.getData().add(new XYChart.Data<String, Number>("7", test[6]));
        series.getData().add(new XYChart.Data<String, Number>("8", test[7]));
        series.getData().add(new XYChart.Data<String, Number>("9", test[8]));
        series.getData().add(new XYChart.Data<String, Number>("10", test[9]));

        //Giver vores LineChart dataen fra vores series 
        PortfolioGraph.getData().add(series);

        //Exit method. Returner en gang når method er kørt, da det er public final
        PortfolioGraph.animatedProperty();

    }
}

/*
        double x1 = (eth + btc) + (Math.floor(Math.random() * (3000 - 100 + 1) + 100));
        double x2 = (eth + btc + Loopring) + Math.floor(Math.random() * (4000 - 100 + 1) + 100);
        double x3 = (eth + btc + Cardano + Loopring) + Math.floor(Math.random() * (3500 - 100 + 1) + 100);
        double x4 = (eth + btc + Cardano + eth + Loopring) + Math.floor(Math.random() * (4000 - 100 + 1) + 100);
        double x5 = (eth + btc + Cardano + eth + Solana + Loopring) + Math.floor(Math.random() * (4500 - 100 + 1) + 100);
        double x6 = (eth + btc + Cardano + eth + Solana + Loopring + eth) + Math.floor(Math.random() * (4500 - 100 + 1) + 100);
        double x7 = (eth + btc + Cardano + eth + Solana + Loopring + btc + eth) + Math.floor(Math.random() * (10000 - 100 + 1) + 100);
        double x8 = (eth + btc + Cardano + eth + Solana + Loopring + btc + Cardano + eth) + Math.floor(Math.random() * (10000 - 100 + 1) + 100);
        double x9 = (eth + btc + Cardano + eth + Solana + Loopring + btc + Cardano + eth + Loopring) + Math.floor(Math.random() * (13000 - 100 + 1) + 100);


 */
//Clear data sådan at den kun viser en update pr. gang man kører denne method    

