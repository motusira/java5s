public class Practice3 {
    public static void main(String[] args) {
        int a = 1;
        {
            int b = 2;
        }
        int c = a + b; // ошибка компиляции
        System.out.println(c);
    }
}
