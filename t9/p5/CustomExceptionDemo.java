// Проверяемое исключение (наследуется от Exception)
class InvalidAgeException extends Exception {
    // Конструктор по умолчанию
    public InvalidAgeException() {
        super("Недопустимый возраст");
    }

    // Конструктор с сообщением
    public InvalidAgeException(String message) {
        super(message);
    }

    // Конструктор с сообщением и причиной (cause)
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Класс, использующий собственное исключение
class Person {
    private int age;

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Возраст должен быть в диапазоне от 0 до 150, получено: " + age);
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        Person person = new Person();

        try {
            person.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            person.setAge(30);
            System.out.println("Возраст установлен: " + person.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
