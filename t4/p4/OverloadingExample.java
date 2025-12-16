public class OverloadingExample {
    public void print(int value) {
        System.out.println("Целое число: " + value);
    }

    public void print(double value) {
        System.out.println("Дробное число: " + value);
    }

    public void print(String value) {
        System.out.println("Строка: " + value);
    }

    public void print(int a, int b) {
        System.out.println("Два целых: " + a + ", " + b);
    }

    public static void main(String[] args) {
        OverloadingExample obj = new OverloadingExample();
        obj.print(42);          // вызов print(int)
        obj.print(3.14);        // вызов print(double)
        obj.print("Hello");     // вызов print(String)
        obj.print(10, 20);      // вызов print(int, int)
    }
}

