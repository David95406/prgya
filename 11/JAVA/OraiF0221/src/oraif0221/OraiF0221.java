package oraif0221;

import java.util.Scanner;

public class OraiF0221 {

    public static boolean primszamCheck(int szam) {
        if (szam == 0) return false;
        
        int oszto = 2;
        while (szam % oszto != 0 && oszto < szam) {
            oszto++;
        }
        
        return szam == oszto;
    }
    
    public static void main(String[] args) {
        int fSzam;
        
        Scanner bill = new Scanner(System.in);
        
        do {
            fSzam = bill.nextInt();
            if (primszamCheck(fSzam)) System.out.println("A(z) " + fSzam + " prímszám.");
        } while (fSzam != 0);
    }
    
}