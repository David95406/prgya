package szamok1016;

public class Felszam {
    private String kerdes;
    private int valasz;
    private int nehezseg;
    private String tema;
    
    public Felszam(String kerdes, int valasz, int nehezseg, String tema) {
        this.kerdes = kerdes;
        this.valasz = valasz;
        this.nehezseg = nehezseg;
        this.tema = tema;
    }

    public String getKerdes() {
        return kerdes;
    }

    public void setKerdes(String kerdes) {
        this.kerdes = kerdes;
    }

    public int getValasz() {
        return valasz;
    }

    public void setValasz(int valasz) {
        this.valasz = valasz;
    }

    public int getNehezseg() {
        return nehezseg;
    }

    public void setNehezseg(int nehezseg) {
        this.nehezseg = nehezseg;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String toString() {
        return "Kerdes: " + kerdes + 
                "\nValasz: " + valasz + 
                "\nNehezseg: " + nehezseg + 
                "\nTema: " + tema;
    }
}
