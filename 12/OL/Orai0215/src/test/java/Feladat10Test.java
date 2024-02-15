import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat10Test {
    private static Feladat10 F1;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat10(1000);
    }

    @Test
    void stringFuncTest() {
        Assertions.assertEquals(4, F1.getL(), "Hibas a stringFunc() metodus!");
    }

    @Test
    void logFuncTest() {
        F1.logFunc();
        Assertions.assertEquals(4, F1.getL(), "Hibas a logFunc() metodus!");
    }

    @Test
    void repeatedFuncTest() {
        F1.repeatedFunc();
        Assertions.assertEquals(4, F1.getL(), "Hibas a repeatedFunc() metodus!");
    }
}