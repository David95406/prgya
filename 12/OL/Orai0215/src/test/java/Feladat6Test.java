import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat6Test {
    private static Feladat6 F1;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat6();
    }

    @Test
    void funcTest() {
        Assertions.assertEquals(120, F1.func(5), "Hibasan szamol a func metodus!");
    }

}