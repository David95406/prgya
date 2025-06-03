import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static double getSzintAtlag(String targetFaj, ArrayList<Karakter> karakterek) {
        int db = 0;
        int szintSzum = 0;
        for (Karakter karakter : karakterek) {
            if (karakter.getFaj().equals(targetFaj)) {
                db++;
                szintSzum += karakter.getSzint();
            }
        }

        return (double) szintSzum / db;
    }

    public static void main(String[] args) {
        ArrayList<Karakter> karakterek = new ArrayList<>();
        RandomAccessFile raf;

        try {
            raf = new RandomAccessFile("./karakterek.csv", "r");
            raf.readLine();
            String line = raf.readLine();

            while (line != null) {
                String utf8 = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                Karakter ujKarakter = new Karakter(utf8.strip().split(";"));
                karakterek.add(ujKarakter);
                line = raf.readLine();
            }

            raf.close();
        } catch (Exception e) {
            System.out.println("file hiba");
        }
        karakterek.clear();
        try {
            FileReader fr = new FileReader("karakterek.csv");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                Karakter k = new Karakter(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
                karakterek.add(k);
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("ok");
        }


        System.out.println("4. feladat:");
        System.out.printf("Az elfek szintátlaga: %.3f", getSzintAtlag("elf", karakterek));

        System.out.println("5. feladat:");
        ArrayList<String> fajok = new ArrayList<>();
        for (Karakter karakter : karakterek) {
            if (!fajok.contains(karakter.getFaj())) {
                fajok.add(karakter.getFaj());
            }
        }

        String lFaj = "";
        int maxDb = 0;
        for (String faj : fajok) {
            int db = 0;
            for (Karakter karakter : karakterek) {
                if (karakter.getFaj().equals(faj)) {
                    db++;
                }
            }

            if (maxDb <= db) {
                maxDb = db;
                lFaj = faj;
            }
        }


        System.out.println("A leggyakoribb faj: " + lFaj);

        System.out.println("6. feladat");
        String okosKarakterekSzoveg = "Okos karakterek:";
        for (Karakter karakter : karakterek) {
            if (karakter.getLeiras().contains("okos")) {
                okosKarakterekSzoveg += " " + karakter.getNev();
            }
        }
        System.out.println(okosKarakterekSzoveg);

        System.out.println("5. feladat 2. megoldas");
        HashMap<String, Integer> fajokHashMap = new HashMap<>();
        for (Karakter karakter : karakterek) {
            if (fajokHashMap.containsKey(karakter.getFaj())) {
                fajokHashMap.put(karakter.getFaj(), fajokHashMap.get(karakter.getFaj()) + 1);
            } else {
                fajokHashMap.put(karakter.getFaj(), 1);
            }
        }
        int maxValueInMap = Collections.max(fajokHashMap.values());
        String lFajHashMap = "";
        for (Map.Entry<String, Integer> entry : fajokHashMap.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                lFajHashMap = entry.getKey();
                break;
            }
        }
        System.out.println("A leggyakoribb faj: " + lFajHashMap);
    }
}