/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random0927;

import java.util.Random;

/**
 *
 * @author user3
 */
public class Random0927 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println((int)(Math.random() * 21)); //0 es 20 kozotti szam
        System.out.println((int)(Math.random() * 71) + (-55));
        System.out.println((int)(Math.random() * 46) + (-40));
        System.out.println((int)(Math.random() * 166) + (-50));
        System.out.println((int)(Math.random() * 26) + (-45));
        //egyagu elagazas
        
        int szam = 25;
        if (szam > 20) {
            System.out.println("Nagyobb");
            System.out.println("A szam duplaja: " + (szam * 2));
        }
        
        //if + else
        int szam_2 = 20;
        if (szam_2 > 20) {
            System.out.println("Nagyobb");
            System.out.println("A szam duplaja: " + (szam * 2));
        }
        else {
            System.out.println("Nem nagyobb");
        }
        
        //tobbagu
        if (szam_2 > 20) {
            System.out.println("Nagyobb");
            System.out.println("A szam duplaja: " + (szam * 2));
        }
        else if (szam < 20) {
            System.out.println("Kisebb");
        }
        else {
            System.out.println("Egyenlo");
        }
        
        //sok agu
        int honap = 10;
        switch(honap)   {
            case 1: System.out.println("Januar"); break;
            case 10: System.out.println("Oktober"); break;
            case 11: System.out.println("November"); break;
            default: System.out.println("Nem meghatarozhato");
        }
        
        //random karakter
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        System.out.println(c);
        int randomCharCode = (int) (Math.random() * 26) + 97;
        System.out.println(randomCharCode);
        System.out.println((char)randomCharCode);
        
    }
    
}
