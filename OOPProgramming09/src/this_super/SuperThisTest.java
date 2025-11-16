package this_super;

public class SuperThisTest {

    public static void main(String[] args) {
        Car car = new Car("Sedan", "Toyota Camry", 210, true);
        System.out.println("Car Type: " + car.getType());
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Car Max Speed: " + car.getMaxSpeed() + " km/h");
        System.out.println("Is Automatic: " + car.isAutomatic());
    }

}
