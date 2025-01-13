package com.example.inlogg; // Se till att detta är rätt paketnamn

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class InloggController {

    @FXML
    private void openCreateAccount(ActionEvent event) {
        try {
            // Ladda CreateUser-fönstret
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CreateUser.fxml"));
            Scene createUserScene = new Scene(fxmlLoader.load());

            // Hämta nuvarande stage och stäng det
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            // Skapa och visa det nya fönstret
            Stage newStage = new Stage();
            newStage.setTitle("Skapa Konto");
            newStage.setScene(createUserScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openLogin(ActionEvent event) {
        try {
            // Ladda CreateUser-fönstret
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Scene LoginScene = new Scene(fxmlLoader.load());

            // Hämta nuvarande stage och stäng det
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            // Skapa och visa det nya fönstret
            Stage newStage = new Stage();
            newStage.setTitle("Login");
            newStage.setScene(LoginScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openRetFromCreate(ActionEvent event) {
        try {
            // Ladda CreateUser-fönstret
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/inlogg.fxml"));
            Scene logginscene = new Scene(fxmlLoader.load());

            // Hämta nuvarande stage och stäng det
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            // Skapa och visa det nya fönstret
            Stage newStage = new Stage();
            newStage.setTitle("inlogg");
            newStage.setScene(logginscene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

