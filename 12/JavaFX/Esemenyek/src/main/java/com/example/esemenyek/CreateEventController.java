package com.example.esemenyek;

import com.example.esemenyek.model.DataManager;
import com.example.esemenyek.model.Esemeny;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class CreateEventController {
    @FXML
    protected TextField nevInput, datumInput, helyszinInput;
    @FXML
    protected Label statusLabel;

    public void back() throws IOException {
        EventsApplication.back();
    }

    private void clearTextFields() {
        nevInput.setText("");
        datumInput.setText("");
        helyszinInput.setText("");
    }

    public void createEvent() {
        try {
            DataManager.esemenylista.add(new Esemeny(
                    nevInput.getText(),
                    datumInput.getText(),
                    helyszinInput.getText()
            ));
            clearTextFields();
            EventsApplication.printLabel(statusLabel, "Sikeres mentés!", "green");
        } catch (Exception e) {
            EventsApplication.printLabel(statusLabel, "Hiba!", "red");
        }
    }
}