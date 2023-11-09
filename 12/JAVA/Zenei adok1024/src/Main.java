import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RandomAccessFile musorTxt;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();

        try {
            musorTxt = new RandomAccessFile("musor.txt", "r");
            int db = 0;
            String z = musorTxt.readLine(); //hány zeneszám (z<=1000) szólt aznap a rádiókban
            System.out.println(z);
            sor = musorTxt.readLine();


            while (sor != null) {
                adatok.add(sor);
                db++;
                sor = musorTxt.readLine();
            }
        } catch (IOException e) {
            System.out.println("Hiba: " + e);
        }


        ArrayList<Musor> musorok = new ArrayList<>();
        System.out.println(adatok.size());
        for (String adat : adatok) {
            Musor ujMusor = new Musor(Integer.parseInt(adat.split(" ")[0]),
                    Integer.parseInt(adat.split(" ")[1]),
                    Integer.parseInt(adat.split(" ")[2]),
                    adat.split(" ", 4)[3].split(":")[0],
                    adat.split(" ", 4)[3].split(":")[1]);

            musorok.add(ujMusor);
        }

        for (Musor musor : musorok) {
            System.out.println(musor + "\n");
        }


    }
}