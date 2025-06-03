package com.vizsga.kossuthdijasokgui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijazottTest {
    private final String ELSO_MUNKAKOR = "szobrász";
    private final String MASODIK_MUNKAKOR = "festő";
    Dijazott dijazott;

    @BeforeEach
    void setUp() {
        dijazott = new Dijazott("Adam", 1933, ELSO_MUNKAKOR, "ugyes volt");
    }

    @Test
    void setMunkakorTest() {
        Assertions.assertEquals(dijazott.getMunkakor(), ELSO_MUNKAKOR, "Hibas konstruktor!");
        dijazott.setMunkakor(MASODIK_MUNKAKOR);
        Assertions.assertEquals(dijazott.getMunkakor(), MASODIK_MUNKAKOR, "Hibas a setMunkakor metodus ervenyes string munkakor eseten");
    }
}