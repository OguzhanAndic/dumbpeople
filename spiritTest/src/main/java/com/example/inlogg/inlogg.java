package com.example.inlogg; // Se till att detta är rätt paketnamn

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class inlogg extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Ladda FXML-filen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Inlogg.fxml"));

        // Skapa en scen med FXML-innehållet
        Scene scene = new Scene(fxmlLoader.load());

        // Sätt titeln för scenen (valfritt)
        stage.setTitle("Inlogg Application");

        // Sätt scenen på fönstret (stage)
        stage.setScene(scene);

        // Visa fönstret
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // Starta JavaFX-applikationen
    }
}