package com.example.szerepjatekkarakterekgui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {

    @FXML
    private ChoiceBox<String> fajokChoiceBox;
    @FXML
    private ListView karakterekListView;

    @FXML
    private void initialize() throws SQLException {
        ArrayList<String> fajok = new ArrayList<>();
        fajok.add("Válasszon fajt!");
        fajok.addAll(DatabaseManager.getFajok());

        fajokChoiceBox.getItems().addAll(fajok);
        fajokChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void sort(MouseEvent mouseEvent) throws SQLException {
        if (fajokChoiceBox.getSelectionModel().getSelectedIndex() == 0) {
            showAlert("Kitöltési hiba", "Válasszon egy fajt a szűréshez!");
        } else {
            String targetFaj = fajokChoiceBox.getSelectionModel().getSelectedItem();
            ArrayList<String> eredmeny = DatabaseManager.getKarakterFromName(targetFaj);

            karakterekListView.getItems().clear();
            karakterekListView.getItems().addAll(eredmeny);
        }
    }

    private void showAlert(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(text);

        alert.showAndWait();
    }
}