public class Main {
    public static void main(String[] args) {
        Bankszamla b = new Bankszamla(1000);

        System.out.println(b);
        b.befizetes(1000);
        b.befizetes(1000);
        System.out.println(b);
        b.penzfelvetel(1500);
        System.out.println(b);
        b.printSzamlatortenet();
        System.out.println(b.getSzamlatortenet());
        try {
            while (true) {
                b.penzfelvetel(100);
            }
        } catch (Exception e) {
            b.printSzamlatortenet();
            System.out.println(e);
        }
    }
}