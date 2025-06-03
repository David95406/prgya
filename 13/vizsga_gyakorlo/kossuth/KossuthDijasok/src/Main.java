import java.io.RandomAccessFile;
import java.rmi.MarshalException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private record EvCounter(int ev, int db) {
        int getEv() {
            return this.ev;
        }
    }

    private static double szazalek(ArrayList<Dijazott> dijazottak) {
        int elsoFokozatDb = 0;
        for (Dijazott dijazott : dijazottak) {
            if (dijazott.getMegjegyzes().equals("I. fokozat")) {
                elsoFokozatDb++;
            }
        }

        return (double) elsoFokozatDb / dijazottak.size() * 100;
    }


    public static void main(String[] args) {
        ArrayList<Dijazott> dijazottak = new ArrayList<>();

        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("dijazottak.csv", "r");

            raf.readLine();
            String line = raf.readLine();

            while (line != null) {
                String utf8 = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                String[] data = utf8.strip().split("\t");

                Dijazott d = new Dijazott(
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4]
                );
                dijazottak.add(d);

                line = raf.readLine();
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("file hiba");
        }

        System.out.println("8. feladat");
        int laszlok = 0;

        for (Dijazott dijazott : dijazottak) {
            if (dijazott.getNev().contains("László")) {
                laszlok++;
            }
        }

        System.out.println("László keresztnevű díjazottak száma: " + laszlok);

        System.out.println("9. feladat");
        ArrayList<Integer> evek = new ArrayList<>();
        int maxEv = -1;
        int maxDb = 0;

        for (Dijazott dijazott : dijazottak) {
            if (!evek.contains(dijazott.getEv())) {
                evek.add(dijazott.getEv());
            }
        }

        for (Integer ev : evek) {
            int db = 0;
            for (Dijazott dijazott : dijazottak) {
                if (dijazott.getEv() == ev) {
                    db++;
                }
            }
            if (db > maxDb) {
                maxDb = db;
                maxEv = ev;
            }
        }

        System.out.println("A legtöbb díjat " + maxEv + "-ben adták.");

        System.out.printf("I. fokozatú díjazott: %.1f ", szazalek(dijazottak));
    }
}