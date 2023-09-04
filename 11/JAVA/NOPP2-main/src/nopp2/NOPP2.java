/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nopp2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user3
 */
public class NOPP2 {

    public static void csillag() {
        System.out.println("*********************");
        System.out.println("*   NOPPVDProject   *");
        System.out.println("*********************");
    }

    public static boolean szokoevE(int x) {

        if (((x % 4 == 0) && (x % 100 != 0)) || (x % 400 == 0)) {

            return true;
        }
        return false;
    }

    public static int reverse(int n) {

        int fordított = 0;
        int maradek;

        while (n > 0) {

            maradek = n % 10;
            fordított = (fordított * 10) + maradek;
            n = n / 10;
        }
        System.out.println(fordított);
        return fordított;
    }

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        //6.-ik FELADAT
        System.out.println("Adjon meg egy évszámot: ");
        int szokev = bill.nextInt();
        //7.-ik FELADAT
        System.out.println("Szökőév: " + szokoevE(szokev));
        System.out.println("Szökőév fordítva: 0" + reverse(szokev));
        csillag();

        // O készít egy metódust, ami eldönti hogy szökőév e
        //if (year % 400 == 0) {
        //  System.out.println(year + " Ez egy szökőév.");
        //} 
        //else if (year % 100 == 0) {
        //  System.out.println(year + " Ez nem egy szökőév..");
        //} 
        //else if (year % 4 == 0) {
        // System.out.println(year + " Ez egy szökőév..");
        //} 
        //else {
        //  System.out.println(year + " Ez nem egy szökőév..");
        //}
    }
}
