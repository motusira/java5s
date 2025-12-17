public class StringMethodsDemo {
    public static void main(String[] args) {
        String s1 = "  Hello, World!  ";
        String s2 = "hello";
        String s3 = "HELLO";
        String s4 = "Java";
        String s5 = "Java";

        // 1. trim() - удаляет пробелы в начале и конце строки
        System.out.println("trim(): '" + s1.trim() + "'");

        // 2. equals() - сравнивает содержимое строк (с учётом регистра)
        System.out.println("equals(): " + s2.equals(s3)); // false

        // 3. equalsIgnoreCase() - сравнивает без учёта регистра
        System.out.println("equalsIgnoreCase(): " + s2.equalsIgnoreCase(s3)); // true

        // 4. length() - возвращает длину строки
        System.out.println("length(): " + s4.length()); // 4

        // 5. charAt(int index) - возвращает символ по индексу
        System.out.println("charAt(0): " + s4.charAt(0)); // 'J'

        // 6. substring(int beginIndex, int endIndex) - выделяет подстроку
        System.out.println("substring(1,3): " + s4.substring(1, 3)); // "av"

        // 7. indexOf(String str) - ищет подстроку, возвращает индекс или -1
        System.out.println("indexOf('World'): " + s1.indexOf("World")); // 8 (в исходной строке с пробелами)

        // 8. toLowerCase() - преобразует строку в нижний регистр
        System.out.println("toLowerCase(): " + s4.toLowerCase()); // "java"

        // 9. replace(CharSequence target, CharSequence replacement) - заменяет вхождения
        System.out.println("replace(): " + s1.replace("World", "Java")); // "  Hello, Java!  "

        // 10. concat(String str) - конкатенирует строки (аналог +)
        System.out.println("concat(): " + s4.concat(" Programming")); // "Java Programming"

        // Дополнительно: литералы из пула
        // s4 и s5 - ссылаются на один и тот же объект в пуле литералов
        System.out.println("s4 == s5 (ссылочное сравнение): " + (s4 == s5)); // true
    }
}
