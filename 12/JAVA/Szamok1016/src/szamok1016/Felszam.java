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
    
    public String toString() {
        return "Kerdes: " + kerdes + 
                "\nValasz: " + valasz + 
                "\nNehezseg: " + nehezseg + 
                "\nTema: " + tema;
    }
}
