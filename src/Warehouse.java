import java.util.ArrayList;
import java.util.List;
// T — вид груза, который хранит этот склад.
public class Warehouse<T extends ICargo> {
    private final List<T> items = new ArrayList<>();
    public void addItem(T item) {
        if (item == null) throw new IllegalArgumentException("Груз не задан");
        items.add(item);
    }
    public double getTotalWeight() {
        double sum = 0;
        for (T item : items) sum += item.getWeight();
        return sum;
    }
    public void printManifest() {
        for (T item : items) System.out.println(item.getType() + " — " + item.getWeight() + " кг");
    }
    @Override public String toString() {
        return "Warehouse: " + items + "; общий вес: " + getTotalWeight() + " кг";
    }
}
