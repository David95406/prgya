public class Film {
    private String cim;
    private String nyelv;
    private int hossz;

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getNyelv() {
        return nyelv;
    }

    public void setNyelv(String nyelv) {
        this.nyelv = nyelv;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        if (hossz > 0) {
            this.hossz = hossz;
        }
    }

    public Film(String cim, String nyelv, int hossz) {
        setCim(cim);
        setNyelv(nyelv);
        setHossz(hossz);
    }

    public Film(String cim, int hossz) {
        this(cim, "hu", hossz);
    }

    public int lengthToSec() {
        return getHossz() * 60;
    }

    public String toString() {
        return "A film cime: " + getCim() + "\nA film hossza: " + getHossz() + "perc, " + lengthToSec() + "mp" +
                "\nA film nyelve: " + getNyelv();
    }
}
