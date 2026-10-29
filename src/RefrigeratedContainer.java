public class RefrigeratedContainer extends BaseCargo {
    private final double targetTemperature;
    public RefrigeratedContainer(String id, String name, double weight, double targetTemperature) {
        super(id, name, weight);
        if (!Double.isFinite(targetTemperature)) throw new IllegalArgumentException("Некорректная температура");
        this.targetTemperature = targetTemperature;
    }
    public double getTargetTemperature() { return targetTemperature; }
    @Override public String getType() { return "Рефрижератор (" + targetTemperature + " °C)"; }
}
