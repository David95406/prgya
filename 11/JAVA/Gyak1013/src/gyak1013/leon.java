
package gyak1013;

import java.util.Random;

/**
 *
 * @author david
 */
public class Gyak1013 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tömb deklarálása
                int[] szamok = new int[10];

                //tömb feltöltése véletlen számokkal 1-10 között
                Random rand = new Random();
                int i;
                for (i = 0; i < szamok.length; i++) {
                    szamok[i] = rand.nextInt(10) + 1;
                }

               //ellenőrző kiíratás 
               for (i = 0; i < szamok.length; i++) {
                    System.out.print(szamok[i] + " ");
                }
                System.out.println(""); //csak egy sortörés

               //összegzés ---------------------------------------------------------
               int osszeg = 0;
               for (i = 0; i < szamok.length; i++) {
                    osszeg = osszeg + szamok[i];
                }
                System.out.println("A tömb elemeinek összege: " + osszeg);

                //megszámlálás -----------------------------------------------------
                int parosDb = 0;
               for (i = 0; i < szamok.length; i++) {
                    if ( szamok[i] % 2 == 0) {
                        parosDb++;
                    }
                }
                System.out.println("A tömb páros elemeinek száma: " + parosDb);

                //minimum keresése ----------------------------------------------
                int min = szamok[0];
                for (i = 1; i < szamok.length; i++) {
                    if ( szamok[i] < min) {
                        min = szamok[i];
                    }
                }
                System.out.println("A tömb legkisebb eleme: " + min);

                //maximum keresése ----------------------------------------------
                int max = szamok[0];
                for (i = 1; i < szamok.length; i++) {
                    if ( szamok[i] > max) {
                        max = szamok[i];
                    }
                }
                System.out.println("A tömb legnagyobb eleme: " + max);

                //kiválasztás ----------------------------------------------------
                i = 0;
                while (szamok[i] >= 5) {
                    i++;
                }
                System.out.println("Az első 5-nél kisebb szám a(z) " + (i+1) + ". helyen van.");

                //eldöntés -------------------------------------------------------
                i = 0;
                while( i < szamok.length && (szamok[i] % 4 != 0) )
                    {
                    i++;
                    }

                if( i < szamok.length )
                    {
                     System.out.println("Van a számok között 4-gyel osztható.");
                    }
            }

        }

}