// Базовый класс
class Shape {
    public double getArea() {
        return 0.0;
    }
}

// Подкласс с корректным переопределением
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Правильное переопределение: совпадают имя, параметры и совместимый возвращаемый тип
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Практика #2: что если тип возвращаемого значения другой?
// Пример 1: несовместимый тип - ошибка компиляции
/*
class Square extends Shape {
    @Override
    public String getArea() {  // ОШИБКА: несовместимый тип возврата
        return "площадь";
    }
}
*/

// Пример 2: ковариантный возвращаемый тип - допустимо
class Animal {}
class Dog extends Animal {}

class Factory {
    public Animal create() {
        return new Animal();
    }
}

class DogFactory extends Factory {
    @Override
    public Dog create() {  // OK: Dog - подтип Animal
        return new Dog();
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Площадь круга: " + circle.getArea());

        Factory f = new DogFactory();
        Animal a = f.create(); // динамическое связывание: вызывается DogFactory.create()
        System.out.println("Создан объект: " + a.getClass().getSimpleName());
    }
}

