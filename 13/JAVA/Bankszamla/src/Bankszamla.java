import java.util.ArrayList;

public class Bankszamla {
    private int egyenleg;
    private ArrayList<String> szamlatortenet = new ArrayList<>();

    public Bankszamla(int egyenleg) {
        setEgyenleg(egyenleg);
        szamlatortenet.add(szamlatortenet.size() + ". Számla létrehozva -> egyenleg: " + getEgyenleg() + "Ft");
    }

    public void befizetes(int osszeg) {
        setEgyenleg(getEgyenleg() + osszeg);
        szamlatortenet.add(szamlatortenet.size() + ". Befizetés: " + osszeg + "Ft -> egyenleg: " + getEgyenleg() + "Ft");
    }

    public void penzfelvetel(int osszeg) {
        setEgyenleg(getEgyenleg() - osszeg);
        szamlatortenet.add(szamlatortenet.size() + ". Penzfelvetel: " + osszeg + "Ft -> egyenleg: " + getEgyenleg() + "Ft");
    }

    public void printSzamlatortenet() {
        for (String egySor : getSzamlatortenet()) {
            System.out.println(egySor);
        }
    }

    @Override
    public String toString() {
        return "Bankszamla{" +
                "egyenleg=" + getEgyenleg() +
                ", szamlaTortent=" + getSzamlatortenet() +
                '}';
    }

    public int getEgyenleg() {
        return egyenleg;
    }

    private void setEgyenleg(int egyenleg) throws IllegalArgumentException {
        if (egyenleg < 0) throw new IllegalArgumentException("Az egyenleg nem lehet kisebb 0-nál!");
        this.egyenleg = egyenleg;
    }

    public ArrayList<String> getSzamlatortenet() {
        return szamlatortenet;
    }
}
