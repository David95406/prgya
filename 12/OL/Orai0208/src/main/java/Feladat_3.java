public class Feladat_3 {
    private String word1;
    private String word2;

    public Feladat_3(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public String copyarray() {
        char[] result = new char[word1.length() + word2.length()];
        int index = 0;
        for (int i = 0; i < word1.length(); i++) {
            result[index] = word1.charAt(i);
            index++;
        }
        for (int i = word2.length() - 1; i >= 0; i--) {
            result[index] = word2.charAt(i);
            index++;
        }
        return new String(result);
    }

    public String copywithoutarray() {
        String result = new String(word1);
        for (int i = word2.length() - 1; i >= 0; i--) {
            result = result + word2.charAt(i);
        }
        return result;
    }
}
