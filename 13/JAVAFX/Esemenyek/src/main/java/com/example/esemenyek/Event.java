package com.example.esemenyek;

import java.sql.Date;

public class Event {
    private int id;
    private String eventName;
    private java.sql.Date eventDate;

    public Event(int id, String eventName, Date eventDate) {
        setId(id);
        setEventName(eventName);
        setEventDate(eventDate);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + getId() +
                ", eventName='" + getEventName() + '\'' +
                ", eventDate=" + getEventDate() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public java.sql.Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
