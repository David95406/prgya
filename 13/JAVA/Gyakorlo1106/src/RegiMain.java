import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class RegiMain implements Comparator<Konyv>, Comparable<Konyv>{
    public static ArrayList<Konyv> konyvek = new ArrayList<>();

    public static void betoltesFilebol(String fajlnev) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fajlnev, "r");
            String sor = raf.readLine();
            while (sor != null) {
                konyvek.add(new Konyv(sor.split(";")));
                sor = raf.readLine();
            }
        } catch (Exception e) {
            System.out.println("baj");
        }
    }

    public static void konyvekKiirasa() {
        System.out.println(konyvek);
    }

    public static void konyvKeresesSzerzoAlapjan(String szerzo) {
        int i = 0;
        do {
            if (konyvek.get(i).getSzerzo().contains(szerzo)) {
                System.out.println(konyvek.get(i).toString());
                return;
            }
            i++;
        } while (konyvek.size() != i);
    }

    public static void rendezKonyvek(String szempont) {
        switch (szempont) {
            case "abc" -> {
                System.out.println("abc");
            }
            case "asc" -> {
                System.out.println("asc");
            }
            case "desc" -> {
                System.out.println("desc");
            }
            default -> {
                return;
            }
        }

    }

    public static void main(String[] args) {
        betoltesFilebol("konyvek.txt");
        konyvKeresesSzerzoAlapjan("Fekete");
        rendezKonyvek("asc");
    }

    @Override
    public int compare(Konyv o1, Konyv o2) {
        return 0;
    }

    @Override
    public Comparator<Konyv> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Konyv> thenComparing(Comparator<? super Konyv> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Konyv> thenComparing(Function<? super Konyv, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Konyv> thenComparing(Function<? super Konyv, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Konyv> thenComparingInt(ToIntFunction<? super Konyv> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Konyv> thenComparingLong(ToLongFunction<? super Konyv> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Konyv> thenComparingDouble(ToDoubleFunction<? super Konyv> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public int compareTo(Konyv o) {
        return 0;
    }
}