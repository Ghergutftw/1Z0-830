public class Employee {

    String name;
    int salary;
    public enum Sex {
        MALE, FEMALE
    }
    Sex Gender;

    public Employee(String name, int salary, Sex gender) {
        this.name = name;
        this.salary = salary;
        Gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Sex getGender() {
        return Gender;
    }
}
