// Базовый класс
class A {
    int a = 10;
    void method() {
        System.out.println("Метод A.method()");
    }
}

// Промежуточный класс
class B extends A {
    int a = 20; // скрывает поле a из A
    void method() {
        System.out.println("Метод B.method()");
    }
}

// Подкласс, демонстрирующий использование super
class C extends B {
    int a = 30; // скрывает a из B и A

    // 1. Вызов конструктора суперкласса через super()
    public C() {
        super(); // необязательно писать явно - вызывается автоматически,
                 // но показано для демонстрации
    }

    // 2. Доступ к полю суперкласса через super.field
    // 3. Вызов метода суперкласса через super.method()
    void demonstrateSuper() {
        int aFromA = super.a; // получает a из B (непосредственного родителя), который = 20
        System.out.println("super.a = " + aFromA); // 20

        // Чтобы получить a из A, нужно вызывать super из B - напрямую из C нельзя
        // (т.к. super ссылается только на непосредственного родителя - B)

        super.method(); // вызывает B.method()
    }
}

public class SuperUsageDemo {
    public static void main(String[] args) {
        C obj = new C();
        obj.demonstrateSuper();
    }
}

