package com.example.esemenyek.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Esemeny {
    private StringProperty nev;
    private StringProperty datum;
    private StringProperty helyszin;

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

    public String getNev() {
        return nev.get();
    }

    public StringProperty nevProperty() {
        return nev;
    }

    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public String getHelyszin() {
        return helyszin.get();
    }

    public StringProperty helyszinProperty() {
        return helyszin;
    }

    public String getLabelFormat() {
        return "Név: " + getNev() + "    Dátum: " + getDatum() + "    Helyszín: " + getHelyszin();
    }

    public String getValue() {
        return getNev() + " " + getHelyszin() + " " + getDatum();
    }
    /*
    public String getDatum() {
        return datum;
    }

    public String getHelyszin() {
        return helyszin;
    }

    protected void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

     */


    protected void setNev(String nev) {
        this.nev = new SimpleStringProperty(nev);
    }



    protected void setDatum(String datum) {
        this.datum = new SimpleStringProperty(datum);
    }

    protected void setHelyszin(String helyszin) {
        this.helyszin = new SimpleStringProperty(helyszin);
    }





}
