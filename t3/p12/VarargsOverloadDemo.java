public class VarargsOverloadDemo {
    // Базовый метод с переменным числом int-параметров
    public void process(int... values) {
        System.out.print("int varargs: ");
        for (int v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // Перегрузка для double...
    public void process(double... values) {
        System.out.print("double varargs: ");
        for (double v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // Перегрузка для String...
    public void process(String... values) {
        System.out.print("String varargs: ");
        for (String v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // Перегрузка с фиксированным параметром + varargs
    public void process(String prefix, int... values) {
        System.out.print("prefix + int varargs: " + prefix + " ");
        for (int v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // Перегрузка с одним параметром (без varargs) - имеет приоритет над varargs
    public void process(int value) {
        System.out.println("single int: " + value);
    }

    public static void main(String[] args) {
        VarargsOverloadDemo demo = new VarargsOverloadDemo();

        demo.process(10);                     // вызовет single int
        demo.process(10, 20);                 // вызовет int varargs
        demo.process(1.5, 2.7);               // вызовет double varargs
        demo.process("a", "b", "c");          // вызовет String varargs
        demo.process("ID:", 1, 2, 3);         // вызовет prefix + int varargs
    }
}
