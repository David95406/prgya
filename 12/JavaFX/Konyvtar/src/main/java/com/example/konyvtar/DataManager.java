package com.example.konyvtar;

import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Book> konyvek;

    public static ArrayList<Book> getKonyvek() {
        return konyvek;
    }

    public static void addBook(Book konyv) {
        konyvek.add(konyv);
    }

    public static int getStock() {
        return konyvek.size();
    }
}
