package com.vizsga.keszletnyilvantarto;

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

public class Main extends Application {
    private TableView<Termek> tabla = new TableView<>();
    private ObservableList<Termek> termekek = FXCollections.observableArrayList();

    private TextField nevField = new TextField();
    private TextField mennyisegField = new TextField();
    private TextField arField = new TextField();
    private TextArea megjegyzesField = new TextArea();

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Keszletkezelo");

        configureTable();
        tabla.setItems(termekek); // Set items to the table

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        GridPane inputPanel = createInputPanel();
        HBox buttonPanel = createButtonPanel();

        root.setTop(inputPanel);
        root.setCenter(tabla);
        root.setBottom(buttonPanel);

        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    private void configureTable() {
        TableColumn<Termek, String> nevCol = new TableColumn<>("Termeknev");
        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));

        TableColumn<Termek, Number> mennyisegCol = new TableColumn<>("Mennyiseg");
        mennyisegCol.setCellValueFactory(
                cellData -> cellData.getValue().mennyisegProperty());

        TableColumn<Termek, Number> arCol = new TableColumn<>("Ár");
        arCol.setCellValueFactory(
                cellData -> cellData.getValue().arProperty());

        TableColumn<Termek, String> statuszCol = new TableColumn<>("Státusz");
        statuszCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        mennyisegCol.setCellFactory(column -> new TableCell<Termek, Number>() {
            @Override
            protected void updateItem(Number item, boolean isEmpty) {
                super.updateItem(item, isEmpty);
                if (isEmpty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    if (item.intValue() < 5) {
                        setStyle("-fx-background-color: red");
                    } else {
                        setStyle("");
                    }
                }
            }
        });

        tabla.getColumns().addAll(nevCol, mennyisegCol, arCol, statuszCol);

        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                loadSelectedProduct(newVal);
            }
        });
    }

    private void loadSelectedProduct(Termek termek) {
        nevField.setText(termek.getNev());
        mennyisegField.setText(String.valueOf(termek.getMennyiseg()));
        arField.setText(String.valueOf(termek.getAr()));
        megjegyzesField.setText(termek.getMegjegyzes());
    }

    private HBox createButtonPanel() {
        HBox panel = new HBox(10);

        Button addButton = new Button("Hozzáadás");
        Button modifyButton = new Button("Modositas");
        Button deleteButton = new Button("Torles");

        addButton.setOnAction(e -> addTermek());
        modifyButton.setOnAction(e -> modifyTermek());
        deleteButton.setOnAction(e -> deleteTermek());

        panel.setPadding(new Insets(10));
        panel.getChildren().addAll(addButton, modifyButton, deleteButton);

        return panel;
    }

    private void addTermek() {
        try {
            Termek ujTermek = new Termek(
                    nevField.getText(),
                    Integer.parseInt(mennyisegField.getText().replaceAll("[^0-9]", "")),
                    Double.parseDouble(arField.getText().replaceAll("[^0-9.]", "")),
                    megjegyzesField.getText()
            );
            termekek.add(ujTermek);
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Hibas adat", e.toString());
        }
    }

    private void modifyTermek() {
        Termek selected = tabla.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setNev(nevField.getText());
                selected.setMennyiseg(Integer.parseInt(mennyisegField.getText().replaceAll("[^0-9]", "")));
                selected.setAr(Double.parseDouble(arField.getText().replaceAll("[^0-9.]", "")));
                selected.setMegjegyzes(megjegyzesField.getText());

                tabla.refresh();
            } catch (NumberFormatException e) {
                showAlert("Hibas adat!", e.toString());
            }
        } else {
            showAlert("Hianyos adat!", "Nincs kiválasztott termék!");
        }
    }

    private void deleteTermek() {
        Termek selected = tabla.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setHeaderText("Torles megerositese");
            confirmAlert.setContentText("Biztosan torolni szeretne?");

            if (confirmAlert.showAndWait().get() == ButtonType.OK) {
                termekek.remove(selected);
                clearFields();
            }
        }
    }

    private void clearFields() {
        nevField.clear();
        mennyisegField.clear();
        arField.clear();
        megjegyzesField.clear();
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private GridPane createInputPanel() {
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20));

        // Fix label positions
        Label nevLabel = new Label("Terméknév:");
        grid.add(nevLabel, 0, 0);
        nevField.setPrefWidth(250);
        grid.add(nevField, 1, 0);

        Label mennyisegLabel = new Label("Mennyiség:");
        grid.add(mennyisegLabel, 0, 1);  // Fixed position to row 1
        mennyisegField.setPrefWidth(250);
        grid.add(mennyisegField, 1, 1);

        Label arLabel = new Label("Ár:");
        grid.add(arLabel, 0, 2);
        arField.setPrefWidth(250);
        grid.add(arField, 1, 2);

        Label megjegyzesLabel = new Label("Megjegyzés:");
        grid.add(megjegyzesLabel, 0, 3);

        megjegyzesField.setPrefRowCount(3);
        megjegyzesField.setWrapText(true);
        megjegyzesField.setPromptText("Opcionalis megjegyzes...");

        ScrollPane scrollPane = new ScrollPane(megjegyzesField);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setFitToWidth(true);

        grid.add(scrollPane, 1, 3);

        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}