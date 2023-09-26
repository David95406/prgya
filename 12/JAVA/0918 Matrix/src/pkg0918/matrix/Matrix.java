package pkg0918.matrix;

import java.util.Scanner;

public class Matrix {
    
    public static void writeMatrix(int[][] tomb) {
        int i, j;

        for (i = 0; i < tomb.length; i++) {
            for (j = 0; j < tomb[i].length; j++) {
                System.out.print(tomb[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] sumMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length && matrix1[0].length != matrix2[0].length) {
            return null;
        }
        int[][] returnMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                returnMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return returnMatrix;
    }
    
    public static int[][] multMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length && matrix1[0].length != matrix2[0].length) {
            return null;
        }
        int[][] returnMatrix = new int[matrix1.length][matrix1[0].length];
        
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                returnMatrix[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        return returnMatrix;
    }
    
    public static int[][] transMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] returnMatrix = new int[matrix1[0].length][matrix1.length];
        return returnMatrix;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Adja meg a matrix sorainak a szamat! ");
        int sorokSzama = scan.nextInt();
        System.out.print("Adja meg a matrix oszlopainak a szamat!");
        int oszlopokSzama = scan.nextInt();
        int[][] matrix1 = new int[sorokSzama][oszlopokSzama];
        int[][] matrix2 = new int[sorokSzama][oszlopokSzama];
        
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                System.out.print("matrix1[" + i + "][" + j + "]");
                matrix1[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print("matrix2[" + i + "][" + j + "]");
                matrix2[i][j] = scan.nextInt();
            }
        }
        
        writeMatrix(matrix1);
        writeMatrix(matrix2);
        writeMatrix(sumMatrix(matrix1, matrix2));
    }
    
}
