package encapsulation;

public class Car extends Vehicle {

    private boolean isAutomatic;

    public Car(String model, int maxSpeed, boolean isAutomatic) {
        super(model, maxSpeed);
        this.isAutomatic = isAutomatic;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

}
