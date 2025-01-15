public class Pingvin extends Allat implements Gondozhato {

    public Pingvin(String nev, String faj, int eletkor) {
        super(nev, faj, eletkor);
    }

    @Override
    public String toString() {
        return "Pingvin{" +
                "nev='" + getNev() + '\'' +
                ", faj='" + getFaj() + '\'' +
                ", eletkor=" + getEletkor() +
                '}';
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + "Háp háp");
    }

    @Override
    public void eszik() {
        System.out.println("Eszik egy halat.");
    }


    @Override
    public void gondozas() {
        eszik();
        System.out.println("A pingvin evett es ellenorive lett.");
    }
}
