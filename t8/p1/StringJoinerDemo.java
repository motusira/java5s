import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        // Пример 1: простой StringJoiner с разделителем
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("яблоки");
        sj1.add("бананы");
        sj1.add("апельсины");
        System.out.println("StringJoiner 1: " + sj1.toString()); // яблоки, бананы, апельсины

        // Пример 2: с префиксом и суффиксом
        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("красный");
        sj2.add("зелёный");
        sj2.add("синий");
        System.out.println("StringJoiner 2: " + sj2.toString()); // [красный, зелёный, синий]

        // Пример 3: объединение с другими коллекциями (например, через Stream)
        // String result = list.stream().collect(Collectors.joining(", "));
        // StringJoiner - основа для таких операций
    }
}
