public class StringConcatenation {
    public static void main(String[] args) {
        String text = "Результат: ";

        int num = 42;
        double pi = 3.1415;
        char symbol = 'X';
        boolean flag = true;

        System.out.println(text + num);
        System.out.println(text + pi);
        System.out.println(text + symbol);
        System.out.println(text + flag)

        Integer objInt = 100;
        Double objDouble = 2.5;

        System.out.println(text + objInt + objDouble);
    }
}
