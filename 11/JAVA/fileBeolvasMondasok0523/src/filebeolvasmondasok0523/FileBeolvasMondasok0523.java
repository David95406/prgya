package filebeolvasmondasok0523;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileBeolvasMondasok0523 {

    public static int[] elsoFeladat(ArrayList<String> userInput) {
        //Hányadik elem a leghosszabb, és mennyi karakter?
        int indexOfLongestElement = 0;
        int i = 0;
        int lengthOfLongestElement = 0;

        for (String mondas : userInput) {
            if (mondas.length() > lengthOfLongestElement) {
                lengthOfLongestElement = mondas.length();
                indexOfLongestElement = i;
            }
            i++;
        }
        int[] returnValue = {indexOfLongestElement, lengthOfLongestElement};

        return returnValue;
    }

    public static boolean masodikFeladat(ArrayList<String> userInput) {
        //Van-e olyan elem, amiben nincs 'a' betű!
        int i = 0;
        while (!userInput.get(i).contains("a") && i < (userInput.size() - 1)) {
            i++;
        }

        if ((userInput.size() - 1) == i) {
            return false;
        } else {
            return true;
        }
    }

    public static int harmadikFeladat(String mondas) {
        //Írj egy metódust, ami a paraméterként kapott szövegben megszámolja az 'e' betűket"
        int eDb = 0;

        for (String betu : mondas.split("")) {
            if ("e".equals(betu)) {
                eDb++;
            }
        }

        return eDb;
    }

    public static int negyedikFeladat(ArrayList<String> userInput) {
        int eDb = 0;

        for (String mondas : userInput) {
            eDb += harmadikFeladat(mondas);
        }

        return eDb;
    }

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        ArrayList<String> mondasok = new ArrayList<>();

        try {
            raf = new RandomAccessFile("mondasok.txt", "r");
            int db = 0;
            sor = raf.readLine();

            while (sor != null) {
                mondasok.add(sor.strip());
                db++;
                sor = raf.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("A " + (elsoFeladat(mondasok)[0] + 1) + ". elem a leghosszabb és " + elsoFeladat(mondasok)[1] + " karakter hosszú.");
        System.out.println(masodikFeladat(mondasok));
        System.out.println(harmadikFeladat(mondasok.get(0)));
        System.out.println(negyedikFeladat(mondasok));
    }

}
