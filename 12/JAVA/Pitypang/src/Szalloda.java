import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Szalloda {
    public static void main(String[] args) {
        RandomAccessFile raf;
        Scanner scan = new Scanner(System.in);
        int valamiAdat = -1;
        ArrayList<Foglalas> foglalasok = new ArrayList<>();
        try {
            String sor;
            raf = new RandomAccessFile("pitypang.txt", "r");
            valamiAdat = Integer.parseInt(raf.readLine());
            sor = raf.readLine();
            while (sor != null) {
                String[] f = sor.split(" ");
                Foglalas ujFoglalas = new Foglalas(Integer.parseInt(f[0]), Integer.parseInt(f[1]),
                        Integer.parseInt(f[2]), Integer.parseInt(f[3]), Integer.parseInt(f[4]),
                        Integer.parseInt(f[5]) == 1, f[6]);
                foglalasok.add(ujFoglalas);
                sor = raf.readLine();
            }

        } catch (IOException e) {
            System.out.println("baj");
        }

        //2
        Foglalas maxIdo = foglalasok.get(0);
        for (Foglalas foglalas : foglalasok) {
            if (foglalas.getTavozas() - foglalas.getErkezes() >
            maxIdo.getTavozas() - maxIdo.getErkezes()) {
                maxIdo = foglalas;
            }
        }
        System.out.println("2. feladat:");
        System.out.println(maxIdo.getVendegAzonosito() + " (" + maxIdo.getErkezes() + ") - " +
                (maxIdo.getTavozas() - maxIdo.getErkezes()));

        //3

    }
}