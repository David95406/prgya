package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutobuszTest {
    private static Autobusz B1;
    private static Autobusz B2;

    @BeforeAll
    static void beforeAll() {
        B1 = new Autobusz(23, false, 6000);
        B2 = new Autobusz(45, true, 12000);
    }

    @Test
    void isCsuklosTest() {
        Assertions.assertFalse(B1.isCsuklos(), "Hiba az isCsuklos metodusnal nem csuklos busz eseten.");
        Assertions.assertTrue(B2.isCsuklos(), "Hiba az isCsuklos metodusnal csuklos busz eseten.");
    }

    @Test
    void setFerohelyTest() {
        B2.setFerohely(46);
        Assertions.assertEquals(46, B2.getFerohely(), "Hiba a setFerohely metodusnal!");
    }

    @Test
    void addUtasTest() {
        Assertions.assertTrue(B1.addUtas(21), "Hiba az addUtas metodusnal lehetseges db utas eseten!");
        Assertions.assertFalse(B2.addUtas(50), "Hiba az addUtas metodusnal nem lehetseges db utas eseten!");
        Assertions.assertFalse(B1.addUtas(5), "Hibas metodus ha a hozzaadott utasok meghaladjak a ferohelyet!");
    }

    @Test
    void isDragabbTest() {
        Assertions.assertTrue(B2.isDragabb(B1), "Hiba az isDragabb metodusnal dragabb ar eseten!");
        Assertions.assertFalse(B1.isDragabb(B2), "Hiba az isDragabb metodusnal olcsobb ar eseten!");
        Assertions.assertFalse(B1.isDragabb(B1), "Hiba az isDragabb metodusnal egyenlo arak eseten!");
    }
}