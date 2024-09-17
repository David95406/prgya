package com.example.pizzeriaalap;

import java.util.Calendar;

public class Rendeles implements iPizza {
    private Pizza pizza;
    private String hely;
    private Calendar datum;

    public Rendeles(Pizza pizza, String hely, Calendar datum) {
        setPizza(pizza);
        setHely(hely);
        setDatum(datum);
    }

    public int rendelesOsszege(boolean isAznapi) throws IllegalArgumentException {
        //Továbbá az ellenőrzésnél figyeljünk arra, hogy nem adhatnak meg a mai napnál régebbi dátumot!
        return isAznapi ? pizza.getAr() + AZONNALISZALLITAS : pizza.getAr() + KESOBBISZALLITAS;
    }

    @Override
    public String toString() {
        return "Rendeles{" +
                "pizza=" + getPizza() +
                ", hely='" + getHely() + '\'' +
                ", datum=" + getDatum() +
                '}';
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getHely() {
        return hely;
    }

    public void setHely(String hely) {
        this.hely = hely;
    }

    public Calendar getDatum() {
        return datum;
    }

    public void setDatum(Calendar datum) {
        this.datum = datum;
    }
}
