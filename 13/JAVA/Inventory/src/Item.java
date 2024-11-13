public class Item {
    private String nev;
    private String tipus;
    private int suly;
    private int ertek;

    public Item(String nev, String tipus, int suly, int ertek) {
        setNev(nev);
        setTipus(tipus);
        setSuly(suly);
        setErtek(ertek);
    }

    @Override
    public String toString() {
        return "Item{" +
                "nev='" + getNev() + '\'' +
                ", tipus='" + getTipus() + '\'' +
                ", suly=" + getSuly() +
                ", ertek=" + getErtek() +
                '}';
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public int getErtek() {
        return ertek;
    }

    public void setErtek(int ertek) {
        this.ertek = ertek;
    }
}
