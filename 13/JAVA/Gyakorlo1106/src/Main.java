public class Main {
    public static void main(String[] args) {
        Konyvtar konyvtar = new Konyvtar("konyvek.txt");
        System.out.println(konyvtar);
        konyvtar.rendezKonyvek("asc");
    }
}
