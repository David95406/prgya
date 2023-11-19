public class Main {
    public static void main(String[] args) {
        final int N = 20;
        Kotveny[] kotvenyek = new Kotveny[N];

        for (int i = 0; i < N; i++) {
            Kotveny ujKotveny = new Kotveny(i, "Pest Bank " + (i + 1) + ". kerulet", 70000, 12, 2 + 4 * (i + 1) / 10.0);
            kotvenyek[i] = ujKotveny;
        }

        System.out.println(kotvenyek[1]);

        Kotveny maxKotveny = kotvenyek[0];
        for (int i = 1; i < kotvenyek.length; i++) {
            if (maxKotveny.getKamat() < kotvenyek[i].getKamat()) {
                maxKotveny = kotvenyek[i];
            }
        }

        System.out.println("A legjobb kamatozasu kotveny a " + maxKotveny.getSorszam() + ". sorszamu: " + maxKotveny.getKamat() + "%");
    }
}