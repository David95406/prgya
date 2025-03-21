package com.vizsga.nevsortest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;

public class HelloApplication extends Application {

    private ObservableList<String> nevek = FXCollections.observableArrayList();
    private ObservableList<String> nemek = FXCollections.observableArrayList();
    private ObservableList<String> korok = FXCollections.observableArrayList();

    private ListView<String> nevListView = new ListView<>(nevek);
    private ListView<String> nemListView = new ListView<>(nemek);
    private ListView<String> korListView = new ListView<>(korok);

    @Override
    public void start(Stage primaryStage) throws IOException {
        TextField nameInputTF = new TextField();
        nameInputTF.setPromptText("Adj meg egy nevet!");

        Button addButton = new Button("Név hozzáadása");
        Button deleteButton = new Button("Név törlése");

        addButton.setOnAction(e -> {
            String ujNev = nameInputTF.getText().trim();
            if (!ujNev.isEmpty()) {
                addNameToDatabase(ujNev);
                System.out.println("Sikeres hozzáadás");
                nameInputTF.clear();
                loadNamesFromDatabase();
            }
        });

        deleteButton.setOnAction(e -> {
            String targetName = nevListView.getSelectionModel().getSelectedItem();
            if (targetName != null && !targetName.isEmpty()) {
                deleteFromDatabaseByName(targetName);
                System.out.println("Sikeres törlés");
                loadNamesFromDatabase();
            }
        });

        loadNamesFromDatabase();

        HBox controls = new HBox(10, nameInputTF, addButton, deleteButton);
        HBox lists = new HBox(10, nevListView, nemListView, korListView);
        VBox root = new VBox(10, controls, lists);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Nevek Lista");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadNamesFromDatabase() {
        nevek.clear();
        nemek.clear();
        korok.clear();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nevek_db", "root", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nev, nem, kor FROM nevek");

            while (resultSet.next()) {
                nevek.add(resultSet.getString("nev"));
                nemek.add(resultSet.getString("nem"));
                korok.add(resultSet.getString("kor"));
            }
        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }
    }

    private void addNameToDatabase(String nev) {
        String sqlInsert = "INSERT INTO nevek (nev) VALUES (?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nevek_db", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, nev);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }
    }

    private void deleteFromDatabaseByName(String name) {
        String sqlDelete = "DELETE FROM nevek WHERE nev = (?) LIMIT 1";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nevek_db", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}