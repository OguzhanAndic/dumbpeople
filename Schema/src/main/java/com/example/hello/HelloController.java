package com.example.hello;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HelloController {

    @FXML
    private GridPane calendarGrid;

    private LocalDate currentDate = LocalDate.now(); // Startdatum är dagens datum

    @FXML
    private Button prevMonthBtn;
    @FXML
    private Button nextMonthBtn;

    // Metod som körs när applikationen startas
    @FXML
    public void initialize() {
        refreshCalendar();
    }

    // Uppdatera kalendern när månad ändras
    private void refreshCalendar() {
        // Rensa griden innan vi lägger till nya datum
        calendarGrid.getChildren().clear();

        // Lägg till veckodagarna i toppen
        String[] weekdays = {"Sön", "Mån", "Tis", "Ons", "Tor", "Fre", "Lör"};
        for (int i = 0; i < weekdays.length; i++) {
            Text weekdayText = new Text(weekdays[i]);
            weekdayText.setFont(new Font(16));
            calendarGrid.add(weekdayText, i, 0);
        }

        // Hämta första dagen i månaden
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        DayOfWeek startDay = firstDayOfMonth.getDayOfWeek();
        int daysInMonth = currentDate.lengthOfMonth();

        // Lägg till datumen i kalendern
        int dayOfMonth = 1;
        for (int row = 1; dayOfMonth <= daysInMonth; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 1 && col < startDay.getValue()) {
                    continue; // Hoppa över tomma dagar innan den första dagen
                }
                if (dayOfMonth > daysInMonth) {
                    break; // När alla dagar är lagda, avsluta loopen
                }

                Button dayButton = new Button(String.valueOf(dayOfMonth));
                dayButton.setStyle("-fx-font-size: 14px; -fx-pref-width: 50px; -fx-pref-height: 50px;");
                calendarGrid.add(dayButton, col, row);
                dayOfMonth++;
            }
        }
    }

    @FXML
    private void goToPreviousMonth() {
        currentDate = currentDate.minusMonths(1);
        refreshCalendar();
    }

    @FXML
    private void goToNextMonth() {
        currentDate = currentDate.plusMonths(1);
        refreshCalendar();
    }
}