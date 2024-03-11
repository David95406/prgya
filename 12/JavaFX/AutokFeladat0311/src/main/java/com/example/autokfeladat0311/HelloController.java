package com.example.autokfeladat0311;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label savingStatus;
    @FXML
    private TextField markaInput, tipusInput, hengerurtartalomInput, szallithatoSzemelyekInput, rendszamInput;
    @FXML
    private Label printAutok;

    private ArrayList<Auto> autok = new ArrayList<>();

    private void printSavingStatus(String value, String color) {
        savingStatus.setTextFill(Paint.valueOf(color));
        savingStatus.setText(value);
    }

    public void addAuto() {
        String marka, tipus, rendszam;
        int hengerurtartalom, szallithatoSzemelyek;
        try {
            marka = markaInput.getText();
            tipus = tipusInput.getText();
            hengerurtartalom = Integer.parseInt(hengerurtartalomInput.getText());
            szallithatoSzemelyek = Integer.parseInt(szallithatoSzemelyekInput.getText());
            rendszam = rendszamInput.getText();
        } catch (Exception e) {
            printSavingStatus("Hiba", "red");
            return;
        }

        Auto ujAuto = new Auto(marka, tipus, hengerurtartalom, szallithatoSzemelyek, rendszam);
        autok.add(ujAuto);
        printList();
    }

    public void printList() {
        printSavingStatus("", "black");
        printAutok.setText("");
        for (Auto egyAuto : autok) {
            printAutok.setText(printAutok.getText() + egyAuto.toString());
        }
    }
    
}