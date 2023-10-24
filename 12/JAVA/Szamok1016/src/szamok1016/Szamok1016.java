package szamok1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Szamok1016 {
    
    public static void main(String[] args) {
        RandomAccessFile felszamTxt;
        String sor;
        ArrayList<String> adatok1 = new ArrayList<>();
        ArrayList<String> adatok2 = new ArrayList<>();

        try {
            felszamTxt = new RandomAccessFile("felszam.txt", "r");
            int db = 0;
            sor = felszamTxt.readLine();

            while (sor != null) {
                adatok1.add(sor);
                sor = felszamTxt.readLine();
                adatok2.add(sor);
                db++;
                sor = felszamTxt.readLine();
            }

            felszamTxt.close();
        } catch (IOException e) {
            System.out.println("hiba: " + e);
        }
        
        ArrayList<Felszam> felszamok = new ArrayList<>();
        for (int i = 0; i < adatok1.size(); i++) {
            Felszam ujFelszam = new Felszam(adatok1.get(i), Integer.parseInt(adatok2.get(i).split(" ")[0]), 
            Integer.parseInt(adatok2.get(i).split(" ")[1]), 
            adatok2.get(i).split(" ")[2]);
            
            felszamok.add(ujFelszam);
        }
        
        System.out.println(felszamok.get(0));
    }
    
}
