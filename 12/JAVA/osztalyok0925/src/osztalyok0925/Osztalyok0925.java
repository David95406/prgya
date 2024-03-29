package osztalyok0925;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Osztalyok0925 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();
        ArrayList<Kutya> kutyak = new ArrayList<>();
        Kutya lenaKutya = new Kutya("Léna", "Labrador", "fekete", 30);
        Kutya rexiKutya = new Kutya("Rexi", "Puli", "fekete", 14);

        System.out.println(lenaKutya.getFajta());
        lenaKutya.ugat();
        
        try {
            raf = new RandomAccessFile("kutyak.txt", "r");
            String[] splitSor = raf.readLine().split(", ");
            Kutya cezarKutya = new Kutya(splitSor[0], splitSor[1], splitSor[2], Integer.parseInt(splitSor[3]));
            splitSor = raf.readLine().split(", ");
            Kutya fickoKutya = new Kutya(splitSor[0], splitSor[1], splitSor[2], Integer.parseInt(splitSor[3]));
            System.out.println(fickoKutya.getNev());
        } catch (IOException e) {
            System.out.println("hiba: " + e);
        }
        
        
        /*
        try {
            raf = new RandomAccessFile("kutyak.txt", "r");
            sor = raf.readLine();

            while (sor != null) {
                adatok.add(sor);
                sor = raf.readLine();
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("hiba: " + e);
        }

        for (String adat : adatok) {
            String nev = adat.split(",")[0].strip();
            String fajta = adat.split(",")[1].strip();
            String szin = adat.split(",")[2].strip();
            int ttomeg = Integer.parseInt(adat.split(",")[3].strip());

            Kutya ujKutya = new Kutya(nev, fajta, szin, ttomeg);
            kutyak.add(ujKutya);
        }

        for (Kutya kutya : kutyak) {
            System.out.println(kutya.getNev());
        }
*/

    }

}
