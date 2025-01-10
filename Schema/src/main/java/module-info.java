module com.example.schema {
    requires javafx.controls;
    requires javafx.fxml;

    // Öppna rätt paket för JavaFX FXML-inläsning
    opens com.example.schema to javafx.fxml;
    opens com.example.inlogg to javafx.fxml;

    // Exports är bra för att göra paketet tillgängligt för andra moduler
    exports com.example.schema;
    exports com.example.inlogg;
}
