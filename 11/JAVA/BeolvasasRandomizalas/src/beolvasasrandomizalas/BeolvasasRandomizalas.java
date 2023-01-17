package beolvasasrandomizalas;

import java.util.Scanner;

public class BeolvasasRandomizalas {
    public static void main(String[] args) {
        
        Scanner bill = new Scanner(System.in);
        //adat beolvasas billrol - egesz szam
        System.out.print("Adjon meg egy számot: ");
        int szam;
        szam = bill.nextInt();
        System.out.println("A beolvasott érték: " + szam);
        //szam2
        System.out.print("Adjon meg egy valos szamot: ");
        Float vszam;
        vszam = bill.nextFloat();
        System.out.println("A beolvasott érték: " + vszam);
        
        //string olvas
        System.out.print("Adja meg a nevet: ");
        String nev;
        nev = bill.nextLine();
        System.out.println("A neve: " + nev);
       
    }
    
}
