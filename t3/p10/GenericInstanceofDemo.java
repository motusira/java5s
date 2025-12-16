import java.util.ArrayList;
import java.util.List;

public class GenericInstanceofDemo {
    public static void main(String[] args) {
        // Пример 1: instanceof с необработанным (raw) типом
        List<String> list = new ArrayList<>();
        if (list instanceof List) {
            System.out.println("list является экземпляром List");
        }

        // Пример 2: instanceof с параметризованным типом — НЕ РАБОТАЕТ
        // Следующая строка не компилируется:
        // if (list instanceof List<String>) { } // ОШИБКА КОМПИЛЯЦИИ

        // Причина: из-за type erasure (стирания типов) во время выполнения
        // информация о конкретном generic-типе (String) недоступна.
        // Поэтому instanceof допускает только проверку по необработанному типу
        // или по wildcard-ограничениям, но не по конкретному параметризованному типу.

        // Пример 3: instanceof с wildcard - допустимо, но бесполезно
        // if (list instanceof List<?>) { } // компилируется, но эквивалентно instanceof List

        // Пример 4: instanceof с обобщённым классом, определённым пользователем
        Wrapper<String> wrapper = new Wrapper<>();
        if (wrapper instanceof Wrapper) {
            System.out.println("wrapper является экземпляром Wrapper");
        }

        // Но так нельзя:
        // if (wrapper instanceof Wrapper<String>) { } // ошибка компиляции

        // Вывод: оператор instanceof не может использоваться для проверки конкретных
        // generic-типов из-за стирания типов в рантайме. Проверять можно только
        // необработанные (raw) типы или классы без параметров.
    }
}

// Вспомогательный generic-класс
class Wrapper<T> {
    private T item;
    public void setItem(T item) { this.item = item; }
    public T getItem() { return item; }
}
