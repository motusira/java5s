public class SwitchFallThroughDemo {
    public static void main(String[] args) {
        int value = 2;
        int i = 0;

        switch (value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2; // выполнится
            case 3:
                i = 3; // тоже выполнится (fall-through)
                break;
            default:
                i = 0;
        }

        System.out.println("При value = " + value + ", i = " + i); // i = 3

        // Объяснение:
        // Если в case отсутствует break, выполнение "проваливается" (fall-through)
        // в следующий case, даже если его условие не совпадает со значением switch.
        // В данном примере при value == 2 выполняются оба присваивания: i = 2 и i = 3,
        // поэтому итоговое значение i - 3.

        // Другой пример: value = 3
        value = 3;
        switch (value) {
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
                break;
        }
        // Выведет только "case 3"

        // Если value = 2 в этом же блоке:
        value = 2;
        switch (value) {
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
                break;
        }
        // Выведет:
        // case 2
        // case 3
    }
}
