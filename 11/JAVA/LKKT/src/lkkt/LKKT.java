/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lkkt;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class LKKT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        int a;
        int b;
        int lkkt;
        Scanner scan = new Scanner(System.in);
        
        a = scan.nextInt();
        b = scan.nextInt();
        lkkt = a;
        
        while(lkkt % b != 0) {
            lkkt += a;
        }
        System.out.println(lkkt);
        
    }
    
}
