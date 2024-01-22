import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int napokszama(int e1, int h1, int n1, int e2, int h2, int n2) {
        h1 = (h1 + 9) % 12;
        e1 = e1 - h1 / 10;
        double d1 = 365 * e1 + e1 / 4 - e1 / 100 + e1 / 400 + (h1 * 365 + 5) / 10 + n1 - 1;
        System.out.println(h1);
        return 0;
    }

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        ArrayList<Utas> utasok = new ArrayList<>();

        //1
        try {
            raf = new RandomAccessFile("utasadat.txt", "r");
            sor = raf.readLine();

            while (sor != null) {
                Utas ujUtas = new Utas(sor.split(" "));
                utasok.add(ujUtas);
                sor = raf.readLine();
            }
        } catch (IOException e) {
            System.out.println("Hiba");
        }

        System.out.println(utasok);

        //2
        System.out.println("2. feladat");
        System.out.println("A buszra " + utasok.size() + " utas akart felszallni.");

        //3
        System.out.println("3. feladat");
        int ervenytelen = 0;
        for (Utas utas : utasok) {
            if (!utas.isErvenyes()) {
                ervenytelen++;
            }
        }
        System.out.println("A buszra " + ervenytelen + " utas nem szallhatott fel");

        //4
        ArrayList<Integer> megallok = new ArrayList<>();
        for (Utas utas : utasok) {
            if (!megallok.contains(utas.getMegalloId())) {
                megallok.add(utas.getMegalloId());
            }
        }
        System.out.println(megallok);
        int[] megalloGyakorisag = new int[megallok.size()];
        int n = 0;
        for (int i = 0; i < utasok.size(); i++) {
            while (megallok.get(n) == utasok.get(i).getMegalloId()) {
                i++;
                //System.out.println(Arrays.toString(megalloGyakorisag));
                megalloGyakorisag[n]++;
                if (i == utasok.size()) {
                    megalloGyakorisag[n]++;
                    break;
                }
            }
            n++;
        }
        for (int i : megalloGyakorisag) {
            System.out.print(i + " ");
        }
        System.out.println(Arrays.stream(megalloGyakorisag).max());

        //5
        System.out.println("5. feladat");
        ArrayList<Utas> ervenyesUtasok = new ArrayList<>();
        for (Utas utas : utasok) {
            if (utas.isErvenyes()) {
                ervenyesUtasok.add(utas);
            }
        }
        int ingyenes = 0;
        int kedvezmenyes = 0;
        for (Utas utas : ervenyesUtasok) {
            switch (utas.getKartyaTipusa()) {
                case ("TAB"):
                    kedvezmenyes++;
                    break;
                case ("NYB"):
                    kedvezmenyes++;
                    break;
                case ("NYP"):
                    ingyenes++;
                    break;
                case ("RVS"):
                    ingyenes++;
                    break;
                case ("GYK"):
                    ingyenes++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Ingyenesen utazok szama: " + ingyenes + " fo");
        System.out.println("Kedvezmenyesen utazok szama: " + kedvezmenyes + " fo");

        //6
        System.out.println(napokszama(2020, 1, 1, 2021, 1, 1));
    }
}