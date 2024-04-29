package com.example.esemenyek.model;

import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Esemeny> esemenylista = new ArrayList<>();

    public static ArrayList<Esemeny> getEsemenylista() {
        return esemenylista;
    }

    public static void setEsemenylista(ArrayList<Esemeny> esemenylista) {
        DataManager.esemenylista = esemenylista;
    }
}
