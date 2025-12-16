package accessdemo;

public class ParentClass {
    public int publicField = 1;
    protected int protectedField = 2;
    int packagePrivateField = 3; // без спецификатора (package-private)
    private int privateField = 4;

    public void publicMethod() {
        System.out.println("Вызван public метод");
    }

    protected void protectedMethod() {
        System.out.println("Вызван protected метод");
    }

    void packagePrivateMethod() {
        System.out.println("Вызван package-private метод");
    }

    private void privateMethod() {
        System.out.println("Вызван private метод");
    }

    // Метод внутри класса может обращаться ко всем полям и методам
    public void accessAllFromInside() {
        System.out.println("Изнутри ParentClass:");
        System.out.println("publicField = " + publicField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("packagePrivateField = " + packagePrivateField);
        System.out.println("privateField = " + privateField);
        publicMethod();
        protectedMethod();
        packagePrivateMethod();
        privateMethod();
    }
}

