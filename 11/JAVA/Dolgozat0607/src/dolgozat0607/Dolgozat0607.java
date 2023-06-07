package dolgozat0607;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dolgozat0607 {

    public static boolean elsoFeladat(ArrayList<String> adatok, List<String> megoldas) {
        return megoldas.equals(adatok);
    }

    public static int masodikFeladat(ArrayList<String> adatok, List<String> megoldas) {
        int helyesValasz = 0;

        for (int i = 0; i < adatok.size(); i++) {
            if (adatok.get(i).equals(megoldas.get(i))) {
                helyesValasz++;
            }
        }

        return helyesValasz;
    }

    public static int[] harmadikFeladat(ArrayList<String> adatok, List<String> megoldas) {
        int j = 0;
        int[] rosszValaszok = new int[adatok.size()];

        for (int i = 0; i < adatok.size(); i++) {
            if (!adatok.get(i).equals(megoldas.get(i))) {
                rosszValaszok[j] = i;
                j++;
            }
            i++;
        }

        int[] returnValue = new int[j];
        for (int i = 0; i < returnValue.length; i++) {
            returnValue[i] = rosszValaszok[i];
        }

        return returnValue;
    }

    public static void main(String[] args) {
        List<String> megoldas = Arrays.asList("a", "a", "b", "d", "e", "c");

        RandomAccessFile raf;
        String sor;
        ArrayList<String> valaszok = new ArrayList<>();
        int versenyzoSorszam;

        try {
            raf = new RandomAccessFile("valaszok.txt", "r");
            int db = 0;
            versenyzoSorszam = Integer.parseInt(raf.readLine());
            sor = raf.readLine();

            while (sor != null) {
                valaszok.add(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }

        System.out.println("Helyesek a versenyző válaszai? " + elsoFeladat(valaszok, megoldas));
        System.out.println("Hány kérdésre adott helyes választ? " + masodikFeladat(valaszok, megoldas));
        int[] rosszValaszok = harmadikFeladat(valaszok, megoldas);
        for (int rosszValasz : rosszValaszok) {
            System.out.println(rosszValasz + ". választ elrontotta a versenyző.");
        }
    }

}
