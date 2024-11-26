public class Bicycle implements  Vehicle {
    private boolean isElectric;
    private boolean isRunning;

    public Bicycle(boolean isElectric) {
        setElectric(isElectric);
        setRunning(false);
    }

    @Override
    public void start() {
        setRunning(true);
        System.out.println("A kerekpárt elindult");
    }

    @Override
    public void stop() {
        System.out.println("A kerékpár megallt");
    }

    @Override
    public String getType() {
        return "Kerékpár";
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "isElectric=" + isElectric() +
                ", isRunning=" + isRunning() +
                '}';
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
