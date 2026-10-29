public class Truck extends Vehicle {
    private final boolean hasTrailer;
    public Truck(String id, double baseCapacityKg, boolean hasTrailer) {
        super(id, capacity(baseCapacityKg, hasTrailer));
        this.hasTrailer = hasTrailer;
    }
    private static double capacity(double base, boolean trailer) {
        if (!Double.isFinite(base) || base <= 0)
            throw new IllegalArgumentException("Базовая грузоподъёмность должна быть > 0");
        return base + (trailer ? 5000 : 0);
    }
    public boolean hasTrailer() { return hasTrailer; }
    @Override public void move() {
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }
}
