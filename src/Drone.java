public class Drone extends Vehicle {
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
        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи: " + batteryLevel + "%");
        batteryLevel -= 5;
    }
}
