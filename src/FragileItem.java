public class FragileItem extends BaseCargo {
    private final boolean requiresSpecialHandling;
    public FragileItem(String id, String name, double weight, boolean requiresSpecialHandling) {
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }
    public boolean isRequiresSpecialHandling() { return requiresSpecialHandling; }
    @Override public String getType() {
        return "Хрупкий груз (особое обращение: " + (requiresSpecialHandling ? "да" : "нет") + ")";
    }
}
