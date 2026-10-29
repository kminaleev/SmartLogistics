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
        Warehouse<StandardBox> boxes = new Warehouse<>();
        boxes.addItem(new StandardBox("B-3", "Книги", 10));
        boxes.addItem(new StandardBox("B-4", "Одежда", 15));
        Warehouse<FragileItem> fragile = new Warehouse<>();
        fragile.addItem(new FragileItem("F-2", "Ваза", 2, true));
        fragile.addItem(new FragileItem("F-3", "Бокалы", 3, true));
        // boxes.addItem(new FragileItem("F-X", "Стекло", 1, true));
        // Ошибка компиляции: addItem ожидает StandardBox, а FragileItem — другой
        // наследник BaseCargo. Общий интерфейс ICargo не делает их взаимозаменяемыми
        // внутри Warehouse<StandardBox>; ограничение T extends ICargo сохраняет T.
        System.out.println("Склад обычных коробок");
        boxes.printManifest();
        System.out.println("Общий вес: " + boxes.getTotalWeight() + " кг");
        System.out.println("Склад хрупких грузов");
        fragile.printManifest();
        System.out.println("Общий вес: " + fragile.getTotalWeight() + " кг");
        Report<Warehouse<StandardBox>> boxReport = new Report<>(boxes);
        Report<Warehouse<FragileItem>> fragileReport = new Report<>(fragile);
        boxReport.printReport();
        fragileReport.printReport();
    }
}
