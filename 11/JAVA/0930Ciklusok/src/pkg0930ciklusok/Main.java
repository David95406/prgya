/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0930ciklusok;

import java.util.Random;
/**
 *
 * @author user3
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        for (i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("\n\n");
        //FOR visszafele
        for (i = 4; i > -1; i--) {
            System.out.println(i);
        }
        System.out.println("\n\n"); 
        //FOR kettesevel`0
        for (i = 0; i < 5; i += 2) {
            System.out.println(i);
        }
        //eloltestestelo ciklus
        int szam = 0;
        while (szam < 5) {
            System.out.println(szam); 
            szam++;
        }
        System.out.println("\n\n");
        //FELADAT: generaljunk 1-20 kozott egy paros szamot
        int parosSzam = (int)(Math.random() * 20) + 1;;
        while (parosSzam % 2 != 0) {
            parosSzam++;
            System.out.println(parosSzam);
        }
               
    }
    
}
