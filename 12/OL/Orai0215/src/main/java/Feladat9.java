public class Feladat9 {
    public static int[] func(int[] a, int[] b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Both arrays must be non-null");
        int c[] = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
