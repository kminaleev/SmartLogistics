import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Car car = new Car("C-1", 4);
        Truck truck = new Truck("T-1", 10000, true);
        Drone drone = new Drone("D-1", 100);
        car.load(100);
        truck.load(new RefrigeratedContainer("R-1", "Продукты", 2000, -18));
        truck.load(List.of(new StandardBox("B-1", "Детали", 20), new FragileItem("F-1", "Стекло", 30, true)));
        drone.load(new StandardBox("B-2", "Посылка", 5));
        drone.load(1);
        for (ICargo item : truck.getCargoList()) System.out.println(item.getType() + ": " + item.getWeight() + " кг");
        List<ITrackable> tracked = new ArrayList<>();
        tracked.add(truck); tracked.add(drone);
        // tracked.add(car); // Ошибка компиляции: Car не реализует ITrackable.
        LogisticsCenter center = new LogisticsCenter();
        System.out.println("Координаты до движения");
        center.monitorFleet(tracked);
        new FleetManager().startDelivery(List.of(car, truck, drone));
        System.out.println("Статус после движения");
        center.dispatch(tracked);
        center.monitorFleet(tracked);
    }
}
