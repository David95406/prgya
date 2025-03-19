package com.example.konyvelfxml;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ElerhetoKonyv {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty cim;
    private final SimpleStringProperty szerzo;
    private final SimpleIntegerProperty kiadasEv;
    private final SimpleStringProperty status;

    public ElerhetoKonyv(int id, String cim, String szerzo, int kiadasEv, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.cim = new SimpleStringProperty(cim);
        this.szerzo = new SimpleStringProperty(szerzo);
        this.kiadasEv = new SimpleIntegerProperty(kiadasEv);
        this.status = new SimpleStringProperty(status);
    }

    @Override
    public String toString() {
        return "ElerhetKonyv{" +
                "id=" + getId() +
                ", cim=" + getCim() +
                ", szerzo=" + getSzerzo() +
                ", kiadasEv=" + getKiadasEv() +
                ", status=" + getStatus() +
                '}';
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getCim() {
        return cim.get();
    }

    public SimpleStringProperty cimProperty() {
        return cim;
    }

    public String getSzerzo() {
        return szerzo.get();
    }

    public SimpleStringProperty szerzoProperty() {
        return szerzo;
    }

    public int getKiadasEv() {
        return kiadasEv.get();
    }

    public SimpleIntegerProperty kiadasEvProperty() {
        return kiadasEv;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setCim(String cim) {
        this.cim.set(cim);
    }

    public void setSzerzo(String szerzo) {
        this.szerzo.set(szerzo);
    }

    public void setKiadasEv(int kiadasEv) {
        this.kiadasEv.set(kiadasEv);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

}
