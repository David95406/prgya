package com.example.szerepjatekkarakterekgui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OrkTest {
    Ork ork1;
    Ork ork2;

    @BeforeEach
    void setUp() {
        ork1 = new Ork(10);
        ork2 = new Ork(100);
    }

    @Test
    void okosTest() {
        Assertions.assertTrue(ork2.okos(), "Az okos() hibas ertekkel ter vissza okos ork eseten!");
        Assertions.assertFalse(ork1.okos(), "Az okos() hibas ertekkel ter vissza nem okos ork eseten!");
    }
}