public class Auto {
    private int nap;
    private String oraPerc;
    private String rendszam;
    private int azonosito;
    private int km;
    private boolean isBehajtas;

    public Auto(String[] adatok) {
        this.nap = Integer.parseInt(adatok[0]);
        this.oraPerc = adatok[1];
        this.rendszam = adatok[2];
        this.azonosito = Integer.parseInt(adatok[3]);
        this.km = Integer.parseInt(adatok[4]);
        this.isBehajtas = Integer.parseInt(adatok[5]) == 1;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "nap=" + nap +
                ", oraPerc='" + oraPerc + '\'' +
                ", rendszam='" + rendszam + '\'' +
                ", azonosito=" + azonosito +
                ", km=" + km +
                ", isBehajtas=" + isBehajtas +
                '}';
    }

    public int getNap() {
        return nap;
    }

    public void setNap(int nap) {
        this.nap = nap;
    }

    public String getOraPerc() {
        return oraPerc;
    }

    public void setOraPerc(String oraPerc) {
        this.oraPerc = oraPerc;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isBehajtas() {
        return isBehajtas;
    }

    public void setBehajtas(boolean behajtas) {
        isBehajtas = behajtas;
    }
}
