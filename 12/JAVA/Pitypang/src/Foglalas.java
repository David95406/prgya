public class Foglalas {
    private int foglalasSzam;
    private int szobaSzam;
    private int erkezes;
    private int tavozas;
    private int vendegSzam;
    private boolean isReggeli;
    private String vendegAzonosito;

    public Foglalas(int foglalasSzam, int szobaSzam, int erkezes, int tavozas, int vendegSzam, boolean isReggeli, String vendegAzonosito) {
        this.foglalasSzam = foglalasSzam;
        this.szobaSzam = szobaSzam;
        this.erkezes = erkezes;
        this.tavozas = tavozas;
        this.vendegSzam = vendegSzam;
        this.isReggeli = isReggeli;
        this.vendegAzonosito = vendegAzonosito;
    }

    @Override
    public String toString() {
        return "Foglalas{" +
                "foglalasSzam=" + foglalasSzam +
                ", szobaSzam=" + szobaSzam +
                ", erkezes=" + erkezes +
                ", tavozas=" + tavozas +
                ", vendegSzam=" + vendegSzam +
                ", isReggeli=" + isReggeli +
                ", vendegAzonosito='" + vendegAzonosito + '\'' +
                '}';
    }

    public int getFoglalasSzam() {
        return foglalasSzam;
    }

    public void setFoglalasSzam(int foglalasSzam) {
        this.foglalasSzam = foglalasSzam;
    }

    public int getSzobaSzam() {
        return szobaSzam;
    }

    public void setSzobaSzam(int szobaSzam) {
        this.szobaSzam = szobaSzam;
    }

    public int getErkezes() {
        return erkezes;
    }

    public void setErkezes(int erkezes) {
        this.erkezes = erkezes;
    }

    public int getTavozas() {
        return tavozas;
    }

    public void setTavozas(int tavozas) {
        this.tavozas = tavozas;
    }

    public int getVendegSzam() {
        return vendegSzam;
    }

    public void setVendegSzam(int vendegSzam) {
        this.vendegSzam = vendegSzam;
    }

    public boolean isReggeli() {
        return isReggeli;
    }

    public void setReggeli(boolean reggeli) {
        isReggeli = reggeli;
    }

    public String getVendegAzonosito() {
        return vendegAzonosito;
    }

    public void setVendegAzonosito(String vendegAzonosito) {
        this.vendegAzonosito = vendegAzonosito;
    }
}
