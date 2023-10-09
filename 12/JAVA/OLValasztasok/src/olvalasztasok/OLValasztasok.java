package olvalasztasok;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class OLValasztasok {

    public static void main(String[] args) {
        RandomAccessFile raf;
        String sor;
        ArrayList<String> adatok = new ArrayList<>();

        try {
            raf = new RandomAccessFile("szavazatok.txt", "r");
            int db = 0;
            sor = raf.readLine();

            while (sor != null) {
                adatok.add(sor);
                db++;
                sor = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println("hiba");
        }
        
        ArrayList<Kepviselo> kepviselok = new ArrayList<>();
        for (String adat : adatok) {
            Kepviselo ujKepviselo = new Kepviselo(Integer.parseInt(adat.split(" ")[0]), Integer.parseInt(adat.split(" ")[1]), 
                    adat.split(" ")[2], adat.split(" ")[3], adat.split(" ")[4]);
            kepviselok.add(ujKepviselo);
        }
        
        //1
        System.out.println("A helyhatósági választáson " + kepviselok.size() + " képviselőjelölt indult.");
        
        //2
        Scanner scan = new Scanner(System.in);
        System.out.print("Vezeteknev: ");
        String fVezeteknev = scan.nextLine();
        System.out.print("Utónév: ");
        String fUtonev = scan.nextLine();
        
        int nincs = 0;
        for (Kepviselo kepviselo : kepviselok) {
            if (fVezeteknev.equals(kepviselo.getVezeteknev()) && fUtonev.equals(kepviselo.getUtonev())) {
                System.out.println(fVezeteknev + " " + fUtonev + ": " + kepviselo.getSzavazatSzam());
            } else if (nincs != (kepviselok.size() - 1)){
                nincs++;
            } else {
                System.out.println("„Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!”");
            }
        }
        
        //12345 ember
        int reszvetel = 0;
        for (Kepviselo kepviselo : kepviselok) {
            reszvetel += kepviselo.getSzavazatSzam();
        }
        //A választáson 5001 állampolgár, a jogosultak 40,51%-a vett részt.
        System.out.println("A választáson 12345 állampolgár, a jogosultak " + (reszvetel / 12345) + "%-a vett részt.");
    }
    
}
