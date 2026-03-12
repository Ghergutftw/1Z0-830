
import java.io.Serializable;

public class Person implements Serializable {
    String name, surname;
    int age;
    boolean married;
    transient long personId;
    transient Animal animal;

    public Person(String name, String surname, int age, boolean married, long personId, String animalName) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.married = married;
        this.personId = personId;
        this.animal = new Animal(animalName);
    }

    @Override
    public String toString() {
        return "name=" + name + ", surname=" + surname + ", age=" + age + ", married=" + married + ", personId="
                + personId;
    }

}
