public class Torta {
    private int emeletekSzama;
    private boolean isKremes;
    private String alak;

    public void ujEmelet() {
        setEmeletekSzama(getEmeletekSzama() + 1);
    }

    public void kremmelMegken() throws TortaException {
        if (isKremes()) {
            throw new TortaException("A torta mar kremes!");
        }
        setKremes(true);
    }

    public int mennyiKaloria() {
        if (isKremes()) {
          return (getEmeletekSzama() * 1000) * 2;
        }
        return getEmeletekSzama() * 1000;
    }

    public Torta(int emeletekSzama, boolean isKremes, String alak) throws IllegalArgumentException {
        this.setEmeletekSzama(emeletekSzama);
        this.setKremes(isKremes);
        this.setAlak(alak);
    }

    public Torta() throws IllegalArgumentException {
        this(1, false, "kör");
    }

    @Override
    public String toString() {
        return "{" + getAlak() + ";" + getEmeletekSzama() + ";" + isKremes() + "}";
    }

    public int getEmeletekSzama() {
        return emeletekSzama;
    }

    public void setEmeletekSzama(int emeletekSzama) throws IllegalArgumentException {
        if (emeletekSzama <= 0) {
            throw new IllegalArgumentException("Az emeletek szama nem lehet 0 vagy negativ szam!");
        }
        this.emeletekSzama = emeletekSzama;
    }

    public boolean isKremes() {
        return isKremes;
    }

    public void setKremes(boolean kremes) {
        isKremes = kremes;
    }

    public String getAlak() {
        return alak;
    }

    public void setAlak(String alak) throws IllegalArgumentException {
        if (alak.length() == 0) {
            throw new IllegalArgumentException("A torta alakjat kotelezo megadni!");
        }
        this.alak = alak;
    }
}
