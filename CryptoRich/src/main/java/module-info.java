module org.openjfx.cryptorich {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens org.openjfx.cryptorich to javafx.fxml;
    exports org.openjfx.cryptorich;
}
