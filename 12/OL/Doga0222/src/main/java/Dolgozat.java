

public class Dolgozat {
    public int func1(int b, int p) {
        int result = 1;
        while (p != 0) {
            result = result * b;
            p--;
        }
        return result;
    }

    public boolean func2(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public double[] func3(int a[], int b[]) {
        double c[] = new double[(a.length < b.length) ? a.length : b.length];
        int i = 0;
        while (i < a.length && i < b.length) {
            c[i] = (a[i] + b[i]) / 2;
            i++;
        }
        return c;
    }

    public static double func4(double a[]) {
        double er = 1;
        for (int i = 0; i < a.length; i++) {
            er += Math.pow(a[i], 0.5);
        }
        return er;
    }

    public String func5(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Error!");
        }
        return a + "/" + b + "=" + a / b;
    }
}