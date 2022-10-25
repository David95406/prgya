/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dogaell1025;

/**
 *
 * @author david
 */
public class DogaEll1025 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ujszoveg = "Sok lúd disznót győz.";
        String masikszoveg = "Sk lúd disznót győz. ";
        
        System.out.println(ujszoveg.length());
        System.out.println(ujszoveg.charAt(0));
        System.out.println(ujszoveg.equals(masikszoveg));
        System.out.println(ujszoveg.contains("lúd"));
        System.out.println(ujszoveg.indexOf("lúd"));
        System.out.println(ujszoveg.replace("lúd", "veréb"));
        System.out.println(ujszoveg.substring(ujszoveg.indexOf(" ")));
    }
    
}
