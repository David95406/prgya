public class Bus implements Vehicle {
    private int capacity;
    private boolean isRunning;

    public Bus(int capacity) {
        setCapacity(capacity);
        setRunning(false);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + getCapacity() +
                ", isRunning=" + isRunning() +
                '}';
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void start() {
        setRunning(true);
        System.out.println("A busz elindult");
    }

    @Override
    public void stop() {
        setRunning(false);
        System.out.println("A busz megallt");
    }

    @Override
    public String getType() {
        return "Busz";
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
