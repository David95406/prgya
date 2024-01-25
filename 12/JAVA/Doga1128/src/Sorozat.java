public class Sorozat {
    private String date;
    private String cim;
    private String resz;
    private int hossz;
    private int lattaE;

    public Sorozat(String date, String cim, String resz, int hossz, int lattaE) {
        this.date = date;
        this.cim = cim;
        this.resz = resz;
        this.hossz = hossz;
        this.lattaE = lattaE;
    }

    @Override
    public String toString() {
        return "Sorozat{" +
                "date='" + date + '\'' +
                ", cim='" + cim + '\'' +
                ", resz='" + resz + '\'' +
                ", hossz=" + hossz +
                ", lattaE=" + lattaE +
                '}' + "\n";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getResz() {
        return resz;
    }

    public void setResz(String resz) {
        this.resz = resz;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public int getLattaE() {
        return lattaE;
    }

    public void setLattaE(int lattaE) {
        this.lattaE = lattaE;
    }
}
