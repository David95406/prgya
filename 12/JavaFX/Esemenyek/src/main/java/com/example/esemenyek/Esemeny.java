package com.example.esemenyek;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Esemeny {
    private final StringProperty nev = new SimpleStringProperty();
    private final StringProperty datum = new SimpleStringProperty();
    private final StringProperty helyszin = new SimpleStringProperty();

    public Esemeny(String nev, String datum, String helyszin) {
        setNev(nev);
        setDatum(datum);
        setHelyszin(helyszin);
    }

    public String getValue() {
        return getNev() + " " + getHelyszin() + " " + getDatum();
    }

    public String getLabelFormat() {
        return "Név: " + getNev() + "    Dátum: " + getDatum() + "    Helyszin: " + getHelyszin();
    }

    public String getNev() {
        return nev.get();
    }

    public void setNev(String name) {
        this.nev.set(name);
    }

    public String getHelyszin() {
        return helyszin.get();
    }

    public void setHelyszin(String helyszin) {
        this.helyszin.set(helyszin);
    }

    public String getDatum() {
        return datum.get();
    }

    public void setDatum(String datum) {
        this.datum.set(datum);
    }
}
