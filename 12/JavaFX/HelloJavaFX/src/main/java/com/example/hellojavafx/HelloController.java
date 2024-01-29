package com.example.hellojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameField;

    @FXML
    private Label clickCount;
    private int cC = 1;

    @FXML
    protected void onHelloButtonClick() {
        String name = nameField.getText();
        if (name.isEmpty()) {
            name = "Anonymus";
        }
        welcomeText.setText("Hello, " + name + "!");
        clickCount.setText("Cick count: " + cC++);
    }


}