package com.example.esemenyek;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class EventListController {
    @FXML
    protected TableView<Esemeny> eventTable;
    @FXML
    protected TableColumn<Esemeny, StringProperty> nevColumn, datumColumn, helyszinColumn;

    @FXML
    public void initialize() {
        nevColumn.setCellValueFactory(new PropertyValueFactory<>("Nev"));
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        helyszinColumn.setCellValueFactory(new PropertyValueFactory<>("Helyszin"));

        ObservableList<Esemeny> esemenylistaOL = FXCollections.observableArrayList(DataManager.getEsemenylista());
        eventTable.setItems(esemenylistaOL);
    }

    public void back() throws IOException {
        EventsApplication.back();
    }

}
