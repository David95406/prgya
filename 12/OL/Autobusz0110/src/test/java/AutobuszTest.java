import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutobuszTest {
    private static Autobusz B1;
    private static Autobusz B2;

    @BeforeAll
    static void beforeAll() {
        B1 = new Autobusz(20, 850, 7000);
        B2 = new Autobusz(30, 1000, 10000);
    }

    @Test
    void getFerohelyTest() {
        Assertions.assertEquals(20, B1.getFerohely(), "Hiba a getFerohely metodusnal!");
    }

    @Test
    void setFerohelyTest() {
        B1.setFerohely(18);
        Assertions.assertEquals(18, B1.getFerohely(), "Hiba a setFerohely metodusnal!");
    }

    @Test
    void addUtasTest() {
        Assertions.assertTrue(B1.addUtas(10), "Hibas az addUtas metodus lehetseges esetben!");
        Assertions.assertFalse(B2.addUtas(43), "Hibas az addUtas metodus lehetetlen esetben! (tobb utas mint ferohely)");
    }

    @Test
    void nagyobbETest() {
        Assertions.assertTrue(B2.nagyobbE(B1), "Hibas az osszehasonlito metodus!");
        Assertions.assertFalse(B1.nagyobbE(B2), "Hibas az osszehasonlito metodus!");
    }
}