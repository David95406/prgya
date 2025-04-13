package com.vizsga.mysqlgyakorlo0413;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jegyzet {
    private int id;
    private final StringProperty cim;
    private final StringProperty tartalom;

    public Jegyzet(int id, String cim, String tartalom) {
        this.id = id;
        this.cim = new SimpleStringProperty(cim);
        this.tartalom = new SimpleStringProperty(tartalom);
    }

    public Jegyzet(String cim, String tartalom) {
        this(-1, cim, tartalom);
    }

    public boolean isEmpty() {
        return getCim().isEmpty() || getTartalom().isEmpty();
    }

    @Override
    public String toString() {
        return "Jegyzet{" +
                "cim=" + getCim() +
                ", leiras=" + getTartalom() +
                '}';
    }

    public String getCim() {
        return cim.get();
    }

    public StringProperty cimProperty() {
        return cim;
    }

    public String getTartalom() {
        return tartalom.get();
    }

    public StringProperty tartalomProperty() {
        return tartalom;
    }

    public int getId() {
        return id;
    }
}
