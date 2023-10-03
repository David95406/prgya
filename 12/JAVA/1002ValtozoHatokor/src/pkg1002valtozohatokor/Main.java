package pkg1002valtozohatokor;

public class Main {
    static int globalisValtozo = 12;

    public static void main(String[] args) {
        int mainValtozo = 5;
        
        System.out.println("A mainValtozo valtozo erteke a main metodusban: " + mainValtozo);
        
        metodus1();
        
    } //main vege
    
    public static void metodus1() {
        //lokalis valtozo metodus1ben
        int metodus1Valtozo = 20;
        System.out.println("A metodusValtozo erteke a metodus1ben: " + metodus1Valtozo);
        System.out.println("A globalisValtozo erteke a metodus1ben: " + globalisValtozo);
        
        System.out.println("\nmetodus2 meghivasa a metodus1ben");
        metodus2();

    }
    
    public static void metodus2() {
        int metodus2Valtozo = 30;
        System.out.println("A metodus2Valtozo erteke a metodus2ben: " + metodus2Valtozo);
        System.out.println("A globalisValtozo erteke a metodus2ben: " + globalisValtozo);
    }
}
