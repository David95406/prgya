package filekezelesdoga0404;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileKezelesDoga0404 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        String versenyzoNev = "";
        int szulEv = -1;
        ArrayList<Integer> pontszamok = new ArrayList<>();

        try {
            raf = new RandomAccessFile("versenyzo.txt", "r");
            int db = 0;
            versenyzoNev = raf.readLine();
            szulEv = Integer.parseInt(raf.readLine().split(":")[1].strip());
            raf.readLine();
            sor = raf.readLine();

            while (sor != null) {
                pontszamok.add(Integer.parseInt(sor));
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }

        RandomAccessFile rafWrite;
        
        try {
            rafWrite = new RandomAccessFile("osszegzes.txt", "rw");
            int osszpontszam = 0;

            for (int pontszam : pontszamok) {
                osszpontszam += pontszam;
            }

            rafWrite.writeBytes(versenyzoNev + " (" + szulEv + "): " + osszpontszam + " pont");

            rafWrite.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
    }

}
