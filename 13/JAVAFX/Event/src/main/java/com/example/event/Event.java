package com.example.event;

public class Event {
    private int id;
    private String eventName;
    private java.sql.Date eventDate;

    public Event(int id, String eventName, java.sql.Date eventDate) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public java.sql.Date getEventDate() {
        return eventDate;
    }

    @Override
    public String toString() {
        return eventName + " (" + eventDate + ")";
    }

}
