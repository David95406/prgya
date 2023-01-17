package abrahamdavid;

import java.util.Random;
import java.util.Scanner;

public class AbrahamDavid {

    public static boolean fEmailCheck(String emailAddress) {
        return (emailAddress.contains("@"));
    }
    
    public static void main(String[] args) {
        //Kérje be a program a felhasználótól az email címét addig, amíg formailag nem megfelelő címet ad meg
        //Az ellenőrzéshez készíts egy saját metódust, ami visszaadja, hogy helyes vagy nem helyes a formátum
        //A formátum akkor helyes, ha van benne @ jel
        String fEmail;
        Scanner bill = new Scanner(System.in);
        
        do {
            System.out.print("Adja meg az email címét! ");
            fEmail = bill.next();
            if (!fEmailCheck(fEmail)) {
                System.out.println("Hibás formátum!");
            }
        } while (!(fEmailCheck(fEmail)));
        System.out.println("Email cím elfogadva!\n");
        
        
        //Hozz létre egy 5 elemű tömböt vagy ArrayList-et. Töltsd fel random egész szám adatokkal 10 és 20 között
        //hány olyan szám van a tömbben vagy listában, melyet egy tőle nagyobb szám követ?
        //Vizsgáld meg, hogy a tömb elemei növekvő sorrendben állnak-e
        int i;
        int nagyobbSzamKov = 0;
        Random rand = new Random();
        int[] rSzamok = new int[5];
        
        for (i = 0; i < rSzamok.length; i++) {
            rSzamok[i] = rand.nextInt(10) + 10;
        }
        
        for (i = 0; i < rSzamok.length - 1; i++) {
            if (rSzamok[i] < rSzamok[i + 1]) {
                nagyobbSzamKov++;
            }
        }
        
        System.out.println("A tömbben " + nagyobbSzamKov + "db olyan szám van, melyet egy tőle nagyobb szám követ.");
        System.out.println("A tömb növekvő sorrendben van? " + (nagyobbSzamKov + 1 == rSzamok.length));
    }
    
}
