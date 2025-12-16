package accessdemo;

public class SamePackageClass {
    public void accessFromSamePackage() {
        ParentClass obj = new ParentClass();
        System.out.println("Из SamePackageClass (тот же пакет):");
        System.out.println("obj.publicField = " + obj.publicField);         // OK
        System.out.println("obj.protectedField = " + obj.protectedField);   // OK
        System.out.println("obj.packagePrivateField = " + obj.packagePrivateField); // OK
        // System.out.println(obj.privateField); // ОШИБКА: недоступно

        obj.publicMethod();        // OK
        obj.protectedMethod();     // OK
        obj.packagePrivateMethod(); // OK
        // obj.privateMethod();    // ОШИБКА: недоступно
    }
}
