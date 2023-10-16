package tanciskola1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class TancIskola1016 {

    public static void main(String[] args) {
        RandomAccessFile tancrendTxt;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();

        try {
            tancrendTxt = new RandomAccessFile("tancrend.txt", "r");
            int db = 0;
            sor = tancrendTxt.readLine();

            while (sor != null) {
                adatok.add(sor);
                db++;
                sor = tancrendTxt.readLine();
            }

            tancrendTxt.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
        
        System.out.println(adatok.size() / 3 + "db tánc történt.");
    }
    
}
