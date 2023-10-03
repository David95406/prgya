package pkg1002allatok;

public class Gerincesek{
    String torzs;
    String latinNev;
    int testtomeg;

    public String getLatinNev() {
        return latinNev;
    }

    public void setLatinNev(String latinNev) {
        this.latinNev = latinNev;
    }

    public int getTesttomeg() {
        return testtomeg;
    }

    public void setTesttomeg(int testtomeg) {
        this.testtomeg = testtomeg;
    }
    
    public String getTorzs() {
        return torzs;
    }

    public void setTorzs(String torzs) {
        this.torzs = torzs;
    }
    
    public void displayInfo() {
        System.out.println("Latin név: " + latinNev + "\nTörzs: " + torzs + "\nTesttömeg: " + testtomeg + "kg");
    }
    
    public Gerincesek(String torzs, String latinNev, int testtomeg) {
        this.torzs = torzs;
        this.latinNev = latinNev;
        this.testtomeg = testtomeg;
    }
}
