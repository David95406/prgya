package oraif0131;

import java.util.Random;

public class OraiF0131 {

    /*
    public static int[][] matrixFillR() {
        int[][] rMatrix = new int[4][5];
        int i, j;
        Random rand = new Random();

        for (i = 0; i < rMatrix.length; i++) {
            for (j = 0; j < rMatrix[i].length; j++) {
                rMatrix[i][j] = rand.nextInt(10);
            }
        }

        return rMatrix;
    }
    */

    public static void randomMatrix(int[][] matrixTomb) {
        Random rand = new Random();
        int i, j;
        
        for (i = 0; i < matrixTomb.length; i++) {
            for (j = 0; j < matrixTomb[i].length; j++) {
                matrixTomb[i][j] = rand.nextInt(10) + 1;
            }
        }
        
    }

    public static void revTomb(int[][] tomb) {
        int i, j;

        for (i = tomb.length - 1; i >= 0; i--) {
            for (j = tomb[i].length - 1; j >= 0; j--) {
                System.out.print(tomb[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int tombOsszeg(int[][] tomb) {
        int i, j, osszeg = 0;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                osszeg += tomb[i][j];
            }
        }

        return osszeg;
    }

    public static boolean parosMatrix(int[][] tomb) {
        int i, j, parosDb = 0;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                if (tomb[i][j] % 2 == 0) {
                    parosDb++;
                }
            }
        }

        return parosDb > ((tomb.length * tomb[0].length) / 2);
    }

    public static void doubleMatrix(int[][] tomb) {
        int i, j;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                tomb[i][j] *= 2;
            }
        }
    }

    public static void writeMatrix(int[][] tomb) {
        int i, j;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                System.out.print(tomb[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] rMatrix = new int[4][5];
        randomMatrix(rMatrix);
        
        System.out.println("alap tomb");
        writeMatrix(rMatrix);

        //tomb forditasa
        System.out.println("\nrev");
        revTomb(rMatrix);
        System.out.println();

        //osszeg + tobb paros mint paratlan
        System.out.println("A tomb elemeinek osszege: " + tombOsszeg(rMatrix));
        System.out.println("A tomb elemeinek tobb mint a fele paros? " + parosMatrix(rMatrix));

        //tomb duplazas
        System.out.println("\nTomb elemeinek duplazasa");
        doubleMatrix(rMatrix);
        writeMatrix(rMatrix);

    }

}
