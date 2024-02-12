package com.example.bukkmaraton;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private ComboBox<String> tavChoice;
    @FXML
    private Label kmhAtlagsebesseg;
    @FXML
    private Label msAtlagsebesseg;
    @FXML
    private TextField idoInput;
    @FXML
    private Button szamolButton;

    //  v=s/t
    @FXML
    private void initialize() {
        tavChoice.setItems(FXCollections.observableArrayList(
                "Mini - 16km",
                "Rövid - 38km",
                "Pedelec - 54km",
                "Közép - 57km",
                "Hosszú - 94mk"
        ));
        tavChoice.getSelectionModel().select("Közép - 57km");
    }

    @FXML
    private void calculate() {
        int[] tavok = {16, 38, 54, 57, 94};

        int tav = tavok[tavChoice.getSelectionModel().getSelectedIndex()];
        String[] ido = idoInput.getText().split(":");
        int ora = Integer.parseInt(ido[0]);
        int perc = Integer.parseInt(ido[1]);
        int mp = Integer.parseInt(ido[2]);

        double idoOra = ora + ((double) perc / 60) + ((double) mp / 3600);
        double kmh = tav / idoOra;
        double ms = kmh / 3.6;
        kmhAtlagsebesseg.setText(String.format("%.2f", kmh) + " km/h");
        msAtlagsebesseg.setText(String.format("%.2f", ms) + " m/s");
    }





}