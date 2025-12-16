import accessdemo.ParentClass;

public class OtherPackageClass {
    public void accessFromOtherPackage() {
        ParentClass obj = new ParentClass();
        System.out.println("Из OtherPackageClass (другой пакет):");
        System.out.println("obj.publicField = " + obj.publicField); // OK
        // System.out.println(obj.protectedField);   // ОШИБКА: недоступно напрямую
        // System.out.println(obj.packagePrivateField); // ОШИБКА
        // System.out.println(obj.privateField);        // ОШИБКА

        obj.publicMethod(); // OK
        // obj.protectedMethod();     // ОШИБКА
        // obj.packagePrivateMethod(); // ОШИБКА
        // obj.privateMethod();        // ОШИБКА
    }

    // Даже как подкласс из другого пакета:
    static class SubClassFromOtherPackage extends ParentClass {
        public void tryAccess() {
            System.out.println("Из подкласса в другом пакете:");
            System.out.println("publicField = " + publicField);       // OK
            System.out.println("protectedField = " + protectedField); // OK (только через наследование)
            // System.out.println(packagePrivateField); // ОШИБКА: недоступно из другого пакета
            // System.out.println(privateField);        // ОШИБКА

            publicMethod();      // OK
            protectedMethod();   // OK
            // packagePrivateMethod(); // ОШИБКА
            // privateMethod();        // ОШИБКА
        }
    }
}

