public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        // Пример, когда возникает NullPointerException при автораспаковке
        Integer nullableInt = null;

        try {
            // При попытке автораспаковки null-объекта в int
            // будет выброшено NullPointerException
            int primitive = nullableInt;  // <- NPE здесь
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
        }

        // Аналогично для других оболочек
        Boolean nullableBool = null;
        try {
            boolean b = nullableBool;  // <- NPE
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение при распаковке Boolean: " + e.getClass().getSimpleName());
        }

        System.out.println("NullPointerExceptionDemo completed.");
    }
}
