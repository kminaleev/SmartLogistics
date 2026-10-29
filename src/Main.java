public class Main {
    public static void main(String[] args) {
        Car car = new Car("C-1", 4);
        Truck truck = new Truck("T-1", 10000, true);
        Drone drone = new Drone("D-1", 100);
        car.load(100); truck.load(12000); drone.load(5); drone.load(1);
        for (Vehicle v : java.util.List.of(car, truck, drone)) {
            System.out.println(v.getId() + ": " + v.getCurrentLoadKg() + "/" + v.getMaxCapacityKg() + " кг");
            v.move();
        }
    }
}
