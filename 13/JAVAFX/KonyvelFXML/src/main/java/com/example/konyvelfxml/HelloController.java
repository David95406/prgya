package com.example.konyvelfxml;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private TextField KNevTextField;
    @FXML
    private TableView<ElerhetoKonyv> elerhetoKonyvTableView;
    @FXML
    private TableColumn<ElerhetoKonyv, String> EKCim;
    @FXML
    private TableColumn<ElerhetoKonyv, String> EKSzerzo;
    @FXML
    private TableColumn<ElerhetoKonyv, Integer> EKKiadasEve;
    @FXML
    private TableView<KiadottKonyv> kiadottKonyTableView;
    @FXML
    private TableColumn<KiadottKonyv, String> KKCim;
    @FXML
    private TableColumn<KiadottKonyv, String> KKKolcsonzo;
    @FXML
    private TableColumn<KiadottKonyv, String> KKDatum;

    @FXML
    private void kiadas() {
        System.out.println("kiadas");
        String nev = KNevTextField.getText();
        if (nev.isEmpty()) {
            System.out.println("Nem adtál meg nevet!");
            return;
        }

        ElerhetoKonyv selectedElerhetoKonyv = elerhetoKonyvTableView.getSelectionModel().getSelectedItem();
        if (selectedElerhetoKonyv == null) {
            System.out.println("Nem választottál ki könyvet!");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/konyvek", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO kiadott_konyvek (konyv_id, kolcsonzo_neve, kiadas_datuma) VALUES (" + selectedElerhetoKonyv.getId() + ", '" + nev + "', NOW())");
            statement.executeUpdate("UPDATE elerheto_konyvek SET status = 'kikolcsonozve' WHERE id = " + selectedElerhetoKonyv.getId());
            initialize();

        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }
        System.out.println("sikeres kiadas");
    }

    @FXML
    private void visszavetel() {
        System.out.println("visszavetel");
        KiadottKonyv selectedKiadottKonyv = kiadottKonyTableView.getSelectionModel().getSelectedItem();
        if (selectedKiadottKonyv == null) {
            System.out.println("Nem választottál ki könyvet!");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/konyvek", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM kiadott_konyvek WHERE id = " + selectedKiadottKonyv.getId());
            statement.executeUpdate("UPDATE elerheto_konyvek SET status = 'elerheto' WHERE id = " + selectedKiadottKonyv.getKonyvId());
            initialize();
        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }

        System.out.println("sikeres visszavetel");
    }

    @FXML
    public void initialize() {
        EKCim.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCim()));
        EKSzerzo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSzerzo()));
        EKKiadasEve.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getKiadasEv()).asObject());

        KKCim.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCim()));
        KKKolcsonzo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKolcsonzoNeve()));
        KKDatum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKiadasDatum()));

        ObservableList<ElerhetoKonyv> elerhetoKonyvek = FXCollections.observableArrayList();
        ObservableList<KiadottKonyv> kiadottKonyvek = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/konyvek", "root", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM elerheto_konyvek");

            while (resultSet.next()) {
                elerhetoKonyvek.add(new ElerhetoKonyv(
                        resultSet.getInt("id"),
                        resultSet.getString("cim"),
                        resultSet.getString("szerzo"),
                        resultSet.getInt("kiadas_eve"),
                        resultSet.getString("status")
                ));
            }

            resultSet = statement.executeQuery("SELECT kiadott_konyvek.id, kiadott_konyvek.konyv_id, elerheto_konyvek.cim, kiadott_konyvek.kolcsonzo_neve, kiadott_konyvek.kiadas_datuma FROM kiadott_konyvek INNER JOIN elerheto_konyvek ON kiadott_konyvek.konyv_id = elerheto_konyvek.id");
            while (resultSet.next()) {
                kiadottKonyvek.add(new KiadottKonyv(
                        resultSet.getInt("id"),
                        resultSet.getInt("konyv_id"),
                        resultSet.getString("cim"),
                        resultSet.getString("kolcsonzo_neve"),
                        resultSet.getString("kiadas_datuma")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Sql hiba: " + e);
        }

        elerhetoKonyvTableView.setItems(elerhetoKonyvek);
        kiadottKonyTableView.setItems(kiadottKonyvek);
        System.out.println("sikeres betoltes/frissites ");
    }
}