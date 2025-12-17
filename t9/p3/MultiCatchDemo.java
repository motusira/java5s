import java.io.*;

public class MultiCatchDemo {

    // Исключения для демонстрации иерархии
    static class Ex1 extends Exception {
        public Ex1(String msg) { super(msg); }
    }

    static class Ex2 extends Ex1 {
        public Ex2(String msg) { super(msg); }
    }

    static class Ex3 extends Ex2 {
        public Ex3(String msg) { super(msg); }
    }

    public static void main(String[] args) {
        // Ситуация 1: несколько исключений обрабатываются одинаково
        try {
            if (Math.random() > 0.5) {
                throw new IOException("Ошибка ввода-вывода");
            } else {
                throw new FileNotFoundException("Файл не найден");
            }
        } catch (IOException | FileNotFoundException e) {
            // Оба исключения обрабатываются одинаково
            System.out.println("Обработка ошибки ввода-вывода: " + e.getMessage());
        }

        // Ситуация 2: иерархия исключений - обработка через отдельные catch-блоки
        // Важно: более специфичные исключения (подклассы) должны идти раньше общих
        try {
            // Генерируем исключение самого "глубокого" типа
            throw new Ex3("Исключение Ex3");
        } catch (Ex3 e) {
            System.out.println("Поймано Ex3: " + e.getMessage());
        } catch (Ex2 e) {
            System.out.println("Поймано Ex2: " + e.getMessage());
        } catch (Ex1 e) {
            System.out.println("Поймано Ex1: " + e.getMessage());
        }

        // Попытка использовать multi-catch с исключениями из одной иерархии - ОШИБКА КОМПИЛЯЦИИ:
        /*
        try {
            throw new Ex3("Тест");
        } catch (Ex2 | Ex3 e) {  // ОШИБКА: Ex3 является подклассом Ex2
            System.out.println(e.getMessage());
        }
        */
    }
}
