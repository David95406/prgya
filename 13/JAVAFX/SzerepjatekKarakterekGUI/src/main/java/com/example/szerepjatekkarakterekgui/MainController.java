package com.example.szerepjatekkarakterekgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    final String URL = "jdbc:mysql://localhost:3306/szerepjatekkarakterek";
    final String USERNAME = "root";
    final String PASSWORD = "";

    @FXML
    private ComboBox<Faj> fajok;
    @FXML
    private ListView<String> karakterek;

    private ObservableList<Faj> fajokFromDB;
    private ObservableList<String> szurtKarakterek;

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resourceBundle) {
        fajokFromDB = FXCollections.observableArrayList();
        fajokFromDB.add(new Faj(-1, "Válasszon egyet..."));

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM fajok";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Faj ujFaj = new Faj(rs.getInt("id"), rs.getString("faj"));
                fajokFromDB.add(ujFaj);
            }
            conn.close();
            fajok.setItems(fajokFromDB);
            fajok.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            showAlert("Adatbazis hiba", "Sikertelen adatbazis csatlakozas!");
        }
    }

    @FXML
    private void szures(ActionEvent actionEvent) {
        int targetId = fajok.getSelectionModel().getSelectedItem().getId();
        if (targetId == 0) {
            showAlert("Kitöltési hiba", "Válasszon egy fajt!");
        } else {
            szurtKarakterek = FXCollections.observableArrayList();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                String query = "SELECT * FROM karakterek WHERE faj_id='" + targetId + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    szurtKarakterek.add(rs.getString("nev") + " (" + rs.getString("szint") + ")");
                }
                rs.close();
                st.close();

                karakterek.setItems(szurtKarakterek);
            } catch (SQLException e) {
                showAlert("Adatbazis hiba", "Sikertelen adatbazis csatlakozas!");
            }
        }
    }

    private void showAlert(String title, String body) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(body);

        a.showAndWait();
    }

}