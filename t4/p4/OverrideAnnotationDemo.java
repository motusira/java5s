// Базовый класс
class Vehicle {
    public void start() {
        System.out.println("Транспортное средство заведено");
    }
}

// Подкласс с ошибкой: опечатка в имени метода
class Car extends Vehicle {
    // Без @Override компилятор не заметит, что метод не переопределяет ничего
    // public void stat() { ... }  // опечатка - создастся новый метод

    // С @Override:
    @Override
    public void start() {  // правильно
        System.out.println("Автомобиль заведён");
    }

    // Допустим, мы хотим переопределить несуществующий метод
    /*
    @Override
    public void accelerate() {  // ОШИБКА КОМПИЛЯЦИИ: метода accelerate() в Vehicle нет
        System.out.println("Ускорение");
    }
    */
}

// Практика #3: @Override помогает поймать:
// - опечатки в имени метода,
// - несоответствие сигнатуры (параметров),
// - попытку переопределить несуществующий метод.

public class OverrideAnnotationDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // благодаря полиморфизму вызывается Car.start()
    }
}
