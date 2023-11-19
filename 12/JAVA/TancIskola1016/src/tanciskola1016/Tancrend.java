package tanciskola1016;

public class Tancrend {
    private String nev;
    private String parFiu;
    private String parLany;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getParFiu() {
        return parFiu;
    }

    public void setParFiu(String parFiu) {
        this.parFiu = parFiu;
    }

    public String getParLany() {
        return parLany;
    }

    public void setParLany(String parLany) {
        this.parLany = parLany;
    }

    public Tancrend(String nev, String parLany, String parFiu) {
        this.setNev(nev);
        this.setParFiu(parFiu);
        this.setParLany(parLany);
    }
    
    public String toString() {
        return "Nev: " + nev + 
                "\nFiu: " + parFiu + 
                "\nLany: " + parLany;
    }
    
    
}
