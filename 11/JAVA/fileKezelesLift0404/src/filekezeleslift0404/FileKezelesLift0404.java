package filekezeleslift0404;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileKezelesLift0404 {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String[] rawSor;
        int[] sor;
        ArrayList<int[]> liftAdatok = new ArrayList<>();

        try {
            raf = new RandomAccessFile("igeny.txt", "r");
            int db = 0;
            int szintekSzama = Integer.parseInt(raf.readLine().strip());
            int csapatokSzama = Integer.parseInt(raf.readLine().strip());
            int igenyekSzama = Integer.parseInt(raf.readLine().strip());
            int size = 0;

            while (raf.readLine() != null) {
                size++;
            }
            raf.seek(0);
            raf.readLine();
            raf.readLine();
            raf.readLine();
            
            while (db < size) {
                int sorIndex = 0;
                sor = new int[6];
                rawSor = raf.readLine().strip().split(" ");

                for (String adat : rawSor) {
                    sor[sorIndex] = Integer.parseInt(adat);
                    sorIndex++;
                }
                liftAdatok.add(sor);

                db++;
            }
            liftAdatok.remove(size - 1); //az utolso sor 0 0 0 0 0 0

            for (int i = 0; i < liftAdatok.size(); i++) {
                for (int j = 0; j < liftAdatok.get(i).length; j++) {
                    System.out.print(liftAdatok.get(i)[j] + " ");
                }
                System.out.println("");
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
    }

}
