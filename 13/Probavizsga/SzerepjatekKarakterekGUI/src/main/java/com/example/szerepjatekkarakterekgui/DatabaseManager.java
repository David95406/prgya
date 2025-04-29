package com.example.szerepjatekkarakterekgui;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/szerepjatekkarakterek";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<String> getFajok() throws SQLException {
        Connection conn = getConnection();
        String sql = "SELECT faj from fajok";
        ResultSet rs = conn.createStatement().executeQuery(sql);

        ArrayList<String> fajok = new ArrayList<>();
        while (rs.next()) {
            String nev = rs.getString(1);
            fajok.add(nev);
        }

        return fajok;
    }

    public static ArrayList<String> getKarakterFromName(String targetName) throws SQLException {
        Connection conn = getConnection();
        String sql = "SELECT nev, szint FROM karakterek INNER JOIN fajok ON fajok.id = karakterek.faj_id WHERE fajok.faj = ('" + targetName + "');";
        ResultSet rs = conn.createStatement().executeQuery(sql);

        ArrayList<String> eredmeny = new ArrayList<>();

        while (rs.next()) {
            String nev = rs.getString(1);
            int szint = rs.getInt(2);

            String text = nev + " (" + szint + " szint)";
            eredmeny.add(text);
        }

        return eredmeny;
    }
}
