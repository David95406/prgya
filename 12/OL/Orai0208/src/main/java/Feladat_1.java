public class Feladat_1 {
    private String word;

    public Feladat_1(String word) {
        this.word = word;
    }

    public String exchange(char c) {
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                array[i] = '?';
            }
        }
        return new String(array);
    }
}