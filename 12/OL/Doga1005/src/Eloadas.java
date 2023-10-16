public class Eloadas {
    String eCim;
    double nettoAr;
    int eladhatoJ;
    int eladottJ;

    public void setEladottJ(int eladottJ) {
        if (eladottJ <= this.eladhatoJ) {
            this.eladottJ = eladottJ;
        }
    }

    public boolean teltHaz() {
        return this.eladottJ == this.eladhatoJ;
    }

    public void Elmaradt() {
        this.eladottJ = 0;
    }

    public String toString() {
        return "Eloadas neve: " + eCim + "\nEladhato jegyek szama: " + eladhatoJ
                + "\nEladott jegyek szama: " + eladottJ + "\nTelthaz: "
                + teltHaz() + "\n";
    }

    public double getBrutto() {
        return nettoAr * 1.27;
    }

    public Eloadas(String eCim, int eladhatoJ, int eladottJ) {
        this.nettoAr = 15000;
        this.eCim = eCim;
        this.eladhatoJ = eladhatoJ;
        this.eladottJ = eladottJ;
    }

    public Eloadas(String eCim, double nettoAr, int eladhatoJ, int eladottJ) {
        this.eCim = eCim;
        this.nettoAr = nettoAr;
        this.eladhatoJ = eladhatoJ;
        this.eladottJ = eladottJ;
    }




}
