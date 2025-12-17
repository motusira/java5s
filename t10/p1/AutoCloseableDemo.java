import java.io.*;

// Практика #4: интерфейс AutoCloseable
/*
Интерфейс AutoCloseable (введён в Java 7) позволяет автоматически закрывать ресурсы
(например, файлы, сокеты, потоки) с помощью конструкции try-with-resources.

Классы, реализующие AutoCloseable (например, все потоки ввода-вывода),
могут использоваться в try-блоке, и их метод close() будет вызван автоматически
при выходе из блока — даже если произошло исключение.

Это предотвращает утечки ресурсов и делает код короче и надёжнее.
*/

public class AutoCloseableDemo {
    public static void main(String[] args) {
        String filename = "auto_close_test.txt";

        // try-with-resources: FileOutputStream реализует AutoCloseable
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write("Тест".getBytes());
            // fos.close() вызовется автоматически
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Без try-with-resources пришлось бы использовать finally и проверять null
        new File(filename).delete();
    }
}
