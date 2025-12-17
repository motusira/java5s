import java.io.*;

// Практика #1: пример использования FileInputStream (подкласс InputStream)
public class InputStreamDemo {
    public static void main(String[] args) {
        // Создаём временный файл для чтения
        String filename = "test_input.txt";
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write("ABC".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение по одному байту через read()
        try (FileInputStream fis = new FileInputStream(filename)) {
            int byteRead;
            System.out.print("Прочитано: ");
            while ((byteRead = fis.read()) != -1) {
                // read() возвращает int (0–255) или -1 при EOF
                System.out.print((char) byteRead); // преобразуем в char для вывода
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удалим временный файл
        new File(filename).delete();
    }
}

