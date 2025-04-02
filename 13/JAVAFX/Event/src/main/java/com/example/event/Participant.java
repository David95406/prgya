package com.example.event;

import java.sql.Timestamp;

public class Participant {
    private int id;
    private int eventId;
    private String participantName;
    private String participantEmail;
    private Timestamp registrationTime;

    public Participant(int id, int eventId, String participantName, String participantEmail, Timestamp registrationTime) {
        this.id = id;
        this.eventId = eventId;
        this.participantName = participantName;
        this.participantEmail = participantEmail;
        this.registrationTime = registrationTime;
    }

    public int getId() {
        return id;
    }

    public int getEventId() {
        return eventId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

}
