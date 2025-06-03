import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static double getSzintAtlag(String targetName, ArrayList<Karakter> karakterek) {
        double osszeg = 0;
        int hossz = 0;

        for (Karakter karakter : karakterek) {
            if (karakter.getFaj().equals(targetName)) {
                hossz++;
                osszeg += karakter.getSzint();
            }
        }

        return osszeg / hossz;
    }

    public static void main(String[] args) {
        ArrayList<Karakter> karakterek = new ArrayList<>();

        try {
            FileReader fr = new FileReader("karakterek.csv");
            BufferedReader bf = new BufferedReader(fr);

            String sor = bf.readLine();

            while ((sor = bf.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(sor, ";");

                Karakter k = new Karakter(
                        stringTokenizer.nextToken(),
                        stringTokenizer.nextToken(),
                        stringTokenizer.nextToken(),
                        Integer.parseInt(stringTokenizer.nextToken())
                );

                karakterek.add(k);
            }

            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("4. feladat");

        double szintAtlag = getSzintAtlag("elf", karakterek);
        System.out.printf("Az elfek szintátlaga: %3.2f\n", szintAtlag);

        System.out.println("6. feladat");
        System.out.print("Okos karakterek: ");
        String okoskak = "";
        for (Karakter karakter : karakterek) {
            if (karakter.getLeiras().contains("okos")) {
                okoskak += okoskak;
            }
        }
        System.out.print(okoskak);

        System.out.println("7. feladat");
        /*
        HashMap<String, Integer> stat = new HashMap<>();

        for (Karakter karakter : karakterek) {
            if (stat.containsKey(karakter.getFaj())) {
                Integer target = stat.get(karakter.getFaj() + 1);
                stat.put(karakter.getFaj(), target);
            } else {
                stat.put(karakter.getFaj(), 1);
            }
        }

        Set<String> kulcsok = stat.keySet();
        Iterator<String> it = kulcsok.iterator();

        int max = 0;
        String maxFajNev = "";
        while (it.hasNext()) {
            String faj = it.next();
            int db = stat.get(faj);

            if (db > max) {
                max = db;
                maxFajNev = faj;
            }
        }
        System.out.println("A leggyakoribb faj: " + maxFajNev);
         */
        //5. feladat
        System.out.println("5. feladat:");
        HashMap<String, Integer> gyakoriFaj = new HashMap<>();
        for (Karakter karakter : karakterek) {
            if (gyakoriFaj.containsKey(karakter.getFaj())) {
                gyakoriFaj.put(karakter.getFaj(), gyakoriFaj.get(karakter.getFaj()) + 1);
            } else {
                gyakoriFaj.put(karakter.getFaj(), 1);
            }
        }
        Set<String> kulcsok = gyakoriFaj.keySet();
        Iterator<String> it = kulcsok.iterator();
        int max = 0;
        String fajMax = "";
        while (it.hasNext()) {
            String faj = it.next();
            int db = gyakoriFaj.get(faj);
            if (db > max) {
                max = db;
                fajMax = faj;
            }
        }

        System.out.println("A leggyakoribb faj: " + fajMax);

        // nem hashMap megoldas
        ArrayList<String> fajok = new ArrayList<>();
        ArrayList<Integer> fajokDb = new ArrayList<>();
        for (Karakter karakter : karakterek) {
            if (!fajok.contains(karakter.getFaj())) {
                fajok.add(karakter.getFaj());
                fajokDb.add(0);
            }
        }

        int masikMax = fajokDb.get(0);
        String masikMaxFajNev = fajok.get(0);

        for (int i = 0; i < fajok.size(); i++) {
            for (int j = 0; j<karakterek.size(); j++) {
                break;
            }
        }

    }
}