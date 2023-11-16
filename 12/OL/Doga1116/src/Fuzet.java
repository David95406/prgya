public class Fuzet {
    private String minta;
    private String kotes;
    private int vastagsag;

    public Fuzet(String minta, String kotes, int vastagsag) {

        this.setMinta(minta);
        this.setKotes(kotes);
        this.setVastagsag(vastagsag);
    }

    @Override
    public String toString() {
        return "Fuzet mintaja: " + getMinta() +
                "\nFuzet kotese: " + getKotes() +
                "\nFuzet vastagsaga: " + getVastagsag();
    }

    public String getMinta() {
        return minta;
    }

    public void setMinta(String minta) {
        this.minta = minta;
    }

    public String getKotes() {
        return kotes;
    }

    public void setKotes(String kotes) {
        this.kotes = kotes;
    }

    public int getVastagsag() {
        return vastagsag;
    }

    public void setVastagsag(int vastagsag) {
        this.vastagsag = vastagsag;
    }
}
