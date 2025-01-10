module com.example.inlogg {
    requires com.example.schema;

    // Öppna rätt paket för JavaFX FXML-inläsning

    opens com.example.inlogg to javafx.fxml;

    // Exports är bra för att göra paketet tillgängligt för andra moduler
    exports com.example.inlogg;
}
