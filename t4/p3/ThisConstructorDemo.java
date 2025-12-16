// Переписанный класс с использованием this() для делегирования конструкторов
class A {
    int a;
    int b;
    int c;
    int z;

    // Базовый конструктор - инициализирует только z
    public A() {
        z = 1;
    }

    // Конструктор с одним параметром - делегирует в базовый, затем устанавливает a
    public A(int a) {
        this();       // вызывает A()
        this.a = a;
    }

    // Конструктор с двумя параметрами - делегирует в предыдущий
    public A(int a, int b) {
        this(a);      // вызывает A(int a)
        this.b = b;
    }

    // Конструктор с тремя параметрами - делегирует в предыдущий
    public A(int a, int b, int c) {
        this(a, b);   // вызывает A(int a, int b)
        this.c = c;
    }
}

public class ThisConstructorDemo {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A(10);
        A obj3 = new A(10, 20);
        A obj4 = new A(10, 20, 30);

        System.out.println("obj4: a=" + obj4.a + ", b=" + obj4.b + ", c=" + obj4.c + ", z=" + obj4.z);
    }
}
