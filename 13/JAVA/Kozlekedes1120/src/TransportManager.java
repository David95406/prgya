import java.util.ArrayList;
import java.util.List;

public class TransportManager {
    private ArrayList<Vehicle> jarmuvek;

    public TransportManager() {
        this.jarmuvek = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.jarmuvek.add(vehicle);
    }
    public void listAllVehicles() {
        System.out.println("{ " + jarmuvek + " }");
    }
    public void startAllVehicles() {
        for (Vehicle v : jarmuvek) {
            v.start();
        }
    }
}
