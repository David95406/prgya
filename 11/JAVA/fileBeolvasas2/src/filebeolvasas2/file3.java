package filebeolvasas2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class file3 {

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
        RandomAccessFile raf;
        String sorMatrix;

        int matrixLen = 0;
        int[][] szamokMatrix = new int[matrixLen][matrixLen];

        try {
            raf = new RandomAccessFile("adat3.txt", "r");
            int db = 0;
            sorMatrix = raf.readLine();

            while (sorMatrix != null) {
                matrixLen++;
                sorMatrix = raf.readLine();
            }
            szamokMatrix = new int[matrixLen][matrixLen];

            raf.seek(0);

            sorMatrix = raf.readLine();

            int[] sor;

            while (sorMatrix != null) {
                sor = new int[matrixLen];
                for (int i = 0; i < sorMatrix.split(" ").length; i++) {
                    sor[i] = Integer.parseInt(sorMatrix.split(" ")[i]);
                }
                szamokMatrix[db] = sor;
                db++;
                sorMatrix = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        writeMatrix(szamokMatrix);
    }
}
