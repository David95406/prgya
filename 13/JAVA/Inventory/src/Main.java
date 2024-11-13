public class Main {
    public static void main(String[] args) {
        Item i1 = new Item("alma", "etel", 1, 0);
        Item i2 = new Item("kard", "fegyver", 80, 100);
        Item i3 = new Item("sisak", "pancel", 25, 20);

        Inventory inventory = new Inventory();
        inventory.hozzaad(i1);
        inventory.hozzaad(i2);
        //inventory.hozzaad(i3);

        //sort test
        inventory.inventoryKiirasa();
        inventory.rendez("ertek");
        inventory.inventoryKiirasa();

        //eltavolit
        inventory.eltavolit("kard");
        inventory.inventoryKiirasa();
    }
}