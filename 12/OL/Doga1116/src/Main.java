import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = 2; //5
        Fuzet[] fuzetek = new Fuzet[N];
        String minta, kotes;
        int vastagsag;


        for (int i = 0; i < N; i++) {
            do {
                System.out.println("Adja meg a fuzet mintajat: " + " (" + (i + 1) + ")");
                minta = scan.next();
            } while (!(minta.equals("sima") || minta.equals("vonalas") || minta.equals("negyzetracsos")));
            do {
                System.out.println("Adja meg a fuzet kotesi modjat: " + " (" + (i + 1) + ")");
                kotes = scan.next();
            } while (!(kotes.equals("spiral") || kotes.equals("fuzott") || kotes.equals("tuzott")));
            do {
                System.out.println("Adja meg a fuzet vastagsasgat: (egesz szam) " + " (" + (i + 1) + ")");
                vastagsag = scan.nextInt();
            } while (vastagsag < 0);
            Fuzet ujFuzet = new Fuzet(minta, kotes, vastagsag);
            fuzetek[i] = ujFuzet;
        }

        //System.out.println(fuzetek[0]);
        Fuzet legvastagabb = fuzetek[0];
        for (int i = 0; i < N; i++) {
            if (fuzetek[i].getMinta().equals("vonalas") &&
                    fuzetek[i].getVastagsag() > legvastagabb.getVastagsag()) {
                legvastagabb = fuzetek[i];
            }
        }
        if (!legvastagabb.getMinta().equals("vonalas")) {
            legvastagabb = new Fuzet("-1", "-1", -1);
            System.out.println("Nincsen vonalas fuzet");
        } else {
            System.out.println("A legvastagabb fuzet adatai: \n" + legvastagabb);
        }

        double atlagVastagsag = 0;
        for (Fuzet fuzet : fuzetek) {
            atlagVastagsag += fuzet.getVastagsag();
        }
        atlagVastagsag = (double) atlagVastagsag / N;
        System.out.println("A fuzetek atlag vatasaga: " + atlagVastagsag);

        int s = 0, f = 0, t = 0;
        for (Fuzet fuzet : fuzetek) {
            switch (fuzet.getKotes()) {
                case "spiral": s++;
                case "fuzott": f++;
                case "tuzott": t++;
                default:
            }
        }
        //...
    }
}