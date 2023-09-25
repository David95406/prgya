package osztalyok0925;

public class Kutya {
    private String nev;
    private String fajta;
    private String szin;
    private int ttomeg;
    
    public String getNev() {
        return nev;
    }

    public String getFajta() {
        return fajta;
    }

    public String getSzin() {
        return szin;
    }

    public int getTtomeg() {
        return ttomeg;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setTtomeg(int ttomeg) {
        this.ttomeg = ttomeg;
    }
    
    public Kutya(String name, String type, String color, int weigth) {
        this.nev = name;
        this.fajta = type;
        this.szin = color;
        this.ttomeg = weigth;
    }
    
    public void ugat() {
        System.out.println(this.nev + ": Vau-vau");
    }
    
}
