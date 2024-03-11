package com.example.autokfeladat0311;

public class Auto {
    private String marka;
    private String tipus;
    private int hengerurtartalom;
    private int szallithatoSzemelyek;
    private String rendszam;

    public Auto(String marka, String tipus, int hengerurtartalom, int szallithatoSzemelyek, String rendszam) throws IllegalArgumentException {
        setMarka(marka);
        setTipus(tipus);
        setHengerurtartalom(hengerurtartalom);
        setSzallithatoSzemelyek(szallithatoSzemelyek);
        setRendszam(rendszam);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marka='" + getMarka() + '\'' +
                ", tipus='" + getTipus() + '\'' +
                ", hengerurtartalom=" + getHengerurtartalom() +
                ", szallithatoSzemelyek=" + getSzallithatoSzemelyek() +
                ", rendszam='" + getRendszam() + '\'' +
                '}' + "\n\n";
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getHengerurtartalom() {
        return hengerurtartalom;
    }

    public void setHengerurtartalom(int hengerurtartalom) throws IllegalArgumentException {
        if (hengerurtartalom <= 0) throw new IllegalArgumentException("A hengerurtartalom nem lehet 0 vagy annal kisebb!");
        this.hengerurtartalom = hengerurtartalom;
    }

    public int getSzallithatoSzemelyek() {
        return szallithatoSzemelyek;
    }

    public void setSzallithatoSzemelyek(int szallithatoSzemelyek) throws IllegalArgumentException {
        if (szallithatoSzemelyek <= 0) throw new IllegalArgumentException("A szallithato szemelyek szama nem lehet 0 vagy annal kisebb!");
        this.szallithatoSzemelyek = szallithatoSzemelyek;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
}
