package com.example.pizzeriaalap;

public abstract class Pizza {
    private int meret; //lehet: 22, 32, 45
    private String megnevezes;

    public Pizza(int meret, String megnevezes) {
        setMeret(meret);
        setMegnevezes(megnevezes);
    }

    public abstract int getAr();

    @Override
    public String toString() {
        return "Pizza{" +
                "meret=" + getMeret() +
                ", megnevezes='" + getMegnevezes() + '\'' +
                '}';
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) throws IllegalArgumentException {
        //if (meret != 22 || meret != 32 || meret != 45) throw new IllegalArgumentException("Hibás méret!");
        this.meret = meret;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }
}
