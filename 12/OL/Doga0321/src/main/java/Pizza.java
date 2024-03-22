import java.util.ArrayList;

public class Pizza extends Etel {
    private int ar;
    public ArrayList<Feltet> feltetek;

    public Pizza(String nev, double kaloria, int ar) {
        super((nev.endsWith("pizza") ? nev : nev.concat(" pizza")), kaloria);
        setAr(ar);
        feltetek = new ArrayList<>();
    }

    public Pizza(String nev, double kaloria) {
        this(nev, kaloria, 3200);
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        if (ar < 0) {
            throw new IllegalArgumentException("Az ár csak pozitív lehet!");
        }
        this.ar = ar;
    }

    public void feltetetFelvesz(Feltet f) throws IllegalArgumentException {
        if (!feltetek.contains(f)) {
            feltetek.add(f);
            ar += 100;
            kaloria += f.getKaloria();
        } else {
            throw new IllegalArgumentException("baj");
        }
    }


    public Feltet[] getFeltetek() {
        Feltet e[] = new Feltet[feltetek.size()];
        for (int i = 0; i < feltetek.size(); i++) {
            e[i] = feltetek.get(i);
        }
        return e;
    }



    public String toString() {
        String er = super.toString() + ", ár: " + getAr() + " Ft";
        if (!feltetek.isEmpty()) {
            er += ", feltétek: ";
            for (int i = 0; i < feltetek.size(); i++) {
                er += feltetek.get(i).getNev() + " ";
            }
        }
        return er;
    }

}
