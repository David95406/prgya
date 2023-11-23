import java.util.*;
public class Mososor implements iAutomoso {
    private int bevetel = 0;
    private List<Jarmu> jarmuvek;
    private List<Jarmu> osszesjarmuvek;
    public Mososor() {
        this.jarmuvek = new ArrayList<Jarmu>();
        this.osszesjarmuvek = new ArrayList<Jarmu>();
    }

    public void add(Jarmu j){
        this.jarmuvek.add(j);
        this.osszesjarmuvek.add(j);
    }

    public void remove(Jarmu j){
        this.jarmuvek.remove(j);
    }

    public int getBevetel() {
        for (Jarmu j : osszesjarmuvek) {
            if (j.getTipus().equals(SZEMELYAUTO)) {
                //bef
            } else {

            }
        }

        return 1;
    }

    @Override
    public String toString() {
        String er = "A mosósorban lévő autók száma: \n";
        for (int i = 0 ; i < jarmuvek.size();i++){
            er += jarmuvek.get(i) + "\n";
        }
        return er;
    }
}