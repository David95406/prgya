import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SzovegTest {
    private static String szoveg1 = "almakorteszilvabarack";
    private static String szoveg2 = "almakorteszilvabarac";
    private static String szoveg3 = "   alma\tkorte";

    private static String szoveg1eredmeny = "almakortes\nzilvabarac\nk";
    private static String szoveg2eredmeny = "almak\nortes\nzilva\nbarac";
    private static String szoveg3eredmeny = "alma   korte";


    private static Szoveg sz1, sz2, sz3;

    @BeforeAll
    static void beforeAll() {
        sz1 = new Szoveg(szoveg1);
        sz2 = new Szoveg(szoveg2);
        sz3 = new Szoveg(szoveg3);
    }

    @Test
    void atalakitTestAlap() {
        Assertions.assertEquals(szoveg1eredmeny, sz1.atalakit(), "Hibas az atalakit metodus!");
        Assertions.assertEquals(szoveg2eredmeny, sz2.atalakit(5), "Hibas az atalakit metodus!");
    }

    @Test
    void tisztitTest() {
        sz3.tisztit();
        Assertions.assertEquals(szoveg3eredmeny, sz3.getValue(), "Hibas");
    }


}