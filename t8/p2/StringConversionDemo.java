public class StringConversionDemo {
    public static void main(String[] args) {
        String str = "Initial string";
        StringBuilder sb = new StringBuilder("Builder content");
        StringBuffer sf = new StringBuffer("Buffer content");

        // Практика #2: преобразования между String, StringBuilder, StringBuffer

        // 1. String - StringBuilder
        StringBuilder fromString1 = new StringBuilder(str);

        // 2. String - StringBuffer
        StringBuffer fromString2 = new StringBuffer(str);

        // 3. StringBuilder - String
        String fromBuilder = sb.toString();

        // 4. StringBuffer - String
        String fromBuffer = sf.toString();

        // 5. StringBuilder - StringBuffer
        StringBuffer fromBuilderToBuffer = new StringBuffer(sb.toString());

        // 6. StringBuffer - StringBuilder
        StringBuilder fromBufferToBuilder = new StringBuilder(sf.toString());

        // 7. StringBuilder - StringBuilder (копия)
        StringBuilder copyBuilder = new StringBuilder(sb);

        // 8. StringBuffer - StringBuffer (копия)
        StringBuffer copyBuffer = new StringBuffer(sf);

        // 9. String из любого через String.valueOf()
        String viaValueOf1 = String.valueOf(sb);
        String viaValueOf2 = String.valueOf(sf);

        // 10. Преобразование через конструкторы с CharSequence (все три реализуют CharSequence)
        StringBuilder sb2 = new StringBuilder(str);          // String - StringBuilder
        StringBuilder sb3 = new StringBuilder(sf);           // StringBuffer - StringBuilder
        StringBuffer sf2 = new StringBuffer(sb);             // StringBuilder - StringBuffer

        // Вывод примеров
        System.out.println("fromBuilder: " + fromBuilder);
        System.out.println("fromBuffer: " + fromBuffer);
        System.out.println("viaValueOf1: " + viaValueOf1);
        System.out.println("sb3: " + sb3);
        System.out.println("sf2: " + sf2);
    }
}
