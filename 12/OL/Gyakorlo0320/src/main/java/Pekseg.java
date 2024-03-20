import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Pekseg {
    private static ArrayList<Arlap> lista = new ArrayList<>();

    public static void main(String[] args) {
        vasarlok("adatok.txt");
        etelLeltar();
    }

    public static void vasarlok(String eleresiUt) {
        RandomAccessFile raf;
        ArrayList<String> file = new ArrayList<>();
        try {
            raf = new RandomAccessFile(eleresiUt, "r");
            String sor = raf.readLine();

            while (sor != null) {
                file.add(sor);
                sor = raf.readLine();
            }
        } catch (IOException ieo) {
            System.out.println("hiba: " + ieo);
        }

        try {
            for (String adat : file) {
                if (adat.split(" ")[0].equals("Pogacsa")) {
                    lista.add(new Pogacsa(
                            Integer.parseInt(adat.split(" ")[1]),
                            Integer.parseInt(adat.split(" ")[2])
                    ));
                }
                else if (adat.split(" ")[0].equals("Kave")) {
                    //lista.add(new Kave((adat.split(" ")[1].equals("habos"))));

                    if (adat.split(" ")[1].equals("habos")) {
                        lista.add(new Kave(true));
                    } else if (adat.split(" ")[1].equals("nem_habos")) {
                        lista.add(new Kave(false));
                    }
                }
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("hiba: " + iae);
        }


    }

    public static void etelLeltar() {
        RandomAccessFile raf;
        ArrayList<Pogacsa> pogacsak = new ArrayList<>();

        for (Arlap adat : lista) {
            if (adat.toString().split(" ")[0].equals("Pogacsa")) {
                pogacsak.add((Pogacsa) adat);
            }
        }

        try {
            raf = new RandomAccessFile("leltar.txt", "rw");
            for (Pogacsa egyPogacsa : pogacsak) {
                raf.writeBytes(egyPogacsa.toString() + "\n");
            }
        } catch (IOException ieo) {
            System.out.println("hiba: " + ieo);
        }

    }
}
