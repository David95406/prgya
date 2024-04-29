package com.example.esemenyek;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class EventListController {
    //@FXML
    //protected ScrollPane eventScollPane;
    @FXML
    protected TableView<Esemeny> eventTable;
    @FXML
    protected TableColumn<Esemeny, StringProperty> nevColumn, datumColumn, helyszinColumn;

    public void back() throws IOException {
        EventsApplication.back();
    }

    protected static Label getEvent(Esemeny e) {
        Label newEvent = new Label(e.toString());
        newEvent.getStyleClass().add("event");
        return newEvent;
    }

    protected void initializexd() {
        nevColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));
        helyszinColumn.setCellValueFactory(new PropertyValueFactory<>("helyszin"));

    }

    @FXML
    public void initialize() {
        nevColumn.setCellValueFactory(new PropertyValueFactory<>("Nev"));
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        helyszinColumn.setCellValueFactory(new PropertyValueFactory<>("Helyszin"));
        ObservableList<Esemeny> data = FXCollections.observableArrayList();
        for (int i = 0; i < DataManager.getEsemenylista().size(); i++) {
            Esemeny event = new Esemeny(
                    DataManager.getEsemenylista().get(i).getNev(),
                    DataManager.getEsemenylista().get(i).getDatum(),
                    DataManager.getEsemenylista().get(i).getHelyszin()
            );
            data.add(event);
        }
        eventTable.setItems(data);
    }

}
