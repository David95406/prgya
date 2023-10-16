package lift1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Lift1016 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        RandomAccessFile igenyTxt;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();

        try {
            igenyTxt = new RandomAccessFile("igeny.txt", "r");
            int db = 0;
            int szintekSzama = Integer.parseInt(igenyTxt.readLine());
            int csapatokSzama = Integer.parseInt(igenyTxt.readLine());
            int igenyekSzama = Integer.parseInt(igenyTxt.readLine());
            if (szintekSzama > 100 || csapatokSzama > 50 || igenyekSzama > 100) {
                System.out.println("hiba");
            }
            sor = igenyTxt.readLine();

            while (sor != null) {
                adatok.add(sor);
                db++;
                sor = igenyTxt.readLine();
            }

            igenyTxt.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
        
        ArrayList<Igeny> igenyek = new ArrayList<>();
        for (String adat : adatok) {
            Igeny ujIgeny = new Igeny(Integer.parseInt(adat.split(" ")[0]), Integer.parseInt(adat.split(" ")[1]), 
            Integer.parseInt(adat.split(" ")[2]), Integer.parseInt(adat.split(" ")[3]), Integer.parseInt(adat.split(" ")[4]), 
            Integer.parseInt(adat.split(" ")[5]));
            igenyek.add(ujIgeny);
        }
        
        //2
        System.out.println("2. feladat Kérem a lift indulási helyét!");
        Integer induloSzint = scan.nextInt();
        igenyek.get(0).setInduloSzint(induloSzint);
        System.out.println(igenyek.get(0));
        
        //3
        System.out.println("A lift a " + igenyek.get(igenyek.size() - 1).getCelSzint() + ". szinten áll az utolsó igény teljesítése után.");
        
    }
    
}
