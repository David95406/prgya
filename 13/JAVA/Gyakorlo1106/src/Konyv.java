public class Konyv {
    private String cim;
    private String szerzo;
    private int kiadasEve;
    private int oldalszam;

    public Konyv(String cim, String szerzo, int kiadasEve, int oldalszam) {
        setCim(cim);
        setSzerzo(szerzo);
        setKiadasEve(kiadasEve);
        setOldalszam(oldalszam);
    }

    public Konyv(String[] sor) {
        this(sor[0], sor[1], Integer.parseInt(sor[2]), Integer.parseInt(sor[3]));
    }

    @Override
    public String toString() {
        return "Konyv{" +
                "cim='" + getCim() + '\'' +
                ", szerzo='" + getSzerzo() + '\'' +
                ", kiadasEve=" + getKiadasEve() +
                ", oldalszam=" + getOldalszam() +
                '}';
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public int getKiadasEve() {
        return kiadasEve;
    }

    public void setKiadasEve(int kiadasEve) {
        this.kiadasEve = kiadasEve;
    }

    public int getOldalszam() {
        return oldalszam;
    }

    public void setOldalszam(int oldalszam) {
        this.oldalszam = oldalszam;
    }
}
