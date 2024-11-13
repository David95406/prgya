import java.util.ArrayList;
import java.util.Comparator;

class StortByNev implements Comparator<Item> { //ABC
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getNev().compareTo(item2.getNev());
    }
}

class SortBySuly implements Comparator<Item> { //novekvo
    @Override
    public int compare(Item item1, Item item2) {
        return item1.getSuly() - item2.getSuly();
    }
}

class SortByErtek implements Comparator<Item> { //csokkeno
    @Override
    public int compare(Item item1, Item item2) {
        return item2.getErtek() - item1.getErtek();
    }
}

public class Inventory {
    private ArrayList<Item> targyak;
    private final int MAX_SULY = 100;

    public Inventory() {
        this.targyak = new ArrayList<>();
    }

    public void hozzaad(Item item) throws IllegalArgumentException {
        int suly = 0;
        for (Item egyTargy : getTargyak()) {
            suly += egyTargy.getSuly();
            if (egyTargy.getNev().equals(item.getNev())) {
                throw new IllegalArgumentException("Ilyen nevu targy mar szerepel!");
            }
        }
        if ((suly + item.getSuly()) > MAX_SULY) {
            throw new IllegalArgumentException("Az inventory meghaladna a megengedett maximalis sulyt! (" + MAX_SULY + ")");
        }
        this.targyak.add(item);
    }

    public void eltavolit(String nev) throws IllegalArgumentException {
        for (int i = 0; i < getTargyak().size(); i++) {
            if (getTargyak().get(i).getNev().equalsIgnoreCase(nev)) {
                this.targyak.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Nem letezo targy!");
    }

    public void rendez(String szempont) throws IllegalArgumentException {
        switch (szempont) {
            case "suly" -> {
                this.targyak.sort(new SortBySuly());
            }
            case "ertek" -> {
                this.targyak.sort(new SortByErtek());
            }
            case "nev" -> {
                this.targyak.sort(new StortByNev());
            }
            default -> {
                throw new IllegalArgumentException("Ervenytelen szempont!");
            }
        }
    }

    public void inventoryKiirasa() {
        String text = "Inventory{\n";
        for (Item egyTargy : getTargyak()) {
            text += "   " + egyTargy.toString() + "\n";
        }
        text += "}";
        System.out.println(text);
    }

    public ArrayList<Item> getTargyak() {
        return targyak;
    }

    public void setTargyak(ArrayList<Item> targyak) {
        this.targyak = targyak;
    }
}
