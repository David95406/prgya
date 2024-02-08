public class Feladat_2 {
    private String[] words;

    public Feladat_2(String[] words) {
        this.words = words;
    }

    public int counter() {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
        }
        return count;
    }
}
