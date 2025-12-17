public class StringBuilderStringBufferDemo {
    public static void main(String[] args) {
        // StringBuilder - несинхронизированный, быстрее
        StringBuilder sb = new StringBuilder("Hello");

        // StringBuffer - потокобезопасный (синхронизированные методы)
        StringBuffer sf = new StringBuffer("World");

        // Методы StringBuilder (аналогичны для StringBuffer)

        // 1. append() - добавляет строку в конец
        sb.append(" Java");
        System.out.println("append(): " + sb); // "Hello Java"

        // 2. insert(int offset, String str) - вставляет строку по индексу
        sb.insert(6, "Beautiful ");
        System.out.println("insert(): " + sb); // "Hello Beautiful Java"

        // 3. delete(int start, int end) - удаляет символы в диапазоне [start, end)
        sb.delete(6, 16);
        System.out.println("delete(): " + sb); // "Hello Java"

        // 4. deleteCharAt(int index) - удаляет символ по индексу
        sb.deleteCharAt(5); // удаляет пробел
        System.out.println("deleteCharAt(): " + sb); // "HelloJava"

        // 5. replace(int start, int end, String str) - заменяет подстроку
        sb.replace(5, 9, " World");
        System.out.println("replace(): " + sb); // "Hello World"

        // 6. reverse() - разворачивает строку
        sb.reverse();
        System.out.println("reverse(): " + sb); // "dlroW olleH"
        sb.reverse(); // вернём обратно

        // 7. setCharAt(int index, char ch) - устанавливает символ по индексу
        sb.setCharAt(0, 'J');
        System.out.println("setCharAt(): " + sb); // "Jello World"

        // 8. setLength(int newLength) - изменяет длину строки
        sb.setLength(5);
        System.out.println("setLength(): " + sb); // "Jello"

        // 9. capacity() - возвращает текущую ёмкость внутреннего буфера
        System.out.println("capacity(): " + sb.capacity()); // обычно 16 (начальная) или больше

        // 10. ensureCapacity(int min) - гарантирует минимальную ёмкость
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100) -> capacity: " + sb.capacity());

        // StringBuffer - демонстрация аналогичной функциональности
        sf.insert(0, "Hello ");
        sf.append("!");
        System.out.println("StringBuffer: " + sf); // "Hello World!"
    }
}
