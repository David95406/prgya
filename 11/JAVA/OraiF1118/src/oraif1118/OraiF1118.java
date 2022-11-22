package oraif1118;

import java.util.Scanner;

public class OraiF1118 {

    public static boolean idEll(String ID) {
        int i;
        String ellcode = "";

        for (i = 0; i < ID.length(); i++) {
            if (Character.isLetter(ID.charAt(i))) {
                if (Character.isUpperCase(ID.charAt(i))) {
                    ellcode = ellcode + "u"; //uppercase
                } else if (Character.isLowerCase(ID.charAt(i))) {
                    ellcode = ellcode + "l"; //lowercase
                } else {
                    return false;
                }
            } else if (Character.isDigit(ID.charAt(i))) {
                ellcode = ellcode + "d"; //digit
            } else {
                return false;
            }
        }
        
        //nem kell break (return)
        switch (ellcode) {
            case "dddddduu":
                return true;
            case "ddddddlu":
                return true;
            case "uuddddd":
                return true;
            default:
                return false;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String Id = "";

        do {
            System.out.println("Adja meg");
            Id = scan.nextLine();
        } while (!idEll(Id));

    }

}
