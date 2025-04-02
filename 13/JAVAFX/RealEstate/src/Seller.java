public class Seller {
    // ----------------------------------
    // Adattagok (mezők)
    // ----------------------------------
    private int id;             // Értékesítő egyedi azonosítója
    private String name;        // Értékesítő teljes neve
    private String phone;       // Értékesítő telefonszáma (formázott vagy nyers formában)

    // ----------------------------------
    // Konstruktor
    // ----------------------------------
    /**
     * Értékesítő objektum létrehozása
     * @param id Egyedi numerikus azonosító (CSV-ből számmá konvertálva)
     * @param name Teljes név (CSV 10. oszlop)
     * @param phone Telefonszám (CSV 11. oszlop, formázás nélkül)
     */
    public Seller(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // ----------------------------------
    // Getter metódusok
    // ----------------------------------
    /** Azonosító lekérdezése (pl. egyedi azonosításhoz) */
    public int getId() {
        return id;
    }

    /** Teljes név lekérdezése (felhasználói interfészhez) */
    public String getName() {
        return name;
    }

    /** Nyers telefonszám lekérdezése (pl. hívásindításhoz) */
    public String getPhone() {
        return phone;
    }
}

