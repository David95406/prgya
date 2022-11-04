package rendszam.pkg1028;

import java.util.Scanner;

public class Rendszam1028 {

    
    /**
     * @param args the command line arguments
     */
    
    static boolean RendszamEll(String rendszam) {
        int i;
        String ellcode = "";
        for (i = 0; i < rendszam.length(); i++) {
            if (Character.isLetter(rendszam.charAt(i))) {
                ellcode = ellcode + "1";
            }
            else if (Character.isDigit(rendszam.charAt(i))) {
                ellcode = ellcode + "0";
            }
            else {
                return false;
            }
        }
        
        if (ellcode.equals("111000")) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String rendszam;
        Scanner bill = new Scanner(System.in);
        
        do {
            System.out.println("Adj meg egy rendszamot! ");
            rendszam = bill.nextLine();
            RendszamEll(rendszam);
        } while (RendszamEll(rendszam) == false);
        
    }
    
}
