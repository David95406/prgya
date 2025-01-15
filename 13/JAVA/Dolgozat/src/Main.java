import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Allat> allatokFile = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile("allatok.txt", "r");
            String sor = raf.readLine();

            while (sor != null) {
                String[] egyAllatAdat = sor.split(";");

                switch (egyAllatAdat[1]) {
                    case "Oroszlan":
                        allatokFile.add(new Oroszlan(egyAllatAdat[0], egyAllatAdat[1], Integer.parseInt(egyAllatAdat[2])));
                        break;
                    case "Pingvin":
                        allatokFile.add(new Pingvin(egyAllatAdat[0], egyAllatAdat[1], Integer.parseInt(egyAllatAdat[2])));
                        break;
                    case "Kigyo":
                        allatokFile.add(new Kigyo(egyAllatAdat[0], egyAllatAdat[1], Integer.parseInt(egyAllatAdat[2])));
                        break;
                    default:
                        System.out.println("Hiba: ismeretlen faj a fileban!");
                }

                sor = raf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Hiba: " + e.getMessage());
        }

        String userInput = "";
        Scanner scan = new Scanner(System.in);
        Allatkert allatok = new Allatkert(allatokFile);
        System.out.println("Udv az allatkertben!");
        System.out.println("    add allatNev allatFaj allatEletkor");
        System.out.println("    remove allatNev");
        System.out.println("    list (osszes allat kilistazasa)");
        System.out.println("    hangotAd (osszes allat hangot ad)");
        System.out.println("    gondozas (osszes allat gondozasa)");
        System.out.println("exit (exit)");
        do {
            userInput = scan.nextLine();

            switch (userInput.split(" ")[0]) {
                case "add":
                    if (userInput.split(" ").length == 4) {
                        String[] rawAllat = userInput.split(" ");
                        boolean toSave = true;

                        switch (rawAllat[2].strip().toLowerCase()) {
                            case "oroszlan":
                                allatok.addAllat(new Oroszlan(rawAllat[1], rawAllat[2], Integer.parseInt(rawAllat[3])));
                                break;
                            case "pingvin":
                                allatok.addAllat(new Pingvin(rawAllat[1], rawAllat[2], Integer.parseInt(rawAllat[3])));
                                break;
                            case "kigyo":
                                allatok.addAllat(new Kigyo(rawAllat[1], rawAllat[2], Integer.parseInt(rawAllat[3])));
                                break;
                            default:
                                toSave = false;
                                System.out.println("Hiba: ismeretlen faj!");
                                break;
                        }

                        if (toSave) {
                            try { //legyen a vegen
                                RandomAccessFile raf = new RandomAccessFile("allatok.txt", "rw");
                                raf.seek(raf.length());
                                raf.writeBytes(rawAllat[1] + ";" + rawAllat[2] + ";" + rawAllat[3] + "\n");
                                raf.close();
                                System.out.println("sikeres hozzaadas");
                            } catch (Exception e) {
                                System.out.println("Hiba: " + e.getMessage());
                            }
                        }
                    } else {
                        System.out.println("Hiba! (add allatNev allatFaj allatEletkor)");
                    }
                    break;

                case "list":
                    allatok.soutAllatok();
                    break;

                case "remove":
                    if (userInput.split(" ").length == 2) {
                        String[] rawAllat = userInput.split(" ");
                        allatok.removeAllatByName(rawAllat[1].strip());
                    } else {
                        System.out.println("Hiba! (remove allatNev)");
                    }
                    break;

                case "hangotAd":
                    allatok.getAllatok().forEach(Allat::hangotAd);
                    break;

                case "gondozas":
                    allatok.getAllatok().forEach(Allat::gondozas);
                    System.out.println("Az allatok gondozasa sikeres!");
                    break;

                case "exit": break;

                default:
                    System.out.println("hibas command!");
                    break;
            }

        } while (!userInput.equals("exit"));

        try {
            RandomAccessFile raf = new RandomAccessFile("allatok.txt", "rw");
            for (Allat a : allatok.getAllatok()) {
                System.out.println(a.toString());
                raf.writeBytes(a.getNev() + ";" + a.getFaj() + ";" + a.getEletkor() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Hiba: " + e.getMessage());
        }
        System.out.println("Az adatok mentese sikeres!");


    }
}
