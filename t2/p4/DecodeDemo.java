public class DecodeDemo {
    public static void main(String[] args) {
        // Примеры использования Integer.decode()
        Integer dec1 = Integer.decode("123");        // десятичная система
        Integer dec2 = Integer.decode("+123");       // явный плюс
        Integer dec3 = Integer.decode("-456");       // отрицательное число

        Integer hex1 = Integer.decode("0x7B");       // шестнадцатеричное (123)
        Integer hex2 = Integer.decode("#7B");        // альтернативная запись hex
        Integer hex3 = Integer.decode("0X7B");       // регистронезависимо

        Integer oct1 = Integer.decode("0173");       // восьмеричное (1*64 + 7*8 + 3 = 123)

        System.out.println("dec1 = " + dec1);
        System.out.println("hex1 = " + hex1);
        System.out.println("oct1 = " + oct1);

        // Аналогично для других оболочек (только целочисленные типы поддерживают decode)
        Long longDec = Long.decode("0x10");          // 16
        Byte byteDec = Byte.decode("010");           // 8 в восьмеричной = 8
        Short shortDec = Short.decode("0x0A");       // 10

        System.out.println("Long: " + longDec);
        System.out.println("Byte: " + byteDec);
        System.out.println("Short: " + shortDec);
    }
}
