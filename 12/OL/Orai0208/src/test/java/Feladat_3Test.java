import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_3Test {
    private static Feladat_3 F1;
    private static Feladat_3 F2;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_3("macska", "kutya");
        F2 = new Feladat_3("cica", "");
    }

    @Test
    void copyarrayTest() {
        Assertions.assertEquals("macskaaytuk", F1.copyarray(), "Hibas a copyarray() metodus!");
        Assertions.assertEquals("cica", F2.copyarray(), "Hibas a copyarray() metodus!");
    }

    @Test
    void copywithoutarrayTest() {
        Assertions.assertEquals("macskaaytuk", F1.copywithoutarray(), "Hibas a copywithoutarray() metodus!");
        Assertions.assertEquals("cica", F2.copyarray(), "Hibas a copywithoutarray() metodus!");
    }
}