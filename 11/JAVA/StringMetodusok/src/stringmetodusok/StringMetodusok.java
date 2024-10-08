/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmetodusok;

/**
 *
 * @author user3
 */
public class StringMetodusok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String szoveg = "Ez egy tetszőleges szoveg. ";
        
        //szoveg hossza
        System.out.println(szoveg.length());
        
        //adott pozicion levo karakter
        System.out.println(szoveg.charAt(5));
        
        //kisbetu
        System.out.println(szoveg.toLowerCase());
        //nagybetu
        System.out.println(szoveg.toUpperCase());
        
        //sorvegi szokoz levagasa
        System.out.println(szoveg.trim().length());
        
        //compare
        System.out.println(szoveg.compareTo("asd"));
        System.out.println(szoveg.equals("asd"));
        System.out.println(szoveg.compareToIgnoreCase("ez egy szoveg. "));
        
        //osszefuzes
        System.out.println(szoveg.concat("Ez egy pedig egy hozzafuzott."));    //lehet tobb is concat.concat.concat stb....
        
        //tartalmazza-e
        System.out.println(szoveg.contains("szoveg"));
        
        //végződik-e valamivel
        System.out.println(szoveg.endsWith(" "));
        
        //kezdődik valamivel
        System.out.println(szoveg.startsWith(" "));
        
        //keresett karakter(ek) első pozíciója 
        System.out.println(szoveg.indexOf("t"));
        System.out.println(szoveg.indexOf("egy"));
        
        //keresett karakter(ek) utolsó pozíciója
        System.out.println(szoveg.lastIndexOf("t"));
        
        //string üres-e (boolean)
        System.out.println(szoveg.isEmpty());
        String ures = "";
        System.out.println(ures.isEmpty());
        
        //lecseréli a szövegben az összes! megadott karakter(ek)et más karakter(ek)re
        System.out.println(szoveg.replace("tetszőleges", "akármilyen"));
        System.out.println(szoveg.replace("e", "b"));
        
        //lecseréli a szövegben az első! megadott karakter(ek)et más karakter(ek)re
        System.out.println(szoveg.split(" "));
        
        //stringből substring kivétele
        System.out.println(szoveg.substring(10));
        System.out.println(szoveg.substring(3,6));
        
        
        
        //tan
        System.out.println("tan:\n\n\n\n");
        
        //compare
        System.out.println(szoveg.compareTo("ezegy tetszoleges szoveg"));
        //equals
        System.out.println(szoveg.equals("ezegy tetszoleges szoveg"));
        //compare ignorecase
        System.out.println(szoveg.compareToIgnoreCase("ezegy tetszoleges szoveg"));
        
        System.out.println(szoveg.concat("Ez pedig egy").concat(" hozzafuzott."));
        
        System.out.println(szoveg.contains("s"));
        
        System.out.println(szoveg.startsWith("e"));
        System.out.println(szoveg.endsWith(" "));
        
        System.out.println(szoveg.indexOf("t"));
        System.out.println(szoveg.lastIndexOf("t"));
        
        System.out.println(szoveg.substring(3, 7));
    }
    
}
