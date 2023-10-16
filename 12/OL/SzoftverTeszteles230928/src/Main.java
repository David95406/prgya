public class Main {

    //import java.util.Random; ??????

    public static void main(String[] args) {
        Pont p1 = new Pont(2, 5); //ezzel tesztelve van a konstruktor
        System.out.println(p1);
        System.out.println("p1 pont: " + p1.getKoordinatak());
        //ezzel minden tesztelve van

        final int N = 20;
        double osszeg = 0;
        int x0 = (int) (Math.random() * 100);
        int y0 = (int) (Math.random() * 100);
        Pont p = new Pont(x0, y0);
        Pont max = p;

        for (int i = 0; i < (N-1); i++) {
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            p = new Pont(x, y);

            if (i == 0) {
                max = p;
            } else if(max.getTavolsag() < p.getTavolsag()) {
                max = p;
            }
            osszeg += p.getTavolsag();
            System.out.println(p);

        }
        System.out.println("Pontok atlagos tavolsaga az origotol: " + osszeg / N);
        System.out.println("A legmesszebb levo pont: " + max.getTavolsag());
    }
}