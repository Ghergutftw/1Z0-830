package abstractKeyword;

public abstract class Vehicle {

    String type;
    String model;

    //abstract method
    abstract int getMaxSpeed();

    public Vehicle(String type, String model) {
        this.type = type;
        this.model = model;
    }

    //non-abstract methods
    public void start(){
        System.out.println("Vehicle is starting");
    }

    public void stop(){
        System.out.println("Vehicle is stopping");
    }

    //functie implicita
    public final void displayInfo(){
        System.out.println("Type: " + type + ", Model: " + model + ", Max Speed: " + getMaxSpeed() + " km/h");
    }

    public static void info(){
        System.out.println("This is a Vehicle class");
    }




}
