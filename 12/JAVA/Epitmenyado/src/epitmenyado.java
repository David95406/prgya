import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class epitmenyado {
    static int osszegA = 0;
    static int osszegB = 0;
    static int osszegC = 0;

    //4
    public static int ado(String adoSav, int alapterulet) {
        int ado = 0;
        switch (adoSav) {
            case "A":
                ado = alapterulet * osszegA;
                break;
            case "B":
                ado = alapterulet * osszegB;
                break;
            case "C":
                ado = alapterulet * osszegC;
                break;
            default:
        }
        if (ado >= 10000) {
            return ado;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RandomAccessFile raf;
        ArrayList<Telek> telkek = new ArrayList<>();
        String sor;

        try {
            raf = new RandomAccessFile("utca.txt", "r");
            sor = raf.readLine();
            osszegA = Integer.parseInt(sor.split(" ")[0]);
            osszegB = Integer.parseInt(sor.split(" ")[1]);
            osszegC = Integer.parseInt(sor.split(" ")[2]);
            sor = raf.readLine();

            while (sor != null) {
                String[] f = sor.split(" ");
                Telek ujTelek = new Telek(f[0], f[1], f[2], f[3], Integer.parseInt(f[4]));
                telkek.add(ujTelek);
                sor = raf.readLine();
            }
        } catch (IOException e) {
            System.out.println("HIBA");
        }

        System.out.println(telkek);

        //2
        System.out.println("2. feladat. A mintaban " + telkek.size() + " telek szerepel.");

        //3
        System.out.print("Egy tulajdonos adoszama: ");
        String userAdoszam = scan.next();
        boolean vanE = false;
        for (Telek egyTelek : telkek) {
            if (egyTelek.getAdoszam().equals(userAdoszam)) {
                vanE = true;
                System.out.println(egyTelek.getUtca() + " utca " + egyTelek.getHazszam());
            }
        }
        if (!vanE) {
            System.out.println("Nem szerepel az adatállományban.");
        }

        //5
        System.out.println("5. feladat");
        ArrayList<Telek> ASav = new ArrayList<>();
        ArrayList<Telek> BSav = new ArrayList<>();
        ArrayList<Telek> CSav = new ArrayList<>();
        int[] adok = new int[3];

        for (Telek egyTelek : telkek) {
            switch (egyTelek.getAdosav()) {
                case "A":
                    ASav.add(egyTelek);
                    adok[0] += ado("A", egyTelek.getAlapterulet());
                    break;
                case "B":
                    BSav.add(egyTelek);
                    adok[1] += ado("B", egyTelek.getAlapterulet());
                    break;
                case "C":
                    CSav.add(egyTelek);
                    adok[2] += ado("C", egyTelek.getAlapterulet());
                    break;
                default:
                    break;
            }
        }
        System.out.println("A savban " + ASav.size() + " telek esik, az ado " + adok[0] + " Ft.");
        System.out.println("B savban " + BSav.size() + " telek esik, az ado " + adok[1] + " Ft.");
        System.out.println("C savban " + CSav.size() + " telek esik, az ado " + adok[2] + " Ft.");

        //6
        ArrayList<String> utcaNevek = new ArrayList<>();
        System.out.println("6. feladat. A több sávba sorolt utcák:");
        for (int i = 0; i < telkek.size() - 1; i++) {
            if (telkek.get(i).getUtca().equals(telkek.get(i + 1).getUtca()) &&
                    !telkek.get(i).getAdosav().equals(telkek.get(i + 1).getAdosav()) &&
                    !utcaNevek.contains(telkek.get(i).getUtca())) {
                utcaNevek.add(telkek.get(i).getUtca());
            }
        }
        for (int i = 0; i < utcaNevek.size(); i++) {
            System.out.println(utcaNevek.get(i));
        }
        /*
        ArrayList<ArrayList<Telek>> utcak = new ArrayList<ArrayList<Telek>>();
        int j = 0;
        for (int i = 0; i < telkek.size(); i++) {
            j = i;
            String utcaNev = telkek.get(i).getUtca();
            ArrayList<Telek> utca = new ArrayList<>();
            utca.add(telkek.get(i));
            while (telkek.get(j).getUtca().equals(utcaNev)) {
                utca.add(telkek.get(j));
                j++;
            }
            System.out.println(i);
            utcak.add(utca);
        }
        System.out.println(utcak);

        for (ArrayList<Telek> egyUtca : utcak) {
            for (Telek egyTelek : egyUtca) {
                System.out.println("sziaaa");
            }
        }

         */

        //7
        System.out.println("7. feladat (txt megjelenitese)");
        scan.next();
        ArrayList<String> tulajok = new ArrayList<>();
        for (
                Telek egyTelek : telkek) {
            if (!tulajok.contains(egyTelek.getAdoszam())) {
                tulajok.add(egyTelek.getAdoszam());
            }
        }

        int[] fizetendo = new int[tulajok.size()];
        for (
                Telek egyTelek : telkek) {
            fizetendo[tulajok.indexOf(egyTelek.getAdoszam())] += ado(egyTelek.getAdosav(), egyTelek.getAlapterulet());
        }
        for (
                String egyTulaj : tulajok) {
            System.out.println(egyTulaj + " " + fizetendo[tulajok.indexOf(egyTulaj)]);
        }


    }
}