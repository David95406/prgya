import java.util.Comparator;

public class Abc implements Comparator<Konyv> {
    @Override
    public int compare(Konyv k1, Konyv k2) {
        return k1.getCim().compareTo(k2.getCim());
    }
}
