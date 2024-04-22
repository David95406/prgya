package com.example.esemenyek;

import com.example.esemenyek.model.Esemeny;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class EventListController {
    @FXML
    protected ScrollPane eventScollPane;
    public void back() throws IOException {
        MainApplication.back();
    }

    protected static Label getEvent(Esemeny e) {
        Label newEvent = new Label(e.getLabelFormat());
        newEvent.getStyleClass().add("event");
        return newEvent;
    }

    @FXML
    protected void initialize() {
        VBox eventList = new VBox();
        for (Esemeny egyEsemeny : MainApplication.esemenyek) {
            eventList.getChildren().add(getEvent(egyEsemeny));
            eventScollPane.setContent(eventList);
        }
    }
}
