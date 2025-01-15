public class Oroszlan extends Allat implements Gondozhato {
    public Oroszlan(String nev, String faj, int eletkor) {
        super(nev, faj, eletkor);
    }

    @Override
    public String toString() {
        return "Oroszlan{" +
                "nev='" + getNev() + '\'' +
                ", faj='" + getFaj() + '\'' +
                ", eletkor=" + getEletkor() +
                '}';
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + "Rrrrr");
    }

    @Override
    public void eszik() {
        System.out.println("Eszik egy steaket.");
    }

    @Override
    public void gondozas() {
        eszik();
        System.out.println("Az oroszlan evett es ellenorive lett.");
    }
}
