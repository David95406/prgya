import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }


    public static double getFajSzintAtlag(String targetName, ArrayList<Karakter> karakterek) {
        double eredmeny = 0;
        int hossz = 0;
        for (Karakter karakter : karakterek) {
            if (karakter.getFajNev().equals(targetName)) {
                eredmeny += karakter.getSzint();
                hossz++;
            }
        }

        return eredmeny / hossz;
    }

    public static void main(String[] args) {
        ArrayList<Karakter> karakterek = new ArrayList<>();

        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("karakterek.csv", "r");
            raf.readLine();

            String line = raf.readLine();
            while (line != null) {
                String[] adatok = line.strip().split(";");
                karakterek.add(new Karakter(adatok));

                line = raf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Hiba tortent a file beolvasasa soran!");
        }

        System.out.println("4. feladat");
        double elfAtlag = getFajSzintAtlag("elf", karakterek);
        DecimalFormat df = new DecimalFormat("#.000");

        System.out.println("Az elfek szintátlaga: " + df.format(elfAtlag));

        System.out.println("5. feladat");
        ArrayList<String> fajok = new ArrayList<>();

        for (Karakter karakter : karakterek) {
            if (!fajok.contains(karakter.getFajNev())) {
                fajok.add(karakter.getFajNev());
            }
        }

        int[] darabok = new int[fajok.size()];
        for (Karakter karakter : karakterek) {
            darabok[fajok.indexOf(karakter.getFajNev())]++;
        }

        int fajIndex = indexOfIntArray(darabok, Arrays.stream(darabok).max().getAsInt());
        System.out.println("A leggyakoribb faj: " + fajok.get(fajIndex));

        String searchValue = "okos";
        ArrayList<String> okosKarakterek = new ArrayList<>();

        for (Karakter karakter : karakterek) {
            if (karakter.getLeiras().contains(searchValue)) {
                okosKarakterek.add(karakter.getNev() + " ");
            }
        }

        System.out.println("6. feladat");
        System.out.print("Okos karakterek: ");
        for (String karakter : okosKarakterek) {
            System.out.print(karakter);
        }
    }
}