package com.example.szerepjatekkarakterekgui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OrkTest {
    Ork butaOrk;
    Ork okosOrk;

    @BeforeEach
    void setUp() {
        butaOrk = new Ork(10);
        okosOrk = new Ork(1000);
    }

    @Test
    void okos() {
        Assertions.assertTrue(okosOrk.okos(), "Hiba az okos metodusban -> okos ork nem okos");
        Assertions.assertFalse(butaOrk.okos(), "Hiba az okos metodusban -> nem okos ork nem okos ork");
    }
}