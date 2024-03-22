import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestClass {

    private static Etel e1, e2;
    private static Pizza p1, p2, p3, p4, p5;

    @BeforeAll
    static void beforeAll() {
        e1 = new Etel("tej", 200);
        e2 = new Etel("sajt", 400);
        p1 = new Pizza("sajtos", 1500, 1500);
        p4 = new Pizza("szalamis", 2000, 2300);
    }

     @Test
     void pizzaKonstruktorTest() {
        p3 = new Pizza("szalamis", 2000, 2100);
        Assertions.assertEquals("szalamis", p3.getNev(), "Hibas a konstruktor!");
        Assertions.assertEquals(2000, p3.getKaloria(), "Hibas a konstruktor!");
        Assertions.assertEquals(2100, p3.getAr(), "Hibas a konstruktor!");
     }

    @Test
    void pizzaFelultoltosKonstruktorTest() {
        p2 = new Pizza("sajtos", 1500);
        Assertions.assertEquals(3200, p2.getAr(), "Hibas a felultoltos konsturktor!");
    }

    @Test
    void pizzaKonstruktorNegativArTest() {
        try {
            p5 = new Pizza("sajtos", 1500, -1000);
        } catch (IllegalArgumentException iae) {
            return;
        }
        Assertions.fail("Nem keletkezett kivetel negativ ar beallitasa eseten a pizza osztalyban!");
    }

    @Test
    void pizzaGetArTest() {
        Assertions.assertEquals(2300, p3.getAr(), "Hibas a getAr metodus!");
    }

    @Test
    void pizzaFeltetetFelveszTest() {
        p4.feltetetFelvesz(new Feltet("paradicsomos", 240));
        p4.feltetetFelvesz(new Feltet("sajt", 300));

        ArrayList<Feltet> feltetek = new ArrayList<Feltet>();
        feltetek.add(new Feltet("paradicsomos", 240));
        feltetek.add(new Feltet("sajt", 300));
        Feltet f[] = {new Feltet("paradicsomos", 240), new Feltet("sajt", 300)};
        Assertions.assertArrayEquals(f, p4.getFeltetek(), "Hibas a feltetetFelvesz metodus!");

        Assertions.assertEquals(2540, p4.getKaloria(), "Hibas a feltetetFelvesz metodus!");
        Assertions.assertEquals(2500, p4.getAr(), "Hibas a feltetetFelvesz metodus!");
        try {
            p4.feltetetFelvesz(new Feltet("paradicsomos", 240));
        } catch (Exception e) {
            return;
        }
        Assertions.fail("Nem keletkezett kivetel ketto azonos feltet hozzaadasakor!");
    }
    @Test
    void etelToStringTest() {
        Assertions.assertEquals("tej (200 kalória), fogyasztható: igen", e1.toString(),
                "Hibas az etel osztaly toString metodus!");
    }

    @Test
    void setKaloriaNegativErtekTest() {
        try {
            e2.setKaloria(-100);
            Assertions.assertEquals(0, e2.getKaloria(), "Hibas a setKaloria metodus!");
        } catch (IllegalArgumentException iea) {
            Assertions.fail("Hiba: kivetel keletkezett a setKaloria metodusban!");
        }

    }

    @Test
    void setKaloriaTest() {
        e2.setKaloria(450);
        Assertions.assertEquals(450, e2.getKaloria(), "Hibas a setKaloria metodus!");
    }
}