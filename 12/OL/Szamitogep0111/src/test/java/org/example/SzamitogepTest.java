package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SzamitogepTest {
    private static Szamitogep Sz1;
    private static Szamitogep Sz2;

    @BeforeAll
    static void beforeAll() {
        Sz1 = new Szamitogep(2048, true);
        Sz2 = new Szamitogep();
    }

    @Test
    void getterTest() {
        Assertions.assertEquals(Sz1.getOsszesMemoria(), 2048, "Hiba a getOsszesMemoria getternel!");
        Assertions.assertEquals(Sz2.getSzabadMemoria(), 8192, "Hiba a getOsszesMemoria getternel " +
                "felultoltos konstruktor eseten!");
        Assertions.assertFalse(Sz2.isTurnOn(), "Hiba az isOn getternel!");
        Assertions.assertTrue(Sz1.isTurnOn(), "Hiba az isOn getternel a felultoltor konstruktornal!");
    }

    @Test
    void setterTest() {
        Sz1.setTurnOn(true);
        Assertions.assertTrue(Sz1.isTurnOn(), "Hiba a setTurnOn metodusnal!");
        Sz2.setTurnOn(false);
        Assertions.assertFalse(Sz2.isTurnOn(), "Hiba a setTurnOn metodusnal!");
    }

    @Test
    void kapcsolTest() {
        Sz1.kapcsol();
        Assertions.assertFalse(Sz1.isTurnOn(), "Hiba a kapcsol metodusnal kikapcsolas eseten!");
        Sz2.kapcsol();
        Assertions.assertTrue(Sz2.isTurnOn(), "Hiba a kapcsol metodusnal kikapcsolas eseten!");
    }

    @Test
    void programMasolTestFail() { //sikertelen masolas test
        try {
            Sz1.programMasol(9000);
        } catch (IllegalArgumentException iae) {
            return;
        } catch (ComputerMemoryException cme) {
            return;
        }
        Assertions.fail("Nem keletkezett masolasi hiba!");
    }
}