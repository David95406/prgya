import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TortaTest {
    private static Torta t1;
    private static Torta t2;
    private static Torta t3;

    @BeforeAll
    static void beforeAll() {
        t1 = new Torta(3, true, "negyzet");
        t3 = new Torta (3, true, "kor");
        t2 = new Torta();
    }

    @Test
    void konstruktorParameteresTest() {
        Assertions.assertEquals(3, t3.getEmeletekSzama(), "Hiba a parametes konstuktorban!");
    }

    @Test
    void konstruktorParameterNelkuliTest() {
        Assertions.assertEquals("kör", t2.getAlak());
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals("{kor;3;true}", t3.toString(), "A toString metodus hibasan irja ki az adatokat!");
    }

    @Test
    void ujEmeletTest() {
        int regiEmeletekSzama = t1.getEmeletekSzama();
        t1.ujEmelet();
        Assertions.assertEquals(regiEmeletekSzama + 1, t1.getEmeletekSzama(), "Az ujEmelet metodus nem noveli az emeletek szamat!");
    }

    @Test
    void setAlakTest() {
        t1.setAlak("gula");
        Assertions.assertEquals("gula", t1.getAlak(), "A setAlak metodus nem valtoztatja meg a torta alakjat!");
    }

    @Test
    void setAlakHibasTest() {
        try {
            t1.setAlak("");
        } catch (IllegalArgumentException iae) {
            return;
        }
        Assertions.fail("A setAlak metodus elfogad nem letezo alakot is!");
    }

    @Test
    void kremmelMegkenNemKremesTortaTest() {
        try {
            t2.kremmelMegken();
        } catch (TortaException te) {
            Assertions.fail("A kremmelMegken metodus nem keni meg a nem kremes tortat!");
        }

    }

    @Test
    void kremmelMegkenKremesTortaTest() {
        try {
            t1.kremmelMegken();//!
            Assertions.assertTrue(t1.isKremes(), "A kremmelMegken metodus nem keni meg a tortat!");
        } catch (TortaException te) {
            return;
        }
        Assertions.fail("A kremmelMegken metodus megkeni a kremes tortat!");
    }

    @Test
    void kremmelMegkenTest() {
        try {
            t2.kremmelMegken();
        } catch (TortaException te) {
            Assertions.fail("Hiba a nem kremes torta megkenesenel!");
        }
        Assertions.assertTrue(t2.isKremes(), "Hiba a kremmelMegken metodusnal!");
    }

    @Test
    void mennyiKaloriaNemKremesTortaTest() {
        t2.setKremes(false);
        Assertions.assertEquals(1000, t2.mennyiKaloria(), "A mennyiKaloria metodus hibasan szamol nem kremes torta eseten!");
    }

    @Test
    void mennyiKaloriaKremesTortaTest(){
        Assertions.assertEquals(6000, t3.mennyiKaloria(), "A mennyiKaloria metodus hibasan szamol krmes torta eseten!");
    }

}