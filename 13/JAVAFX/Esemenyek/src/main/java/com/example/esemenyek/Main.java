package com.example.esemenyek;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main extends Application {
    private ListView<Event> eventListView;
    private TableView participantTableView;
    private TextField nameTextField;
    private TextField emailTextField;
    private ObservableList<Event> eventList;
    private ObservableList<Participant> participantList;

    @Override
    public void start(Stage primaryStage) {
        eventListView = new ListView<>();
        eventListView.prefWidth(200);

        participantTableView = new TableView();

        TableColumn<Participant, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getParticipant_name())
        );

        TableColumn<Participant, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setPrefWidth(200);
        emailColumn.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getParticipant_email())
        );

        TableColumn<Participant, String> timeColumn = new TableColumn<>("Regisztracio ideje");
        timeColumn.setPrefWidth(150);
        timeColumn.setCellValueFactory(cellData ->
            new SimpleObjectProperty(cellData.getValue().getRegistration_time())
        );

        participantTableView.getColumns().addAll(nameColumn, emailColumn, timeColumn);

        nameTextField = new TextField();
        emailTextField = new TextField();

        HBox formBox = new HBox(10);
        formBox.setPadding(new Insets(10));
        formBox.getChildren().addAll(new Label("Név: "), nameTextField,
                new Label("Email: "), emailTextField);

        Button registrationButton = new Button("Regisztráció");
        Button updateButton = new Button("Modositas");
        Button deleteButton = new Button("Torles");

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(registrationButton, updateButton, deleteButton);

        VBox bottomBox = new VBox(10);
        bottomBox.getChildren().addAll(buttonBox, formBox);

        BorderPane root = new BorderPane();
        root.setLeft(eventListView);
        root.setCenter(participantTableView);
        root.setBottom(bottomBox);

        eventListView.getSelectionModel().selectedItemProperty().addListener((
                observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                int eventId = newValue.getId();

                loadParticipiants(eventId);
            }
        });

        loadEvents();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("rendezvenyek");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private void loadEvents() {
        eventList = FXCollections.observableArrayList();

        try {
            List<Event> events = DatabaseUtil.getEvents();
            eventList.addAll(events);
        } catch (SQLException e) {
            e.printStackTrace();
            //showAlert = new Alert("hiba", "nem sikerult betolteni az adatokat.");
        }

        eventListView.setItems(eventList);
    }

    private void loadParticipiants(int eventId) {
        participantList = FXCollections.observableArrayList();

        try {
            List<Participant> participants = DatabaseUtil.getParticipants(eventId);

            participantList.addAll(participants);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        participantTableView.setItems(participantList);
    }

    public static void main(String[] args) {
        launch();
    }
}