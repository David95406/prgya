public class Category {
    // ----------------------------------
    // Adattagok (mezők)
    // ----------------------------------
    private int id;         // Kategória egyedi azonosítója (pl. 1=ház, 2=lakás)
    private String name;    // Kategória rövid neve (érték a CSV fájl 13. oszlopából)

    // ----------------------------------
    // Konstruktor
    // ----------------------------------
    /**
     * Kategória objektum létrehozása
     * @param id Egyedi numerikus azonosító (CSV 12. oszlop számmá konvertálva)
     * @param name Szöveges megnevezés (CSV 13. oszlop)
     */
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ----------------------------------
    // Getter metódusok
    // ----------------------------------
    /** Azonosító lekérdezése (pl. szűréshez vagy azonosításhoz) */
    public int getId() {
        return id;
    }

    /** Kategória nevének lekérdezése (felhasználói megjelenítéshez) */
    public String getName() {
        return name;
    }
}

