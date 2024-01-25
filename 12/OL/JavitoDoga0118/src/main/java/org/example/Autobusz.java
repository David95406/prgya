package org.example;

public class Autobusz {
    private int ferohely;
    private boolean isCsuklos;
    private int berlesAr;
    private int foglaltHelyek;

    public boolean addUtas(int utasDb) {
        if ((foglaltHelyek + utasDb) <= ferohely && utasDb >= 0) {
            foglaltHelyek += utasDb;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Autobusz{" +
                "ferohely=" + getFerohely() +
                ", isCsuklos=" + isCsuklos() +
                ", berlesAr=" + getBerlesAr() +
                ", foglaltHelyek=" + getFoglaltHelyek() +
                '}';
    }

    public boolean isDragabb(Autobusz B2) {
        if (this.getBerlesAr() > B2.getBerlesAr()) {
            return true;
        }
        return false;
    }

    public Autobusz(int ferohely, boolean isCsuklos, int berlesAr) {
        this.setFerohely(ferohely);
        this.setCsuklos(isCsuklos);
        this.setBerlesAr(berlesAr);
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        if (ferohely >= 0) {
            this.ferohely = ferohely;
        }
    }

    public boolean isCsuklos() {
        return isCsuklos;
    }

    public void setCsuklos(boolean csuklos) {
        isCsuklos = csuklos;
    }

    public int getBerlesAr() {
        return berlesAr;
    }

    public void setBerlesAr(int berlesAr) {
        this.berlesAr = berlesAr;
    }

    public int getFoglaltHelyek() {
        return foglaltHelyek;
    }

    public void setFoglaltHelyek(int foglaltHelyek) {
        if (foglaltHelyek >= 0) {
            this.foglaltHelyek = foglaltHelyek;
        }
    }
}
