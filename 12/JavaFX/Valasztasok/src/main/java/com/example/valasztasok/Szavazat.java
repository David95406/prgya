package com.example.valasztasok;

import java.io.RandomAccessFile;

public class Szavazat {
    private int valasztokeruletId;
    private int szavazatokSzama;
    private String vezeteknev;
    private String keresztnev;
    private String partnev;

    public Szavazat(int valasztokeruletId, int szavazatokSzama, String vezeteknev, String keresztnev, String partnev) {
        setValasztokeruletId(valasztokeruletId);
        setSzavazatokSzama(szavazatokSzama);
        setVezeteknev(vezeteknev);
        setKeresztnev(keresztnev);
        setPartnev(partnev);
    }

    public Szavazat(String[] adatok) {
        setValasztokeruletId(Integer.parseInt(adatok[0]));
        setSzavazatokSzama(Integer.parseInt(adatok[1]));
        setVezeteknev(adatok[2]);
        setKeresztnev(adatok[3]);
        setPartnev(adatok[4]);
    }

    public void save() { //raf write file
        return;
    }

    @Override
    public String toString() {
        return getValasztokeruletId() + " " +
                getSzavazatokSzama() + " " +
                getVezeteknev() + " " +
                getKeresztnev() + " " +
                getPartnev();
    }

    public int getValasztokeruletId() {
        return valasztokeruletId;
    }

    public void setValasztokeruletId(int valasztokeruletId) {
        this.valasztokeruletId = valasztokeruletId;
    }

    public int getSzavazatokSzama() {
        return szavazatokSzama;
    }

    public void setSzavazatokSzama(int szavazatokSzama) {
        this.szavazatokSzama = szavazatokSzama;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getPartnev() {
        return partnev;
    }

    public void setPartnev(String partnev) {
        this.partnev = partnev;
    }
}
