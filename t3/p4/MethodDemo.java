// Базовый класс
class Animal {
    // Метод, который будет переопределяться
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }

    // Метод с параметром для демонстрации перегрузки
    public void sleep(int hours) {
        System.out.println("Животное спит " + hours + " часов");
    }

    // Перегрузка метода sleep
    public void sleep(int hours, String place) {
        System.out.println("Животное спит " + hours + " часов в " + place);
    }

    // Ещё одна перегрузка другой тип параметра
    public void sleep(String duration) {
        System.out.println("Животное спит " + duration);
    }
}

// Подкласс, демонстрирующий переопределение
class Dog extends Animal {
    // Переопределение метода makeSound
    @Override
    public void makeSound() {
        System.out.println("Собака гавкает");
    }

    // Перегрузка в подклассе
    public void sleep(int hours, String place, boolean dream) {
        System.out.println("Собака спит " + hours + " часов в " + place +
                           (dream ? " и видит сны" : ""));
    }
}

// Подкласс с дополнительным примером переопределения
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает");
    }

    // Можно также переопределить перегруженный метод
    @Override
    public void sleep(int hours) {
        System.out.println("Кошка дремлет " + hours + " часов");
    }
}

// Основной класс для запуска
public class MethodDemo {
    public static void main(String[] args) {
        // Демонстрация переопределения
        Animal genericAnimal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        genericAnimal.makeSound(); // Животное издаёт звук
        dog.makeSound();
        cat.makeSound();

        System.out.println();

        // Демонстрация перегрузки
        Animal animal = new Animal();
        animal.sleep(8);                          // 8 часов
        animal.sleep(6, "конуре");                // 6 часов в конуре
        animal.sleep("весь день");                // спит весь день

        System.out.println();

        // Перегрузка в подклассе
        Dog myDog = new Dog();
        myDog.sleep(5, "будке", true);            // спит 5 часов в будке и видит сны

        System.out.println();

        // Переопределение перегруженного метода
        Cat myCat = new Cat();
        myCat.sleep(3);                           // Кошка дремлет 3 часов

        // тип возвращаемого значения не влияет на перегрузку.
        // Следующие два метода НЕЛЬЗЯ объявить одновременно, если они отличаются ТОЛЬКО типом возврата:
        // int getValue() { return 1; }
        // double getValue() { return 1.0; } // ОШИБКА КОМПИЛЯЦИИ: метод уже определён
    }
}
