import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private static Rectangle t1;
    private static Rectangle t2;
    private static Rectangle t3;
    private static Rectangle t4;

    @BeforeAll
    static void beforeAll() {//teglalapok elokeszitese
        t1 = new Rectangle(4.0, 4.0);
        t2 = new Rectangle(1.68, 4.45);
        t3 = new Rectangle();
        t4 = new Rectangle(-2.4, -6.98);
    }

    @Test
    void keruletTest() {
        Assertions.assertEquals(16.0, t1.getKerulet(), 0.1, "Hibas a kerulet!");
        Assertions.assertEquals(12.26, t2.getKerulet(), 0.1, "Hibas a kerulet a valos szamra!");
        Assertions.assertEquals(0, t3.getKerulet(), "Hibas a kerulet a felultoltos konstruktorra!");
        Assertions.assertEquals(-18.76, t4.getKerulet(), 0.1, "Hibas a kerulet negativ szamra!");
    }

    @Test
    void getATest() {
    }
}