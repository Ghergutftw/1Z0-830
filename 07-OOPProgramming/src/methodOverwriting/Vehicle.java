package methodOverwriting;

public class Vehicle {

    protected void stop(){
        System.out.println("Vehicle is stopping");
    }

    public void accelerate(int speed){
        System.out.println("Vehicle is accelerating to " + speed + " km/h");
    }

    void start(){
        System.out.println("Vehicle is starting");
    }

}
