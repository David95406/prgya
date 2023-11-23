import java.util.*;

public class Automoso {
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Automoso(String nev) {
        this.setNev(nev);
        this.mososorok = new ArrayList<Mososor>();
    }

    private String nev;


    private List<Mososor> mososorok;

    public void add(Mososor m) {
        this.mososorok.add(m);
    }

    public void remove(Mososor m) {
        this.mososorok.remove(m);
    }

    public String toString() {
        String er = "A mosósorban lévő autók száma: ";
        for (int i = 0; i < mososorok.size(); i++) {
            er += mososorok.get(i) + "\n";
        }
        return er + "\n";
    }


}