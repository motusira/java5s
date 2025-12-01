public class ArithmeticPromotion {
    public static void main(String[] args) {
        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        float f = 50.5f;
        double d = 60.6;

        System.out.println(b + s);
        System.out.println(i + l);
        System.out.println(l + f);
        System.out.println(f + d);

        Object result1 = b + s;
        Object result2 = f + d;

        System.out.println("Тип b+s: " + result1.getClass().getSimpleName());
        System.out.println("Тип f+d: " + result2.getClass().getSimpleName());
    }
}
