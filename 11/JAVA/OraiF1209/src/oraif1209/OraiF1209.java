package oraif1209;

public class OraiF1209 {

    public static double kamatSzamok(int ev, double penzO) {
        int i;

        for (i = 0; i < ev; i++) {
            penzO = penzO + (penzO * 0.1);
        }

        return penzO;
    }

    public static void main(String[] args) {
        int i, ev, penzO;
        ev = 5;
        penzO = 1000;

        for (i = 0; i < ev; i++) {
            System.out.println(kamatSzamok(i + 1, 1000));
        }
        System.out.println(ev + " ev alatt " + Math.round(penzO / (kamatSzamok(ev, penzO)) * 100) + "%-ot nott.\n");

        System.out.println(kamatSzamok(5, 1000));
    }

}