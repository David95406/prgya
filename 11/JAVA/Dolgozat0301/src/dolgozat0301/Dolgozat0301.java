package dolgozat0301;

public class Dolgozat0301 {

    public static void randomMatrix(int[][] matrixTomb) {
        for (int i = 0; i < matrixTomb.length; i++) {
            for (int j = 0; j < matrixTomb[i].length; j++) {
                matrixTomb[i][j] = (int) (Math.random() * 21) + 10;
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

    
    public static void sorMinMaxKulonbseg(int[][] matrixTomb) {
        int min, max;

        for (int i = 0; i < matrixTomb.length; i++) {
            max = matrixTomb[i][0];
            min = matrixTomb[i][0];
            for (int j = 0; j < matrixTomb[i].length; j++) {
                if (max < matrixTomb[i][j]) {
                    max = matrixTomb[i][j];
                }
                if (min > matrixTomb[i][j]) {
                    min = matrixTomb[i][j];
                }
            }
            System.out.println("A(z) " + (i + 1) + ". sorban a különbség a legnagyobb és a legkisebb szám között: " + (max - min));
        }
    }

    public static boolean primeInMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int oszto = 2;

                while (matrix[i][j] % oszto != 0 && oszto < matrix[i][j]) {
                    oszto++;
                }
                if (matrix[i][j] == oszto) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[] primePlaceMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int oszto = 2;

                while (matrix[i][j] % oszto != 0 && oszto < matrix[i][j]) {
                    oszto++;
                }
                if (matrix[i][j] == oszto) {
                    int[] returnVar = {i, j};
                    return returnVar;
                }
            }
        }

        int[] returnVar = {-1, -1};
        return returnVar;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        randomMatrix(matrix);

        writeMatrix(matrix);
        System.out.println();

        //1. feladat
        sorMinMaxKulonbseg(matrix);
        System.out.println();

        //2. feladat
        System.out.println(((primeInMatrix(matrix)) ? "A mátrixban van prímszám." : "A mátrixban nincs prímszám."));
        System.out.println();
        
        //3. feladat
        System.out.println((primePlaceMatrix(matrix)[0] != -1) ? "Az első prímszám a(z) " + (primePlaceMatrix(matrix)[0] + 1) + ".sor " + (primePlaceMatrix(matrix)[1] + 1) + ".eleme." : "A mátrixban nincs prímszám.");
        
    }

}