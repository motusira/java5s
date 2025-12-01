public class NarrowingConversion {
    public static void main(String[] args) {
        int i = 200;
        byte b = (byte) i;
        System.out.println("b = " + b);

        double d = 123.456;
        int n = (int) d
        System.out.println("n = " + n);

        long big = 10000000000L;
        int small = (int) big;
        System.out.println("small = " + small);
        int code = 65;
        char ch = (char) code;
        System.out.println("ch = " + ch);
    }
}
