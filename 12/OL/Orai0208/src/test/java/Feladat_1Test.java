import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Feladat_1Test {
    private static Feladat_1 F1;
    private static Feladat_1 F2;
    private static Feladat_1 F3;

    @BeforeAll
    static void beforeAll() {
        F1 = new Feladat_1("macska");
        F2 = new Feladat_1(" ");
        F3 = new Feladat_1("Elemer");
    }

    @Test
    void exchangeTest() {
        Assertions.assertEquals("m?csk?", F1.exchange('a'), "Hibasan csereli ki a karaktereket az exchange() metodus!");
        Assertions.assertEquals("?", F2.exchange(' '), "Hibasan csereli ki a karaktereket az exchange() metodus!");
        Assertions.assertEquals("?lemer", F3.exchange('E'), "Hibasan csereli ki a karaktereket az exchange() metodus! (nagybetu-kisbetu)");
    }

    @Test
    void exchangeTestValtozasNelkul() {
        Assertions.assertEquals("macska", F1.exchange('d'), "Hibasan csereli ki a karaktereket az exchange() metodus!");
    }

}