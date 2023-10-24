package tanciskola1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class TancIskola1016 {

    public static void main(String[] args) {
        RandomAccessFile tancrendTxt;
        String sor;
        ArrayList<String> adatok1 = new ArrayList<>();
        ArrayList<String> adatok2 = new ArrayList<>();
        ArrayList<String> adatok3 = new ArrayList<>();

        try {
            tancrendTxt = new RandomAccessFile("tancrend.txt", "r");
            int db = 0;
            sor = tancrendTxt.readLine();

            while (sor != null) {
                adatok1.add(sor);
                sor = tancrendTxt.readLine();
                adatok2.add(sor);
                sor = tancrendTxt.readLine();
                adatok3.add(sor);
                db++;
                sor = tancrendTxt.readLine();
            }

            tancrendTxt.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
        
        ArrayList<Tancrend> tancrendek = new ArrayList<>();
        for (int i = 0; i < adatok1.size(); i++) {
            Tancrend ujTancrend = new Tancrend(adatok1.get(i), adatok2.get(i), adatok3.get(i));
            tancrendek.add(ujTancrend);
        }
        
        System.out.println(tancrendek.get(0));
    }
    
}
