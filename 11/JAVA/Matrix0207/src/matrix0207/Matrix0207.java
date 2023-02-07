package matrix0207;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix0207 {

    public static void randomMatrix(int[][] matrixTomb) {
        Random rand = new Random();
        int i, j;

        for (i = 0; i < matrixTomb.length; i++) {
            for (j = 0; j < matrixTomb[i].length; j++) {
                matrixTomb[i][j] = rand.nextInt(10) + 1;
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

    public static int foatloOsszeg(int[][] tomb) {
        int osszeg = 0;

        for (int i = 0; i < tomb.length; i++) {
            osszeg += tomb[i][i];
        }

        return osszeg;
    }

    public static void elemCsereRegi(int[][] tomb, int x, int y, int value) {
        tomb[x - 1][y - 1] = value;
    }
    
    public static void elemCsere(int[][] tomb, int x1, int y1, int x2, int y2) {
        int saveValue = tomb[x1][y1];
        
        tomb[x1][y1] = tomb[x2][y2];
        tomb[x2][y2] = saveValue;
    }
    
    public static boolean egyenloMatrixRegi(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) return false;
        
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) return false;
            }
        }
        
        return true;
    }
    
    public static boolean egyenloMatrix(int[][] matrix1, int[][] matrix2) {
        return Arrays.equals(matrix1, matrix2);
    }
    
    public static int[][] revMatrix(int[][] matrix) {
        int[][] returnMatrix = new int[matrix.length][matrix.length];
        int i2 = -1, j2 = -1;
        
        for (int i = matrix.length - 1; i >= 0; i--) {
            i2++;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                j2++;
                //System.out.print(matrix[i][j] + " ");
                returnMatrix[i2][j2] = matrix[i][j];
            }
            j2 = - 1;
        }
        
        return returnMatrix;
    }
    
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);

        int[][] matrix = new int[5][5];
        randomMatrix(matrix);

        writeMatrix(matrix);

        //főátló összeg
        System.out.println(foatloOsszeg(matrix));
        
        //felcseréli a mátrix 2 elemét
        System.out.print("sor: ");
        int sor1 = bill.nextInt();
        System.out.print("oszlop: ");
        int oszlop1 = bill.nextInt();
        System.out.print("sor: ");
        int sor2 = bill.nextInt();
        System.out.print("oszlop: ");
        int oszlop2 = bill.nextInt();
        System.out.println();
        elemCsere(matrix, sor1, oszlop1, sor2, oszlop2);
        writeMatrix(matrix);
        System.out.println();
        
        //két matrix egyenlő
        int[][] testMatrix = new int[5][5];
        randomMatrix(testMatrix);
        System.out.println(egyenloMatrix(matrix, matrix));
        System.out.println(egyenloMatrix(matrix, testMatrix));
        
        writeMatrix(revMatrix(matrix));
    }

}
