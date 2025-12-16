public class EqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Иван", 25);
        Person p2 = new Person("Иван", 25);
        Person p3 = new Person("Анна", 30);
        Person p4 = null;

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // false
        System.out.println("p1.equals(p1): " + p1.equals(p1)); // true

        // Проверка согласованности equals и hashCode
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
    }
}

/*
Соглашения, которым должна следовать реализация equals() (из спецификации Java):

1. Рефлексивность: x.equals(x) должно возвращать true.
2. Симметричность: если x.equals(y) == true, то y.equals(x) == true.
3. Транзитивность: если x.equals(y) == true и y.equals(z) == true, то x.equals(z) == true.
4. Непротиворечивость: многократные вызовы x.equals(y) должны возвращать один и тот же результат,
   если ни один из объектов не был изменён.
5. Для любого ненулевого x: x.equals(null) должно возвращать false.

Дополнительно:
- Если equals() переопределён, то должен быть переопределён и hashCode(),
  причём объекты, равные по equals(), обязаны иметь одинаковый hashCode().
- Рекомендуется использовать getClass() для проверки типа (а не instanceof),
  если класс не предназначен для наследования или если поведение equals()
  должно быть строго привязано к конкретному классу.
*/
