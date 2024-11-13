public class Kutya extends Allat {
    public Kutya(String nev) {
        super(nev);
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + ": Vau vau");
    }

    @Override
    public void eszik() {
        System.out.println(getNev() + " mohón eszik a tálból.");
    }
}
