public class Feladat8 {
    private String str;
    private int n;

    public Feladat8(String str) {
        this.str = str;
    }

    public Feladat8(int n) {
        this.n = n;
    }

    public int func() {
        if(str!=null) {
            int answer = 0, factor = 1;
            for (int i = str.length() - 1; i >= 0; i--) {
                answer += (str.charAt(i) - '0') * factor;
                factor *= 10;
            }
            return answer;
        }
        return n;
    }

    public String func2() {
        if(str!=null){
            return str;
        }
        return new String("" + n);
    }

}