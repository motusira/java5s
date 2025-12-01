public class TypeInferenceExample {
    public static void main(String[] args) {
        var name = "Иван";
        var age = 25;
        var pi = 3.1415;
        var isActive = true;
        var list = java.util.Arrays.asList(1, 2, 3);

        System.out.println(name + ", " + age + " лет");
        System.out.println("pi = " + pi);
        System.out.println("Активен: " + isActive);
        System.out.println("Список: " + list);
    }
}
