package accessdemo;

public class ChildClass extends ParentClass {
    public void accessFromChild() {
        System.out.println("Из ChildClass (тот же пакет + подкласс):");
        System.out.println("publicField = " + publicField);         // OK
        System.out.println("protectedField = " + protectedField);   // OK
        System.out.println("packagePrivateField = " + packagePrivateField); // OK
        // System.out.println(privateField); // ОШИБКА: недоступно

        publicMethod();        // OK
        protectedMethod();     // OK
        packagePrivateMethod(); // OK
        // privateMethod();    // ОШИБКА: недоступно
    }
}
