public abstract class Peksutemeny implements Arlap {
    protected int mennyiseg;
    private double alapar;

    public Peksutemeny(int mennyiseg, double alapar) throws IllegalArgumentException {
        setMennyiseg(mennyiseg);
        setAlapar(alapar);
    }

    public abstract void megkostol();

    @Override
    public double mennyibeKerul() {
        return getAlapar() * getMennyiseg();
    }

    @Override
    public String toString() {
        return getMennyiseg() + "db - " + mennyibeKerul() + " Ft";
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    protected void setMennyiseg(int mennyiseg) throws IllegalArgumentException {
        if (mennyiseg <= 0) throw new IllegalArgumentException("A mennyiseg nem lehet 0 vagy annal kisebb!");
        this.mennyiseg = mennyiseg;
    }

    public double getAlapar() {
        return alapar;
    }

    private void setAlapar(double alapar) throws IllegalArgumentException {
        if (alapar < 0) throw new IllegalArgumentException("Az alapar nem lehet kisebb 0-nal!");
        this.alapar = alapar;
    }
}
