package polymorphism;

public class Test {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        Vehicle myCar = new Car();
        Vehicle myMotorcycle = new Motorcycle();

        myVehicle.accelerate();      // Outputs: The vehicle is accelerating.
        myCar.accelerate();          // Outputs: The car is accelerating.
        //The instance of the Vehicle class is referring to the Car class
        myMotorcycle.accelerate();   // Outputs: The motorcycle is accelerating.

        if (myCar instanceof Car) {
            System.out.println("myCar is an instance of Car");
        }

        //Car newCar = (Car) new Vehicle(); // This line will cause a compile-time error
        printAccelerate(myCar);
        printAccelerate(myMotorcycle);

        //Because of polymorphism,
        // the method that gets called is determined
        // by the actual object type, not the reference type.
    }

    public static void printAccelerate(Vehicle vehicle) {
        vehicle.accelerate();
    }

    /*
    public static void printAccelerate(Car car) {
        car.accelerate();
    }
    public static void printAccelerate(Motorcycle motorcycle) {
        motorcycle.accelerate();
    }
    */

}
