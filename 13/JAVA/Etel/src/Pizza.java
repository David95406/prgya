import java.util.ArrayList;

public class Pizza extends Etel {
    private int ar;
    private ArrayList<Etel> feltetek;

    public Pizza(String etelNeve, int kaloriakSzama, int ar) {
        super((etelNeve.endsWith("pizza") ? etelNeve : etelNeve + " pizza"), kaloriakSzama);
        setAr(ar);
        this.feltetek = new ArrayList<>();
    }

    public Pizza(String etelNeve, int kaloriakSzama) {
        this(etelNeve, kaloriakSzama, 3200);
    }

    public void feltetetFelvesz(Etel feltet) throws IllegalArgumentException {
        boolean vanBenne = false;
        for (Etel egyFeltet : feltetek) {
            if (egyFeltet.getEtelNeve().equals(feltet.getEtelNeve())) {
                throw new IllegalArgumentException("A feltét már szerepel!");
            }
        }

        //masik megoldas
        int index = 0;
        while (!vanBenne && index < feltetek.size()) {
            vanBenne = feltetek.get(index).getEtelNeve().equals(feltet.getEtelNeve());
            index++;
        }
        if (vanBenne) throw new IllegalArgumentException("A feltét már szerepel!");

        feltetek.add(feltet);
        setKaloriakSzama(getKaloriakSzama() + feltet.getKaloriakSzama());
        setAr(getAr() + 100);
    }

    @Override
    public String toString() {
        String feltetLista = "";
        for (Etel egyFeltet : getFeltetek()) {
            feltetLista += egyFeltet.getEtelNeve() + ", ";
        }
        return "Pizza{" + super.toString() +
                " ár=" + getAr() + "Ft" +
                (getFeltetek().isEmpty() ? "" : ", feltetek='" + feltetLista.trim() + '\'') +
                '}';
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = (ar < 0) ? 1000 : ar;
    }

    public ArrayList<Etel> getFeltetek() {
        return feltetek;
    }
}
