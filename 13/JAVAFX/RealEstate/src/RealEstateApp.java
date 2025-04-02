import java.util.List;

public class RealEstateApp {

    /**
     * Fő alkalmazás belépési pontja
     * @param args Parancssori argumentumok (nincs használatban)
     */
    public static void main(String[] args) {
        // 1. CSV fájl betöltése és Ad objektumok listájának létrehozása
        List<Ad> ads = Ad.loadFromCsv("src/realestates.csv");

        // ----------------------------------
        // 6. feladat megoldása: Földszinti ingatlanok átlagos alapterülete
        // ----------------------------------
        double avgAreaGroundFloor = ads.stream()
                .filter(ad -> ad.getFloors() == 0)       // Szűrés földszinti ingatlanokra (0 emelet)
                .mapToInt(Ad::getArea)                   // Átalakítás numerikus streammé (alapterület)
                .average()                               // Átlag számítása
                .orElse(0);                              // Üres eredmény esetén 0 visszaadása

        // Eredmény kiírása formázott módon
        System.out.printf("6. Földszinti ingatlanok átlagos alapterülete: %.2f m2\n", avgAreaGroundFloor);

        // ----------------------------------
        // 8. feladat megoldása: Mesevár óvodához legközelebbi tehermentes ingatlan
        // ----------------------------------
        // Óvoda koordinátái (Budapest, Mesevár Óvoda)
        final double kindergartenLat = 47.4164220114023;
        final double kindergartenLon = 19.066342425796986;

        // Legközelebbi ingatlan keresése
        Ad nearestAd = ads.stream()
                .filter(Ad::isFreeOfCharge)  // Szűrés tehermentes ingatlanokra
                .min((ad1, ad2) -> Double.compare(  // Összehasonlítás távolság alapján
                        ad1.distanceTo(kindergartenLat, kindergartenLon),  // Első ingatlan távolsága
                        ad2.distanceTo(kindergartenLat, kindergartenLon))) // Második ingatlan távolsága
                .orElse(null);  // Ha nincs eredmény, null érték visszaadása

        // Eredmény kiírása
        if (nearestAd != null) {
            System.out.println("\n8. Mesevár óvodához légvonalban legközelebbi tehermentes ingatlan adatai:");
            System.out.println(" Eladó neve: " + nearestAd.getSeller().getName());
            System.out.println(" Eladó telefonja: " + nearestAd.getSeller().getPhone());
            System.out.println(" Alapterület: " + nearestAd.getArea() + " m2");
            System.out.println(" Szobák száma: " + nearestAd.getRooms());
        } else {
            System.out.println("\n8. Nem található tehermentes ingatlan az óvoda közelében.");
        }
    }
}
