package com.example.esemenyek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EventsApplication extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(EventsApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 350);
        stage.setTitle("Események");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String view) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));

        switch (view) {
            case "main-view.fxml":
                stg.setScene(new Scene(pane, 500, 350));
                stg.setTitle("Események");
                break;
            case "createevent-view.fxml":
                stg.setScene(new Scene(pane, 350, 250));
                stg.setTitle("Létrehozás");
                break;
            case "eventlist-view.fxml":
                stg.setScene(new Scene(pane, 600, 400));
                stg.setTitle("Listázás");
                break;
            case "searchevent-view.fxml":
                stg.setScene(new Scene(pane, 500, 350));
                stg.setTitle("Keresés");
                break;
            default:
                throw new IOException("Nem letező oldal!");
        }
        System.out.println("Change scene: " + view);
    }

    public static void back() throws IOException {
        EventsApplication main = new EventsApplication();
        main.changeScene("main-view.fxml");
    }

    public static void printLabel(Label l, String value, String color) {
        l.setTextFill(Paint.valueOf(color));
        l.setText(value);
    }

}