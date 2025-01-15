public abstract class Allat implements Gondozhato {
    private String nev;
    private String faj;
    private int eletkor;

    public Allat(String nev, String faj, int eletkor) {
        setNev(nev);
        setFaj(faj);
        setEletkor(eletkor);
    }

    public abstract void hangotAd();
    public abstract void eszik();

    @Override
    public String toString() {
        return "Allat{" +
                "nev='" + getNev() + '\'' +
                ", faj='" + getFaj() + '\'' +
                ", eletkor=" + getEletkor() +
                '}';
    }

    public String getNev() { //private!
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getFaj() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj = faj;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }
}
