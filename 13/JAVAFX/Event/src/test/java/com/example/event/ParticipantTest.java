package com.example.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
class ParticipantTest {
    public Participant p1;

    @BeforeEach
    void setUp() {
        p1 = new Participant(1, 2, "Leon", "leonka@gmail.com", null);
    }

    @Test
    void getId() {
        Assertions.assertEquals(1, p1.getId(), "Hiba a getId metodusnal!");
    }

    @Test
    void getEventId() {
        Assertions.assertEquals(2, p1.getEventId(), "Hiba a getId metodusnal!");
    }

    @Test
    void getParticipantName() {
        Assertions.assertEquals("Leon", p1.getParticipantName(), "Hiba a getParticipantName metodusnal!");
    }

    @Test
    void getParticipantEmail() {
        Assertions.assertEquals("leonka@gmail.com", p1.getParticipantEmail(), "Hiba a getParticipantEmail metodusnal!");
    }

    @Test
    void getRegistrationTime() {
        Assertions.assertNull(p1.getRegistrationTime(), "Hiba a getRegistrationTime metodusnal!");
    }
}