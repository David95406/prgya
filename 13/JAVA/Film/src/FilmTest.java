public class FilmTest {
    public static void main(String[] args) {
        Film f = new Film("film", "erno", 5);
        System.out.println(f);
        System.out.println(f.getHossz());
        System.out.println("\n\n");
        Sorozat s = new Sorozat("sorozat", "erno", 100, 10);
        System.out.println(s);
        System.out.println(s.getHossz());
        Sorozat s2 = new Sorozat("minisorozat", "erno", 60);
        System.out.println(s2);
        System.out.println(s2.getHossz());
    }
}