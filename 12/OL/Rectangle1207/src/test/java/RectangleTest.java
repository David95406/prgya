import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private static Rectangle t1;
    private static Rectangle t2;
    private static Rectangle t3;
    private static Rectangle t4;
    private static Rectangle t5;
    private static Rectangle t6;

    @BeforeAll
    static void beforeAll() {//teglalapok elokeszitese
        t1 = new Rectangle(4.0, 4.0);
        t2 = new Rectangle(1.68, 4.45);
        t3 = new Rectangle();
        t4 = new Rectangle(-2.4, -6.98);
        t5 = new Rectangle(1, 1);

        t6 = new Rectangle(5, 20); //masik mod a setter testeleshez
        t6.setB(21);
    }

    @Test
    void getKeruletTest() {
        Assertions.assertEquals(16.0, t1.getKerulet(), 0.1, "Hibas a kerulet!");
        Assertions.assertEquals(12.26, t2.getKerulet(), 0.1, "Hibas a kerulet valos szamra!");
        Assertions.assertEquals(0, t3.getKerulet(), "Hibas a kerulet a felultoltos konstruktorra!");
        Assertions.assertEquals(-18.76, t4.getKerulet(), 0.1, "Hibas a kerulet negativ szamra!");

    }

    @Test
    void getTeruletTest() {
        Assertions.assertEquals(16, t1.getTerulet(), "Hibas a terulet egesz szamra!");
        Assertions.assertEquals(7.476, t2.getTerulet(), "Hibas a terulet valos szamra!");
        Assertions.assertEquals(0, t3.getTerulet(), "Hibas a terulet felultoltos konstruktorral!");
        //Assertions.assertEquals(-16.752, t4.getTerulet(), "Hibas a terulet negativ szamra!");
    }

    @Test
    void getATest() {
        Assertions.assertEquals(4, t1.getA(), "Hibas a getA() metodus egesz szam eseten!");
        Assertions.assertEquals(1.68, t2.getA(), "Hibas a getA() metodus valos szam eseten!");
        Assertions.assertEquals(0, t3.getA(), "Hibas a getA() metodus a felultoltos konstruktorral!");
        Assertions.assertEquals(-2.4, t4.getA(), "Hibas a getA() metodus negativ valos szam eseten!");
    }

    @Test
    void getBTest() {
        Assertions.assertEquals(4, t1.getB(), "Hibas a getB() metodus egesz szam eseten!");
        Assertions.assertEquals(4.45, t2.getB(), "Hibas a getB() metodus valos szam eseten!");
        Assertions.assertEquals(0, t3.getB(), "Hibas a getB() metodus a felultoltos konstruktorral!");
        Assertions.assertEquals(-6.98, t4.getB(), "Hibas a getB() metodus negativ valos szam eseten!");
    }

    @Test
    void isNegyzetTest() {
        Assertions.assertTrue(t1.isNegyzet(), "Nem negyzetet ad egyenlo ertekek eseten!");
        Assertions.assertFalse(t2.isNegyzet(), "Negyzetet ad nem egyenlo ertekek eseten!");
    }

    @Test
    void setATest() {
        t5.setA(5);
        Assertions.assertEquals(5.0, t5.getA(), "Hibas a setA() metodus egesz szam eseten!");
        t5.setA(5.7);
        Assertions.assertEquals(5.7, t5.getA(), "Hibas a setA() metodus valos szam eseten!");

    }

    @Test
    void setBTest() {
        Assertions.assertEquals(21, t6.getB(), "Hibas a setB() metodus egesz szam eseten!");
    }

    @Test
    void getNagyobbTest() {
        Assertions.assertSame(t1, t3.getNagyobb(t1, t2), "Hibas a getNagyobb() metodus! (nem a nagyobbat adja)");
        Assertions.assertNotSame(t2, t3.getNagyobb(t1, t2), "Hibas a getNagyobb() metodus! (a nagyobbat adja)");
    }


}