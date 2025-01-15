import java.util.ArrayList;

public class AllatokTest {
    public static void main(String[] args) {
        Oroszlan Leon = new Oroszlan("Leon", "Oroszlan", 5);
        Pingvin Pingu = new Pingvin("Pingu", "Pingvin", 10);
        Kigyo Kobra = new Kigyo("Kobra", "Kigyo", 2);

        ArrayList<Allat> allatok = new ArrayList<>();
        allatok.add(Leon);
        allatok.add(Pingu);
        allatok.add(Kobra);

        allatok.forEach(Allat::hangotAd);
        System.out.println("\n\n\n");

        Allatkert allatkert = new Allatkert(allatok);
        allatkert.soutAllatok();
    }
}