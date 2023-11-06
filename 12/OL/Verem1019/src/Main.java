public class Main {

    public static void main(String[] args) {
        Verem v = new Verem(5);
        v.add(1);
        System.out.println(v.getK());
        System.out.println(v);
        v.clear();

        System.out.println("\n\n\n");
        for (int i = 1; i <= 6; i++) {
            if (!v.add(i)) {
                System.out.println("Megtelt a verem!");
            }
        }
        System.out.println(v);
        System.out.println("A verem tartalmazza a 2-t? " + (v.isContains(2) ? "Igen" : "Nem"));
        for (int i = 1; i <= 6; i++) {
            if (!v.remove()) {
                System.out.println("A verem üres!");
            }
        }

        System.out.println(v.getI(0));
}
}