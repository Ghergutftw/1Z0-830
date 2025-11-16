package polymorphism;

public class Car extends Vehicle {
    @Override
    public void accelerate() {
        System.out.println("The car is accelerating.");
    }
}
