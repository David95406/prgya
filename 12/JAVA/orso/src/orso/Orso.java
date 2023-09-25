package orso;

public class Orso {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2.5, 4.8);
        System.out.println(r);
        System.out.println("Kerulete: " + r.getKerulet());
        System.out.println("Terulete: " + r.getTerulet());

        Rectangle r2 = new Rectangle();
        System.out.println(r2);
        r2.setA(20);
        r2.setB(20);
        System.out.println(r2);
        System.out.println("Az A oldal: " + r2.getA());
        if (r2.isSquare()) {
            System.out.println("Negyzet");
        } else {
            System.out.println("Teglalap");
        }
        System.out.println(((r2.isSquare()) ? "Negyzet" : "Teglalap"));
    }
    
}
