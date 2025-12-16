public class IntegerCacheDemo {
    public static void main(String[] args) {
        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1==i1 " + (a1 == i1));
        System.out.println("b1==i1 " + (b1 == i1));
        System.out.println("a1==b1 " + (a1 == b1));
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("a2==i2 " + (a2 == i2));
        System.out.println("b2==i2 " + (b2 == i2));
        System.out.println("a2==b2 " + (a2 == b2));
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));

        // Объяснение:
        // Класс Integer содержит кэш IntegerCache для значений от -128 до 127.
        // При автоупаковке значений в этом диапазоне всегда возвращается один
        // и тот же объект из кэша, поэтому a2 == b2 - true.
        // Для значений вне диапазона (например, 128) создаются новые объекты,
        // поэтому a1 == b1 - false.
        // Оператор == для сравнения Integer сравнивает ссылки, а не значения.
        // Метод equals() сравнивает значения - поэтому всегда true при одинаковых числах.
    }
}
