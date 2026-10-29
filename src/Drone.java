public class Drone extends Vehicle implements ITrackable {
    private double latitude;
    private double longitude;
    private double altitude;
    private int batteryLevel;
    public Drone(String id, int batteryLevel) {
        super(id, 5);
        if (batteryLevel < 0 || batteryLevel > 100)
            throw new IllegalArgumentException("Заряд должен быть от 0 до 100");
        this.batteryLevel = batteryLevel;
    }
    public int getBatteryLevel() { return batteryLevel; }
    @Override public void move() {
        if (batteryLevel < 5) {
            System.out.println("Дрон " + getId() + ": недостаточно заряда");
            return;
        }
        latitude += 0.001;
        longitude += 0.002;
        altitude = 50;
        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
        batteryLevel -= 5;
    }

    @Override public String getCurrentCoordinates() {
        return String.format(java.util.Locale.ROOT, "lat=%.3f, lon=%.3f, alt=%.1f м", latitude, longitude, altitude);
    }
    @Override public void sendStatusUpdate() {
        System.out.println(getId() + ": " + getCurrentCoordinates()
            + ", загрузка " + getCurrentLoadKg() + " кг" + ", заряд " + batteryLevel + "%");
    }
}
