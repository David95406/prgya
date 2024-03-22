
public class Etel {
    private String nev;
    protected double kaloria;
    private boolean fogyszthato;

    public Etel(String nev, double kaloria) {
        setNev(nev);
        setKaloria(kaloria);
        setFogyszthato(true);
    }

    public String getNev() {
        return nev;
    }

    private void setNev(String nev) {
        this.nev = nev;
    }

    public double getKaloria() {
        return kaloria;
    }

    public void setKaloria(double kaloria) {
        if (kaloria < 0) {
            this.kaloria = 0;
        } else {
            this.kaloria = kaloria;
        }
    }

    public boolean isFogyszthato() {
        return fogyszthato;
    }

    public void setFogyszthato(boolean fogyszthato) {
        this.fogyszthato = fogyszthato;
    }

    @Override
    public String toString() {
        return getNev() + " (" + getKaloria() + " kalória), fogyasztható: " + (isFogyszthato() ? "igen" : "nem") + ".";
    }
}
