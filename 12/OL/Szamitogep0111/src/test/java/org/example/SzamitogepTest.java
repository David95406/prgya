package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
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
    @Order(1)
    void parameterNelkuliKonstruktorTest() {
        Assertions.assertEquals(8192, Sz2.getOsszesMemoria(), "Hiba a parameter nelkuli konstruktorban!");
        Assertions.assertFalse(Sz2.isTurnOn(), "Nincs kikapcsolva a szamitogep parameter nelkuli konsturkorban!");
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
        Assertions.assertTrue(Sz1.isTurnOn(), "Hiba bekapcsolas eseten!");
        Sz2.setTurnOn(false);
        Assertions.assertFalse(Sz2.isTurnOn(), "Hiba a kikapcsolas eseten!");
    }

    @Test
    @Order(2)//lehet kulon keri, kulon kapcsolTestTrue, kapcsolTestFalse
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

    @Test
    void programMasolTestSuccess() {
        try {
            Sz1.programMasol(100);
        } catch (IllegalArgumentException iae) {
            Assertions.fail(iae.getMessage());
        } catch (ComputerMemoryException cme) {
            Assertions.fail(cme.getMessage());
        }
    }

    @Test
    void programMasolTestNegativErtek() {
        try {
            Sz1.programMasol(-100);
        } catch (IllegalArgumentException iae) {
            return;
        } catch (ComputerMemoryException cme) {
            return;
        }
        Assertions.fail("Negativ ertek eseten nem erkezett kivetel! ");
    }

    @Test
    @Order(3)
    void toStringTest() {
        Assertions.assertEquals("[8192 MB, 8192 MB, false]", Sz2.toString());
    }

    @Test
    @Order(5)
    void isTurnOnTest() {
        Assertions.assertTrue(Sz1.isTurnOn(), "Hiba az isTurnOn metodusban!");
    }

}