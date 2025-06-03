package com.vizsga.databaseconngyak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TableView<Karakter> karakterekTableView;
    @FXML
    private TableColumn<Karakter, String> nevTableColumn;
    @FXML
    private TableColumn<Karakter, Integer> evTableColumn;
    @FXML
    private TextField nevTextField;

    private ObservableList<Karakter> karakterek;

    @FXML
    private void initialize() throws SQLException {
        karakterek = DatabaseManager.getKarakterek();

        nevTableColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        evTableColumn.setCellValueFactory(new PropertyValueFactory<>("ev"));
        karakterekTableView.setItems(karakterek);
    }

    @FXML
    private void search() throws SQLException {
        try {
            String searchValue = nevTextField.getText();
            if (searchValue.isEmpty()) {
                karakterekTableView.setItems(karakterek);
            } else {
                ObservableList<Karakter> eredemeny = FXCollections.observableArrayList();
                for (Karakter karakter : karakterek) {
                    if (karakter.getNev().contains(searchValue)) {
                        eredemeny.add(karakter);
                    }
                }

                karakterekTableView.setItems(eredemeny);
            }
        } catch (Exception e) {
            showAlert("hiba", "hiba tortent");
        }
    }

    private static void showAlert(String title, String body) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(body);

        a.showAndWait();
    }
}