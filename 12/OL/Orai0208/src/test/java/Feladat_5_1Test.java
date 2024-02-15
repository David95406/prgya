import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_5_1Test {
    private static Feladat_5 F1;
    private static Feladat_5 F2;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_5(new char[][]{
                {'a', 'l', 'm', 'a'},
                {'h', 'e', 'g'},
                {'h', 'a', 'b'}
        });
        F2 = new Feladat_5(new char[][]{
                {'a', 'b', 'c'},
                {'a', 'd', 'h'}
        });
    }

    @Test
    void finderTest() {
        Assertions.assertArrayEquals(new int[]{0, 1}, F1.finder('l'), "Hibas a finder() metodus!");
    }

    @Test
    void finderSuccessTest() {
        Assertions.assertArrayEquals(new int[2], F1.finder('a'), "Hibas a finder() metodus!");
    }

}