import java.io.*;

// Практика #2: пример использования FileOutputStream (подкласс OutputStream)
public class OutputStreamDemo {
    public static void main(String[] args) {
        String filename = "test_output.txt";

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            // write(int b) записывает младший байт аргумента
            fos.write('H'); // 72
            fos.write('e'); // 101
            fos.write('l'); // 108
            fos.write('l'); // 108
            fos.write('o'); // 111
            fos.write('\n'); // новая строка
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проверим результат
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Записано в файл: " + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(filename).delete();
    }
}
