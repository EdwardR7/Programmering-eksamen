/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.cryptorich;

/**
 * FXML Controller class
 *
 * @author edwardrostomian
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistreController {

    @FXML
    private TextField txtRegUsername, txtRegPassword1, txtRegPassword2;

    @FXML
    private Label MessageBox;

    private String EmptyFieldUser = "No username inserted";
    private String EmptyFieldPass = "No password inserted";
    private String passAsymmetry = "Passwords are not the same";
  
    
    @FXML
    private void switchToSecondary() throws IOException, Exception {
        App.setRoot("secondary");
    }

    @FXML
    private void handleBtnRegisterUser() throws IOException, Exception {
        DBMetoder DB = new DBMetoder();

        if ((!txtRegUsername.getText().isBlank() && !txtRegPassword1.getText().isBlank() && txtRegPassword1.getText().equals(txtRegPassword2.getText()))) {
            DB.RegisterUser(new User(-1, txtRegUsername.getText(), txtRegPassword2.getText()), txtRegUsername.getText());
            MessageBox.setText(DB.UserExists);
            
        } else if (txtRegUsername.getText().isBlank()) {
            MessageBox.setText(EmptyFieldUser);
        } else if (txtRegPassword1.getText().isBlank() || txtRegPassword2.getText().isBlank()) {
            MessageBox.setText(EmptyFieldPass);

        }else{
          MessageBox.setText(passAsymmetry);
                    
    }

    }
}
