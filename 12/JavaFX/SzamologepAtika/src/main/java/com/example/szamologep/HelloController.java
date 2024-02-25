package com.example.szamologep;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField output;

    @FXML
    protected void onZeroClick() {
        output.setText(output.getText() + " 0 ");
    }

    @FXML
    protected void onOneClick() {
        output.setText(output.getText() + "1");
    }

    @FXML
    protected void onTwoClick() {
        output.setText(output.getText() + "2");
    }

    @FXML
    protected void onThreeClick() {
        output.setText(output.getText() + "3");
    }

    @FXML
    protected void onFourClick() {
        output.setText(output.getText() + "4");
    }

    @FXML
    protected void onFiveClick() {
        output.setText(output.getText() + "5");
    }

    @FXML
    protected void onSixClick() {
        output.setText(output.getText() + "6");
    }

    @FXML
    protected void onSevenClick() {
        output.setText(output.getText() + "7");
    }

    @FXML
    protected void onEightClick() {
        output.setText(output.getText() + "8");
    }

    @FXML
    protected void onNineClick() {
        output.setText(output.getText() + "9");
    }

    @FXML
    protected void onPlusClick() {
        output.setText(output.getText() + " + ");
    }

    @FXML
    protected void onMinusClick() {
        output.setText(output.getText() + " - ");
    }

    @FXML
    protected void onDivideClick() {
        output.setText(output.getText() + " / ");
    }

    @FXML
    protected void onMultiplyClick() {
        output.setText(output.getText() + " * ");
    }

    @FXML
    protected void onACClick() {
        output.setText("");
    }
}