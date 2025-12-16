public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        // Вариант 1: вызов через имя класса (рекомендуемый способ)
        A.printVars();

        // Вариант 2: вызов через ссылку на экземпляр класса (компилятор допускает, но не рекомендуется)
        A instance = new A();
        instance.printVars();

        // Вариант 3: вызов внутри статического контекста (например, из другого статического метода)
        anotherStaticMethod();
    }

    public static void anotherStaticMethod() {
        // Внутри статического метода можно вызывать статические методы напрямую
        A.printVars();
        // или просто
        printVarsFromA();
    }

    // Вспомогательный метод для вызова из другого класса, если бы он был в том же файле
    public static void printVarsFromA() {
        A.printVars();
    }
}
