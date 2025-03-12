package com.vizsga.keszletnyilvantarto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Termek {
    private final SimpleStringProperty nev;
    private final SimpleIntegerProperty mennyiseg;
    private final SimpleDoubleProperty ar;
    private final SimpleStringProperty megjegyzes;

    public Termek(String nev, int mennyiseg, double ar, String megjegyzes) {
        this.nev = new SimpleStringProperty(nev);
        this.mennyiseg = new SimpleIntegerProperty(mennyiseg);
        this.ar = new SimpleDoubleProperty(ar);
        this.megjegyzes = new SimpleStringProperty(megjegyzes);
    }

    @Override
    public String toString() {
        return "Termek{" +
                "nev=" + getNev() +
                ", mennyiseg=" + getMennyiseg() +
                ", ar=" + getAr() +
                ", megjegyzes=" + getMegjegyzes() +
                '}';
    }

    // Statusz szamitas
    public String getStatus() {
        return getMennyiseg() < 5 ? "Alacsony készlet" : "Normál készlet";
    }

    public String getNev() {
        return nev.get();
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public SimpleStringProperty nevProperty() {
        return nev;
    }

    public int getMennyiseg() {
        return mennyiseg.get();
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg.set(mennyiseg);
    }

    public SimpleIntegerProperty mennyisegProperty() {
        return mennyiseg;
    }

    public double getAr() {
        return ar.get();
    }

    public void setAr(double ar) {
        this.ar.set(ar);
    }

    public SimpleDoubleProperty arProperty() {
        return ar;
    }

    public String getMegjegyzes() {
        return megjegyzes.get();
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes.set(megjegyzes);
    }

    public SimpleStringProperty megjegyzesProperty() {
        return megjegyzes;
    }
}