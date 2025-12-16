// Final-класс - нельзя наследовать
final class Utility {
    public void doSomething() {
        System.out.println("Utility работает");
    }
}

// Следующий класс НЕ компилируется:
/*
class ExtendedUtility extends Utility {
    // Ошибка: "cannot inherit from final Utility"
}
*/

public class FinalClassDemo {
    public static void main(String[] args) {
        Utility util = new Utility();
        util.doSomething();
        
        // Наследование от Utility невозможно - только прямое использование
    }
}
