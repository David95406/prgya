package com.example.szerepjatekkarakterekgui;

public class Faj {
    private int id;
    private String faj;

    public Faj(int id, String faj) {
        this.id = id;
        this.faj = faj;
    }

    @Override
    public String toString() {
        return getFaj();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaj() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj = faj;
    }
}
