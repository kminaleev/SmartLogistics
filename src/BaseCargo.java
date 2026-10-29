public abstract class BaseCargo implements ICargo {
    private final String id;
    private final String name;
    private final double weight;
    public BaseCargo(String id, String name, double weight) {
        if (id == null || id.isBlank() || name == null || name.isBlank())
            throw new IllegalArgumentException("Нужны id и название");
        if (!Double.isFinite(weight) || weight <= 0)
            throw new IllegalArgumentException("Вес должен быть > 0");
        this.id = id; this.name = name; this.weight = weight;
    }
    @Override public double getWeight() { return weight; }
    @Override public String getType() { return getClass().getSimpleName(); }
    public String getId() { return id; }
    public String getName() { return name; }
    @Override public String toString() {
        return getType() + " [" + id + "] " + name + ", " + weight + " кг";
    }
}
