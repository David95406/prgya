public class Feladat_4 {
    private String word1;
    private String word2;

    public Feladat_4(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public String alternatearray() {
        char[] result = new char[word1.length() + word2.length()];
        int index = 0;
        int length;
        if (word1.length() >= word2.length()) {
            length = word1.length();
        } else {
            length = word2.length();
        }
        for (int i = 0; i < length; i++) {
            if (i < word1.length()) {
                result[index] = word1.charAt(i);
                index++;
            }
            if (i < word2.length()) {
                result[index] = word2.charAt(i);
                index++;
            }
        }
        return new String(result);
    }

    public String alternatewithoutarray() {
        String result = "";
        int length;
        if (word1.length() >= word2.length()) {
            length = word1.length();
        } else {
            length = word2.length();
        }
        for (int i = 0; i < length; i++) {
            if (i < word1.length()) {
                result += word1.charAt(i);
            }
            if (i < word2.length()) {
                result += word2.charAt(i);
            }
        }
        return result;
    }
}