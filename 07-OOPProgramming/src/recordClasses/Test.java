package recordClasses;

public class Test {
    public static void main(String[] args) {
//        PersonTwo person= new PersonTwo("Alice", 30);
//        PersonTwo person2= new PersonTwo("Alice", 30);
//
//        //getters
//        System.out.println("Name: " + person.getName());
//        System.out.println("Age: " + person.getAge());
//
//        System.out.println(person.toString());
//
//        //equals
//        System.out.println("person equals person2: " + person.equals(person2));
//        System.out.println("person hashCode: " + person.hashCode());
//        System.out.println("person2 hashCode: " + person2.hashCode());

        Person person= new Person("Alice", 30);
        Person person2= new Person("Alice", 30);

        //getters
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        System.out.println(person.toString());

        //equals
        System.out.println("person equals person2: " + person.equals(person2));
        System.out.println("person hashCode: " + person.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());

        Person person3= new Person();

        try {
            Person person4= new Person("Alice", -5);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Person person5= new Person("Bianca", 25);
        person5.yourNameIsBeautiful();

        OuterPerson.InnerPerson innerPerson= new OuterPerson.InnerPerson("Bob");
        innerPerson.greet();


    }
}
