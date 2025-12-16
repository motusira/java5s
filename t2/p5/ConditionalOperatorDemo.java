public class ConditionalOperatorDemo {
    public static void main(String[] args) {
        int a = 2; // пример значения

        // Исходная конструкция через if-else
        int i = 0;
        if (a == 1) {
            i = 1;
        } else if (a == 2) {
            i = 2;
        } else {
            i = 3;
        }

        // Эквивалентная запись с использованием тернарного оператора ? :
        int j = (a == 1) ? 1 : (a == 2) ? 2 : 3;

        // Проверка эквивалентности
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("Результаты совпадают: " + (i == j));
    }
}
