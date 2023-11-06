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

        //4 (nemjo)
        int minSzintI = igenyek.get(0).getInduloSzint();
        int maxSzintI = igenyek.get(0).getCelSzint();
        int minSzintC = igenyek.get(0).getInduloSzint();
        int maxSzintC = igenyek.get(0).getCelSzint();
        for (int i = 1; i < igenyek.size(); i++) {
            if (minSzintI < igenyek.get(i).getInduloSzint()) {
                minSzintI = igenyek.get(i).getInduloSzint();
            }
            if (minSzintC < igenyek.get(i).getCelSzint()) {
                minSzintC = igenyek.get(i).getCelSzint();
            }
            if (maxSzintI > igenyek.get(i).getInduloSzint()) {
                maxSzintI = igenyek.get(i).getInduloSzint();
            }
            if (maxSzintC > igenyek.get(i).getCelSzint()) {
                maxSzintC = igenyek.get(i).getCelSzint();
            }
        }
        int min, max;
        if (minSzintI < minSzintC) {
            min = minSzintI;
        } else {
            min = minSzintC;
        }
        if (maxSzintI > maxSzintC) {
            max = maxSzintI;
        } else {
            max = maxSzintC;
        }
        System.out.println(min);
        System.out.println(max);

        //5
        int felUtasokNelkul = 0;
        for (int i = 0; i < igenyek.size() - 1; i++) {
            if (igenyek.get(i).getCelSzint() < igenyek.get(i + 1).getInduloSzint()) {
                felUtasokNelkul++;
            }
        }

        int felUtasokkal = 0;
        for (int i = 0; i < igenyek.size(); i++) {
            if (igenyek.get(i).getInduloSzint() > igenyek.get(i).getCelSzint()) {
                felUtasokkal++;
            }
        }
        System.out.println("Utasok nelkul " + felUtasokNelkul + "szer ment fel a lift");
        System.out.println("Utasokkal " + felUtasokkal + "szer ment fel a lift");

        //6
        int minCsapat = igenyek.get(0).getCsapat();
        int maxCsapat = igenyek.get(0).getCsapat();
        for (int i = 1; i < igenyek.size(); i++) {
            if (igenyek.get(i).getCsapat() < min) {
                minCsapat = igenyek.get(i).getCsapat();
            }
            if (igenyek.get(i).getCsapat() > maxCsapat) {
                maxCsapat = igenyek.get(i).getCsapat();
            }
        }
        System.out.println(minCsapat);
        System.out.println(maxCsapat);
    }
    
}
