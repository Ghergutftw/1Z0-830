package recordClasses;

import java.util.Objects;

public class PersonTwo {
    private final String name;
    private final int age;

    public PersonTwo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonTwo personTwo = (PersonTwo) o;
        return age == personTwo.age && Objects.equals(name, personTwo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "PersonTwo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
