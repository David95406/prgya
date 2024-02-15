public class Feladat7 {
    private int n;

    public Feladat7(int n) {
        this.n = n;
    }

    public boolean func() {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
