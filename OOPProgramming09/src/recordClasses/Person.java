package recordClasses;

public record Person(String name, int age) implements Drink {

    public Person(){
        this(null,0);
    }

    //Compact canonical constructor
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public void yourNameIsBeautiful(){
        if(name.equals("Bianca")){
            System.out.println("Your name is beautiful!");
        }
    }

    @Override
    public void canDrink(String drinkName) {
        if (age >= 18) {
            System.out.println("Can drink " + drinkName);
        } else {
            System.out.println("Cannot drink " + drinkName);
        }
    }

}
