package com.example.event;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class HelloApplication extends Application {
    private ListView<Event> eventListView;
    private TableView<Participant> participantTableView;
    private TextField nameTextField;
    private TextField emailTextField;
    private ObservableList<Event> eventList;
    private ObservableList<Participant> participantList;

    @Override
    public void start(Stage primaryStage) {
        // ListView a rendezvényeknek (bal oldali panel)
        eventListView = new ListView<>();
        eventListView.setPrefWidth(200);

        // TableView a résztvevőknek (középső panel)
        participantTableView = new TableView<>();

        TableColumn<Participant, String> nameColumn = new TableColumn<>("Név");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getParticipantName()));

        TableColumn<Participant, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setPrefWidth(200);
        emailColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getParticipantEmail()));

        TableColumn<Participant, Timestamp> timeColumn = new TableColumn<>("Regisztráció ideje");
        timeColumn.setPrefWidth(150);
        timeColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getRegistrationTime()));

        participantTableView.getColumns().addAll(nameColumn, emailColumn, timeColumn);

        // Alul elhelyezendő űrlap elemek (részvevő hozzáadásához/módosításához)
        nameTextField = new TextField();
        emailTextField = new TextField();

        HBox formBox = new HBox(10);
        formBox.setPadding(new Insets(10));
        formBox.getChildren().addAll(new Label("Név:"), nameTextField, new Label("Email:"), emailTextField);

        Button registrationButton = new Button("Regisztráció");
        Button updateButton = new Button("Módosítás");
        Button deleteButton = new Button("Törlés");

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(registrationButton, updateButton, deleteButton);

        VBox bottomBox = new VBox(10);
        bottomBox.getChildren().addAll(formBox, buttonBox);

        // Fő elrendezés: BorderPane
        BorderPane root = new BorderPane();
        root.setLeft(eventListView);
        root.setCenter(participantTableView);
        root.setBottom(bottomBox);

        // Eseménykezelők beállítása

        // ListView: amikor kiválasztunk egy rendezvényt, töltsük be a hozzá tartozó résztvevőket.
        eventListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int eventId = newValue.getId();
                loadParticipants(eventId);
            }
        });

        registrationButton.setOnAction(e -> handleRegistration());
        updateButton.setOnAction(e -> handleUpdate());
        deleteButton.setOnAction(e -> handleDelete());

        // Töltsük be a rendezvényeket az adatbázisból
        loadEvents();

        // Állítsuk be és mutassuk a jelenetet
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Rendezvény Regisztrációs Rendszer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Rendezvények betöltése a DatabaseUtil.getEvents() metódussal
    private void loadEvents() {
        eventList = FXCollections.observableArrayList();
        try {
            List<Event> events = DatabaseUtil.getEvents();
            eventList.addAll(events);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Hiba", "Nem sikerült betölteni a rendezvényeket!");
        }
        eventListView.setItems(eventList);
    }

    // Résztvevők betöltése egy adott rendezvényhez
    private void loadParticipants(int eventId) {
        participantList = FXCollections.observableArrayList();
        try {
            List<Participant> participants = DatabaseUtil.getParticipantsForEvent(eventId);
            participantList.addAll(participants);
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Hiba", "Nem sikerült betölteni a résztvevőket!");
        }
        participantTableView.setItems(participantList);
    }

    // Új résztvevő regisztrálása
    private void handleRegistration() {
        Event selectedEvent = eventListView.getSelectionModel().getSelectedItem();
        if (selectedEvent == null) {
            showAlert("Hiba", "Kérlek válassz egy rendezvényt!");
            return;
        }
        String name = nameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        if (name.isEmpty() || email.isEmpty()) {
            showAlert("Hiba", "A név és email megadása kötelező!");
            return;
        }
        try {
            DatabaseUtil.addParticipant(selectedEvent.getId(), name, email);
            loadParticipants(selectedEvent.getId());
            nameTextField.clear();
            emailTextField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Hiba", "A regisztráció során hiba történt!");
        }
    }

    // Résztvevő adatainak módosítása
    private void handleUpdate() {
        Participant selectedParticipant = participantTableView.getSelectionModel().getSelectedItem();
        if (selectedParticipant == null) {
            showAlert("Hiba", "Kérlek válassz egy résztvevőt a módosításhoz!");
            return;
        }
        String name = nameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        if (name.isEmpty() || email.isEmpty()) {
            showAlert("Hiba", "A név és email megadása kötelező a módosításhoz!");
            return;
        }
        try {
            DatabaseUtil.updateParticipant(selectedParticipant.getId(), name, email);
            Event selectedEvent = eventListView.getSelectionModel().getSelectedItem();
            loadParticipants(selectedEvent.getId());
            nameTextField.clear();
            emailTextField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Hiba", "A módosítás során hiba történt!");
        }
    }

    // Résztvevő törlése
    private void handleDelete() {
        Participant selectedParticipant = participantTableView.getSelectionModel().getSelectedItem();
        if (selectedParticipant == null) {
            showAlert("Hiba", "Kérlek válassz egy résztvevőt a törléshez!");
            return;
        }
        try {
            DatabaseUtil.deleteParticipant(selectedParticipant.getId());
            Event selectedEvent = eventListView.getSelectionModel().getSelectedItem();
            loadParticipants(selectedEvent.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Hiba", "A törlés során hiba történt!");
        }
    }

    // Egyszerű figyelmeztető párbeszédablak
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}