package oraif0110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class OraiF0110 {

    public static int szigetek() {
        int[] meres = {0,0,200,548,20,0,0,0,310,980,1280,650,102,0,0,45,0,21,65,0,0};
        int islandCount = 0;

        for (int i = 1; i < meres.length; i++) {
            if (meres[i-1] == 0 && meres[i] > 0) {
                islandCount++;
            }
        }

        return islandCount;
    }
    
    public static int legmagasabbPont() {
        int[] meres = {0,0,200,548,20,0,0,0,310,980,1280,650,102,0,0,45,0,21,65,0,0};
        int biggestElement = 0;
        
        for (int i = 0; i < meres.length; i++) {
            if (meres[i] > biggestElement) {
                biggestElement = meres[i];
            }
        }
        
        return biggestElement;
    }

    public static void maxEmelkedo() {
        int[] meres = {0,0,200,548,20,0,0,0,310,980,1280,650,102,0,0,45,0,21,65,0,0};
    int biggestElevationChange = 0;

    for (int i = 0; i < meres.length-1; i++) {
        int elevationChange = meres[i+1] - meres[i];
        if (elevationChange > biggestElevationChange) {
            biggestElevationChange = elevationChange;
        }
    }
    System.out.println("Biggest elevation change: " + biggestElevationChange);

    }

    public static boolean egyformaSziget() {
        List<Integer> meres = new ArrayList<>(Arrays.asList(0, 0, 200, 548, 20, 0, 0, 0, 310, 980, 1280, 650, 102, 0, 0, 45, 0, 21, 65, 0, 0));
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int width = 0;
        boolean egyforma;

        for (int i = 0; i < meres.size(); i++) {
            if (meres.get(i) == 0) {
                if (i > end) {
                    for (int j = start; j < end; j++) {
                        if (meres.get(j) == (end - start)) {
                            egyforma = true;
                            break;
                        }
                    }
                }
                start = i + 1;
                end = i + 1;
            } else {
                end = i;
            }
        }

        egyforma = false;

        if (egyforma) {
            return true;
        } else {
            return false;
        }
    }

    public static void jobb_balPart() {
        List<Integer> meres = new ArrayList<>(Arrays.asList(0, 0, 200, 548, 20, 0, 0, 0, 310, 980, 1280, 650, 102, 0, 0, 45, 0, 21, 65, 0, 0));

        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int width = 0;

        for (int i = 0; i < meres.size(); i++) {
            if (meres.get(i) == 0) {
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

    public static void main(String[] args) {
        jobb_balPart();
        szigetek();
        System.out.println(legmagasabbPont());
        maxEmelkedo();
    }

}
