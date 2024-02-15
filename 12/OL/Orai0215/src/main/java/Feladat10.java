public class Feladat10 {
    private int n;
    private int l;

    public Feladat10(int n) {
        this.n = n;
        stringFunc();
    }

    public void stringFunc(){
        l = String.valueOf(n).length();
    }

    public void logFunc(){
        l = (int) (Math.log10(n) + 1);
    }

    public void repeatedFunc(){
        long temp = 1;
        while (temp <= n) {
            l++;
            temp *= 10;
        }
    }

    public int getN() {
        return n;
    }

    public int getL() {
        return l;
    }

    @Override
    public String toString() {
        return "Feladat10{" +
                "n=" + getN() +
                ", l=" + getL() +
                '}';
    }
}
