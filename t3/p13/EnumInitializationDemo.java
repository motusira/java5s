// Практика #1: перечисление с инициализацией элементов
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6);

    private final double mass;   // масса в кг
    private final double radius; // радиус в метрах

    // Конструктор вызывается для каждого элемента enum при инициализации
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() { return mass; }
    public double getRadius() { return radius; }
}


// Практика #2: перечисление с собственным методом
public enum Operation {
    PLUS {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        public double apply(double x, double y) { return x / y; }
    };

    // Абстрактный метод, который каждый элемент enum обязан реализовать
    public abstract double apply(double x, double y);
}


public class EnumDemo {
    public static void main(String[] args) {
        // Использование Planet
        Planet earth = Planet.EARTH;
        System.out.println("Масса Земли: " + earth.getMass() + " кг");

        // Использование Operation
        double result = Operation.PLUS.apply(5.0, 3.0);
        System.out.println("5 + 3 = " + result);

        result = Operation.TIMES.apply(4.0, 2.5);
        System.out.println("4 * 2.5 = " + result);

        // Перечисления нельзя создавать через new
        // Planet p = new Planet(...); // ОШИБКА КОМПИЛЯЦИИ

        // Перечисления не могут быть супер- или подклассами
        // class MyPlanet extends Planet { } // ОШИБКА

        // Перечисления не могут быть параметризованы
        // enum Box<T> { ... } // ОШИБКА

        // Перечисления не могут быть абстрактными
        // abstract enum Color { ... } // ОШИБКА
    }
}
