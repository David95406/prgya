public class EtelTest {
    public static void main(String[] args) {
        Etel e = new Etel("kaja", -100);
        System.out.println(e);

        Pizza p = new Pizza("sajtos", 1000, -100);
        System.out.println(p);
        p.feltetetFelvesz(new Etel("sajtos feltet", 300));
        p.feltetetFelvesz(new Etel("cukros feltet", 300));
        System.out.println(p);
        Pizza ures = new Pizza("kiflis", 1000, 400);
        System.out.println(ures);
    }
}