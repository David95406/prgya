/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *f6 = run
 */
package myfirst;

/**
 *
 * @author user3
 */
public class MyFirst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int szam = 3;
        String fnev = "Abraham";
        String lnev = "David";
        System.out.println("Hello Word!");
        System.out.println(1 + szam);
        System.out.println(fnev + " " + lnev);
        if (szam > 2) {
            System.out.println(szam + " nagyobb 2 nél");
        }
        System.out.print("em"); //nem kezd uj sort
        System.out.print("ber\n");
        int mszam = 12; //masodik szam
        System.out.println("A megadott érték: " + mszam);
        double magassag = 1.65; //float
        System.out.println("Magassag: " + magassag + "m");
        System.out.println("Magassag cmben: " + (magassag * 100) + "cm");
    }
    
}