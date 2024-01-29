public class Macska {
    private double testsuly;
    private boolean isEhes;

    public Macska(double testsuly, boolean isEhes) throws IllegalArgumentException {
        setTestsuly(testsuly);
        setEhes(isEhes);
    }

    public Macska(double testsuly) throws IllegalArgumentException {
        this(testsuly, true);
    }

    public void eszik(double etelSuly) throws MacskaException {
        if (etelSuly <= 0) {
            throw new IllegalArgumentException("Az etel sulya nem lehet negativ!");
        }
        if (!isEhes) {
            throw new MacskaException("A macsak nem ehes!");
        }

        setTestsuly(getTestsuly() + etelSuly);
        setEhes(false);

        /* (talan jo igy is)
        if (isEhes) {
            setEhes(false);
            setTestsuly(getTestsuly() + etelSuly);
        } else {
            throw new MacskaException("A macsak nem ehes!");
        }
         */
    }

    public void futkos() throws MacskaException {
        double ujSuly = getTestsuly() - 0.1;

        if (ujSuly <= 0.1 ) {
            throw new MacskaException("A macsaka mar nem tud futni!");
        }

        if (!isEhes) {
            setEhes(true);
        }
    }

    @Override
    public String toString() {
        return "Macska{" +
                "testsuly=" + getTestsuly() +
                ", isEhes=" + (isEhes() ? "Ehes" : "Nem ehes") +
                '}';
    }

    public double getTestsuly() {
        return testsuly;
    }

    public void setTestsuly(double testsuly) {
        if (testsuly <= 0) {
            this.testsuly = testsuly;
            throw new IllegalArgumentException("A macska súlya csak pozitiv szam lehet!");
        }
        this.testsuly = testsuly;
    }

    public boolean isEhes() {
        return isEhes;
    }

    public void setEhes(boolean isEhes) {
        this.isEhes = isEhes;
    }
}
