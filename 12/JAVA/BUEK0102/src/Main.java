import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RandomAccessFile raf;
        ArrayList<Auto> autok = new ArrayList<>();
        String sor;

        try {
            raf = new RandomAccessFile("autok.txt", "r");
            sor = raf.readLine();
            autok.add(new Auto(sor.split(" ")));

            while (sor != null) {
                sor = raf.readLine();
                Auto auto = new Auto(sor.split(" "));
                autok.add(auto);
            }
        } catch (IOException e) {
            System.out.println("baj");
        }

        System.out.println(autok);


    }
}