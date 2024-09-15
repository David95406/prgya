package com.example.pizzeriaalap;

public class PizzaSima extends Pizza implements iPizza {

    public PizzaSima(int meret, String megnevezes) {
        super(meret, megnevezes);
    }

    @Override
    public int getAr() throws IllegalArgumentException {
        switch (getMeret()) {
            case 22 -> {
                return HUSZONKETTOCMPIZZA;
            }
            case 32 -> {
                return HARMINCKETTOCMPIZZA;
            }
            case 45 -> {
                return NEGYVENOTCMPIZZA;
            }
            default -> {
                throw new IllegalArgumentException("Hibás méret!");
            }
        }
    }
}
