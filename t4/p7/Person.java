public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределение equals()
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на ссылочное равенство
        if (this == obj) {
            return true;
        }

        // 2. Проверка на null
        if (obj == null) {
            return false;
        }

        // 3. Проверка на принадлежность к тому же классу
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 4. Приведение типа
        Person other = (Person) obj;

        // 5. Сравнение полей
        if (age != other.age) {
            return false;
        }
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

    // Обязательно переопределяем hashCode() при переопределении equals()
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

