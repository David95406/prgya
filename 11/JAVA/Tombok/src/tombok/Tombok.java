/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tombok;

/**
 *
 * @author user3
 */
public class Tombok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int tomb deklaralasa
        int[] szamok =new int[4];
        
        //ertekadas
        szamok[0] = 11;
        szamok[1] = 56; //stb...
        System.out.println(szamok[1]);
        
        //tomb deklaralasa egyutt 
        int[] jegyek = new int[] {3,2,1,4,2,3,1};
        System.out.println(jegyek[4]);
        
        //string tomb deklaralasa
        String[] nevek = new String[3];
        nevek[0] = "Janos";
        System.out.println(nevek[0]);
        
        //String deklaralasa
        String nevem;
        //String ertekadasa
        nevem = "David";
        System.out.println(nevem);
        System.out.println(nevem.charAt(0));
        
        //tomb bejarasa
        int i;
        for (i=0; i < jegyek.length;i++) {
            System.out.println(jegyek[i]);
        }
        
                
        
        
        
    }
    
}
