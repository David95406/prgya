public class Musor {
    private int radioSorszama;
    private int perc;
    private int masodperc;
    private String eloado;
    private String cim;

    public Musor(int radioSorszama, int perc, int masodperc, String eloado, String cim) {
        this.radioSorszama = radioSorszama;
        this.perc = perc;
        this.masodperc = masodperc;
        this.eloado = eloado;
        this.cim = cim;
    }

    public String toString() {
        return "Sorszam: " + radioSorszama +
                "\nHossz: " + perc + ":" + masodperc +
                "\nEloado: " + eloado +
                "\nCim: " + cim;
    }
}
