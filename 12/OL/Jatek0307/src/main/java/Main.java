public class Main {
    public static void main(String[] args) {
        Szoveg sz = new Szoveg("aaaaaaaaaabbbBBBbbbbccccccccccaa");
        System.out.println(sz.atalakit(12));
        System.out.println("\n\n\n\n\n\n----:)----");
        System.out.println(sz.atalakit(40));

        sz.tisztit();
        System.out.println(sz);
    }
}
