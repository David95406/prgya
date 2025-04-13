package com.vizsga.mysqlgyakorlo0413;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TableView<Jegyzet> jegyzetekTableView;
    @FXML
    private TableColumn<Jegyzet, String> jegyzetCimColumn;
    @FXML
    private TableColumn<Jegyzet, String> jegyzetTartalomColumn;
    @FXML
    private TextArea jegyzetTartalomTextArea;
    @FXML
    private TextField jegyzetCimTextField;
    @FXML
    private TextArea updateJegyzetTartalomTextArea;
    @FXML
    private TextField updateJegyzetCimTextField;


    private ArrayList<Jegyzet> jegyzetek;
    private Jegyzet updateTarget;

    @FXML
    private void initialize() {
        jegyzetek = DatabaseUtil.getJegyzetek();

        jegyzetCimColumn.setCellValueFactory(new PropertyValueFactory<>("cim"));
        jegyzetTartalomColumn.setCellValueFactory(new PropertyValueFactory<>("tartalom"));

        jegyzetekTableView.getItems().addAll(jegyzetek);
    }

    private void refresh() {
        jegyzetek = DatabaseUtil.getJegyzetek();

        jegyzetekTableView.getItems().clear();
        jegyzetekTableView.getItems().addAll(jegyzetek);
        setSelected();
    }

    @FXML
    private void createJegyzet() throws SQLException {
        Jegyzet ujJegyzet = new Jegyzet(jegyzetCimTextField.getText(), jegyzetTartalomTextArea.getText());

        if (!ujJegyzet.isEmpty()) {
            if (DatabaseUtil.addJegyzet(ujJegyzet)) {
                refresh();
                jegyzetCimTextField.clear();
                jegyzetTartalomTextArea.clear();
            } else {
                showAlert("Hiba tortent!");
            }
        } else {
            showAlert("Hianyos mezok!");
        }
    }

    @FXML
    private void removeJegyzet() throws SQLException {
        int targetId;

        try {
            targetId = jegyzetekTableView.getSelectionModel().getSelectedItem().getId();
        } catch (Exception e) {
            showAlert("Nincs kijelolet elem!");
            return;
        }

        if (DatabaseUtil.removeJegyzet(targetId)) {
            refresh();
        } else {
            showAlert("Hiba tortent torles soran!");
        }
    }

    private void showAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.ERROR, alertText);
        alert.showAndWait();
    }

    @FXML
    private void setSelected() {
        try {
            updateTarget = jegyzetekTableView.getSelectionModel().getSelectedItem();

            updateJegyzetCimTextField.setText(updateTarget.getCim());
            updateJegyzetTartalomTextArea.setText(updateTarget.getTartalom());
        } catch (Exception e) {
            updateTarget = null;

            updateJegyzetCimTextField.setText("");
            updateJegyzetTartalomTextArea.setText("");
        }

    }

    @FXML
    private void updateJegyzet() {
        Jegyzet updatetedTarget = new Jegyzet(updateTarget.getId(), updateJegyzetCimTextField.getText(), updateJegyzetTartalomTextArea.getText());

        if (!updatetedTarget.isEmpty()) {
            if (DatabaseUtil.updateJegyzet(updatetedTarget)) {
                refresh();
            } else {
                showAlert("Hiba tortent!");
            }
        } else {
            showAlert("Hianyos mezok!");
        }

    }
}