package pkg1003geometriaialakzatok;

public class Main {

    public static void main(String[] args) {
        Circle ujKor = new Circle("Kör", 5.0, 78.5);
        System.out.println(ujKor.toString());
        ujKor.setRadius(7.0);
        System.out.println("\n" + ujKor.toString());
    }
    
}
