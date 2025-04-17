package com.vizsga.mysqlgyakorlo0413;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/database";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<Object> get() {
        ArrayList<Object> result = new ArrayList<>();
        String sql = "SELECT * FROM table_name";

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String value1 = rs.getString("value1");
                String value2 = rs.getString("value2");

                result.add(new Object(value1, value2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static boolean store(Object object) throws SQLException {
        String sql = "INSERT INTO table_name (value1, value2) VALUES (?, ?)";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getValue1());
            ps.setString(2, object.getValue2());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean delete(int targetId) throws SQLException {
        String sql = "DELETE FROM table_id WHERE id = (?)";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, targetId);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean update(Object object) {
        String sql = "UPDATE table_name SET value1 = ?, value2 = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getValue1());
            ps.setString(2, object.getValue2());
            ps.setInt(3, object.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
