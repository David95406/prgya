package com.vizsga.kossuthdijasokgui;

public class SearchResult {
    private String nev;
    private int ev;
    private String munkakor;
    private String megjegyzes;

    public SearchResult(String nev, int ev, String munkakor, String megjegyzes) {
        this.nev = nev;
        this.ev = ev;
        this.munkakor = munkakor;
        this.megjegyzes = megjegyzes;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "nev='" + nev + '\'' +
                ", ev=" + ev +
                ", munkakor='" + munkakor + '\'' +
                ", megjegyzes='" + megjegyzes + '\'' +
                '}';
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public String getMunkakor() {
        return munkakor;
    }

    public void setMunkakor(String munkakor) {
        this.munkakor = munkakor;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
