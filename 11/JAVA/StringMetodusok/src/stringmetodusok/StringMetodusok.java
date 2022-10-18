/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringmetodusok;

/**
 *
 * @author david
 */
public class StringMetodusok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String szoveg = "Ez egy szoveg. ";
        
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
        
        //copmare
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
        
    }
    
}
