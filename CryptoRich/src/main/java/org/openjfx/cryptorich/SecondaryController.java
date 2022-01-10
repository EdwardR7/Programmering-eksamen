package org.openjfx.cryptorich;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {
    
      @FXML
    private void switchToRegistre() throws IOException {
        App.setRoot("registre");
    }
    
}