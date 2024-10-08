public class SzinesKor extends Kor {
    private String szin;

    public SzinesKor(double radius, double[] center, String szin) {
        super(radius, center);
        setSzin(szin);
    }

    @Override
    public String toString() {
        return "SzinesKor{" + this.toString() +
                "szin='" + szin + '\'' +
                '}';
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }
}
