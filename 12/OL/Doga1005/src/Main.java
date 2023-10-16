public class Main {
    public static void main(String[] args) {
        //teszt osztaly
        Eloadas ujEloadas = new Eloadas("Frakk", 5000, 20, 10);

        ujEloadas.setEladottJ(20);
        System.out.println(ujEloadas.eladottJ);
        System.out.println(ujEloadas.teltHaz());
        System.out.println(ujEloadas.getBrutto());
        System.out.println(ujEloadas.toString());
        System.out.println();
    }
}