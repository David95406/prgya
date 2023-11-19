public class Kotveny {
    private int sorszam;
    private String nev;
    private int nevertek;
    private int futamido; //honap
    private double kamat;

    public Kotveny(int sorszam, String nev, int nevertek, int futamido, double kamat) {
        this.setSorszam(sorszam);
        this.setNev(nev);
        this.setNevertek(nevertek);
        this.setFutamido(futamido);
        this.setKamat(kamat);
    }

    @Override
    public String toString() {
        return "Kotveny sorszama: " + this.getSorszam() +
                "\nKibocsajto neve: " + this.getNev() +
                "\nKotveny neverteke: " + this.getNevertek() +
                "\nFutamido: " + this.getFutamido() + " honap" +
                "\nKamat: " + this.getKamat() + "%\n\n";
    }

    public int getSorszam() {
        return sorszam;
    }

    public String getNev() {
        return nev;
    }

    private void setNev(String nev) {
        this.nev = nev;
    }

    private void setSorszam(int sorszam) {
        this.sorszam = sorszam;
    }

    public int getNevertek() {
        return nevertek;
    }

    private void setNevertek(int nevertek) {
        this.nevertek = nevertek;
    }

    public int getFutamido() {
        return futamido;
    }

    private void setFutamido(int futamido) {
        this.futamido = futamido;
    }

    public double getKamat() {
        return kamat;
    }

    private void setKamat(double kamat) {
        this.kamat = kamat;
    }
}
