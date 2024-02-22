import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DolgozatTest {
    private static Dolgozat D1;

    @BeforeAll
    static void beforeAll() {
        D1 = new Dolgozat();
    }

    @Test
    void func1Test() {
        Assertions.assertEquals(16, D1.func1(2, 4), "Hiba a func1 metodusban!");
        Assertions.assertEquals(1, D1.func1(5, 0), "Hibas a func1 metodus 0-val valo hatvanyozaskor!");
    }

    @Test
    void func2Test() {
        Assertions.assertTrue(D1.func2(new int[]{1, 2, 2}), "Hiba a func2 metodusban true return ertek eseten!");
    }

    @Test
    void func2FalseTest() {
        Assertions.assertFalse(D1.func2(new int[]{1, 2, 3}), "Hiba a func2 metodusban false return ertek eseten!");
    }

    @Test
    void func3Test() {
        Assertions.assertArrayEquals(new double[]{2.0, 3.0, 4.0}, D1.func3(new int[]{1, 2, 3}, new int[]{4, 5, 6}),
                "Hibas a func3 metodus!");
    }

    @Test
    void func4Test() {
        Assertions.assertEquals(6.4, D1.func4(new double[]{5.0, 10.0}), 0.5,  "Hibas a func4 metodus!");
    }

    @Test
    void func5Test() throws Exception {
        Assertions.assertEquals("4/2=2", D1.func5(4, 2), "Hibas a func5 metodus nem 0-val valo osztaskor!");
    }

    @Test
    void func5TestNullaval() {
        try {
            D1.func5(3, 0);
        } catch (Exception e) {
            return;
        }
        Assertions.fail("Hiba a func5 metodusban! 0-val nem lehet osztani!");
    }
}