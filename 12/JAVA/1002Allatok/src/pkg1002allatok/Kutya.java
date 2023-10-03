package pkg1002allatok;

public class Kutya extends Emlosok {
    private String nev;
    private boolean nem; // him-0 nosteny-1
    private String szin;
    private String mintazat;

    public Kutya(String nev, boolean nem, String szin, String mintazat, String faj, String torzs, String latinNev, int testtomeg) {
        super(faj, torzs, latinNev, testtomeg);
        this.nev = nev;
        this.nem = nem;
        this.szin = szin;
        this.mintazat = mintazat;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Név: " + nev + "\nNőstény: " + nem + "\nSzín: " + szin + "\nMinatazat: " + mintazat + "\nLatin név: " + super.latinNev + "\nTörzs: " + super.torzs + "\nFaj: " + super.faj + "\nTesttömeg: " + super.testtomeg + "kg");
    }

    public void ugat() {
        System.out.println(nev + ": Vau-vau");
    }
    
}
