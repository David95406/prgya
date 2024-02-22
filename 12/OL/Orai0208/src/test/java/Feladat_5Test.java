import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_5Test {
    private static Feladat_5 F1;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_5(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}});
    }

    @Test
    void finderTest() {
        Assertions.assertEquals(1, F1.finder('e')[0], "A finder() metodus hibas tombindexet ad vissza!");
        Assertions.assertEquals(1, F1.finder('e')[1], "A finder() metodus hibas indexet ad vissza!");
    }

    @Test
    void hibasFinderTest() { //hibat fog dobni
        if (Arrays.equals(F1.finder('a'), F1.finder('z'))) {
            Assertions.fail("A finder() metodus ugyanazt az erteket adja vissza nem szereplo elemnel mint az elso elemnel!");
        }
    }
}