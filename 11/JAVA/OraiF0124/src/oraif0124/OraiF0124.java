package oraif0124;

import java.util.ArrayList;
import java.util.Random;

public class OraiF0124 {

    public static void main(String[] args) {
        int i, j;
        Random rand = new Random();
        ArrayList<ArrayList<Integer>> szamok = new ArrayList<>();

        for (i = 0; i < 5; i++) {
            ArrayList<Integer> szList = new ArrayList<>();
            for (j = 0; j < 5; j++) {
                szList.add(rand.nextInt(10));
            }
            szamok.add(szList);
        }

        System.out.println();

        //2D tömb (mátrix) inicializalasa
        int[][] tombSzamok = {{2, 9, 7}, {1, 0, 3}};

        //2D tömb bejárása
        for (i = 0; i < tombSzamok.length; i++) {
            for (j = 0; j < tombSzamok[i].length; j++) {
                System.out.print(tombSzamok[i][j] + " ");
            }
            System.out.println();
        }

        //csak az elso sor
        for (j = 0; j < tombSzamok[0].length; j++) {
            System.out.print(tombSzamok[0][j] + " ");
        }
        System.out.println();

        System.out.println("");
        for (i = 0; i < tombSzamok.length; i++) {
            System.out.println(tombSzamok[i][1]);
        }

        //tomb elemeinek osszege
        int osszeg = 0;
        for (i = 0; i < tombSzamok.length; i++) {
            for (j = 0; j < tombSzamok[i].length; j++) {
                osszeg += tombSzamok[i][j];
            }
        }
        System.out.println("A 2D lista elemeinek összege: " + osszeg);

        //A sorok osszege
        int sorOsszeg;

        for (i = 0; i < tombSzamok.length; i++) {
            sorOsszeg = 0;
            for (j = 0; j < tombSzamok[i].length; j++) {
                sorOsszeg = sorOsszeg + tombSzamok[i][j];
            }
            System.out.println("A(z) " + (i + 1) + ". sor elemeinek osszege: " + sorOsszeg);
        }

        //paros szamok a tomb
        int parosDb = 0;

        for (i = 0; i < tombSzamok.length; i++) {
            for (j = 0; j < tombSzamok[i].length; j++) {
                if (tombSzamok[i][j] % 2 == 0) {
                    parosDb++;
                }
            }
        }
        System.out.println(parosDb + " darab paros szam van.");

        //paros szam soronkent
        int parosDbSor;
        for (i = 0; i < tombSzamok.length; i++) {
            parosDbSor = 0;
            for (j = 0; j < tombSzamok[i].length; j++) {
                if (tombSzamok[i][j] % 2 == 0) {
                    parosDbSor++;
                }
            }
            System.out.println("A(z) " + (i + 1) + ". sorban " + parosDbSor + " darab paros szam van.");
        }

        //oszloposan bejaras
        int oszlopokSzama = tombSzamok[0].length;
        int sorokSzama = tombSzamok.length;
        
        for (j = 0; j < oszlopokSzama; j++) {
            for (i = 0; i < sorokSzama; i++) {
                System.out.print(tombSzamok[i][j] + " ");
            }
        }
        System.out.println();
        
        //oszlopok osszege
        for (j = 0; j < oszlopokSzama; j++) {
            int oszlopOsszeg = 0;
            for (i = 0; i < sorokSzama; i++) {
                oszlopOsszeg += tombSzamok[i][j];
            }
            System.out.println("A(z)" + (j + 1) + ". oszlop elemeinek osszege: " + oszlopOsszeg);
        }
        
        //3sor 5oszlop random
        int[][] randomTomb = new int[3][5];
        
        for (i = 0; i < randomTomb.length; i++) {
            for (j = 0; j < randomTomb[i].length; j++) {
                randomTomb[i][j] = rand.nextInt(10) + 1;
            }
        }
        
        for (i = 0; i < randomTomb.length; i++) {
            for (j = 0; j < randomTomb[i].length; j++) {
                System.out.print(randomTomb[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}
