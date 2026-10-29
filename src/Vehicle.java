import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private final String id;
    private final double maxCapacityKg;
    private double currentLoadKg;
    private final List<ICargo> cargoList = new ArrayList<>();

    public Vehicle(String id, double maxCapacityKg) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Пустой id");
        if (!Double.isFinite(maxCapacityKg) || maxCapacityKg <= 0)
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        this.id = id;
        this.maxCapacityKg = maxCapacityKg;
    }
    public abstract void move();
    // Все перегрузки используют одну проверку и единое хранилище грузов.
    public void load(double weight) { load(new StandardBox(java.util.UUID.randomUUID().toString(), "Безымянный груз", weight)); }
    public void load(ICargo item) { load(List.of(item)); }
    public void load(List<ICargo> items) {
        if (items == null) throw new IllegalArgumentException("Список не задан");
        List<ICargo> batch = new ArrayList<>(items);
        double sum = 0;
        for (ICargo item : batch) {
            if (item == null || !Double.isFinite(item.getWeight()) || item.getWeight() <= 0)
                throw new IllegalArgumentException("Недопустимый груз");
            sum += item.getWeight();
        }
        if (!Double.isFinite(sum) || sum > maxCapacityKg - currentLoadKg) {
            System.out.println("Превышен лимит загрузки для " + id);
            return;
        }
        cargoList.addAll(batch);
        currentLoadKg += sum;
    }
    public List<ICargo> getCargoList() { return List.copyOf(cargoList); }
    public String getId() { return id; }
    public double getMaxCapacityKg() { return maxCapacityKg; }
    public double getCurrentLoadKg() { return currentLoadKg; }
}
