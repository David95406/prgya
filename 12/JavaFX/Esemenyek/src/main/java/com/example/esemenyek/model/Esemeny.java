package com.example.esemenyek.model;

import java.util.Collection;

public class Esemeny {
    private String nev;
    private String datum;
    private String helyszin;

    public Esemeny(String nev, String datum, String helyszin) {
        setNev(nev);
        setDatum(datum);
        setHelyszin(helyszin);
    }

    @Override
    public String toString() {
        return "Event{" +
                "nev='" + getNev() + '\'' +
                ", datum='" + getDatum() + '\'' +
                ", helyszin='" + getHelyszin() + '\'' +
                '}';
    }

    public String getLabelFormat() {
        return "Név: " + getNev() + "    Dátum: " + getDatum() + "    Helyszin: " + getHelyszin();
    }

    public String getValue() {
        return getNev() + " " + getHelyszin() + " " + getDatum();
    }

    public String getNev() {
        return nev;
    }

    protected void setNev(String nev) {
        this.nev = nev;
    }

    public String getDatum() {
        return datum;
    }

    protected void setDatum(String datum) {
        this.datum = datum;
    }

    public String getHelyszin() {
        return helyszin;
    }

    protected void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

}
