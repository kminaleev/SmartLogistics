public abstract class Vehicle {
    private final String id;
    private final double maxCapacityKg;
    private double currentLoadKg;

    public Vehicle(String id, double maxCapacityKg) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Пустой id");
        if (!Double.isFinite(maxCapacityKg) || maxCapacityKg <= 0)
            throw new IllegalArgumentException("Грузоподъёмность должна быть > 0");
        this.id = id;
        this.maxCapacityKg = maxCapacityKg;
    }
    public abstract void move();
    public void load(double weight) {
        if (!Double.isFinite(weight) || weight <= 0)
            throw new IllegalArgumentException("Вес должен быть положительным");
        if (weight <= maxCapacityKg - currentLoadKg) currentLoadKg += weight;
        else System.out.println("Превышен лимит загрузки для " + id);
    }
    public String getId() { return id; }
    public double getMaxCapacityKg() { return maxCapacityKg; }
    public double getCurrentLoadKg() { return currentLoadKg; }
}
