package com.example.esemenyek;

import javafx.scene.control.ListView;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/eventregistrationdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // rendezvenyek lekerdezese
    public static List<Event> getEvents() throws SQLException {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM events";

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("event_name");
                Date eventDate = rs.getDate("event_date");
                eventList.add(new Event(id, eventName, eventDate));
            }
        } catch (Exception e) {
            System.out.println("sql hiba: " + e);
        }

        return eventList;
    }

    //resztvevok lekerdezese
    public static List<Participant> getParticipants(int eventId) throws SQLException {
        List<Participant> participantList = new ArrayList<>();
        String sql = "SELECT * FROM participants WHERE event_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            try (ResultSet rs = ps.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String participantName = rs.getString("participant_name");
                    String participantEmail = rs.getString("participant_email");
                    Timestamp registrationTime = rs.getTimestamp("registration_time");
                    participantList.add(new Participant(id, eventId, participantName, participantEmail, registrationTime));
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            return participantList;
        }

    }
}
