/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;


/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
public class KøbSælgController implements Initializable {

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
	private Label BalanceLabel;
	
	@FXML
	private Slider BalanceSlider;
	
	int Balance;

        @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Balance = (int) BalanceSlider.getValue();
		BalanceLabel.setText(Integer.toString(Balance)+"$");
		
		BalanceSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				Balance = (int) BalanceSlider.getValue();
				BalanceLabel.setText(Integer.toString(Balance)+"$");
				
			}			
		});		
	}
}
    
    

