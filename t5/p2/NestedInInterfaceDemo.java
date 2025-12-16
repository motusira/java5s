public interface MyInterface {
    // Вложенный класс в интерфейсе неявно является public static
    class NestedClass {
        public void doSomething() {
            System.out.println("Метод вложенного класса внутри интерфейса");
        }

        // Может содержать статические и нестатические методы
        public static void doStaticThing() {
            System.out.println("Статический метод вложенного класса в интерфейсе");
        }
    }

    // Обычные методы интерфейса
    void interfaceMethod();
}


// Реализация интерфейса (необязательна для использования вложенного класса)
class MyClass implements MyInterface {
    @Override
    public void interfaceMethod() {
        System.out.println("Реализация метода интерфейса");
    }
}


// Основной класс для демонстрации
public class NestedInInterfaceDemo {
    public static void main(String[] args) {
        // Создание экземпляра вложенного класса напрямую через интерфейс
        MyInterface.NestedClass nested = new MyInterface.NestedClass();
        nested.doSomething();

        // Вызов статического метода вложенного класса
        MyInterface.NestedClass.doStaticThing();

        // Реализация интерфейса не требуется для использования вложенного класса
        MyClass obj = new MyClass();
        obj.interfaceMethod();
    }
}
