package objektumlista;

import java.util.ArrayList;

public class ObjektumLista {

    public static void main(String[] args) {
        Eredmeny peter = new Eredmeny("Péter", "zöld", "9", 200);
        Eredmeny geza = new Eredmeny("Géza", "WOW", "10", 1590);
        Eredmeny lena = new Eredmeny("Léna", "fekete", "11", 1298);
        Eredmeny gaspar = new Eredmeny("Gáspár", "piros", "11", 784);
        
        ArrayList<Eredmeny> eredmenyek = new ArrayList<>();
        eredmenyek.add(peter);
        eredmenyek.add(geza);
        eredmenyek.add(lena);
        eredmenyek.add(gaspar);
        
        System.out.println("Jelöltek száma: " + eredmenyek.size());
        int osszesSzavazat = 0;
        int szavazatok = 0;
        int ezerSzavazat = 0;
        String atlagAlatt = "";
        String WOWPartJelolt = "";
        String aNevVege = "";
        for (Eredmeny eredmeny : eredmenyek) {
            szavazatok += eredmeny.getSzavazatSzam();
            osszesSzavazat += eredmeny.getSzavazatSzam();
            if (eredmeny.getSzavazatSzam() > 1000) {
                ezerSzavazat++;
            }
            if ("WOW".equals(eredmeny.getPart())) {
                WOWPartJelolt = eredmeny.getNev();
            }
        }
        for (Eredmeny eredmeny : eredmenyek) {
            if (eredmeny.getSzavazatSzam() < (osszesSzavazat / eredmenyek.size())) {
                atlagAlatt += eredmeny.getNev() + ",";
            }
            if ("a".equals(String.valueOf(eredmeny.getNev().charAt(eredmeny.getNev().length() - 1)))) {
                aNevVege += eredmeny.getNev() + ",";
            }
        }
        System.out.println("Összes szavazat: " + szavazatok);
        System.out.println("Ezernel tobb szavazatos jeloltek szama: " + ezerSzavazat);
        System.out.println("WOW párt jelöltje: " + WOWPartJelolt);
        System.out.println("Atlag alatti jeloltek: " + atlagAlatt);
        System.out.println("A betuvel vegzodo jeloltek: " + aNevVege);
    }
    
}
