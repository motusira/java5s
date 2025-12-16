// Базовый класс с final-методом
class Base {
    public final void display() {
        System.out.println("Это final-метод в классе Base");
    }
}

// Подкласс - попытка переопределить final-метод вызовет ошибку компиляции
class Derived extends Base {
    // Следующий метод НЕ компилируется:
    /*
    @Override
    public final void display() {
        System.out.println("Попытка переопределить final-метод");
    }
    */
    // Ошибка: "display() in Derived cannot override display() in Base;
    // overridden method is final"
}

public class FinalMethodDemo {
    public static void main(String[] args) {
        Derived obj = new Derived();
        obj.display(); // вызывается final-метод из Base
    }
}

