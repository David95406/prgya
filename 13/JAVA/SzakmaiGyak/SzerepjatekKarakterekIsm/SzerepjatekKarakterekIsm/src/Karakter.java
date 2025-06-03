public class Karakter {
    private String nev;
    private String faj;
    private String leiras;
    private int szint;


    public Karakter(String nev, String faj, String leiras, int szint) {
        setNev(nev);
        setFaj(faj);
        setSzint(szint);
        setLeiras(leiras);
    }

    public Karakter(String[] karakterAdatok) {
        //this(karakterAdatok[0], karakterAdatok[1], karakterAdatok[3], Integer.parseInt(karakterAdatok[2]));
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

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}
