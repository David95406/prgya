package com.example.szamologep;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public Button plusBtn, minusBtn, divideBtn, multiplyBtn;
    int firstNum = 0;
    int secondNum = 0;
    int operator = 0;
    boolean isMinus = false;

    @FXML
    private TextField output;

    @FXML
    protected void onZeroClick() {
        output.setText(output.getText() + "0");
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
    private void setOperators(boolean value) {
        plusBtn.setDisable(value);
        minusBtn.setDisable(value);
        multiplyBtn.setDisable(value);
        divideBtn.setDisable(value);
    }

    @FXML
    protected void onPlusClick() {
        if (output.getText().equals("-")) {
            output.setText("");
            isMinus = false;
        } else {
            firstNum = Integer.parseInt(output.getText());
            output.setText("");
            operator = 1;
            setOperators(true);
        }
    }

    @FXML
    protected void onMinusClick() {
        if (output.getText().isEmpty()) {
            isMinus = true;
            output.setText("-");
        } else {
            firstNum = isMinus ? (Integer.parseInt(output.getText()) * -1) : Integer.parseInt(output.getText());
            output.setText("");
            operator = 2;
            setOperators(true);
        }
    }

    @FXML
    protected void onMultiplyClick() {
        firstNum = Integer.parseInt(output.getText());
        output.setText("");
        operator = 3;
        setOperators(true);
    }

    @FXML
    protected void onDivideClick() {
        firstNum = Integer.parseInt(output.getText());
        output.setText("");
        operator = 4;
        setOperators(true);
    }

    @FXML
    protected void onACClick() {
        firstNum = 0;
        secondNum = 0;
        output.setText("");
        setOperators(false);
    }

    public void onEquals() {
        secondNum = Integer.parseInt(output.getText());
        output.setText("");
        switch (operator) { //(1 +) (2 -) (3 *) (4 /)
            case 1: output.setText(String.valueOf(firstNum + secondNum)); break;
            case 2: output.setText(String.valueOf(firstNum - secondNum)); break;
            case 3: output.setText(String.valueOf(firstNum * secondNum)); break;
            case 4: output.setText(String.valueOf((double) firstNum / secondNum)); break;
            default: output.setText("Math error"); break;
        }
    }
}