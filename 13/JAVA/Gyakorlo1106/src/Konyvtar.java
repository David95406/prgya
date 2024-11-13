import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Konyvtar {
    private ArrayList<Konyv> konyvek;

    public Konyvtar(String fajlnev) {
        konyvek = new ArrayList<>();
        try {
            RandomAccessFile raf = new RandomAccessFile(fajlnev, "r");
            String sor = raf.readLine();
            while (sor != null) {
                this.konyvek.add(new Konyv(sor.split(";")));
                sor = raf.readLine();
            }
        } catch (Exception e) {
            System.out.println("baj");
        }
    }

    public void konyvekKiirasa() {
        System.out.println(getKonyvek());
    }

    public void konyvKeresesSzerzoAlapjan(String szerzo) {
        int i = 0;
        do {
            if (getKonyvek().get(i).getSzerzo().contains(szerzo)) {
                System.out.println(getKonyvek().get(i).toString());
                return;
            }
            i++;
        } while (getKonyvek().size() != i);
    }

    public void rendezKonyvek(String szempont) throws IllegalArgumentException {
        switch (szempont) {
            case "abc" -> {
                Abc abc = new Abc();
                for (int i = 0; i < getKonyvek().size()-1; i++) {
                    return;
                }
            }
            case "asc" -> {
                Asc asc = new Asc();
                System.out.println("asc");
            }
            case "desc" -> {
                Desc desc = new Desc();
                System.out.println("desc");
            }
            default -> {
                throw new IllegalArgumentException("Hibás szempont!");
            }
        }

    }

    public ArrayList<Konyv> getKonyvek() {
        return konyvek;
    }

    @Override
    public String toString() {
        return "Konyvtar{" +
                "konyvek=" + getKonyvek() +
                '}';
    }
}
