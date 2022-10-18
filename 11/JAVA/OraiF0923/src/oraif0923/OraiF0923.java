/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oraif0923;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author user3
 */
public class OraiF0923 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner bill = new Scanner(System.in);
        System.out.println("Addja meg a haromszog oldalait.");
        System.out.print("");
        int a;
        a = bill.nextInt();
        System.out.print("");
        int b;
        b = bill.nextInt();
        System.out.print("");
        int c;
        c = bill.nextInt();
        if (a * b > c && a * c > b && b * c > a) {
            System.out.println("A haromszog derekszogu");
        
        } else {
                System.out.println("A haromszog nem derekszogu");
                }
        int x = 3;
        int y = 4;
        System.out.println(Math.sqrt((x*x) + (y*y)));
        
    }
    
}
