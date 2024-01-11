package org.example;

public class Szamitogep {
    private double szabadMemoria;
    private boolean isTurnOn;
    private double osszesMemoria;

    public Szamitogep(double szabadMemoria, boolean isTurnOn) throws IllegalArgumentException {
        this.setSzabadMemoria(szabadMemoria);
        this.setTurnOn(isTurnOn);
        this.setOsszesMemoria(szabadMemoria);
    }

    public Szamitogep() {
        this(8192, false);
        setOsszesMemoria(8192);
    }

    @Override
    public String toString() {
        return "[" + getOsszesMemoria() + "MN, " + getOsszesMemoria() + ", " +
                getSzabadMemoria() + "MB, " + isTurnOn() + "]";
    }

    public void programMasol(double size) throws ComputerMemoryException, IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("A program merete nem lehet 0 vagy kisebb!");
        }
        if (size <= getSzabadMemoria() && isTurnOn()) {
            setSzabadMemoria(getSzabadMemoria() - size);
        } else if (!isTurnOn()) {
            throw new ComputerMemoryException("Elsonek kapcsolja be a gepet!");
        } else {
            throw new ComputerMemoryException("Nincs eleg memoria!");
        }
    }

    public void kapcsol() {
        if (!isTurnOn()) {
            setTurnOn(true);
        } else {
            setTurnOn(false);
        }
    }

    public double getOsszesMemoria() {
        return osszesMemoria;
    }

    private void setOsszesMemoria(double osszesMemoria) throws IllegalArgumentException {
        this.osszesMemoria = osszesMemoria;
    }

    public double getSzabadMemoria(){
        return szabadMemoria;
    }

    private void setSzabadMemoria(double szabadMemoria) throws IllegalArgumentException {
        this.szabadMemoria = szabadMemoria;
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public void setTurnOn(boolean turnOn) {
        isTurnOn = turnOn;
    }
}
