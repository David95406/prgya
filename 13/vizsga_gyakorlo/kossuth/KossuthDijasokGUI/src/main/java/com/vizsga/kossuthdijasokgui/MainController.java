package com.vizsga.kossuthdijasokgui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
    @FXML
    private TableColumn<SearchResult, String> megjegyzesTableColumn;
    @FXML
    private TableColumn<SearchResult, String> munkakorTableColumn;
    @FXML
    private TableColumn<SearchResult, Integer> evTableColumn;
    @FXML
    private TableColumn<SearchResult, String> nevTableColumn;
    @FXML
    private TableView<SearchResult> eredmenyekTableView;
    @FXML
    private TextField munkakorTextField;
    @FXML
    private Button searchButton;

    public void initialize() {
        nevTableColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        evTableColumn.setCellValueFactory(new PropertyValueFactory<>("ev"));
        munkakorTableColumn.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        megjegyzesTableColumn.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));
    }

    public void handleSearch() throws SQLException {
        String munkakor = munkakorTextField.getText();
        if (!munkakor.isEmpty()) {
            ArrayList<SearchResult> eredmeny = DatabaseManager.filterByMunkakor(munkakor);
            eredmenyekTableView.getItems().clear();
            for (SearchResult sr : eredmeny) {
                eredmenyekTableView.getItems().add(sr);
            }
        } else {
            showAlert("Error", "Adjon meg munkakort");
        }
    }

    private void showAlert(String title, String body) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(title);
        a.setTitle("Hiba");
        a.setContentText(body);

        a.showAndWait();
    }
}