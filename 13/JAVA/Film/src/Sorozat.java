public class Sorozat extends Film implements iFilm {
    private int epizodokSzama;

    public Sorozat(String magyarCim, String rendezo, int jatekido, int epizodokSzama) {
        super(magyarCim, rendezo, jatekido);
        this.epizodokSzama = epizodokSzama;
    }

    public Sorozat(String magyarCim, String rendezo, int jatekido) {
        this(magyarCim, rendezo, jatekido, MINISOROZAT_RESZ_SZAM);
    }

    @Override
    public String getHossz() { //, sorozat esetén számoljuk ki az évad részeinek együttes hosszát
        int osszHossz = getJatekido() * getEpizodokSzama();
        String hosszString = (osszHossz / 60) + ":" + (osszHossz - ((osszHossz / 60) * 60));
        if (hosszString.split(":")[0].length() == 1) {
            hosszString = "0" + hosszString;
        }
        if (hosszString.split(":")[1].length() == 1) {
            hosszString = hosszString.split(":")[0] + ":0" + hosszString.split(":")[1];
        }
        return hosszString;
    }

    @Override
    public String toString() {
        return "Sorozat{" + super.toString() +
                "epizodokSzama=" + epizodokSzama +
                '}';
    }

    public int getEpizodokSzama() {
        return epizodokSzama;
    }

    public void setEpizodokSzama(int epizodokSzama) {
        this.epizodokSzama = epizodokSzama;
    }
}
