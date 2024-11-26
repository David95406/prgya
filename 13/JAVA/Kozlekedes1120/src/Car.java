public class Car implements Vehicle {
    private String fuelType;
    private boolean isRunning;

    public Car(String fuelType) {
        setFuelType(fuelType);
        setRunning(false);
    }

    @Override
    public void start() {
        setRunning(true);
        System.out.println("Az auto elindult");
    }

    @Override
    public void stop() {
        setRunning(false);
        System.out.println("Az auto megallt");
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelType='" + getFuelType() + '\'' +
                ", isRunning=" + isRunning() +
                '}';
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}