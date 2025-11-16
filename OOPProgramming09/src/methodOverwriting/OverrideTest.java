package methodOverwriting;

public class OverrideTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.start();          // Calls Vehicle's start method
        vehicle.accelerate(100); // Calls Vehicle's accelerate method
        vehicle.stop();          // Calls Car's overridden stop method

        Car car = new Car();
        car.start();             // Calls Vehicle's start method
        car.accelerate(150);    // Calls Vehicle's accelerate method
        car.stop();

    }
}



