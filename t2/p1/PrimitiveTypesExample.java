public class PrimitiveTypesExample {
    static boolean defaultBoolean;
    static byte defaultByte;
    static short defaultShort;
    static int defaultInt;
    static long defaultLong;
    static float defaultFloat;
    static double defaultDouble;
    static char defaultChar;

    public static void main(String[] args) {
        boolean flag = true;
        byte b = 100;
        short s = 30000;
        int i = 1_000_000;
        long l = 123_456_789_012L;
        float f = 3.14f;
        double d = 2.71828;
        char ch = 'A';

        System.out.println("boolean: " + flag + " | по умолчанию: " + defaultBoolean);
        System.out.println("byte: " + b + " | по умолчанию: " + defaultByte);
        System.out.println("short: " + s + " | по умолчанию: " + defaultShort);
        System.out.println("int: " + i + " | по умолчанию: " + defaultInt);
        System.out.println("long: " + l + " | по умолчанию: " + defaultLong);
        System.out.println("float: " + f + " | по умолчанию: " + defaultFloat);
        System.out.println("double: " + d + " | по умолчанию: " + defaultDouble);
        System.out.println("char: '" + ch + "' | по умолчанию: '" + defaultChar + "'");
    }
}
