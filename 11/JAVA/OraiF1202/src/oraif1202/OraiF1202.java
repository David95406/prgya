package oraif1202;

import java.util.ArrayList;
import java.util.Collections;

public class OraiF1202 {

    public static int ketLegnagyobb(ArrayList<Integer> lista) {
        Collections.sort(lista);
        return lista.get(lista.size() - 2);
    }

    public static boolean tombCompare(ArrayList<Integer> tomb1, ArrayList<Integer> tomb2) {
        int i, ell = 0;

        if (tomb1.size() == tomb2.size()) {
            for (i = 0; i < tomb1.size(); i++) {
                if (tomb1.get(i).equals(tomb2.get(i))) {
                    ell++;
                }
            }
            System.out.println(ell + " " + tomb1.size());
            if (ell == tomb1.size()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> szamok = new ArrayList<Integer>(); //2, 4, 12, 3, 9, 15
        ArrayList<Integer> szamok2 = new ArrayList<Integer>();
        szamok.add(2); szamok.add(4); szamok.add(12); szamok.add(3); szamok.add(9); szamok.add(15);
        szamok2.add(2); szamok2.add(4); szamok2.add(12); szamok2.add(3); szamok2.add(9); szamok2.add(15);
            
        System.out.println(ketLegnagyobb(szamok));
        System.out.println(tombCompare(szamok, szamok2));
        System.out.println(szamok + "\n" +  szamok2);
    }

}
