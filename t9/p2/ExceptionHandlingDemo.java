public class ExceptionHandlingDemo {

    // Метод, который генерирует два исключения
    public static void riskyMethod() throws RuntimeException {
        // Исключение 1: перехватываемое (обрабатываемое локально)
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено и обработано: " + e.getClass().getSimpleName());
        }

        // Исключение 2: необработанное - будет проброшено наверх
        throw new RuntimeException("Необработанное исключение — приведёт к аварийной остановке");
    }

    public static void main(String[] args) {
        System.out.println("Начало выполнения");

        // Вызов метода, который обрабатывает одно исключение и пробрасывает другое
        riskyMethod();

        // Эта строка никогда не выполнится, потому что
        // riskyMethod() выбрасывает необработанное исключение
        System.out.println("Конец выполнения");
    }
}
