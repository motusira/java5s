public class A {
    public final int a;

    // Вариант 1: инициализация в конструкторе (основной способ для non-static final-полей)
    public A(int value) {
        a = value;
    }

    // Вариант 2: инициализация в конструкторе по умолчанию
    public A() {
        a = 42;
    }

    // Вариант 3: инициализация в блоке инициализации (instance initializer)
    /*
    {
        a = 100;
    }
    */

    // Примечание:
    // - final-поле НЕ может быть инициализировано в обычном методе.
    // - Оно должно быть инициализировано ровно один раз до завершения конструирования объекта.
    // - Если конструкторов несколько, каждое из них должно инициализировать final-поле.
}

public class FinalFieldDemo {
    public static void main(String[] args) {
        A obj1 = new A(10);
        System.out.println("obj1.a = " + obj1.a); // 10

        A obj2 = new A();
        System.out.println("obj2.a = " + obj2.a); // 42
    }
}
