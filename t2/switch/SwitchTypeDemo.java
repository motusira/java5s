public class SwitchTypeDemo {
    public static void main(String[] args) {
        // 1. byte
        byte b = 2;
        switch (b) {
            case 1: System.out.println("byte: 1"); break;
            case 2: System.out.println("byte: 2"); break;
        }

        // 2. short
        short s = 3;
        switch (s) {
            case 3: System.out.println("short: 3"); break;
        }

        // 3. int
        int i = 4;
        switch (i) {
            case 4: System.out.println("int: 4"); break;
        }

        // 4. char
        char c = 'A';
        switch (c) {
            case 'A': System.out.println("char: A"); break;
        }

        // 5. String (начиная с Java 7)
        String str = "hello";
        switch (str) {
            case "hello": System.out.println("String: hello"); break;
        }

        // 6. enum
        Color color = Color.RED;
        switch (color) {
            case RED: System.out.println("enum: RED"); break;
            case GREEN: System.out.println("enum: GREEN"); break;
        }

        // 7. Wrapper-типы: Byte, Short, Integer, Character
        Integer wrapped = 5;
        switch (wrapped) {
            case 5: System.out.println("Integer wrapper: 5"); break;
        }

        // Примечание: типы long, float, double, boolean и их оболочки - НЕДОПУСТИМЫ в switch.
    }

    enum Color {
        RED, GREEN, BLUE
    }
}

