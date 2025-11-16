package methodOverwriting;

public class Car extends Vehicle{

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }

    @Override
    public void accelerate(int speed){
        System.out.println("Car is accelerating to " + speed + " km/h");
    }

    @Override
    public void start() {

        System.out.println("Car is starting");
    }
}


