
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    /*
    int szam = 1;
    sout((float) szam / 4) => float lesz az erdemeny
     */
    public static void randomMatrix(int[][] matrixTomb) {
        Random rand = new Random();

        for (int i = 0; i < matrixTomb.length; i++) {
            for (int j = 0; j < matrixTomb[i].length; j++) {
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

    public static int[][] sumMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] returnMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                returnMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return returnMatrix;
    }

    public static void main(String[] args) {
        String decide;
        decide = (20 > 10) ? "asd" : "nem";
        System.out.println(decide);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void fileOlv() {
        RandomAccessFile raf;
        String sor;
        ArrayList<String> autok = new ArrayList<>();
        int adatLen = 0;

        try {
            raf = new RandomAccessFile("adat.txt", "r");
            int db = 0;
            adatLen = Integer.parseInt(raf.readLine());
            sor = raf.readLine();

            while (sor != null) {
                autok.add(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
    }

    public static void fileIr() {
        RandomAccessFile raf2;
        String[] adatok = null;

        try {
            raf2 = new RandomAccessFile("autokWrite.txt", "rw");
            for (String adat : adatok) {
                raf2.writeBytes(adat + "\n");
            }
            raf2.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
    }

}
