package com.example.javafxwelcome;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    @FXML
    public TextField usernameInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Label statusLabel;

    public ArrayList<User> userek = new ArrayList<>();

    private void printLabel(Label l, String value, String color) {
        l.setTextFill(Paint.valueOf(color));
        l.setText(value);
    }

    public void login() throws IOException {
        User ujUser;
        try {
            String userEmail = usernameInput.getText();
            String userPassword = passwordInput.getText();

            ujUser = new User(userEmail, userPassword);
            printLabel(statusLabel, "Sikeres bejelentkezés!", "green");
            userek.add(ujUser);
        } catch (IllegalArgumentException iea) {
            System.out.println("hibas");
            printLabel(statusLabel, "Hibas adatok.", "red");
            return;
        }

        if (ujUser.isAdmin()) {
            admin();
        }
    }

    private void admin() throws IOException {
        printLabel(statusLabel, "Adminként bejelentkezve!", "green");
        LoginApplication main = new LoginApplication();
        main.changeScene("info-view.fxml");
    }
}