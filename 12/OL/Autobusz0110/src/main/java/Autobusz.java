public class Autobusz {
    private int ferohely;
    private int hatotavolsag;
    private int berlesiAr;
    private int utasokSzama;

    //1
    public boolean addUtas(int db) {
        if (utasokSzama <= ferohely && db <= ferohely) {
            utasokSzama += db;
            return true;
        }
        return false;
    }

    //2
    public boolean nagyobbE(Autobusz B2) {
        return this.getBerlesiAr() >= B2.getBerlesiAr();
    }

    public Autobusz(int ferohely, int hatotavolsag, int berlesiAr) {
        this.ferohely = ferohely;
        this.hatotavolsag = hatotavolsag;
        this.berlesiAr = berlesiAr;
    }

    public int getUtasokSzama() {
        return utasokSzama;
    }

    public void setUtasokSzama(int utasokSzama) {
        if (utasokSzama <= ferohely) {
            this.utasokSzama = utasokSzama;
        }
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    public int getHatotavolsag() {
        return hatotavolsag;
    }

    public void setHatotavolsag(int hatotavolsag) {
        this.hatotavolsag = hatotavolsag;
    }

    public int getBerlesiAr() {
        return berlesiAr;
    }

    public void setBerlesiAr(int berlesiAr) {
        this.berlesiAr = berlesiAr;
    }
}
