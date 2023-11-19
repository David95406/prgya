package lift1016;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Lift1016 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        RandomAccessFile igenyTxt;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();
        int szintekSzama = 0;
        int csapatokSzama = 0;
        int igenyekSzama = 0;

        try {
            igenyTxt = new RandomAccessFile("igeny.txt", "r");
            int db = 0;
            szintekSzama = Integer.parseInt(igenyTxt.readLine());
            csapatokSzama = Integer.parseInt(igenyTxt.readLine());
            igenyekSzama = Integer.parseInt(igenyTxt.readLine());
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
        int induloSzint = 1;//scan.nextInt();
        igenyek.get(0).setInduloSzint(induloSzint);
        System.out.println(igenyek.get(0));

        //3
        System.out.println("A lift a " + igenyek.get(igenyek.size() - 1).getCelSzint() +
                ". szinten áll az utolsó igény teljesítése után.");

        //4
        int[] minMaxSzintek = new int[4];
        for (Igeny igeny : igenyek) {
            if (igeny.getInduloSzint() < minMaxSzintek[0]) {
                minMaxSzintek[0] = igeny.getInduloSzint();
            }
            if (igeny.getCelSzint() > minMaxSzintek[1]) {
                minMaxSzintek[1] = igeny.getCelSzint();
            }
            if (igeny.getInduloSzint() < minMaxSzintek[2]) {
                minMaxSzintek[2] = igeny.getInduloSzint();
            }
            if (igeny.getCelSzint() > minMaxSzintek[3]) {
                minMaxSzintek[3] = igeny.getCelSzint();
            }
        }
        System.out.println("A legalacsonyabb erintett szint: " + Arrays.stream(minMaxSzintek).min().getAsInt() +
                "\nA legmagasabb erintett szint: " + Arrays.stream(minMaxSzintek).max().getAsInt());

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
        ArrayList<Integer> osszesCsapat = new ArrayList<Integer>();
        for (int i = 0; i < csapatokSzama; i++) {
            osszesCsapat.add(i + 1);
        }
        ArrayList<Integer> csapatok = new ArrayList<Integer>();
        for (Igeny igeny : igenyek) {
            if (!csapatok.contains(igeny.getCsapat())) {
                csapatok.add(igeny.getCsapat());
            }
        }
        ArrayList<Integer> nemVettekIgenybeCsapatok = new ArrayList<Integer>(osszesCsapat);
        nemVettekIgenybeCsapatok.removeAll(csapatok);
        System.out.println("Csapatok akik nem vettek igenybe: " +
                Arrays.toString(nemVettekIgenybeCsapatok.toArray()).replace("[", "").replace("]", ""));


        //7
        int randomCsapat = csapatok.get(rand.nextInt(csapatok.size()));
        ArrayList<Igeny> randomCsapatIgeny = new ArrayList<Igeny>();
        for (Igeny igeny : igenyek) {
            if (igeny.getCsapat() == randomCsapat) {
                randomCsapatIgeny.add(igeny);
            }
        }

        int[] szabalytalansag = new int[2];
        boolean szabalytalan = false;
        for (int i = 0; i < randomCsapatIgeny.size() - 1; i++) {
            if (randomCsapatIgeny.get(i).getCsapat() == randomCsapat &&
                    randomCsapatIgeny.get(i).getCelSzint() != randomCsapatIgeny.get(i + 1).getInduloSzint()) {
                szabalytalan = true;
                szabalytalansag[0] = randomCsapatIgeny.get(i).getCelSzint();
                szabalytalansag[1] = randomCsapatIgeny.get(i + 1).getInduloSzint();
                break;
            }
        }
        System.out.println(szabalytalan ? "A " + randomCsapat + ". csapat a "
                + szabalytalansag[0] + ". szinttol gyalog ment a " + szabalytalansag[1] + ". szintig."
                : "Nem bizonyítható szabálytalanság a " + randomCsapat + ". csapatnal.");


        //8
        System.out.println("\n\nAdatok bekerese:\n");
        for (int i = 0; i < randomCsapatIgeny.size(); i++) {

            System.out.println((i + 1) + ". igeny adatai: ");
            System.out.println(randomCsapatIgeny.get(i));

            System.out.print("Adja meg a(z) " + (i + 1) + ". igeny sikeresseget: ");
            boolean sikeressegInput = scan.nextBoolean();
            System.out.print("Adja meg a(z) " + (i + 1) + ". igeny feladatkodjat: ");
            int feladatkodInput = scan.nextInt();


            try (FileWriter writer = new FileWriter("blokkol.txt", true)){
                String content = "Indulasi emelet: " + randomCsapatIgeny.get(i).getInduloSzint() +
                        "\nCelemelet: " + randomCsapatIgeny.get(i).getCelSzint() +
                        "\nFeladatkod: " + feladatkodInput +
                        "\nBefejezes ideje: " +
                        randomCsapatIgeny.get(i).getOra() + ":" + randomCsapatIgeny.get(i).getPerc() + ":" + randomCsapatIgeny.get(i).getMasodperc() +
                        "\nSikeresseg: " + (sikeressegInput ? "befejezett" : "bejezetlen") +
                        "\n----\n";
                writer.write(content);
            } catch (IOException e) {
                System.out.println("HIBA");
            }
            System.out.println("Adatok sikeresen mentve!\n\n\n");

        }


    }
}
