package finalKeyword;

public class Car extends Vehicle{

    String model = "Toyota";

    @Override
    public void showMaxSpeed() {
        System.out.println("Max speed of car is 220 km/h");
    }
}
