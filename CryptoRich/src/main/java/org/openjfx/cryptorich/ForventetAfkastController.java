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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.lang.Math;

/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
public class ForventetAfkastController implements Initializable {

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
    private Label StartbeløbLabel, AfkastLabel, TidshorisontLabel, PorteføljeLabel;
	
    @FXML
    private Slider StartbeløbSlider, AfkastSlider, TidshorisontSlider;
    
    static public int StartBeløbVærdi, AfkastVærdi, TidshorisontVærdi;
    
    static public double x;
    
       @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		StartBeløbVærdi = (int) StartbeløbSlider.getValue();
		StartbeløbLabel.setText(Integer.toString(StartBeløbVærdi)+" kr");
		
		StartbeløbSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				StartBeløbVærdi = (int) StartbeløbSlider.getValue();
				StartbeløbLabel.setText(Integer.toString(StartBeløbVærdi)+" kr");
				
			}			
		});
                
                AfkastVærdi = (int) AfkastSlider.getValue();
		AfkastLabel.setText(Integer.toString(AfkastVærdi)+"%");
		
		AfkastSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				AfkastVærdi = (int) AfkastSlider.getValue();
				AfkastLabel.setText(Integer.toString(AfkastVærdi)+"%");
                
               }			
		});
                
                  TidshorisontVærdi = (int) TidshorisontSlider.getValue();
		TidshorisontLabel.setText(Integer.toString(TidshorisontVærdi)+" år");
		
		TidshorisontSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				TidshorisontVærdi = (int) TidshorisontSlider.getValue();
				TidshorisontLabel.setText(Integer.toString(TidshorisontVærdi)+" år");
                
               }			
		}); 
                
	}    
        
        public void Beregn(){
            
//Renters rente effekt, hvis tidshorisont er større end 1 år 
        if(TidshorisontVærdi>1){
                
 //Beregning            
         x = (double) StartBeløbVærdi * Math.pow(1+((double)AfkastVærdi/100),(double)TidshorisontVærdi);
                     System.out.println(x);
//Når det er 1 år                     
   } else {
             x = ((((double)StartBeløbVærdi/100)*((double)AfkastVærdi))*(double)TidshorisontVærdi)+(double)StartBeløbVærdi;
             
            System.out.println(x);
        }
        
//Ændre vores label til værdien af x            
       PorteføljeLabel.setText(Double.toString(x)+" kr");
		
      
        }
}

    

        

                        