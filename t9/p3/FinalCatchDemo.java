public class FinalCatchDemo {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (final ArithmeticException e) {
            // Практика #2: final в catch означает, что ссылка 'e' не может быть изменена
            // (например, нельзя сделать e = null или e = другое исключение)
            // Это запрещает повторное присваивание параметру исключения внутри блока catch.

            System.out.println("Перехвачено: " + e.getMessage());

            // Следующая строка вызовет ошибку компиляции:
            // e = new ArithmeticException("Новое исключение"); // НЕЛЬЗЯ

            // Но можно читать поля и вызывать методы:
            e.printStackTrace();
        }

        // Вложенные try-catch (дополнительно по теории)
        try {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("Внутренний catch: " + e.getClass().getSimpleName());
                throw e; // пробрасываем дальше
            }
        } catch (Exception e) {
            System.out.println("Внешний catch: " + e.getClass().getSimpleName());
        }
    }
}
