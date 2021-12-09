module org.openjfx.cryptorich {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.cryptorich to javafx.fxml;
    exports org.openjfx.cryptorich;
}
