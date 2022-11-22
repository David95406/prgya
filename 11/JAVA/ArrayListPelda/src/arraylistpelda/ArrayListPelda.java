package arraylistpelda;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListPelda {

    public static void main(String[] args) {
        int i, parosDb = 0;
        Random rand = new Random();
        ArrayList<Integer> szamok = new ArrayList<Integer>(); //.add(); .size(); .get()

        for (i = 0; i < 10; i++) {
            szamok.add(rand.nextInt(10) + 10);
        }

        for (i = 0; i < szamok.size(); i++) {
            System.out.print(szamok.get(i) + " ");
        }
        System.out.println("\n");

        for (i = 0; i < szamok.size(); i++) {
            if (szamok.get(i) % 2 == 0) {
                parosDb++;
            }
        }
        System.out.println("Ennyi paros szam van a listaban: " + parosDb);

    }

}
