import java.util.List;
public class Main {
    public static void main(String[] args) {
        Car car = new Car("C-1", 4);
        Truck truck = new Truck("T-1", 10000, true);
        Drone drone = new Drone("D-1", 100);
        car.load(100);
        truck.load(new CargoItem("Оборудование", 2000));
        truck.load(List.of(new CargoItem("Коробка 1", 20), new CargoItem("Коробка 2", 30)));
        drone.load(new CargoItem("Посылка", 5));
        drone.load(1); // Лимит превышен: текущая загрузка остаётся 5 кг.
        for (Vehicle v : List.of(car, truck, drone))
            System.out.println(v.getId() + ": " + v.getCurrentLoadKg() + " кг, грузов: " + v.getCargoList().size());
        new FleetManager().startDelivery(List.of(car, truck, drone));
        drone.move();
        System.out.println("Заряд после двух перемещений: " + drone.getBatteryLevel() + "%");
    }
}
