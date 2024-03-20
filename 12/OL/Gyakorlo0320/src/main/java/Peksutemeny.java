public abstract class Peksutemeny implements Arlap {
    protected int mennyiseg;
    private int alapar;

    public Peksutemeny(int mennyiseg, int alapar) throws IllegalArgumentException {
        setMennyiseg(mennyiseg);
        setAlapar(alapar);
    }

    public abstract void megkostol();

    @Override
    public int mennyibeKerul() {
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

    public int getAlapar() {
        return alapar;
    }

    private void setAlapar(int alapar) throws IllegalArgumentException {
        if (alapar < 0) throw new IllegalArgumentException("Az alapar nem lehet kisebb 0-nal!");
        this.alapar = alapar;
    }
}
