package com.example.konyvtar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class KonyvtarApplication extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(KonyvtarApplication.class.getResource("createbook-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Könyvtár nyilvántartó!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String view) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));

        switch (view) {
            case "stock-view.fxml" -> {
                stg.setScene(new Scene(pane, 600, 400));
                stg.setTitle("Készlet");
            }
            case "createbook-view.fxml" -> {
                stg.setScene(new Scene(pane, 500, 300));
                stg.setTitle("Könyvtár nyilvántartó!");
            }
            default -> throw new IOException("Nem létező oldal!");
        }
    }

    public static void back() throws IOException {
        KonyvtarApplication main = new KonyvtarApplication();
        main.changeScene("createbook-view.fxml");
    }

    public static void printLabel(Label l, String value, String color) {
        l.setTextFill(Paint.valueOf(color));
        l.setText(value);
    }

    public static void main(String[] args) {
        launch();
    }
}