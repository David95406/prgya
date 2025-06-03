package com.vizsga.kossuthdijasokgui;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/kossuthdijasok";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static ArrayList<SearchResult> filterByMunkakor(String munkakor) throws SQLException {
        ArrayList<SearchResult> eredmeny = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT dijazottak.nev, dijazottak.ev, munkakor.munkakor, dijazottak.megjegyzes FROM dijazottak INNER JOIN munkakor ON dijazottak.munkakor_id = munkakor.munkakor_id WHERE munkakor.munkakor LIKE '%" + munkakor + "%';";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                SearchResult sr = new SearchResult(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                eredmeny.add(sr);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot connect the database!", e);
        }

        return eredmeny;
    }

}
