import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_4Test {
    private static Feladat_4 F1;
    private static Feladat_4 F2;
    private static Feladat_4 F3;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_4("koki", "leon");
        F2 = new Feladat_4("kutya", "");
        F3 = new Feladat_4("aligator", "tyuk");
    }

    @Test
    void alternatearrayTest() {
        Assertions.assertEquals("kloekoin", F1.alternatearray(), "Hibas az alternatearray() metodus!");
        Assertions.assertEquals("kutya", F2.alternatearray(), "Hibas az alternatearray() metodus!");
        Assertions.assertEquals("atlyiugkator", F3.alternatearray(), "Hibas az alternatearray() metodus");
    }

    @Test
    void alternatewithoutarray() {
        Assertions.assertEquals("kloekoin", F1.alternatearray(), "Hibas az alternatearray() metodus!");
        Assertions.assertEquals("kutya", F2.alternatearray(), "Hibas az alternatearray() metodus!");
        Assertions.assertEquals("atlyiugkator", F3.alternatearray(), "Hibas az alternatearray() metodus");
    }
}