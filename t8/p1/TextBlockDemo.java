public class TextBlocksDemo {
    public static void main(String[] args) {
        // Практика #3: три двойные кавычки - это текстовые блоки (text blocks)
        // Назначение: удобное задание многострочных строк без экранирования

        String json = """
        {
            "name": "Иван",
            "age": 25
        }
        """;

        String html = """
        <html>
            <body>
                <p>Привет, мир!</p>
            </body>
        </html>
        """;

        System.out.println("JSON:\n" + json);
        System.out.println("HTML:\n" + html);

        // Преимущества:
        // - автоматическое сохранение переносов строк;
        // - не нужно экранировать кавычки внутри;
        // - упрощает форматирование многострочного текста.
    }
}
