package tanciskola1016;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;

public class TancIskola1016 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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


        //2
        System.out.println("Az elso tanc neve: " + tancrendek.get(0).getNev() +
                "\nAz utolso tanc neve: " + tancrendek.get(tancrendek.size() - 1).getNev());

        //3
        int samba = 0;
        for (Tancrend tancrend : tancrendek) {
            if (tancrend.getNev().equals("samba")) {
                samba++;
            }
        }
        System.out.println(samba + " par mutatott be sambat.");

        //4
        ArrayList<String> vilmaTancok = new ArrayList<String>();
        for (Tancrend tancrend : tancrendek) {
            if (tancrend.getParLany().equals("Vilma")) {
                vilmaTancok.add(tancrend.getNev());
            }
        }
        System.out.println("Vilma ezekben a tancokban szerepelt: " +
                Arrays.toString(vilmaTancok.toArray()).replace("[", "").replace("]", ""));

        //5
        System.out.print("Adja meg a tancot: ");
        String tancInput = scan.next();
        boolean isTancInput = false;
        for (Tancrend tancrend : tancrendek) {
            if (tancrend.getParLany().equals("Vilma") && tancrend.getNev().equals(tancInput)) {
                System.out.println("A " + tancInput + " bemutatojan Vilma parja " + tancrend.getParFiu() + " volt.");
                isTancInput = true;
            }
        }
        if (!isTancInput) {
            System.out.println("Vilma nem tancolt " + tancInput + "-t");
        }

        //6
        ArrayList<String> fiuk = new ArrayList<String>();
        ArrayList<String> lanyok = new ArrayList<String>();
        for (Tancrend tancrend : tancrendek) {
            if (!fiuk.contains(tancrend.getParFiu())) {
                fiuk.add(tancrend.getParFiu());
            }
            if (!lanyok.contains(tancrend.getParLany())) {
                lanyok.add(tancrend.getParLany());
            }
        }

        try (FileWriter writer = new FileWriter("szereplok.txt")) {
            writer.write("Fiuk: " + Arrays.toString(fiuk.toArray()).replace("[", "").replace("]", ""));
            writer.write("\nLanyok: " + Arrays.toString(lanyok.toArray()).replace("[", "").replace("]", ""));
        } catch (IOException e) {
            System.out.println("HIBA");
        }

        //7
        int[] fiukStat = new int[fiuk.size()];
        int[] lanyokStat = new int[lanyok.size()];
        for (int i = 0; i < tancrendek.size(); i++) {
            for (int j = 0; j < fiuk.size(); j++) {
                if (tancrendek.get(i).getParFiu().equals(fiuk.get(j))) {
                    fiukStat[j]++;
                }
            }
            for (int j = 0; j < lanyok.size(); j++) {
                if (tancrendek.get(i).getParLany().equals(lanyok.get(j))) {
                    lanyokStat[j]++;
                }
            }
        }

        int maxFiu = fiukStat[0];
        ArrayList<String> maxFiuk = new ArrayList<String>();
        for (int i = 0; i < fiuk.size(); i++) {
            if (maxFiu <= fiukStat[i]) {
                maxFiuk.add(fiuk.get(i));
            }
        }

        int maxLany = lanyokStat[0];
        ArrayList<String> maxLanyok = new ArrayList<String>();
        for (int i = 0; i < lanyok.size(); i++) {
            if (maxLany <= lanyokStat[i]) {
                maxLanyok.add(lanyok.get(i));
            }
        }
        System.out.println("A fiuk kozul a legtobbet szereplt(ek): " +
                Arrays.toString(maxFiuk.toArray()).replace("[", "").replace("]", ""));
        System.out.println("A lanyok kozul a legtobbet szereplt(ek): " +
                Arrays.toString(maxLanyok.toArray()).replace("[", "").replace("]", ""));

    }

}
