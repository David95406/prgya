package com.vizsga.databaseconngyak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<OlvasObj> adatok = new ArrayList<>();

        try {
            FileReader fr = new FileReader("valami.csv");
            BufferedReader bf = new BufferedReader(fr);

            String line = bf.readLine();
            while ((line = bf.readLine()) != null) {
                OlvasObj olvasObj = new OlvasObj(line.strip().split(";"));
                adatok.add(olvasObj);
            }

            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("file olvasasi hiba");
        }

        System.out.println(adatok);
    }
}
