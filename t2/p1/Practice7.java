public class Practice7 {
    public static void main(String[] args) {
        int a = 120;
        byte b = a + 10;
        byte c = (byte)(a + 10);
        byte d = a + 1;

        // будет ошибка компиляции

        System.out.println("c = " + c);
    }
}
