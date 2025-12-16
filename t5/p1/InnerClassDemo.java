// Демонстрация из другого класса (в том же пакете)
class InnerClassDemo {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // Доступ к public внутреннему классу
        OuterClass.PublicInner pubInner = outer.new PublicInner();
        pubInner.accessOuterFields();

        // Доступ к protected и package-private возможен, т.к. мы в том же пакете
        OuterClass.ProtectedInner protInner = outer.new ProtectedInner();
        protInner.doSomething();

        OuterClass.PackagePrivateInner packInner = outer.new PackagePrivateInner();
        packInner.doSomething();

        // OuterClass.PrivateInner - недоступен отсюда (ошибка компиляции)

        // Внешний класс может создавать и использовать все свои внутренние классы
        outer.demonstrateInnerAccess();
        outer.accessInnerMembers();

        // Внутренний класс может изменять даже private-поля внешнего
        pubInner.demonstrateOuterAccess();
    }
}
