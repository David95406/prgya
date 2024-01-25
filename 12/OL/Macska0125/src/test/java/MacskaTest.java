import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MacskaTest {
    private static Macska m1;
    private static Macska m2;
    private static Macska m3;

    @BeforeAll
    static void beforeAll() {
        m1 = new Macska(5, false);
        m2 = new Macska(1);
    }

    @Test
    @Order(1)
    static void konstruktorTestNegativErtek() {
        try {
            m3 = new Macska(-10);
        } catch (IllegalArgumentException iae) {
            return;
        }
        Assertions.fail("A macsak sulya nem lehet negativ!");
    }

    @Test
    @Order(2)
    static void konstruktorTest() {
        Assertions.assertEquals(1, m2.getTestsuly(), "Helytelen suly beallitas 1 parameteres konsturktor eseten!");
        Assertions.assertTrue(m2.isEhes(), "Helytelen suly beallitas 1 parameteres konsturktor eseten!");
    }

    @Test
    @Order(3)
    static void setSulyTest() {
        m2.setTestsuly(0.7);
        Assertions.assertEquals(0.7, m2.getTestsuly(), "Hiba a setTestsuly() metodusnal pozitiv ertek eseten!");
    }

    @Test
    @Order(4)
    static void eszikSikeresTest() {
        try {
            m1.eszik(0.2);
        } catch (IllegalArgumentException iae) {
           Assertions.fail(iae.getMessage());
        } catch (MacskaException me) {
            Assertions.fail(me.getMessage());
        }
    }

    @Test
    @Order(5)
    static void eszikSikertelenTest() {
        try {
            m2.eszik(0.1);
        } catch (IllegalArgumentException iae) {
            return;
        } catch (MacskaException me) {
            return;
        }
        Assertions.fail("Nem keletkezett hiba a nem ehes macsak etetesekor! (MacskaException)");
    }

    @Test
    @Order(6)
    static void eszikSikertelenNegativTest() {
        try {
            m1.eszik(-0.1);
        } catch (IllegalArgumentException iae) {
            return;
        } catch (MacskaException me) {
            return;
        }
        Assertions.fail("Nem keletkezett hiba a negativ sulyu etel eseten! (MacskaException)");
    }

    @Test
    @Order(7)
    static void futkosTest() {
        double regiSuly = m1.getTestsuly();
        try {
            m1.futkos();
        } catch (MacskaException me) {
            Assertions.fail(me.getMessage());
        }

        Assertions.assertFalse(m1.isEhes(), "A macska nem lett ehes futkosas utan!");
        Assertions.assertEquals(m1.getTestsuly(), regiSuly, "A macsak sulya nem csokkent futkosas utan!");
    }

    @Test
    @Order(8)
    static void futkosSikertelenTest() {
        double regiSuly = m1.getTestsuly();
        try {
            m1.setTestsuly(0.1);
            m1.futkos();
        } catch (MacskaException me) {
            return;
        }

        Assertions.fail("Nem keletkezett hiba a 0.1 sulyu macska futattasanal (MacskaException)");
    }
}