import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileDemo {
    public static void main(String[] args) {
        String filename = "input.txt";

        // Создаём временный файл для демонстрации
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            writer.write("123 hello 45.67\nworld 89");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из текстового файла с помощью Scanner
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    System.out.println("Целое число: " + num);
                } else if (scanner.hasNextDouble()) {
                    double d = scanner.nextDouble();
                    System.out.println("Дробное число: " + d);
                } else {
                    String word = scanner.next();
                    System.out.println("Слово: " + word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        // Удалим временный файл
        new File(filename).delete();
    }
}
