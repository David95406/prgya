import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvesLeolvasasTest {
    private static EvesLeolvasas el1, el2, el3, el4;

    @BeforeAll
    static void beforeAll() {
        el1 = new EvesLeolvasas(90, 5600);
        el3 = new EvesLeolvasas(10, 9000);
    }

    @Test
    void negativKonstruktorTest() {
        try {
            el2 = new EvesLeolvasas(-90, 100);
        } catch (IllegalArgumentException iae) {
            return;
        }

        Assertions.fail("Nem keletkezett IllegalArgumentException negativ ár esetén a konstruktorban!");
    }

    @Test
    void setArTestSikeres() {
        el3.setAr(80);
        Assertions.assertTrue(80, el3.getAr(), "Hibas a setAr metodus!");
    }

    @Test
    void setArSikertelenNegativ() {
        try {
            el3.setAr(-10);
        } catch (IllegalArgumentException iae) {
            return;
        }
        Assertions.fail("Nem keletkezett IllegalArgumentException a setAr negativ ár eseten!");
    }

    @Test
    void setArSikertelenKetszeres() {
        try {
            el3.setAr((el3.getAr() * 2) + 1);
        } catch (IllegalArgumentException iae) {
            return;
        }
        Assertions.fail("Nem keletkezett IllegalArgumentException tul magas ar eseten!");
    }

    @Test
    void getFizetendoTest() {
        Assertions.assertEquals(126000, el1.getFizetendo(3), "Hibasan szamol a getFizetendo metodus!");
    }

    @Test
    void getFizetendoTestKerekit() {
        Assertions.assertEquals(53839, el4.getFizetendo(2), "Hibasan szamol a getFizetendo metodus!");
    }


}