package com.example.fxmltest;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> tableColLastName;
    @FXML
    private TableColumn<Person, String> tableColFirstName;

    private ArrayList<Person> persons = new ArrayList<>();

    @FXML
    private void initialize() {
        tableColFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getItems().addAll(persons);
    }

    private void refresh() {
        tableView.getItems().clear();
        tableView.getItems().addAll(persons);
    }

    @FXML
    private void addPerson(MouseEvent mouseEvent) {
        if (firstNameTextField.getLength() > 0 && lastNameTextField.getLength() > 0) {
            Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText());
            persons.add(newPerson);
            refresh();
            firstNameTextField.setText("");
            lastNameTextField.setText("");
        }
    }

    @FXML
    public void removePerson() {
        try {
            int targetIndex = tableView.getSelectionModel().getSelectedIndex();
            persons.remove(targetIndex);
            refresh();
        } catch (Exception e) {
            System.out.println("Nincs kivalasztva");
        }

    }
}