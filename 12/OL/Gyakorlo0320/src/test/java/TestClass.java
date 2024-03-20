import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestClass {
    private static Pogacsa p1;
    private static Pogacsa p2;
    private static Kave k1;
    private static Kave k2;
    private static Kave k3;

    @BeforeAll
    static void beforeAll() {
        p1 = new Pogacsa(5, 100);
        k1 = new Kave(true);
        k2 = new Kave(false);
    }

    @Test
    void interfaceTest() {
        Assertions.assertEquals(180, Arlap.CSESZEKAVE, "Hibas az arlap CSESZEKAVE erteke!");
    }

    @Test
    void mennyibeKerulTest() {
        Assertions.assertEquals(270, k1.mennyibeKerul(), "Hibas a mennyibeKerul metodus!");
        Assertions.assertEquals(180, k2.mennyibeKerul(), "Hibas a mennyibeKerul metodus!");
        Assertions.assertEquals(500, p1.mennyibeKerul(), "Hibas a mennyibeKerul metodus!");
    }

    @Test
    void megkostolTest() {
        p1.megkostol();
        Assertions.assertEquals(2.5, p1.getMennyiseg(), 0.5, "Hibas a megkostol metodus!");
    }

    @Test
    void pogacsaKonstruktorTest() {
        p2 = new Pogacsa(20, 200);
        Assertions.assertEquals(20, p2.getMennyiseg(), "Hibas a Pogacsa osztaly konstruktor!");
        Assertions.assertEquals(200, p2.getAlapar(), "Hibas a Pogacsa osztaly konstruktor!");
    }

    @Test
    void pogacsaKonstruktorTestNegativMennyiseg() {
        try {
            p2 = new Pogacsa(0, 100);
        } catch (IllegalArgumentException iea) {
            return;
        }

        try {
            p2 = new Pogacsa(-10, 100);
        } catch (IllegalArgumentException iea) {
            return;
        }

        Assertions.fail("A mennyiseg lehet 0-nal kisebb szam!");
    }

    @Test
    void pogacsaKonstruktorTestNegativAlapar() {
        try {
            p2 = new Pogacsa(10, -100);
        } catch (IllegalArgumentException iea) {
            return;
        }

        Assertions.fail("Az alapar lehet 0-nal kisebb szam!");
    }

    @Test
    void kaveKonstruktorTest() {
        k3 = new Kave(true);
        Assertions.assertTrue(k3.isHabosE(), "Hibas a Kave osztaly konstruktor!");
        k3 = new Kave(false);
        Assertions.assertFalse(k3.isHabosE(), "Hibas a Kave osztaly konstruktor!");
    }

    @Test
    void kaveToStringTest() {
        Assertions.assertEquals("Habos kave - 270 Ft", k1.toString(), "Hibas a Kave osztaly toString metodus!");
        Assertions.assertEquals("Nem habos kave - 180 Ft", k2.toString(), "Hibas a Kave osztaly toString metodus!");
    }

    @Test
    void pogacsaToStringTest() {
        Assertions.assertEquals("Pogacsa 5db - 500 Ft", p1.toString(), "Hibas a Pogacsa osztaly toString metodus!");
    }

}