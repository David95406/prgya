public class Godor {
    private int dip;

    public Godor(int dip) {
        this.setDip(dip);
    }

    public String toString() {
        return ""+ getDip();
    }

    public int getDip() {
        return dip;
    }

    public void setDip(int dip) {
        this.dip = dip;
    }
}
