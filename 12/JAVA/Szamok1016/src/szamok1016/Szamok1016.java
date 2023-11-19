package szamok1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;

public class Szamok1016 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
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

        //2
        System.out.println("Feladatok szama: " + adatok1.size());

        //3
        int[] matekFPontok = new int[3];
        int matekFeladatok = 0;
        for (Felszam felszam : felszamok) {
            if (felszam.getTema().equals("matematika")) {
                matekFeladatok++;
                switch (felszam.getNehezseg()) {
                    case 1: matekFPontok[0]++;
                    case 2: matekFPontok[1]++;
                    case 3: matekFPontok[2]++;
                    default:
                }
            }
        }
        System.out.println("Az adatfileban " + matekFeladatok + " matematika feladat van, " +
                "1 pontot er " + matekFPontok[0] + " feladat, " +
                "2 pontot er " + matekFPontok[1] + " feladat, " +
                "3 pontot er " + matekFPontok[2] + " feladat.");

        //4
        int[] valaszokRange = {felszamok.get(0).getValasz(), felszamok.get(0).getValasz()};
        for (Felszam felszam : felszamok) {
            if (felszam.getValasz() < valaszokRange[0]) {
                valaszokRange[0] = felszam.getValasz();
            }
            if (felszam.getValasz() > valaszokRange[1]) {
                valaszokRange[1] = felszam.getValasz();
            }
        }
        System.out.println("A valaszok szamerteke " + valaszokRange[0] + "-tol " + valaszokRange[1] + "-ig terjed.");

        //5
        ArrayList<String> temak = new ArrayList<String>();
        for (Felszam felszam : felszamok) {
            if (!temak.contains(felszam.getTema())) {
                temak.add(felszam.getTema());
            }
        }

        System.out.println("Temakorok: " + Arrays.toString(temak.toArray()).replace("[", "").replace("]", ""));

        //6
        System.out.print("Milyen temakorbol szeretne kerdest kapni? ");
        String temaInput = scan.next();
        ArrayList<Felszam> temaKerdesek = new ArrayList<Felszam>();
        for (Felszam felszam : felszamok) {
            if (temaInput.equals(felszam.getTema())) {
                temaKerdesek.add(felszam);
            }
        }

        int kerdesIndex = rand.nextInt(temaKerdesek.size());
        System.out.print(temaKerdesek.get(kerdesIndex).getKerdes() + " ");
        int fValasz = scan.nextInt();
        if (fValasz == temaKerdesek.get(kerdesIndex).getValasz()) {
            System.out.println("Helyes valasz! A valasz " + temaKerdesek.get(kerdesIndex).getNehezseg() + " pontot er.");
        } else {
            System.out.println("Hibas valasz! A valasz 0 pontot er.");
            System.out.println("Helyes valasz: " + temaKerdesek.get(kerdesIndex).getValasz());
        }

        //7
        ArrayList<Felszam> tesztkerdesek = new ArrayList<Felszam>();
        int tesztPontok = 0;
        while (tesztkerdesek.size() != 10) {
            int tesztkerdesIndex = rand.nextInt(felszamok.size());
            if (!tesztkerdesek.contains(felszamok.get(tesztkerdesIndex))) {
                tesztkerdesek.add(felszamok.get(tesztkerdesIndex));
                tesztPontok += felszamok.get(tesztkerdesIndex).getNehezseg();
            }
        }
        System.out.println(tesztkerdesek.size());

        try (FileWriter writer = new FileWriter("tesztfel.txt")) {
            for (Felszam egyKerdes : tesztkerdesek) {
                String content = egyKerdes.getNehezseg() + " " + egyKerdes.getValasz() + " " + egyKerdes.getKerdes() + "\n";
                writer.write(content);
            }
            writer.write("A feladatsorra osszesen " + tesztPontok + " pont adhato");
        } catch (IOException e) {
            System.out.println("HIBA");
        }
    }

}
