/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szovegmani;

/**
 *
 * @author david
 */
/*
A StringBuilder egy olyan osztály a Java nyelvben, amelyet a karakterláncok
(szövegek) hatékony manipulálására terveztek. A StringBuilder alkalmas szövegek
összefűzésére, szövegek módosítására, szövegek beszúrására, megfordítására is.
Segítségül: StringBuilder fordított = new StringBuilder(szoveg);
 */
import java.util.Scanner;

public class SzovegMani {

    public static int karakterSzamolas(String szoveg) {
        return szoveg.length();
    }

    public static String szovegForditasa(String szoveg) {
        String returnValue = "";

        for (int i = 0; i < szoveg.length(); i++) {
            returnValue = returnValue.concat(String.valueOf(szoveg.charAt((szoveg.length() - 1) - i)));
        }

        return returnValue;
    }

    public static boolean isPalindroma(String szoveg) {
        szoveg = szoveg.toLowerCase();
        return szoveg.compareTo(szovegForditasa(szoveg)) == 0;
    }

    public static boolean szovegOsszehasonlitas(String szoveg, String masikSzoveg) {
        return szoveg.compareTo(masikSzoveg) == 0;
    }

    public static String szovegCsere(String szoveg, char csereKarakter, char ujKarakter) {
        if (szoveg.contains(String.valueOf(csereKarakter))) {
            return szoveg.replace(String.valueOf(csereKarakter), String.valueOf(ujKarakter));
        } else {
            return szoveg;
        }
    }

    public static int szoSzamolas(String szoveg) {
        return szoveg.split(" ").length;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem, adjon meg egy szöveget: ");
        String szoveg = scanner.nextLine();

        // 1. metódus: Számolja meg, hány karakterből áll a szöveg.
        int karakterSzam = karakterSzamolas(szoveg);
        System.out.println("A szöveg " + karakterSzam + " karakterből áll.");

        // 2. metódus: Fordítsa meg a szöveget.
        String fordítottSzoveg = szovegForditasa(szoveg);
        System.out.println("A szöveg fordítva: " + fordítottSzoveg);

        // 3. metódus: Ellenőrizze, hogy a szöveg palindróma-e.
        boolean palindroma = isPalindroma(szoveg);
        if (palindroma) {
            System.out.println("A szöveg palindróma.");
        } else {
            System.out.println("A szöveg nem palindróma.");
        }

        // 4. metódus: Szöveg összehasonlítás
        String masikSzoveg = "Ez egy masik szoveg";
        boolean azonos = szovegOsszehasonlitas(szoveg, masikSzoveg);
        if (azonos) {
            System.out.println("A két szöveg azonos.");
        } else {
            System.out.println("A két szöveg nem azonos.");
        }

        // 5. metódus: Szöveg cseréje
        char csereKarakter = 'e';
        char ujKarakter = 'X';
        String csereltSzoveg = szovegCsere(szoveg, csereKarakter, ujKarakter);
        System.out.println("A szöveg cserélve: " + csereltSzoveg);

        // 6. metódus: Szószámoló
        int szoSzam = szoSzamolas(szoveg);
        System.out.println("A szövegben " + szoSzam + " szó található.");
    }

}
