public class BreakContinueDemo {
    public static void main(String[] args) {
        // Пример использования break и continue в цикле for
        System.out.println("Числа от 1 до 10, кроме 5, остановка на 8:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // пропускаем вывод 5
            }
            if (i == 8) {
                break; // выходим из цикла
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Пример с while
        System.out.println("Нечeтные числа до 10, пропускаем 3 и 7:");
        int n = 1;
        while (n <= 10) {
            if (n == 3 || n == 7) {
                n++;
                continue;
            }
            if (n == 9) {
                break;
            }
            System.out.print(n + " ");
            n++;
        }
        System.out.println();
    }
}
