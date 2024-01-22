import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RandomAccessFile raf;
        String sor;
        ArrayList<String> adatok1 = new ArrayList<String>();
        ArrayList<String> adatok2 = new ArrayList<String>();
        ArrayList<String> adatok3 = new ArrayList<String>();
        ArrayList<String> adatok4 = new ArrayList<String>();
        ArrayList<String> adatok5 = new ArrayList<String>();
        ArrayList<Sorozat> sorozatok = new ArrayList<Sorozat>();

        try {
            raf = new RandomAccessFile("lista.txt", "r");
            sor = raf.readLine();


            while (sor != null) {
                adatok1.add(sor);
                sor = raf.readLine();
                adatok2.add(sor);
                sor = raf.readLine();
                adatok3.add(sor);
                sor = raf.readLine();
                adatok4.add(sor);
                sor = raf.readLine();
                adatok5.add(sor);
                sor = raf.readLine();
            }
        } catch (IOException e) {
            System.out.println("HIBA");
        }

        for (int i = 0; i < adatok1.size(); i++) {
            Sorozat ujSorozat = new Sorozat(adatok1.get(i), adatok2.get(i), adatok3.get(i),
                    Integer.parseInt(adatok4.get(i)), Integer.parseInt(adatok5.get(i)));
            sorozatok.add(ujSorozat);
        }

        //2
        int vanDatum = 0;
        for (Sorozat egySorozat : sorozatok) {
            if (!egySorozat.getDate().equals("NI")) {
                vanDatum++;
            }
        }
        System.out.println("2. feladat:\n" + vanDatum + "db adasnak van ismert adasbe kerulesi datuma.\n");

        //3
        int lattaMar = 0;
        for (Sorozat egySorozat : sorozatok) {
            if (egySorozat.getLattaE() == 1) {
                lattaMar++;
            }
        }
        System.out.println("3. feladat:\n" + (double) (lattaMar * 100) / sorozatok.size() +
                "%at latta mar a listat rogzito szemely.\n");

        //4
        int osszesPerc = 0;
        for (Sorozat egySorozat : sorozatok) {
            if (egySorozat.getLattaE() == 1) {
                osszesPerc += egySorozat.getHossz();
            }
        }
        int nap = 0;
        int ora = 0;
        while (osszesPerc / 1440 >= 1) {
            nap++;
            osszesPerc -= 1440;
        }
        while (osszesPerc / 60 >= 1) {
            ora++;
            osszesPerc -= 60;
        }

        System.out.println("4.feladat:\nSorozatnezessel " + nap + " napot " +
                ora + " orat es " + osszesPerc + "percet toltott.\n");

        //5 (teljesen rossz)
        System.out.println("2001.01.01".split("").length);
        System.out.print("Adjon meg egy datumot! (eeee.hh.nn) Datum= ");
        String userDatum = scan.next();
        int userDatumValue = Integer.parseInt(userDatum.split("")[0] + userDatum.split("")[1] +
                userDatum.split("")[2] + userDatum.split("")[3]) * 365 +
                Integer.parseInt(userDatum.split("")[5] + userDatum.split("")[6]) * 30 +
                Integer.parseInt(userDatum.split("")[8] + userDatum.split("")[9]);

        System.out.println(userDatumValue);
        ArrayList<Sorozat> dateSorozat = new ArrayList<Sorozat>();
        for (Sorozat egySorozat : sorozatok) {
            if (!egySorozat.getDate().equals("NI")) {
                int napok = Integer.parseInt(egySorozat.getDate().split("")[0] +
                        egySorozat.getDate().split("")[1] +
                        egySorozat.getDate().split("")[2] +
                        egySorozat.getDate().split("")[3]) * 365 +
                        Integer.parseInt(egySorozat.getDate().split("")[5] +
                                egySorozat.getDate().split("")[6]) * 30 +
                        Integer.parseInt(egySorozat.getDate().split("")[8] +
                                egySorozat.getDate().split("")[9]);
                if (egySorozat.getLattaE() == 0 && napok >= userDatumValue) {
                    dateSorozat.add(egySorozat);
                }
            }
        }
        for (Sorozat egySorozat : dateSorozat) {
            System.out.println(egySorozat.getResz() + "    " + egySorozat.getCim());
        }

        //5.1 (valami ilyesmi)
        ArrayList<Sorozat> userStuff = new ArrayList<>();
        for (Sorozat egySorozat : sorozatok) {
            if (!egySorozat.getDate().equals("NI") && egySorozat.getLattaE() == 0) {
                int eSEv = Integer.parseInt(egySorozat.getDate().split("\\.")[0]);
                int eSHonap = Integer.parseInt(egySorozat.getDate().split("\\.")[1]);
                int eSNap = Integer.parseInt(egySorozat.getDate().split("\\.")[2]);

                int userEv = Integer.parseInt(userDatum.split("\\.")[0]);
                int userHonap = Integer.parseInt(userDatum.split("\\.")[1]);
                int userNap = Integer.parseInt(userDatum.split("\\.")[2]);

                if (userEv == eSEv && userHonap >= eSHonap && userNap >= eSNap) {
                    userStuff.add(egySorozat);
                } else if (userEv > eSEv) {
                    userStuff.add(egySorozat);
                }
            }

        }
        for (Sorozat egySorozat : userStuff) {
            System.out.println(egySorozat.getResz() + "    " + egySorozat.getCim());
        }


    }
}