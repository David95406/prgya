public class Kigyo extends Allat implements Gondozhato {

    public Kigyo(String nev, String faj, int eletkor) {
        super(nev, faj, eletkor);
    }

    @Override
    public String toString() {
        return "Kigyo{" +
                "nev='" + getNev() + '\'' +
                ", faj='" + getFaj() + '\'' +
                ", eletkor=" + getEletkor() +
                '}';
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + "Szsssss");
    }

    @Override
    public void eszik() {
        System.out.println("Eszik egy egeret.");
    }


    @Override
    public void gondozas() {
        eszik();
        System.out.println("A kigyo evett es ellenorive lett.");
    }
}
