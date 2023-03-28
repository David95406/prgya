package filebeolvasas2;

import java.util.ArrayList;
import java.io.IOException;
import java.io.RandomAccessFile;

public class file4 {
    
    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        int osszeg = 0;
        ArrayList<Integer> szamok = new ArrayList<>();
        
        try {
            raf = new RandomAccessFile("adat.txt", "r");
            sor = raf.readLine();

            while (sor != null) {
                szamok.add(Integer.parseInt(sor));
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba!");
        }
        
        for (int szam : szamok) {
            System.out.print(szam + " ");
            osszeg = osszeg + szam;
        }
        System.out.println("\nAz összeg: " + osszeg);
    }
}
