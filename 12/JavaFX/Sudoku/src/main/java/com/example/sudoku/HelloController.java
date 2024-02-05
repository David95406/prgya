package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button checkBtn;
    @FXML
    private Label checkAlert;
    @FXML
    private TextField txt;
    @FXML
    private TextField kezdoallapotTF;
    @FXML
    private Label kezdoallapotLabel;
    @FXML
    private int SudokuLength = 4;
    @FXML
    private int kezdoallapotLength = 0;
    private int KAMAXLENGTH = SudokuLength * SudokuLength;

    @FXML
    protected void plusBtn() {
        if (SudokuLength < 9) {
            SudokuLength++;
            txt.setText(String.valueOf(SudokuLength));
        }
    }

    @FXML
    protected void minusBtn() {
        if (SudokuLength > 4)
            SudokuLength--;
        txt.setText(String.valueOf(SudokuLength));
    }

    @FXML
    protected void updateLength() {
        KAMAXLENGTH = SudokuLength * SudokuLength;
        kezdoallapotLength = kezdoallapotTF.getLength();

        if (kezdoallapotLength > KAMAXLENGTH) {
            kezdoallapotTF.setText(kezdoallapotTF.getText().substring(0, KAMAXLENGTH));
        } else {
            kezdoallapotLabel.setText("Hossz: " + kezdoallapotTF.getLength());
        }
    }

    @FXML
    protected void clickBtn() {
        checkAlert.setVisible(true);
        checkAlert.setText("Szükséges karakterek szama: " + (KAMAXLENGTH - kezdoallapotLength));
    }


}