public class CargoItem {
    private final String name;
    private final double weight;
    public CargoItem(String name, double weight) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Пустое название");
        if (!Double.isFinite(weight) || weight <= 0)
            throw new IllegalArgumentException("Вес должен быть положительным");
        this.name = name; this.weight = weight;
    }
    public String getName() { return name; }
    public double getWeight() { return weight; }
}
