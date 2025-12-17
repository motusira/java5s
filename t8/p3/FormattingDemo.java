import java.util.Date;
import java.util.Formatter;

public class FormattingDemo {
    public static void main(String[] args) {
        // Практика #1: примеры пяти спецификаторов формата

        boolean flag = true;
        char ch = 'A';
        int number = 42;
        double pi = 3.14159;
        String text = "Hello";

        // Использование System.out.printf (внутри использует Formatter)
        System.out.printf("Логическое: %b%n", flag);
        System.out.printf("Символ: %c%n", ch);
        System.out.printf("Целое: %d%n", number);
        System.out.printf("Число с плавающей точкой: %.3f%n", pi);
        System.out.printf("Строка: %s%n", text);

        // Практика #3: форматирование даты и времени
        Date now = new Date();

        System.out.printf("Текущий час (24ч): %tH%n", now);
        System.out.printf("Текущий час (12ч): %tI%n", now);
        System.out.printf("Минуты: %tM%n", now);
        System.out.printf("Год (4 цифры): %tY%n", now);
        System.out.printf("Полное название месяца: %tB%n", now);

        // Практика #2: зачем нужен метод flush()?
        // При использовании Formatter с потоками (например, FileWriter или System.out)
        // данные могут сначала записываться во внутренний буфер, а не сразу в целевой выход.
        // Метод flush() принудительно сбрасывает буфер, гарантируя, что все данные записаны.
        // Это особенно важно при работе с файлами или сетевыми потоками, чтобы избежать потери данных
        // в случае аварийного завершения программы до автоматической записи.

        // Пример с явным Formatter
        Formatter formatter = new Formatter(System.out);
        formatter.format("Явный Formatter: число = %d, строка = %s%n", 100, "test");
        formatter.flush(); // гарантирует, что вывод отправлен в System.out
        formatter.close();
    }
}
