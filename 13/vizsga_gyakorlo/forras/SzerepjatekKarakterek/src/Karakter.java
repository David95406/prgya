public class Karakter {
    private String nev;
    private String faj;
    private String leiras;
    private int szint;

    public Karakter(String nev, String faj, String leiras, int szint) {
        this.nev = nev;
        this.faj = faj;
        this.leiras = leiras;
        this.szint = szint;
    }

    public Karakter(String[] adatok) {
        this(
                adatok[0],
                adatok[1],
                adatok[2],
                Integer.parseInt(adatok[3])

        );
    }

    @Override
    public String toString() {
        return "Karakter{" +
                "nev='" + nev + '\'' +
                ", faj='" + faj + '\'' +
                ", leiras='" + leiras + '\'' +
                ", szint=" + szint +
                '}';
    }

    public String getNev() {
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

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }
}
