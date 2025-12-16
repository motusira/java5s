import java.util.Arrays;

public class ArraysUtilDemo {
    public static void main(String[] args) {
        // toString(...)
        int[] arr1 = {3, 1, 4, 1, 5};
        System.out.println("toString: " + Arrays.toString(arr1));

        // sort(...)
        int[] arr2 = {3, 1, 4, 1, 5};
        Arrays.sort(arr2);
        System.out.println("after sort: " + Arrays.toString(arr2));

        // binarySearch(...) - работает только на отсортированных массивах
        int index = Arrays.binarySearch(arr2, 4);
        System.out.println("binarySearch for 4: " + index); // 3

        // equals(...)
        int[] arr3 = {1, 1, 3, 4, 5};
        int[] arr4 = {1, 1, 3, 4, 5};
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("arr3 == arr4 (equals): " + Arrays.equals(arr3, arr4)); // true
        System.out.println("arr3 == arr5 (equals): " + Arrays.equals(arr3, arr5)); // false

        // compare(...) - доступен начиная с Java 9
        // Возвращает отрицательное, нулевое или положительное число
        // в зависимости от лексикографического сравнения массивов
        // (аналогично compareTo для строк)
        int cmp1 = Arrays.compare(arr3, arr4); // 0
        int cmp2 = Arrays.compare(arr3, arr5); // отрицательное число
        System.out.println("compare(arr3, arr4): " + cmp1);
        System.out.println("compare(arr3, arr5): " + cmp2);
    }
}
