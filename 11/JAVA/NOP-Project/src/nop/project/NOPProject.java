package nop.project;

import java.util.Scanner;

public class NOPProject {

    //3. feladat
    public static void elvalaszt() {
        System.out.println("*****************");
    }

    //4. feladat
    public static boolean szokoev(int ev) {
        return ((ev > 1582) && (ev % 4 == 0) && (ev % 100 != 0) || (ev % 400 == 0));
    }

    //5. feladat
    public static String evVissza(int ev) {
        String evV = "";
        int i;
        for (i = 0; i < String.valueOf(ev).length(); i++) {
            evV = evV + String.valueOf(ev).charAt((String.valueOf(ev).length() - i) - 1);
        }
        return evV;
    }

    //főprogram
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        int fEv;

        //6. feladat
        do {
            elvalaszt();
            System.out.print("Adjon meg egy évszámot: ");
            fEv = bill.nextInt();
        } while (szokoev(fEv) == false);

        //7. feladat
        System.out.println("Az évszám visszafelé: " + evVissza(fEv));
    }

}
