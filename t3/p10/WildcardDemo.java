import java.util.ArrayList;
import java.util.List;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class WildcardDemo {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());

        // Использование <? extends Animal>
        printAnimals(dogs);   // OK: Dog extends Animal
        printAnimals(cats);   // OK: Cat extends Animal
        printAnimals(animals); // OK: Animal extends Animal

        // Использование <? super Dog>
        addDogs(dogs);        // OK: Dog super Dog
        addDogs(animals);     // OK: Animal super Dog
        // addDogs(cats);     // ОШИБКА: Cat не является супертипом Dog

        // Объяснение:
        // - <? extends T> (upper bounded wildcard) - позволяет читать объекты как T,
        //   но нельзя добавлять (кроме null), потому что конкретный подтип неизвестен.
        //   Используется, когда нужен "только для чтения" доступ к коллекции.
        //
        // - <? super T> (lower bounded wildcard) - позволяет добавлять объекты типа T
        //   в коллекцию, потому что гарантировано, что коллекция может принять T.
        //   Используется, когда нужно писать в коллекцию.
    }

    // Метод с <? extends Animal>: можно читать, нельзя безопасно писать
    public static void printAnimals(List<? extends Animal> list) {
        for (Animal a : list) {
            System.out.println(a);
        }
        // list.add(new Dog()); // ОШИБКА: нельзя добавлять
    }

    // Метод с <? super Dog>: можно добавлять Dog, но читать можно только как Object
    public static void addDogs(List<? super Dog> list) {
        list.add(new Dog());
        // Animal a = list.get(0); // ОШИБКА: тип возвращаемого значения - Object
        Object obj = list.get(0); // OK
    }
}
