import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Feladat9Test {
    //private static Feladat9 F1;

    @BeforeAll
    static void beforeAll() {
        //nem kell peldanyositani mert static
    }

    @Test
    void funcTest() {
        //System.out.println(Arrays.toString(Feladat9.func(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] c = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(c, Feladat9.func(a, b), "Hibas a func metodus!");
    }
}