/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oraif1007;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author user3
 */
public class OraiF1007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Adjon meg 0-nal nagyobb paros szamot.");
        Scanner scan = new Scanner(System.in);
        int fszam = scan.nextInt();
        while (!(fszam > 0 && fszam % 2 == 0)) {
            fszam = scan.nextInt();
        }
        //hatul 
        do {
            System.out.println("Adjon meg 0-nal nagyobb paros szamot.");
            fszam = scan.nextInt();
        } while (!(fszam > 0 && fszam % 2 == 0));
        //szam kitalal
        int rszam = (int) (Math.random() * 9) + 1;
        System.out.println(rszam);
        System.out.println("talald ki a szamot 1-10");
        while (fszam != rszam) {
            System.out.println("nem");
            fszam = scan.nextInt();
        }
    }
    
}
