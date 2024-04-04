public class Kave implements Arlap {
    private boolean habosE;

    public Kave(boolean habosE) {
        setHabosE(habosE);
    }

    @Override
    public double mennyibeKerul() {
        return isHabosE() ? (CSESZEKAVE * 1.5) : CSESZEKAVE;
    }

    @Override
    public String toString() {
        return (isHabosE() ? "Habos" : "Nem habos") + " kave - " + mennyibeKerul() + " Ft";
    }

    public boolean isHabosE() {
        return habosE;
    }

    private void setHabosE(boolean habosE) {
        this.habosE = habosE;
    }
}
