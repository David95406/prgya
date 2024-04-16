package com.example.javafxwelcome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void changeScene(String view) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(view));
        stg.setScene(new Scene(pane, 500, 350));
        //stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}