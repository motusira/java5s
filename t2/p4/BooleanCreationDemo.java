public class BooleanCreationDemo {
    public static void main(String[] args) {
        // Способы создания экземпляра Boolean

        // 1. Автоупаковка
        Boolean b1 = true;
        Boolean b2 = false;

        // 2. Статический метод valueOf(boolean)
        Boolean b3 = Boolean.valueOf(true);
        Boolean b4 = Boolean.valueOf(false);

        // 3. Статический метод valueOf(String)
        Boolean b5 = Boolean.valueOf("true");    // true
        Boolean b6 = Boolean.valueOf("TRUE");    // true (регистронезависимо)
        Boolean b7 = Boolean.valueOf("false");   // false
        Boolean b8 = Boolean.valueOf("abc");     // false (любая другая строка - false)

        // 4. Конструктор new Boolean(...) - устаревший, но технически возможен
        // Согласно условию, конструкторы "не применяются", но они существуют
        // и компилируются. Однако их использование не рекомендуется.
        Boolean b9 = new Boolean(true);   // deprecated since Java 9
        Boolean b10 = new Boolean("true");

        // Вывод
        System.out.println("b1=" + b1 + ", b5=" + b5 + ", b8=" + b8);
        System.out.println("BooleanCreationDemo completed.");
    }
}
