import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat8Test {
    private static Feladat8 F1;
    private static Feladat8 F2;
    private static Feladat8 F3;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat8(125);
        F2 = new Feladat8("123");
        F3 = new Feladat8("hallo");
    }

    @Test
    void funcTest() {
        Assertions.assertEquals(125, F1.func(), "Hibas a func() metodus int bemenet eseten!");
    }

    @Test
    void func2Test() {
        Assertions.assertEquals("123", F2.func2(), "Hibas a func() metodus string bemenet eseten!");
        Assertions.assertEquals("125", F1.func2(), "Hibas a func() metodus int bemenet eseten!");
    }

}