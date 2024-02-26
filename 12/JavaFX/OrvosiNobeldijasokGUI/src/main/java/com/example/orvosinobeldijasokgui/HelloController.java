package com.example.orvosinobeldijasokgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.io.RandomAccessFile;
import java.io.IOException;

public class HelloController {
    @FXML
    private Button saveData;
    @FXML
    private TextField evInput, nevInput, szHInput, orszagInput; //szulhal
    @FXML
    private Label savingStatus;

    private void printSavingStatus(String value, String color) {
        savingStatus.setTextFill(Paint.valueOf(color));
        savingStatus.setText(value);
    }

    public void save() {
        if (!(evInput.getText().equals("") && nevInput.getText().equals("") &&
                szHInput.getText().equals("") && orszagInput.getText().equals(""))) {
            if (Integer.parseInt(evInput.getText()) > 1989) {
                RandomAccessFile raf;
                try {
                    raf = new RandomAccessFile("dijazott.txt", "rw");
                    String kiirandoString = "Év: " + evInput.getText() +
                            "\nNév: " + nevInput.getText() +
                            "\nSz/H: " + szHInput.getText() +
                            "\nOrszág: " + orszagInput.getText();
                    raf.writeBytes(kiirandoString + "\n");
                    printSavingStatus("Sikeres mentés!", "green");

                } catch (IOException e) {
                    System.out.println("Hiba: " + e);
                    printSavingStatus("Hiba történt a mentés során!", "red");
                }
            } else {
                printSavingStatus("Hiba! Az évszám nem megfelelő!", "red");
            }
        } else {
            printSavingStatus("Töltsön ki minden mezőt!", "black");
        }
    }

    public void checkYear() {
    }
}