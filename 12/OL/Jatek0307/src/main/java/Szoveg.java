public class Szoveg implements Feldolgozo {
    private String value;

    public Szoveg(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Szoveg{" +
                "value='" + getValue() + '\'' +
                '}';
    }

    public String atalakit(int userSORHOSSZ) throws IllegalArgumentException {
        if (userSORHOSSZ <= 0) throw new IllegalArgumentException("A parameternek nagyobbnak kell lennie 0-nal!");

        String returnValue = "";
        for (int i = 0; i < getValue().length(); i++) {
            returnValue += getValue().charAt(i);
            if (i != 0 && (i + 1) % (userSORHOSSZ) == 0) {
                returnValue += "\n";
            }
        }
        return returnValue;
    }

    public String atalakit() {
        return atalakit(Feldolgozo.SORHOSSZ);
    }

    void tisztit() {
        setValue(getValue().trim().toLowerCase());
    }
}
