/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gyak1013;

import java.util.Random;

/**
 *
 * @author david
 */
public class Gyak1013 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Dolgozat gyakorlás
        //Tömb deklarálása
        int []szamok = new int[10];
        //Random számok
        Random rand = new Random();
        int i; //-> Hiba: i = 0;
        for (i = 0; i < szamok.length; i++) {
            szamok[i] = rand.nextInt(10) + 1;
        }
        //Összegzés
        int osszeg = 0;
        for (i = 0; i < szamok.length; i++) {
            osszeg = osszeg + szamok[i];
        }
        //2-vel osztható
        int parosDB = 0;
        for (i = 0; i < szamok.length; i++) {
            if (szamok[i] % 2 == 0) {
                parosDB++;
            }
        }
        //Minimun
        int min = 0;
        for (i = 1; i < szamok.length; i++) {
            if (szamok[i] < min) {
                min = szamok[i];
            }
        }
        //Max
        int max = 0;
        for (i = 1; i < szamok.length; i++) {
            if (szamok[i] > max) {
                max = szamok[i];
            }
        }
        //kiválasztás
        i = 0;
        while (szamok[i] >= 5) {
            i++;
        }
        //Eldöntés
        i = 0;
        while (i < szamok.length && (szamok[i] % 4 != 0)) {
            i++;
        }
    }
    
}