package com.vizsga.databaseconngyak;

public class Karakter {
    private String nev;
    private int ev;

    public Karakter(String nev, int ev) {
        this.nev = nev;
        this.ev = ev;
    }

    @Override
    public String toString() {
        return "Karakter{" +
                "nev='" + nev + '\'' +
                ", ev=" + ev +
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
}
