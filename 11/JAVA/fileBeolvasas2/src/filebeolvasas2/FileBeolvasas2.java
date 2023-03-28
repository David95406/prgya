package filebeolvasas2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileBeolvasas2 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        int osszeg = 0;
        int[] szamok = new int[6];
        
        try {
            raf = new RandomAccessFile("adat.txt", "r");
            int db = 0;
            sor = raf.readLine();

            while (sor != null) {
                szamok[db] = Integer.parseInt(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba!");
        }
        
        for (int szam : szamok) {
            System.out.println(szam);
            osszeg = osszeg + szam;
        }
        System.out.println("Az összeg: " + osszeg);

    }

}
