import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_5Test {
    private static Feladat_5 F1;
    private static Feladat_5 F2;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_5(new char['a']['b']);
        F2 = new Feladat_5(new char['c']['c']);
    }

    @Test
    void finderTest() {
        Assertions.assertEquals(new int[]{0, 1}, F1.finder('a'), "hibas");
    }
}