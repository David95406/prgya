import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RandomAccessFile hivasokTxt;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();
        ArrayList<Integer> telefonszamok = new ArrayList<>();

        try {
            hivasokTxt = new RandomAccessFile("HIVASOK.txt" , "r");
            sor = hivasokTxt.readLine();

            while (sor != null) {
                adatok.add(sor);
                telefonszamok.add(Integer.parseInt(hivasokTxt.readLine()));
                sor = hivasokTxt.readLine();
            }
        } catch (IOException e) {
            System.out.println("hiba");
        }

        int i = 0;
        ArrayList<Hivasok> hivasok = new ArrayList<>();
        for (String adat : adatok) {
            Hivasok ujHivas = new Hivasok(Integer.parseInt(adat.split(" ")[0]),
                    Integer.parseInt(adat.split(" ")[1]),
                    Integer.parseInt(adat.split(" ")[2]),
                    Integer.parseInt(adat.split(" ")[3]),
                    Integer.parseInt(adat.split(" ")[4]),
                    Integer.parseInt(adat.split(" ")[5]),
                    telefonszamok.get(i));
            hivasok.add(ujHivas);
            i++;
        }

        System.out.println(hivasok.get(0));


    }
}