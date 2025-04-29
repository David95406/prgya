public class Karakter {
    private String nev;
    private String fajNev;
    private String leiras;
    int szint;

    public Karakter(String nev, String fajNev, String leiras, int szint) {
        setNev(nev);
        setFajNev(fajNev);
        setLeiras(leiras);
        setSzint(szint);
    }

    public Karakter(String[] adatok) {
        this(adatok[0], adatok[1], adatok[2], Integer.parseInt(adatok[3]));
    }

    @Override
    public String toString() {
        return "Karakter{" +
                "nev='" + getNev() + '\'' +
                ", fajNev='" + getFajNev() + '\'' +
                ", leiras='" + getLeiras() + '\'' +
                ", szint='" + getSzint() + '\'' +
                '}';
    }

    public String getNev() {
        return nev;
    }

    private void setNev(String nev) {
        this.nev = nev;
    }

    public String getFajNev() {
        return fajNev;
    }

    private void setFajNev(String fajNev) {
        this.fajNev = fajNev;
    }

    public String getLeiras() {
        return leiras;
    }

    private void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public int getSzint() {
        return szint;
    }

    private void setSzint(int szint) {
        this.szint = szint;
    }
}
