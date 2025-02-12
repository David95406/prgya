package com.vizsga.vizsgaproba.console;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    public static double distanceTo(double ax, double ay, double bx, double by) {
        return Math.sqrt(Math.pow((ax - bx), 2) + Math.pow((ay - by), 2));
    }

    public static void main(String[] args) {
        ArrayList<Ad> ads = Ad.loadFromCsv();
        System.out.println(ads);

        // 6. feladat
        int foldszintiIngatlanok = 0;
        double sum = 0;

        for (Ad ad : ads) {
            if (ad.getFloors() == 0) {
                foldszintiIngatlanok++;
                sum += ad.getArea();
            }
        }
        double foldszintiIngatlaokAtlagosATerulete = sum / foldszintiIngatlanok;
        System.out.println("1 Földszinti ingatlanok atlagos alapterulete: " + String.format("%,.2f", foldszintiIngatlaokAtlagosATerulete) + " m2");

        // 7. feladat
        Ad min = ads.get(0);
        double mesevarX = 47.4164220114023;
        double mesevarY = 19.066342425796986;

        for (Ad ad : ads) {
            if (distanceTo(ad.getCords()[0], ad.getCords()[1], mesevarX, mesevarY) <
                    distanceTo(min.getCords()[0], min.getCords()[1], mesevarX, mesevarY)) {
                min = ad;
            }
        }

        System.out.println("Mesevar ovodahoz legvonalban legkozelebbi tehermentes ingatlan adatai:");
        System.out.println("\tEladó neve        :  " + min.getSeller().getName());
        System.out.println("\tEladó telefonszáma:  " + min.getSeller().getPhone());
        System.out.println("\tAlapterulet       :  " + min.getArea());
        System.out.println("\tSzobak szama      :  " + min.getFloors());
    }
}
