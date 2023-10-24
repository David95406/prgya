public class Hivasok {
    private int kOra;
    private int kPerc;
    private int kMasodperc;
    private int vOra;
    private int vPerc;
    private int vMasodperc;
    private int telefonszam;

    public Hivasok(int kOra, int kPerc, int kMasodperc, int vOra, int vPerc, int vMasodperc, int telefonszam) {
        this.kOra = kOra;
        this.kPerc = kPerc;
        this.kMasodperc = kMasodperc;
        this.vOra = vOra;
        this.vPerc = vPerc;
        this.vMasodperc = vMasodperc;
        this.telefonszam = telefonszam;
    }

    public String toString() {
        return "Kerdete: " + kOra + ":" + kPerc + ":" + kMasodperc +
                "\nVege: " + vOra + ":" + vPerc + ":" + vMasodperc +
                "\nTelefonszam: " + telefonszam;
    }
}
