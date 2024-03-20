public class Pogacsa extends Peksutemeny{

    public Pogacsa(int mennyiseg, int alapar) throws IllegalArgumentException {
        super(mennyiseg, alapar);
    }

    @Override
    public void megkostol() throws IllegalArgumentException {
        setMennyiseg(getMennyiseg() / 2);
    }

    @Override
    public String toString() {
        return "Pogacsa " + super.toString();
    }
}
