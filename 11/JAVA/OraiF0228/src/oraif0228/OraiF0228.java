package oraif0228;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class OraiF0228 {

    public static void randomMatrix(int[][] matrixTomb) {
        Random rand = new Random();
        int i, j;

        for (i = 0; i < matrixTomb.length; i++) {
            for (j = 0; j < matrixTomb[i].length; j++) {
                matrixTomb[i][j] = rand.nextInt(5) + 64; //5 64
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

    public static void writeFloatMatrix(float[][] tomb) {
        int i, j;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                System.out.print(tomb[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sorMax(int[][] matrixTomb) {
        int max;

        for (int i = 0; i < matrixTomb.length; i++) {
            max = matrixTomb[i][0];
            for (int j = 0; j < matrixTomb[i].length; j++) {
                if (max < matrixTomb[i][j]) {
                    max = matrixTomb[i][j];
                }
            }
            System.out.println("A(z) " + (i + 1) + ". sor maximuma: " + max);
        }
    }

    public static void oszlopMin(int[][] matrixTomb) {
        int min;

        for (int j = 0; j < matrixTomb[0].length; j++) {
            min = matrixTomb[j][0];
            for (int i = 0; i < matrixTomb.length; i++) {
                if (min > matrixTomb[i][j]) {
                    min = matrixTomb[i][j];
                }
            }
            System.out.println("A(z) " + (j + 1) + ". oszlop minimuma: " + min);
        }
    }

    public static int[][] sumMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] returnMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                returnMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return returnMatrix;
    }

    public static float[][] hanyadosMatrix(int[][] matrix1, int[][] matrix2) {
        float[][] returnMatrix = new float[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                returnMatrix[i][j] = Float.valueOf(matrix1[i][j]) / Float.valueOf(matrix2[i][j]);
                //returnMatrix[i][j] = (float)matrix1[i][j] / (float)matrix2[i][j];
            }
        }
        return returnMatrix;
    }

    public static boolean vaneEgyforma(int[][] matrix) {
        /*
        int i = 0, j = 0;
        
        while (matrix[i][j] != matrix[i][j + 1]) {
            System.out.println(i);
            System.out.println(j);
            if (i == (matrix.length - 1) && (j + 1) == matrix[0].length) {
                return false;
            }
            if ((j + 1) == matrix[0].length) {
                i++;
                j = -1;
            }
            j++;
        }
         */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix[0].length - 1); j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void statisztikaMatrixRegi(int[][] matrix) {
        int[][] adatok = new int[2][4];
        adatok[0][0] = 65;
        adatok[0][1] = 66;
        adatok[0][2] = 67;
        adatok[0][3] = 68;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                switch (matrix[i][j]) {
                    case 65:
                        adatok[1][0]++;
                    case 66:
                        adatok[1][1]++;
                    case 67:
                        adatok[1][2]++;
                    case 68:
                        adatok[1][3]++;
                }
            }
        }
        writeMatrix(adatok);
    }

    public static void statisztikaMatrix(int[][] matrix) {
        int[] stat = new int[256];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int item = matrix[i][j];
                stat[item]++;
            }
        }
        
        for (int k = 0; k < stat.length; k++) {
            System.out.print(stat[k] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        randomMatrix(matrix);
        writeMatrix(matrix);

        System.out.println();
        sorMax(matrix);
        System.out.println();
        oszlopMin(matrix);

        //2. feladat
        int[][] secMatrix = new int[5][5];
        randomMatrix(secMatrix);

        System.out.println();
        writeMatrix(sumMatrix(matrix, secMatrix));
        System.out.println();
        writeFloatMatrix(hanyadosMatrix(matrix, secMatrix));

        System.out.println("\nVan-e egymás mellett 2 egyforma szám? " + vaneEgyforma(matrix));
        statisztikaMatrix(matrix);
    }

}
