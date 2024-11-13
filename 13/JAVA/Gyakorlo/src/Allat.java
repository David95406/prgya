public abstract class Allat {
    private String nev;

    public Allat(String nev) {
        setNev(nev);
    }

    public abstract void hangotAd();

    public abstract void eszik();

    @Override
    public String toString() {
        return "Allat{" +
                "nev='" + getNev() + '\'' +
                '}';
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
