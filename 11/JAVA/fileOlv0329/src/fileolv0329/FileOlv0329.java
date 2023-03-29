package fileolv0329;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileOlv0329 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        ArrayList<String> autok = new ArrayList<>();
        int adatLen = 0;

        try {
            raf = new RandomAccessFile("adat.txt", "r");
            int db = 0;
            adatLen = Integer.parseInt(raf.readLine());
            sor = raf.readLine();

            while (sor != null) {
                autok.add(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba!");
        }

        for (String auto : autok) {
            System.out.println(auto);
        }
        
        RandomAccessFile raf2;
        
        try {
            raf2 = new RandomAccessFile("autokWrite.txt", "rw");
            for (String auto : autok) {
                if (auto.startsWith("F")) {
                    raf2.writeBytes(auto + "\n");
                }
                
            }
            raf2.close();
        } catch (IOException e){
            System.out.println("hiba");
        }
    }

}
