package objektumlista;

public class Eredmeny {
    private String nev;
    private String part;
    private String korzet;
    private int szavazatSzam; 

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getKorzet() {
        return korzet;
    }

    public void setKorzet(String korzet) {
        this.korzet = korzet;
    }

    public int getSzavazatSzam() {
        return szavazatSzam;
    }

    public void setSzavazatSzam(int szavazatSzam) {
        this.szavazatSzam = szavazatSzam;
    }

    public Eredmeny(String nev, String part, String korzet, int szavazatSzam) {
        this.nev = nev;
        this.part = part;
        this.korzet = korzet;
        this.szavazatSzam = szavazatSzam;
    }
    
    
}
