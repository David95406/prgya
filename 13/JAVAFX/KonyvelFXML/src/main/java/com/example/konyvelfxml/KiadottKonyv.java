package com.example.konyvelfxml;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class KiadottKonyv {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty konyvId;
    private final SimpleStringProperty cim;
    private final SimpleStringProperty kolcsonzoNeve;
    private final SimpleStringProperty kiadasDatum;

    public KiadottKonyv(int id, int konyvId, String cim, String kolcsonzoNeve, String kiadasDatum) {
        this.id = new SimpleIntegerProperty(id);
        this.konyvId = new SimpleIntegerProperty(konyvId);
        this.cim = new SimpleStringProperty(cim);
        this.kolcsonzoNeve = new SimpleStringProperty(kolcsonzoNeve);
        this.kiadasDatum = new SimpleStringProperty(kiadasDatum);
    }

    @Override
    public String toString() {
        return "KiadottKonyv{" +
                "id=" + getId() +
                ", konyvId=" + getKonyvId() +
                ", cim=" + getCim() +
                ", kolcsonzoNeve=" + getKolcsonzoNeve() +
                ", kiadasDatum=" + getKiadasDatum() +
                '}';
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public int getKonyvId() {
        return konyvId.get();
    }

    public SimpleIntegerProperty konyvIdProperty() {
        return konyvId;
    }

    public String getCim() {
        return cim.get();
    }

    public SimpleStringProperty cimProperty() {
        return cim;
    }

    public String getKolcsonzoNeve() {
        return kolcsonzoNeve.get();
    }

    public SimpleStringProperty kolcsonzoNeveProperty() {
        return kolcsonzoNeve;
    }

    public String getKiadasDatum() {
        return kiadasDatum.get();
    }

    public SimpleStringProperty kiadasDatumProperty() {
        return kiadasDatum;
    }
}