public class Macska extends Allat {

    public Macska(String nev) {
        super(nev);
    }

    @Override
    public void hangotAd() {
        System.out.println(getNev() + ": Miau miau");
    }

    @Override
    public void eszik() {
        System.out.println(getNev() + " óvatosan eszik a tálból.");
    }
}
