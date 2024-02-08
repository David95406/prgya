import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_2Test {
    private static Feladat_2 F1;
    private static Feladat_2 F2;
    private static Feladat_2 F3;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_2(new String[]{"macska", "kutya"});
        F2 = new Feladat_2(new String[]{"", ""});
        F3 = new Feladat_2(new String[]{});
    }

    @Test
    void counterTest() {
        Assertions.assertEquals(11, F1.counter(), "Hibasan szamol a counter() metodus!");
        Assertions.assertEquals(0, F2.counter(), "Hibasan szamol a counter() metodus! (ures tombok)");
        Assertions.assertEquals(0, F3.counter(), "Hibasan szamol a counter() metodus! (nincs tomb)");
    }
}