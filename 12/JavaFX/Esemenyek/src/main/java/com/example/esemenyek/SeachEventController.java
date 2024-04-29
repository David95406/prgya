package com.example.esemenyek;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class SeachEventController {
    @FXML
    protected ScrollPane eventScollPane;
    @FXML
    protected TextField searchBar;

    public void search() {
        String input = searchBar.getText();
        ArrayList<Esemeny> results = new ArrayList<>();

        for (Esemeny egyEsemeny : DataManager.esemenylista) {
            if (egyEsemeny.toString().contains(input)) {
                results.add(egyEsemeny);
            }
        }

        VBox eventList = new VBox();
        for (Esemeny egyEsemeny : results) {
            eventList.getChildren().add(EventListController.getEvent(egyEsemeny));
            eventScollPane.setContent(eventList);
        }
    }

    public void back() throws IOException {
        EventsApplication.back();
    }
}
