/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elsodogaell1014;

/**
 *
 * @author user3
 */
public class ElsoDogaELL1014 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] szamok = new int[] {3,2,15,4,42,3};
        //paratlan
        int i;
        int paratlanDB = 0;
        for (i = 0; i < szamok.length; i++) {
            if (szamok[i] % 2 != 0) {
                paratlanDB++;
            }
        }
        System.out.println(paratlanDB);
        //osszeg
        int osszeg = 0;
        for (i = 0; i < szamok.length; i++) {
            osszeg = osszeg + szamok[i];
        }
        System.out.println(osszeg);
        //min
        int min = szamok[0];
        for (i = 1; i < szamok.length; i++) {
            if (szamok[i] < min) {
                min = szamok[i];
            }
        }
        System.out.println(min);
        //10 és 20 kozott
        int a = 0;
        while ((a < szamok.length) && (szamok[a] > 10) && (szamok[a] < 20))  {
            a++;
        }
        System.out.println(a);
   }
    
}
