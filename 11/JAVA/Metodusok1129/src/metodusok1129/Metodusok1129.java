package metodusok1129;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Metodusok1129 {

    public static boolean szamJParos(int szam) {
        int i = 0, ell = 0;

        for (i = 0; i < String.valueOf(szam).length(); i++) {
            if (Integer.valueOf(String.valueOf(szam).charAt(i)) % 2 == 0) {
                ell++;
            }
        }
        if (String.valueOf(szam).length() == ell) {
            return true;
        }
        return false;

    }

    public static boolean kozeppont(int a, int b, int c) {
        ArrayList<Integer> szamok = new ArrayList<Integer>();
        szamok.add(a);
        szamok.add(b);
        szamok.add(c);
        Collections.sort(szamok);

        return ((szamok.get(2) - szamok.get(1)) == (szamok.get(1)- szamok.get(0)));
    }

    public static void matrix(int n) {
        Random rand = new Random();
        String matrixCode = "";
        int a, i;

        for (i = 0; i < n; i++) {
            for (a = 0; a < 5; a++) {
                if (rand.nextInt(2) == 1) {
                    matrixCode = matrixCode + "0    ";
                } else {
                    matrixCode = matrixCode + "1    ";
                }
            }
            System.out.println(matrixCode);
            matrixCode = "";

        }
    }

    public static void main(String[] args) {
        System.out.println(szamJParos(22));
        System.out.println(kozeppont(2, 7, 12));
        matrix(5);
    }

}
