/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orai1004;

import java.util.Scanner;

/**
 *
 * @author user3
 */
public class Orai1004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Adjon meg egy szamot! (irja be '-1' a kilepeshez.");
        Scanner scan = new Scanner(System.in);
        int db = 0;
        int szam = scan.nextInt();
        int osszeg = 0;
        int haromoszt = 0;
        float atlag = 0;
        while (szam != -1) {
            osszeg += szam;
            db++;
            if (szam % 3 == 0) {
                haromoszt++;
            }
            szam = scan.nextInt();
        }

        osszeg += 2;
        atlag = (osszeg / db);
        System.out.println("Done\n");
        System.out.println(db + "db szam van");
        System.out.println("A szamok osszege: " + osszeg);
        System.out.println("Harommal oszthato szamok: " + haromoszt);
        System.out.println("A szamok atlaga: " + atlag);
    }
    
}
