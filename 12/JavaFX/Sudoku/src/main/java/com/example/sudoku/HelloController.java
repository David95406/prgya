package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class HelloController {
    @FXML
    private TextField txt;

    private int szam = 4;

    @FXML
    protected void plusBtn() {
        if (szam < 9) {
            szam++;
            txt.setText(String.valueOf(szam));
        }
    }

    @FXML
    protected void minusBtn() {
        if (szam > 4)
            szam--;
        txt.setText(String.valueOf(szam));
    }
}