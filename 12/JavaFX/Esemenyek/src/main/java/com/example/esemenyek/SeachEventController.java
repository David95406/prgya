package com.example.esemenyek;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class SeachEventController {
    @FXML
    protected TextField searchBar;

    @FXML
    protected TableView<Esemeny> eventTable;
    @FXML
    protected TableColumn<Esemeny, StringProperty> nevColumn, datumColumn, helyszinColumn;

    public void search() {
        String input = searchBar.getText();
        if (input.isEmpty()) {
            eventTable.setItems(null);
            return;
        }

        nevColumn.setCellValueFactory(new PropertyValueFactory<>("Nev"));
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        helyszinColumn.setCellValueFactory(new PropertyValueFactory<>("Helyszin"));
        ObservableList<Esemeny> results = FXCollections.observableArrayList();
        for (Esemeny egyEsemeny : DataManager.getEsemenylista()) {
            if (egyEsemeny.getValue().contains(input)) results.add(egyEsemeny);
        }
        eventTable.setItems(results);
    }

    public void back() throws IOException {
        EventsApplication.back();
    }
}
