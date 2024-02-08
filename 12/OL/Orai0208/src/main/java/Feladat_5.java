public class Feladat_5 {
    private char[][] array;

    public Feladat_5(char[][] array) {
        this.array = array;
    }

    public int[] finder(char c) {
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == c) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
