package fileolvgyak0321;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOlvGyak0321 {
    
    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        String[] nevek = new String[5];
        
        try {
            raf = new RandomAccessFile("nevek.txt", "r");
            int db = 0;
            raf.readLine(); //az elso sorban nincs nev
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
    }
    
}
