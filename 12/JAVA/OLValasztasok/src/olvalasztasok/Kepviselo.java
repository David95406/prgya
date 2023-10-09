package olvalasztasok;

public class Kepviselo {
    private int valasztoKerulet;
    private int szavazatSzam;
    private String vezeteknev;
    private String utonev;
    private String tamogato;

    public int getValasztoKerulet() {
        return valasztoKerulet;
    }

    public void setValasztoKerulet(int valasztoKerulet) {
        this.valasztoKerulet = valasztoKerulet;
    }

    public int getSzavazatSzam() {
        return szavazatSzam;
    }

    public void setSzavazatSzam(int szavazatSzam) {
        this.szavazatSzam = szavazatSzam;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getUtonev() {
        return utonev;
    }

    public void setUtonev(String utonev) {
        this.utonev = utonev;
    }

    public String getTamogato() {
        return tamogato;
    }

    public void setTamogato(String tamogato) {
        this.tamogato = tamogato;
    }

    public Kepviselo(int valasztoKerulet, int szavazatSzam, String vezeteknev, String utonev, String tamogato) {
        this.valasztoKerulet = valasztoKerulet;
        this.szavazatSzam = szavazatSzam;
        this.vezeteknev = vezeteknev;
        this.utonev = utonev;
        this.tamogato = tamogato;
    }
    
    
}
