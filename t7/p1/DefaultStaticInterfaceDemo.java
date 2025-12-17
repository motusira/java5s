interface Drawable {
    // Абстрактный метод (по умолчанию)
    void draw();

    // default-метод
    default void describe() {
        System.out.println("Это объект, реализующий интерфейс Drawable");
    }

    // static-метод
    static void showInfo() {
        System.out.println("Интерфейс Drawable предоставляет методы для отрисовки");
    }
}

// Класс, реализующий интерфейс
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Рисуем круг");
    }

    // Можно переопределить default-метод
    @Override
    public void describe() {
        System.out.println("Это круг");
    }
}

// Основной класс
public class DefaultStaticInterfaceDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();

        // Вызов абстрактного метода (реализован в классе)
        circle.draw();

        // Вызов переопределённого default-метода
        circle.describe();

        // Вызов default-метода через ссылку типа интерфейса
        Drawable d = new Circle();
        d.describe();

        // Вызов static-метода - ТОЛЬКО через имя интерфейса
        Drawable.showInfo();

        // Нельзя вызывать static-метод через экземпляр:
        // circle.showInfo(); // ОШИБКА КОМПИЛЯЦИИ
    }
}

