public class Report<T> {
    private final T data;
    public Report(T data) { this.data = data; }
    public void printReport() {
        System.out.println("Тип данных: " + (data == null ? "null" : data.getClass().getSimpleName()));
        System.out.println("Содержимое: " + data);
    }
}
