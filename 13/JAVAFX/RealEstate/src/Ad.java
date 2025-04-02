import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ad {
    // ----------------------------------
    // Adattagok (mezők)
    // ----------------------------------
    private int id;                     // Egyedi azonosító
    private String description;         // Ingatlan leírása (opcionális)
    private int rooms;                  // Szobák száma
    private int area;                   // Alapterület (négyzetméter)
    private int floors;                 // Emeletek száma
    private Category category;          // Kategória objektum (pl. ház, lakás)
    private Seller seller;              // Értékesítő objektum
    private boolean freeOfCharge;       // Tehermentesség jelzője
    private String imageUrl;            // Kép elérési útja
    private String latlong;             // Szélességi/hosszúsági koordináták (formátum: "lat,lon")
    private String createAt;            // Létrehozás dátuma

    // ----------------------------------
    // Konstruktor
    // ----------------------------------
    /**
     * Ingyatlanhirdetés létrehozása
     * @param id Egyedi azonosító
     * @param rooms Szobák száma
     * @param latlong Koordináták (String formátumban)
     * @param floors Emeletek száma
     * @param area Alapterület (m²)
     * @param description Leírás (üresen is hagyható)
     * @param freeOfCharge Tehermentesség (boolean)
     * @param imageUrl Kép URL címe
     * @param createAt Létrehozás dátuma
     * @param seller Értékesítő objektum
     * @param category Kategória objektum
     */
    public Ad(int id, int rooms, String latlong, int floors, int area, String description,
              boolean freeOfCharge, String imageUrl, String createAt, Seller seller, Category category) {
        this.id = id;
        this.rooms = rooms;
        this.latlong = latlong;
        this.floors = floors;
        this.area = area;
        this.description = description;
        this.freeOfCharge = freeOfCharge;
        this.imageUrl = imageUrl;
        this.createAt = createAt;
        this.seller = seller;
        this.category = category;
    }

    // ----------------------------------
    // CSV betöltő metódus
    // ----------------------------------
    /**
     * CSV fájl betöltése és Ad objektumok listájának létrehozása
     * @param fileName CSV fájl elérési útja
     * @return Ad objektumok listája
     */
    public static List<Ad> loadFromCsv(String fileName) {
        List<Ad> ads = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Fejléc sor kihagyása
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                // Szétvágás pontosvesszővel elválasztott részekre
                String[] data = line.split(";");

                // Adatmezők feldolgozása és objektum létrehozása
                Ad ad = new Ad(
                        Integer.parseInt(data[0]),       // id
                        Integer.parseInt(data[1]),       // rooms
                        data[2],                         // latlong
                        Integer.parseInt(data[3]),       // floors
                        Integer.parseInt(data[4]),       // area
                        data[5],                         // description
                        data[6].equals("1"),             // freeOfCharge (1=true, 0=false)
                        data[7],                         // imageUrl
                        data[8],                         // createAt
                        new Seller(                      // Seller objektum
                                Integer.parseInt(data[9]),
                                data[10],
                                data[11]
                        ),
                        new Category(                    // Category objektum
                                Integer.parseInt(data[12]),
                                data[13]
                        )
                );
                ads.add(ad);
            }
        } catch (IOException e) {
            // Hibakezelés: stack trace kiírása standard error-ra
            e.printStackTrace();
        }
        return ads;
    }

    // ----------------------------------
    // Segédmetódusok
    // ----------------------------------
    /**
     * Távolság számítás egyszerűsített módon (nem pontos földrajzi számítás!)
     * @param lat Célpont szélességi fok
     * @param lon Célpont hosszúsági fok
     * @return Távolság egységnyi koordináta rendszerben
     */
    public double distanceTo(double lat, double lon) {
        // Koordináták szétválasztása
        String[] coords = this.latlong.split(",");
        double adLat = Double.parseDouble(coords[0]);
        double adLon = Double.parseDouble(coords[1]);

        // Különbségek számítása
        double dx = adLat - lat;
        double dy = adLon - lon;

        // Pitagorasz-tétel alkalmazása (síkbeli távolság)
        return Math.sqrt(dx * dx + dy * dy);
    }

    // ----------------------------------
    // Getter metódusok
    // ----------------------------------
    /** Emeletek számának lekérdezése */
    public int getFloors() { return floors; }

    /** Alapterület lekérdezése */
    public int getArea() { return area; }

    /** Tehermentesség állapotának lekérdezése */
    public boolean isFreeOfCharge() { return freeOfCharge; }

    /** Értékesítő objektum lekérdezése */
    public Seller getSeller() { return seller; }

    /** Szobák számának lekérdezése */
    public int getRooms() { return rooms; }
}
