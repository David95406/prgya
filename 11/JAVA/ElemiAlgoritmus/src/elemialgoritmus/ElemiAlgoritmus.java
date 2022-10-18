/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elemialgoritmus;

import java.util.Random;

/**
 *
 * @author david
 */
public class ElemiAlgoritmus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] szamok = new int[10];
        int paros = 0;
        int negyoszt = 0;
        int osszeg = 0;
        int otkis = -1;
        int max = 0;
        int min = 10;
        
        //10 random szam
        for (int i = 0; i < 10; i++) {
            szamok[i] = (int) (Math.random() * 10) + 1;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.print(szamok[i] + " ");
            
            //oszzeg
            osszeg += szamok[i];
            
            //paros
            if (szamok[i] % 2 == 0) {
                paros++;
            }
            
            //oszthato 4
            if (szamok[i] % 4 == 0) {
                negyoszt++;
            }
            
            //az elso <5
            if (szamok[i] < 5 && otkis == -1) {
                otkis = i;
            }
            
        }
        
        //max
        for (int a = 0; a < szamok.length; a++) {
            if (szamok[a] > max) {
                max = szamok[a];
            }
        }
        
        //min
        for (int b = 0; b < szamok.length; b++) {
            if (szamok[b] < min) {
                min = szamok[b];
            }
        }
        
        if (otkis == -1) {
            System.out.println("\nNincs 5-nel kisebb szam!");
        }
        else {
            System.out.println("\nAz elso otnel kisebb szam helye: " + otkis);
        }
        
        System.out.println("A szamok osszege: " + osszeg);
        System.out.println("Paros szamok: " + paros + " db.");
        System.out.println("4-gyel oszthato szamok: " + negyoszt + " db.");
        System.out.println("A legnagyobb szam: " + max);
        System.out.println("A legkisebb szam: " + min);
        
    }
    
}
