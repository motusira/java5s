// Внешний класс
public class OuterClass {
    private int privateField = 1;
    int packageField = 2;
    protected int protectedField = 3;
    public int publicField = 4;

    // 1. Внутренний класс с разными модификаторами доступа

    // public внутренний класс — доступен из любого места
    public class PublicInner {
        public void accessOuterFields() {
            // Внутренний класс имеет доступ ко ВСЕМ полям внешнего класса,
            // независимо от их модификаторов доступа
            System.out.println("privateField: " + privateField);
            System.out.println("packageField: " + packageField);
            System.out.println("protectedField: " + protectedField);
            System.out.println("publicField: " + publicField);
        }
    }

    // private внутренний класс — доступен только внутри OuterClass
    private class PrivateInner {
        void doSomething() {
            System.out.println("PrivateInner работает");
        }
    }

    // package-private (по умолчанию) — доступен только в пределах пакета
    class PackagePrivateInner {
        void doSomething() {
            System.out.println("PackagePrivateInner работает");
        }
    }

    // protected внутренний класс — доступен в том же пакете и в подклассах
    protected class ProtectedInner {
        void doSomething() {
            System.out.println("ProtectedInner работает");
        }
    }

    // Метод во внешнем классе, демонстрирующий доступ к внутренним
    public void demonstrateInnerAccess() {
        // Доступ к private внутреннему классу возможен, т.к. мы внутри OuterClass
        PrivateInner pi = new PrivateInner();
        pi.doSomething();

        // Доступ к любому полю/методу внутренних классов
        PublicInner pub = new PublicInner();
        // Но напрямую читать их private-поля извне нельзя — только через их методы
    }

    // 2. Внешний класс имеет доступ к полям внутреннего класса, как к обычным членам
    public void accessInnerMembers() {
        PublicInner inner = new PublicInner();
        // inner.a — если бы поле a было объявлено, можно было бы читать/писать,
        // подчиняясь обычным правилам доступа (private, public и т.д.)

        // Например:
        inner.internalPublicField = "из внешнего класса";
        System.out.println(inner.internalPublicField);
        // inner.internalPrivateField — недоступно, если оно private
    }

    // Класс для демонстрации доступа изнутри
    public class PublicInner {
        private String internalPrivateField = "private значение";
        public String internalPublicField = "public значение";

        public void demonstrateOuterAccess() {
            // Внутренний класс свободно читает и пишет любые поля внешнего класса
            privateField = 999;
            System.out.println("Изменено privateField внешнего класса на: " + privateField);
        }
    }
}
