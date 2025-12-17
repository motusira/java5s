/*
Практика #1: назначение основных классов исключений

- Throwable - корневой класс всей иерархии исключений. Только его подклассы могут быть выброшены и перехвачены.

- Error - указывает на серьёзные проблемы, которые обычно не подлежат обработке в приложении
  (например, OutOfMemoryError, StackOverflowError). Эти ошибки возникают на уровне JVM
  и свидетельствуют о критических сбоях, которые программист не может и не должен обрабатывать.

- Exception - базовый класс для всех исключений, которые могут и должны обрабатываться.
  Исключения этого типа делятся на две группы:
    1. Проверяемые (checked) - наследники Exception, кроме RuntimeException.
       Компилятор требует их обрабатывать (try-catch) или объявлять в throws.
    2. Непроверяемые (unchecked) - наследники RuntimeException.
       Обработка не обязательна, но возможна. Возникают из-за ошибок программиста
       (например, деление на ноль, выход за границы массива).

- RuntimeException - корень непроверяемых исключений. Используется для ошибок времени выполнения,
  которые можно избежать правильной логикой программы.
*/


public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        // 1. ArithmeticException - деление на ноль
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // 2. ArrayIndexOutOfBoundsException - выход за границы массива
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 3. IllegalArgumentException - недопустимый аргумент
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        // 4. ClassCastException - некорректное приведение типов
        try {
            Object obj = "строка";
            Integer num = (Integer) obj; // нельзя привести String к Integer
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }

        // 5. NullPointerException - вызов метода или доступ к полю через null
        try {
            String str = null;
            int len = str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
    }

    // Вспомогательный метод для демонстрации IllegalArgumentException
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }
}
