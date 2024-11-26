public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("gas");
        Car mercedes = new Car("diesel");
        Bicycle kerekpar = new Bicycle(false);
        Bus tbusz = new Bus(67);

        TransportManager garazs = new TransportManager();
        garazs.addVehicle(bmw);
        garazs.addVehicle(mercedes);
        garazs.addVehicle(kerekpar);
        garazs.addVehicle(tbusz);

        garazs.listAllVehicles();
        garazs.startAllVehicles();
    }
}