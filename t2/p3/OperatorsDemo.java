public class OperatorsDemo {
    public static void main(String[] args) {
        // Арифметические и составные операторы присваивания
        int a = 10;
        a += 5;
        a -= 3;
        a *= 2;
        a /= 4;
        a %= 5;

        // Тернарный оператор
        int x = 8, y = 5;
        int max = (x > y) ? x : y;

        // Логические операторы
        boolean flag1 = true, flag2 = false;
        boolean result1 = flag1 || flag2;
        boolean result2 = flag1 && flag2;

        // Побитовые операторы
        int b = 6;
        int c = 3;
        int or = b | c;
        int xor = b ^ c;
        int and = b & c;

        // Операторы сравнения
        boolean eq = (a == 1);
        boolean ne = (a != 2);
        boolean gt = (x > y);
        boolean ge = (x >= 8);
        boolean lt = (y < x);
        boolean le = (y <= 5);

        // Побитовые сдвиги
        int d = 8;
        int right = d >> 1;
        int unsignedRight = d >>> 1;
        int left = d << 2;

        // Сложение и вычитание
        int sum = 10 + 3;
        int diff = 10 - 3;

        // Умножение, деление, остаток
        int prod = 4 * 5;
        int quot = 10 / 3;
        int rem = 10 % 3;

        // Унарные операторы: префиксные и постфиксные формы
        int e = 5;
        int preInc = ++e;       // e = 6, preInc = 6

        int f = 5;
        int postInc = f++;      // f = 6, postInc = 5

        int preDec = --f;       // f = 5, preDec = 5

        int g = 5;
        int postDec = g--;      // g = 4, postDec = 5

        int bitwiseNot = ~5;
        boolean not = !true;

        // Операторы ( ) и [ ]
        int[] arr = {1, 2, 3};
        int first = arr[0];
        int expr = (2 + 3) * 4;

        // Строки: конкатенация
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + " " + s2;
        s1 += "!";

        // Операторы == и != для базовых типов
        int i1 = 100, i2 = 100;
        boolean sameValue = (i1 == i2);

        // Присваивание
        int h = 42;
        String str = "example";

        System.out.println("OperatorsDemo completed without errors.");
    }
}

