import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat7Test {
    private static Feladat7 F1;
    private static Feladat7 F2;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat7(7);
        F2 = new Feladat7(9);
    }

    @Test
    void funcTrueTest() {
        Assertions.assertTrue(F1.func(), "Hibas a func metodus!");
    }

    @Test
    void funcFalseTest() {
        Assertions.assertFalse(F2.func(), "Hibas a func metodus!");
    }

}