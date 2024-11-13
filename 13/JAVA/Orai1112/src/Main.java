import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean isSzolanc(String[] szavak) {
        for (int i = 0;i < (szavak.length - 1); i++) {
            if (szavak[i].charAt(szavak[i].length() - 1) != szavak[i+1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] szavak = new String[]{"atika", "bitcoin", "siwniger", "asztals", "balfab"};
        String[] a = new String[5];
        /*
        System.out.println("Adjon meg 5 szot!");
        for (int i = 0; i < szavak.length; i++) {
            szavak[i] = s.next();
        }
         */

        System.out.println("A lista: \n" + Arrays.toString(szavak));

        if (isSzolanc(szavak)) {
            System.out.println("Ezek a szavak szolancot alkotnak!");
        } else {
            System.out.println("Ezek a szavak nem alkotnak szolancot!");
        }



        //2
        int ossz = 1;
        for (int i = 0; i < szavak.length; i++) {
            ossz *= i + 1;
        }
        System.out.println(ossz);
        String[][] osszesSzavak = new String[ossz][5];

        Random random = new Random();
        int igen = 1000000000;
        int i = 0;
        while (i != igen) {
            System.out.println(i);
            String[] current = new String[]{szavak[random.nextInt(5)], szavak[random.nextInt(5)],
                    szavak[random.nextInt(5)], szavak[random.nextInt(5)]};
            if (isSzolanc(current)) {
                System.out.println("Van szolanc valahogy!");
                System.out.println("Ez: " + Arrays.toString(current));
                break;
            }
            i++;
        }

    }
}