package com.example.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Kalender");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}