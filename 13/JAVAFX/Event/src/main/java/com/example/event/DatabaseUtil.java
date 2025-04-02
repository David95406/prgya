package com.example.event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/eventRegistrationDB";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Cseréld le a jelszóra

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Rendezvények lekérdezése
    public static List<Event> getEvents() throws SQLException {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("event_name");
                Date eventDate = rs.getDate("event_date");
                eventList.add(new Event(id, eventName, eventDate));
            }
        }
        return eventList;
    }

    // Résztvevők lekérdezése egy adott rendezvényhez
    public static List<Participant> getParticipantsForEvent(int eventId) throws SQLException {
        List<Participant> participantList = new ArrayList<>();
        String sql = "SELECT * FROM participants WHERE event_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String participantName = rs.getString("participant_name");
                    String participantEmail = rs.getString("participant_email");
                    Timestamp registrationTime = rs.getTimestamp("registration_time");
                    participantList.add(new Participant(id, eventId, participantName, participantEmail, registrationTime));
                }
            }
        }
        return participantList;
    }

    // Új résztvevő beszúrása
    public static void addParticipant(int eventId, String name, String email) throws SQLException {
        String sql = "INSERT INTO participants (event_id, participant_name, participant_email) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.executeUpdate();
        }
    }

    // Résztvevő módosítása
    public static void updateParticipant(int participantId, String name, String email) throws SQLException {
        String sql = "UPDATE participants SET participant_name = ?, participant_email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, participantId);
            ps.executeUpdate();
        }
    }

    // Résztvevő törlése
    public static void deleteParticipant(int participantId) throws SQLException {
        String sql = "DELETE FROM participants WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, participantId);
            ps.executeUpdate();
        }
    }

    // Opcionális: mintaadatok

}
