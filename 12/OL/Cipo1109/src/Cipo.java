public class Cipo {
    private String marka;
    private String szin;
    private int meret;

    public Cipo(String marka, String szin, int meret) {
        this.setMarka(marka);
        this.setSzin(szin);
        this.setMeret(meret);
    }

    public String toString() {
        return "A cipő márkája: " + getMarka() +
                "\nA cipő színe: " + getSzin() +
                "\nA cipő mérete: " + getMeret();
    }

    public String getMarka() {
        return marka;
    }

    public String getSzin() {
        return szin;
    }

    public int getMeret() {
        return meret;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }
}
