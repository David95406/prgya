/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oraif1018;

import java.util.Scanner;

/**
 *
 * @author user3
 */
public class OraiF1018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String fnev, classID, firstName, lastName;
        int i;
        
        fnev = scan.nextLine();
        firstName = fnev.split(" ")[0];
        lastName = fnev.split(" ")[1];
        classID = scan.nextLine();
        
        //Ha a betujele 'e' vel kezdodik, alakitsuk 'E'-re
        if(classID.split("")[4].equals("e")) {
            classID = classID.replaceFirst("e", "E");
        }
        
        //Ha az evfolyam szama 2022-nel kisebb, akkor a classID minden betuje legyen nagy.
        if(Integer.parseInt(classID.substring(0,4)) < 2022) {
            for(i = 0; i < classID.split("").length; i++){
                System.out.print(classID.split("")[i].toUpperCase());
            }
        }
        System.out.println("");
        
        //Ha az osztaly mindket betuje nagy, irjuk ki, hogy estis osztaly
        if((classID.split("")[3].equals(classID.split("")[3].toUpperCase())) && (classID.split("")[4].equals(classID.split("")[4].toUpperCase()))) {
            System.out.println("Ez egy estis osztály");
        }
    }
    
}
