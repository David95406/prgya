package com.example.javafxdb;

import java.sql.*;

public class DatabaseConnection {
    private static final String DB_URL = "jbdc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("mysql hiba: " + e);
        }
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }



}
