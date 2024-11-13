public class Medve extends Allat {
    public Medve(String nev) {
        super(nev);
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + ": Brum brum");
    }

    @Override
    public void eszik() {
        System.out.println(getNev() + " keményen eszik a tálból.");
    }
}
