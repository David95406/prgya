package com.vizsga.databaseconngyak;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/kossuthdijasok";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static ObservableList<Karakter> getKarakterek() throws SQLException {
        ObservableList<Karakter> karakterek = FXCollections.observableArrayList();
        Connection connection = getConnection();

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT nev, ev FROM dijazottak";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Karakter k = new Karakter(rs.getString(1), rs.getInt(2));
                karakterek.add(k);
            }
        } catch (Exception e) {
            System.out.println("hiba");
        }

        return karakterek;
    }

}
