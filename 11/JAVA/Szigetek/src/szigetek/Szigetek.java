package szigetek;

import java.util.List;
import java.util.ArrayList;

public class Szigetek {

    public static int[] szigetList() {
        int[] adatok = {0, 0, 200, 548, 20, 0, 0, 0, 310, 980, 1280, 650, 102, 0, 0, 45, 0, 21, 65, 0, 0};
        return adatok;
    }

    public static ArrayList<ArrayList<Integer>> szigetekList() {
        ArrayList<ArrayList<Integer>> szigetek = new ArrayList<>();
        ArrayList<Integer> sziget = new ArrayList<>();
        int i = 0;

        while (szigetek.size() != szigetSzam()) {
            if (szigetList()[i] == 0) {
                i++;
            } else {
                while (szigetList()[i] != 0) {
                    sziget.add(szigetList()[i]);
                    i++;
                }

                szigetek.add(sziget);
                sziget = new ArrayList<>();
            }
            
        }

        System.out.println(szigetek);
        return szigetek;
    }

    public static int szigetSzam() {
        int szigetek = 0, i;

        for (i = 0; i < szigetList().length; i++) {
            if (szigetList()[i] == 0) {
                if (i > 0 && szigetList()[i - 1] > 0) {
                    szigetek++;
                }
            }
        }

        return szigetek;
    }

    public static void jobb_balPart() {
        int i;
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int width;

        for (i = 0; i < szigetList().length; i++) {
            if (szigetList()[i] == 0) {
                if (i > end) {
                    width = end - start;
                    if (width > (maxEnd - maxStart)) {
                        maxStart = start;
                        maxEnd = end;
                    }
                }
                start = i + 1;
                end = i + 1;
            } else {
                end = i;
            }
        }

        width = end - start;
        if (width > (maxEnd - maxStart)) {
            maxStart = start;
            maxEnd = end;
        }

        System.out.println("Bal: " + maxStart);
        System.out.println("Jobb:" + maxEnd);
    }

    public static boolean egyformaSziget() {
        int i;
        List<int[]> islands = new ArrayList<>();

        for (i = 0; i < szigetList().length; i++) {

        }

        return false;
    }

    public static void maxEmelkedo() {
        int biggestElevationChange = 0, kezdes = 0, vege = 0;

        for (int i = 0; i < szigetList().length - 1; i++) {
            int elevationChange = szigetList()[i + 1] - szigetList()[i];
            if (elevationChange > biggestElevationChange) {
                biggestElevationChange = elevationChange;
                kezdes = i;
                vege = i + 1;
            }
        }

        System.out.println("Legnagyobb elemlkedő: " + biggestElevationChange);
        System.out.println(kezdes + " " + vege);
        System.out.println(szigetList()[kezdes]);
        System.out.println("A legnagyobb emelkedo " + kezdes + " és " + vege + " között van. " + szigetList()[kezdes] + " " + szigetList()[vege]);
    }

    public static int legmagasabbPont() {
        int maxM = 0;

        for (int i = 0; i < szigetList().length; i++) {
            if (szigetList()[i] > maxM) {
                maxM = szigetList()[i];
            }
        }

        return maxM;
    }

    public static boolean van_e_volgy() {
        int volgy, maxVolgy = 0;

        for (int i = 0; i < szigetList().length - 2; i++) {
            if (szigetList()[i + 1] < szigetList()[i] && szigetList()[i] < szigetList()[i + 2]) {
                volgy = szigetList()[i] - szigetList()[i + 1];
                if (volgy > maxVolgy) {
                    maxVolgy = volgy;
                }
            }
        }

        if (maxVolgy == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int elsoSziget() {
        int i = 0;
        
        while (szigetList()[i] == 0) {
            i++;
        }
        return i + 1;
    }
    
    public static int legnagyobbSziget() {
        int maxLength = 0;
        
        for (int i = 0; i < szigetekList().size(); i++) {
            if (szigetekList().get(i).size() > maxLength) {
                maxLength = szigetekList().get(i).size();
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        szigetekList();
        System.out.println(egyformaSziget());
        maxEmelkedo();
        System.out.println(legmagasabbPont());
        System.out.println("Szigetek száma: " + szigetSzam());
        System.out.println("Van e völgy? " + van_e_volgy());
        System.out.println("Az elso sziget kezdodik: " + elsoSziget());

    }

}
