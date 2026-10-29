public class Car extends Vehicle {
    private final int passengerCount;
    public Car(String id, int passengerCount) {
        super(id, 500);
        if (passengerCount < 0) throw new IllegalArgumentException("Число пассажиров < 0");
        this.passengerCount = passengerCount;
    }
    public int getPassengerCount() { return passengerCount; }
    @Override public void move() {
        System.out.println("Легковой автомобиль " + getId() + " едет по дороге со скоростью 90 км/ч");
    }
}
