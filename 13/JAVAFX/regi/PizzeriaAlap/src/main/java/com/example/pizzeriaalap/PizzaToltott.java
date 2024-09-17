package com.example.pizzeriaalap;

public class PizzaToltott extends Pizza implements iPizza {
    private String toltelek;

    public PizzaToltott(int meret, String megnevezes, String toltelek) {
        super(meret, megnevezes);
        setToltelek(toltelek);
    }

    @Override
    public int getAr() throws IllegalArgumentException {
        switch (getMeret()) {
            case 22 -> {
                return HUSZONKETTOCMPIZZA + TOLTOTTPIZZAFELAR;
            }
            case 32 -> {
                return HARMINCKETTOCMPIZZA + TOLTOTTPIZZAFELAR;
            }
            case 45 -> {
                return NEGYVENOTCMPIZZA + TOLTOTTPIZZAFELAR;
            }
            default -> {
                throw new IllegalArgumentException("Hibás méret!");
            }
        }
    }

    @Override
    public String toString() {
        return "PizzaToltott{" + super.toString() + '\'' +
                "toltelek='" + getToltelek() + '\'' +
                '}';
    }

    public String getToltelek() {
        return toltelek;
    }

    public void setToltelek(String toltelek) {
        this.toltelek = toltelek;
    }
}
