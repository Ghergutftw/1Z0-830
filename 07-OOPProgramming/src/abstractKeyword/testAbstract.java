package abstractKeyword;

public class testAbstract {

    public static void main(String[] args) {

        Car myCar = new Car("Sedan", "Toyota Camry", 4);
        myCar.start();
        System.out.println("Max Speed: " + myCar.getMaxSpeed() + " km/h");
        myCar.stop();
        myCar.displayInfo();

    }

}
