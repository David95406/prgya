package com.example.esemenyek;

import java.sql.Timestamp;

public class Participant {
    private int id;
    private int eventId;
    private String participant_name;
    private String participant_email;
    private java.sql.Timestamp registration_time;

    public Participant(int id, int eventId, String participant_name, String participant_email, Timestamp registration_time) {
        setId(id);
        setEventId(eventId);
        setParticipant_name(participant_name);
        setParticipant_email(participant_email);
        setRegistration_time(registration_time);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + getId() +
                ", eventId=" + getEventId() +
                ", participant_name='" + getParticipant_name() + '\'' +
                ", participant_email='" + getParticipant_email() + '\'' +
                ", registration_time=" + getRegistration_time() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getParticipant_email() {
        return participant_email;
    }

    public void setParticipant_email(String participant_email) {
        this.participant_email = participant_email;
    }

    public Timestamp getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Timestamp registration_time) {
        this.registration_time = registration_time;
    }
}
