import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Cipo c = new Cipo("Nike", "feher", 44);

        System.out.println(c);

        final int MAX = 5;
        Cipo[] cipok = new Cipo[MAX];
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < MAX; i++) {
            System.out.print("Márka:");
            String marka = s.next();
            System.out.print("\nSzín:");
            String szin = s.next();
            System.out.print("\nMéret:");
            int meret = s.nextInt();
            System.out.println();

            cipok[i] = new Cipo(marka, szin, meret);


        }

        for (Cipo cipo : cipok) {
            System.out.println(cipo);
        }

        Cipo maxCipo = cipok[0];
        for (int i = 1; i < MAX; i++) {
            if (maxCipo.getMeret() < cipok[i].getMeret()) {
                maxCipo = cipok[i];
            }
        }
    }
}