package org.openjfx.cryptorich;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {
        @FXML
    private TextField txtLoginUsername, txtLoginPassword;

    @FXML
    private Label MessageBoxLogin;
    
    
    private String EmptyFieldChecker;
    
    
    
      @FXML
    private void switchToRegistre() throws IOException {
        App.setRoot("registre");
    }
    
      @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenu");
    }
    
        @FXML
    private void handleBtnLogin() throws IOException, Exception {
        DBMetoder DB = new DBMetoder();
        if(!txtLoginUsername.getText().isBlank() && !txtLoginPassword.getText().isBlank()){
            if(DB.loginVerficiation(txtLoginUsername.getText(), txtLoginPassword.getText())){
              MessageBoxLogin.setText(DB.verifyMessage);
              switchToMainMenu();
            }else{
              MessageBoxLogin.setText(DB.verifyMessage);
                
            }
            
        }else if(txtLoginUsername.getText().isBlank()){
            EmptyFieldChecker = "No username inserted";
            MessageBoxLogin.setText(EmptyFieldChecker);
        }else if(txtLoginPassword.getText().isBlank()){
            EmptyFieldChecker = "No password inserted";
            MessageBoxLogin.setText(EmptyFieldChecker);
        }

    }
}

