package com.example.konyvek;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    private TableView<ElerhetKonyv> tabla = new TableView<>();
    private ObservableList<ElerhetKonyv> elerhetoKonyvek = FXCollections.observableArrayList();

    private TextField cimField = new TextField();
    private TextField szerzoField = new TextField();
    private TextField kiadasEvField = new TextField();

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("konyvek");
        TextField nameInputTF = new TextField();


        loadElerhetoKonyvekFromDatabase();


    }

    private void loadElerhetoKonyvekFromDatabase() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/konyvek", "root", "")) {
            elerhetoKonyvek.clear();
            Statement statement = connection.createStatement();
            ResultSet resultStatement = statement.executeQuery("SELECT * FROM konyvek");

            while (resultStatement.next()) {
                // elerhetoKonyvek.add(resultStatement('cim'));

            }
        } catch (SQLException e) {
            System.out.println("sql hiba");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}