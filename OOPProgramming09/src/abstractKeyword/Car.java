package abstractKeyword;

public class Car extends Vehicle{

    int numberOfDoors;

    public Car(String type, String model, int numberOfDoors) {
        super(type, model);
        this.numberOfDoors = numberOfDoors;
    }

    // implementation of abstract method from Vehicle class
    @Override
    int getMaxSpeed() {
        return 200;
    }

    // inheritance of non-abstract method from Vehicle class
    @Override
    public void start() {
        System.out.println("Car is starting with a roar!");
    }
}
