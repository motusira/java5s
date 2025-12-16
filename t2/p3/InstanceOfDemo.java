class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
interface Swimmable {}
class Duck extends Animal implements Swimmable {}

public class InstanceOfDemo {
    public static void main(String[] args) {
        // Базовый пример
        Animal myPet = new Dog();
        boolean isDog = myPet instanceof Dog;
        boolean isAnimal = myPet instanceof Animal;
        boolean isCat = myPet instanceof Cat;

        // Сравнение с интерфейсом
        Animal duck = new Duck();
        boolean canSwim = duck instanceof Swimmable;

        // Случай с null
        Animal nullPet = null;
        boolean isNullDog = nullPet instanceof Dog;

        // Пример с Object
        Object obj = "Hello";
        boolean isString = obj instanceof String;

        System.out.println("InstanceOfDemo completed without errors.");
    }
}
