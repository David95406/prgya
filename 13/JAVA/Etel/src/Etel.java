public class Etel {
    private String etelNeve;
    private int kaloriakSzama;
    private boolean isFogyaszthato;

    public Etel(String etelNeve, int kaloriakSzama) {
        setEtelNeve(etelNeve);
        setKaloriakSzama(kaloriakSzama);
        setFogyaszthato(true);
    }

    @Override
    public String toString() {
        return getEtelNeve() + " (" + getKaloriakSzama() + " kalória), fogyasztható: " + (isFogyaszthato ? "igen" : "nem") + ".";
    }

    public String getEtelNeve() {
        return etelNeve;
    }

    public void setEtelNeve(String etelNeve) {
        this.etelNeve = etelNeve;
    }

    public int getKaloriakSzama() {
        return kaloriakSzama;
    }

    public void setKaloriakSzama(int kaloriakSzama) {
        this.kaloriakSzama = Math.max(kaloriakSzama, 0);
    }

    public boolean isFogyaszthato() {
        return isFogyaszthato;
    }

    public void setFogyaszthato(boolean fogyaszthato) {
        isFogyaszthato = fogyaszthato;
    }
}
