package inheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.eat("dog"); // private method, not accessible
        dog.drink("dog"); // protected method, accessible within the same package
        dog.move("dog");  // default method, accessible within the same package
        dog.breathe("dog"); // public method, accessible everywhere
        dog.bark(); // method from Dog class
    }
}