package filebeolvasas2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class file2 {
    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        
        int osszeg = 0;
        int adatLength = 0;
        int[] szamok = new int[adatLength];
        
        try {
            raf = new RandomAccessFile("adat2.txt", "r");
            int db = 0;
            adatLength = Integer.parseInt(raf.readLine()); //az elso a file hossza!
            szamok = new int[adatLength];
            sor = raf.readLine();
            
            while (sor != null) {
                szamok[db] = Integer.parseInt(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        for (int szam : szamok) {
            System.out.println(szam);
            osszeg = osszeg + szam;
        }
        System.out.println("Az összeg: " + osszeg);
        System.out.println("A fileban " + adatLength + " szám van.");
    }
}
