package com.vizsga.mysqlgyakorlo0413;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/vizsga_gyakorlo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /*
    private static Connection conn;
    static {
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     */

    public static ArrayList<Jegyzet> getJegyzetek() {
        ArrayList<Jegyzet> jegyzetek = new ArrayList<>();
        String sql = "SELECT id, cim, tartalom FROM jegyzetek";

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String cim = rs.getString("cim");
                String tartalom = rs.getString("tartalom");

                jegyzetek.add(new Jegyzet(id, cim, tartalom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jegyzetek;
    }

    public static boolean addJegyzet(Jegyzet ujJegyzet) throws SQLException {
        String sql = "INSERT INTO jegyzetek (cim, tartalom) VALUES (?, ?)";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ujJegyzet.getCim());
            ps.setString(2, ujJegyzet.getTartalom());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean removeJegyzet(int targetId) throws SQLException {
        String sql = "DELETE FROM jegyzetek WHERE id = (?)";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, targetId);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean updateJegyzet(Jegyzet updateTarget) {
        String sql = "UPDATE jegyzetek SET cim = ?, tartalom = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, updateTarget.getCim());
            ps.setString(2, updateTarget.getTartalom());
            ps.setInt(3, updateTarget.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
