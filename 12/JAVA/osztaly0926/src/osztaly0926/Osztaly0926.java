package osztaly0926;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Osztaly0926 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String[] adat = {"Rózsa", "vörös", "12", "true"};
        Noveny rozsa = new Noveny(adat);
        System.out.println(rozsa.getNev());
        System.out.println(rozsa.isEvelo());
        
        try {
            raf = new RandomAccessFile("novenyek.txt", "r");
            Noveny muskatli = new Noveny(raf.readLine().split(", "));
            System.out.println(muskatli.getNev());
            System.out.println(muskatli.isEvelo());
        } catch (IOException e) {
            System.out.println("hiba: " + e);
        }
    }
    
}
