import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int elso_szabaly(int n) {
        String sz = String.valueOf(n);
        int[] szam = new int[sz.length()];
        for (int i = 0; i < sz.length(); i++) {
            int szamjegy = Integer.parseInt(String.valueOf(sz.charAt(i)));
            if (szamjegy - 1 < 0) {
                szam[i] = 9;
            } else {
                szam[i] = szamjegy - 1;
            }
        }

        StringBuilder eredmeny = new StringBuilder();
        for (int i : szam) {
            eredmeny.append(i);
        }
        return Integer.parseInt(eredmeny.toString());
    }

    public static int masodik_szabaly(int n) {
        String sz = String.valueOf(n);

        char legkisebbJegy = '9';
        int legkisebbPozicio = -1;

        for (int i = 0; i < sz.length(); i++) {
            char jelenlegiJegy = sz.charAt(i);
            if (jelenlegiJegy < legkisebbJegy) {
                legkisebbJegy = jelenlegiJegy;
                legkisebbPozicio = i;
            }
        }

        int eredmeny = n / 2;
        StringBuilder felezettStr = new StringBuilder(String.valueOf(eredmeny));

        if (legkisebbPozicio < felezettStr.length()) {
            int aktualisJegy = felezettStr.charAt(legkisebbPozicio) - '0';
            int modositottJegy = aktualisJegy + 5;
            felezettStr.setCharAt(legkisebbPozicio, (char) ('0' + modositottJegy % 10));
        }

        return Integer.parseInt(felezettStr.toString());
    }

    public static int harmadik_szabaly(int n) {
        String sz = String.valueOf(n);
        ArrayList<Integer> szam = new ArrayList<>();

        for (String s : sz.split("")) {
            szam.add(Integer.parseInt(s));
        }
        Collections.reverse(szam);

        StringBuilder eredmeny = new StringBuilder();
        for (int i : szam) {
            eredmeny.append(i);
        }
        return Integer.parseInt(eredmeny.toString());
    }

    public static int negyedik_szabaly(int n) {
        String sz = String.valueOf(n);
        int[] szam = new int[sz.length()];
        for (int i = 0; i < sz.length(); i++) {
            int szamjegy = Integer.parseInt(String.valueOf(sz.charAt(i)));

            if (szamjegy % 2 == 0) {
                szam[i] = szamjegy + 1;
            } else {
                szam[i] = szamjegy - 1;
            }

            if (szam[i] >= 10) {
                szam[i] = 0;
            }

            if (szam[i] <= -1) {
                szam[i] = 9;
            }
        }

        StringBuilder eredmeny = new StringBuilder();
        for (int i : szam) {
            eredmeny.append(i);
        }
        return Integer.parseInt(eredmeny.toString());
    }

    public static int otodik_szabaly(int n) { // 3456 -> 6345
        String sz = String.valueOf(n);
        int[] szam = new int[sz.length()];
        szam[0] = Integer.parseInt(String.valueOf(sz.charAt(sz.length() - 1)));
        for (int i = 1; i < sz.length(); i++) {
            int szamjegy = Integer.parseInt(String.valueOf(sz.charAt(i - 1)));
            szam[i] = szamjegy;
        }

        StringBuilder eredmeny = new StringBuilder();

        for (int i : szam) {
            eredmeny.append(i);
        }
        return Integer.parseInt(eredmeny.toString());
    }

    public static int hatodik_szabaly(int n) { //3679 -> 3312
        String sz = String.valueOf(n);
        int[] szam = new int[sz.length()];
        for (int i = 0; i < sz.length(); i++) {
            int szamjegy = Integer.parseInt(String.valueOf(sz.charAt(i)));
            szam[i] = szamjegy;
        }

        for (int i = 0; i < szam.length; i++) {
            int j = 0;
            while (i != j) {
                szam[i] -= szam[j];
                j++;
            }

            if (szam[i] < 0) {
                szam[i] += 10;
            }

            if (szam[i] > 9) {
                szam[i] -= 10;
            }
        }

        StringBuilder eredmeny = new StringBuilder();
        for (int i : szam) {
            eredmeny.append(i);
        }
        return Integer.parseInt(eredmeny.toString());
    }

    public static void main(String[] args) {
        System.out.println("1: " + elso_szabaly(2301));
        System.out.println("2: " + masodik_szabaly(4680));
        System.out.println("3: " + harmadik_szabaly(1234));
        System.out.println("4: " + negyedik_szabaly(2174));
        System.out.println("5: " + otodik_szabaly(3456));
        System.out.println("6: " + hatodik_szabaly(1360));
    }

    
}