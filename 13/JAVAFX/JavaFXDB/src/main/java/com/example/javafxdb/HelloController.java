package com.example.javafxdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;

public class HelloController {

    @FXML
    private TableView dbDataTableView;
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn emailCol;

    @FXML
    private void loadDataFromDb() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT id, username FROM user");

            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                dbDataTableView.getItems().add(new User(id, username));
            }
        } catch (SQLException e) {
            System.out.println("hiba");
        }
    }

}