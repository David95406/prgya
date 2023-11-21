import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RandomAccessFile melysegTxt;
        ArrayList<Godor> melysegek = new ArrayList<Godor>();
        try {
            melysegTxt = new RandomAccessFile("melyseg.txt", "r");
            String sor = melysegTxt.readLine();

            while (sor != null) {
                melysegek.add(new Godor(Integer.parseInt(sor)));
                sor = melysegTxt.readLine();
            }
        } catch (IOException e) {
            System.out.println("HIBA");
        }

        //1
        System.out.println("1. feladat\nA fajl adatainak szama: " + melysegek.size());

        //2
        System.out.println("\n2. feladat");
        System.out.print("Adjon meg egy tavolsagerteket: ");
        int tavolsagertekInput = scan.nextInt();
        System.out.println(tavolsagertekInput + " tavolsagban " +
                melysegek.get(tavolsagertekInput - 1).toString() + "m mely a godor.");

        //3
        System.out.println("\n3. feladat");
        int erintettlen = 0;
        for (Godor dip : melysegek) {
            if (dip.getDip() == 0) {
                erintettlen++;
            }
        }
        System.out.println("A erintetlen terulet aranya: " + String.format("%.2f", (double) erintettlen / melysegek.size() * 100) + "%");

        //4
        ArrayList<Godor> egyGodor = new ArrayList<Godor>();
        ArrayList<ArrayList<Godor>> godrok = new ArrayList<ArrayList<Godor>>();
        for (int i = 0; i < melysegek.size(); i++) {
            Godor uresGodor = new Godor(0);
            while (melysegek.get(i).getDip() != 0) {
                egyGodor.add(melysegek.get(i));
                i++;
            }
            godrok.add(egyGodor);
            egyGodor = new ArrayList<Godor>();
        }

        for (int i = 0; i < godrok.size(); i++) {
            godrok.removeIf(ArrayList::isEmpty);
        }

        try (FileWriter writer = new FileWriter("godrok.txt")) {
            for (ArrayList<Godor> godor : godrok) {
                for (Godor melyseg : godor) {
                    writer.write(melyseg.getDip() + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {   
            System.out.println("HIBA");
        }

        //5
        System.out.println("\n5. feladat\nGodrok szama: " + godrok.size());

        //6
        System.out.println("\n6. feladat");
        ArrayList<Godor> userGodor = new ArrayList<Godor>();
        if (melysegek.get(tavolsagertekInput).getDip() != 0) {
            int kezdoIndex;
            int vegeIndex;
            int gIndex = tavolsagertekInput - 1;
            while (melysegek.get(gIndex).getDip() != 0) {
                userGodor.add(melysegek.get(gIndex));
                gIndex--;
            }
            kezdoIndex = gIndex;

            userGodor.add(melysegek.get(tavolsagertekInput));
            gIndex = tavolsagertekInput;
            while (melysegek.get(gIndex).getDip() != 0) {
                userGodor.add(melysegek.get(gIndex));
                gIndex++;
            }
            vegeIndex = gIndex;

            //a
            System.out.println("a)\nA godor kezdete: " + kezdoIndex + " meter, " +
                    "a godor vege: " + vegeIndex + " meter.");

            //b
            Godor UGMax = userGodor.get(0);
            for (Godor egyMelyseg : userGodor) {
                if (UGMax.getDip() < egyMelyseg.getDip()) {
                    UGMax = egyMelyseg;
                }
            }
            Godor UGMin = userGodor.get(0);
            for (Godor egyMelyseg : userGodor) {
                if (UGMin.getDip() > egyMelyseg.getDip()) {
                    UGMax = egyMelyseg;
                }
            }

            int UGMaxIndex = userGodor.lastIndexOf(UGMax);
            int UGMinIndex = userGodor.indexOf(UGMin);
            int jobbra = UGMaxIndex;
            int balra = UGMaxIndex;
            int mely = 0;

            while (userGodor.get(jobbra).getDip() > userGodor.get(jobbra++).getDip() &&
                    userGodor.get(balra).getDip() > userGodor.get(balra--).getDip() &&
            userGodor.get(jobbra).getDip() != UGMin.getDip()) {
                mely++;
            }
            boolean melyulE = mely == userGodor.get(UGMinIndex).getDip();
            System.out.println("b)");
            System.out.println(melyulE ? "Folyamatosan melyul" : "Nem melyul folyamatosan");


            //c
            System.out.println("c)\nA legnagyobb melysege: " + UGMax + " meter.");

            //d
            int terfogat = 0;
            for (Godor godor : userGodor) {
                terfogat += 10 * godor.getDip();
            }
            System.out.println("d)\nA terfogata: " + terfogat + " m^3.");

            //e
            System.out.println("e)\nA vizmennyiseg " + (terfogat - 90) + " m^3.");


        } else {
            System.out.println("Az adott helyen nincs godor.");
        }


    }
}