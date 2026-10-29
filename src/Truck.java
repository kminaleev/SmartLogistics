public class Truck extends Vehicle implements ITrackable {
    private double latitude;
    private double longitude;
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
        latitude += 0.001;
        longitude += 0.002;
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }

    @Override public String getCurrentCoordinates() {
        return String.format(java.util.Locale.ROOT, "lat=%.3f, lon=%.3f", latitude, longitude);
    }
    @Override public void sendStatusUpdate() {
        System.out.println(getId() + ": " + getCurrentCoordinates()
            + ", загрузка " + getCurrentLoadKg() + " кг");
    }
}
