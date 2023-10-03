package pkg1002allatok;

public class Main {

    public static void main(String[] args) {
        Gerincesek ujKutya = new Gerincesek("Emlős", "Canis lupus familiaris", 30);
        ujKutya.displayInfo();
        Emlosok ujEmlos = new Emlosok("Kutya", "Emlős", "Canis lupus familiaris", 30);
        ujEmlos.displayInfo();
        //Kutya(String nev, boolean nem, String szin, String mintazat, String faj, String torzs, String latinNev, int testtomeg) 
        Kutya lenaKutya = new Kutya("Léna", true, "fekete", "mina", "labrador", "kutya", "Canis lupus familiaris", 30);
        System.out.println("");
        lenaKutya.displayInfo();
        lenaKutya.ugat();
    }
    
}
