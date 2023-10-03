package pkg1002allatok;

public class Emlosok extends Gerincesek{
    String faj;

    public Emlosok(String faj, String torzs, String latinNev, int testtomeg) {
        super(torzs, latinNev, testtomeg);
        this.faj = faj;
    }

    @Override
    public void displayInfo() {
        System.out.println("Latin név: " + super.latinNev + "\nTörzs: " + super.torzs + "\nFaj: " + faj + "\nTesttömeg: " + super.testtomeg + "kg");
    }
    
    public void eszik() {
        System.out.println(faj + " eszik");
    }
}
