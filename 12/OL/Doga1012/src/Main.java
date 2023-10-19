public class Main {



    public static void main(String[] args) {
        Film elso = new Film("Frakk", 120);
        System.out.println(elso.toString());


        Film[] filmLista = new Film[10];
        for (int i = 0; i < 10; i++) {
            Film film = new Film(String.valueOf(i), i * 30);
            filmLista[i] = film;
            System.out.println(film.toString());
        }

        int longest = 0;
        int filmId = 0;
        int i = 0;
        for (Film egyFilm : filmLista) {
            i++;
            if (egyFilm.getHossz() > longest) {
                longest = egyFilm.getHossz();
                filmId = i;
            }
        }

        System.out.println(filmLista[filmId - 1].toString());
    }
}