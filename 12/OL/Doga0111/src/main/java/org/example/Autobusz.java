package org.example;

public class Autobusz {
    private int ferohely;
    private boolean isCsuklos;
    private int berlesAr;

    public boolean addUtas(int utasDb) {
        if (utasDb <= ferohely) {
            return true;
        }
        return false;
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
        this.ferohely = ferohely;
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
}
