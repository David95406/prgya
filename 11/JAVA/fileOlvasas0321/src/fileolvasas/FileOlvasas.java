package fileolvasas;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOlvasas {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        String[] nevek = new String[6];

        try {
            raf = new RandomAccessFile("nevek.txt", "r");
            int db = 0;
            sor = raf.readLine();

            while (sor != null) {
                nevek[db] = sor;
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba!");
        }

        for (String nev : nevek) {
            System.out.println(nev);
        }

        //szamok olvasasa
        RandomAccessFile raf2;
        int[] szamok = new int[10];

        try {
            raf2 = new RandomAccessFile("szamok.txt", "r");
            int db = 0;

            sor = raf2.readLine();
            while (sor != null) {
                szamok[db] = Integer.parseInt(sor);
                db++;
                sor = raf2.readLine();
            }
        } catch (IOException e) {
            System.out.println("hiba" + e);
        }

        for (int i = 0; i < szamok.length; i++) {
            System.out.print(szamok[i] + "  ");
        }
    }

}
