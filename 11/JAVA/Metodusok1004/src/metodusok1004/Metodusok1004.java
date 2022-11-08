/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodusok1004;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author user3
 */
public class Metodusok1004 { //11!

    public static float atlag(float a, float b) {
        return (a + b) / 2;
    }

    public static void fejlec() {
        System.out.println("***************");
        System.out.println("*   Feladat   *");
        System.out.println("***************");
    }

    public static int random(int a, int b) {
        if (a < b) {
            return (int) (Math.random() * b) + a;
        } else if (a > b) {
            return (int) (Math.random() * a) + b;
        } else {
            return a;
        }
    }

    public static int random2(int a, int b) {
        return (int) (Math.random() * a) + b;
    }

    public static double gula(double a, double m) {
        return (a * a * m) / 3;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner bill = new Scanner(System.in);
        float a, b;
        int i, c, d;
        double ga, m;

        fejlec();

        System.out.println("Két szám átlaga");
        a = bill.nextFloat();
        b = bill.nextFloat();
        System.out.println(atlag(a, b));
        System.out.println("tartomany");

        c = bill.nextInt();
        d = bill.nextInt();
        System.out.println("");

        //random 1
        System.out.println(random(c, d));

        //random 2
        if (c < d) {
            System.out.println(random2(d, c));
        } else if (c > d) {
            System.out.println(random2(c, d));
        } else {
            System.out.println(c + " = " + d);
        }

        //tomb feltoltese random szamokkal
        int[] szamok = new int[20];
        for (i = 0; i < 20; i++) {
            szamok[i] = random(c, d);
        }

        System.out.println("Lista:");
        for (i = 0; i < szamok.length; i++) {
            System.out.println(szamok[i] + "\t");
        }
        
        //gula
        System.out.println("A gula terulete: ");
        ga = bill.nextDouble();
        System.out.println("A gula magassaga: ");
        m = bill.nextDouble();
        System.out.println("A gula terfogata: " + gula(ga, m));
    }

}
