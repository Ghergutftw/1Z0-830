package anonymous;

public class Cheetah implements Animals{
    @Override
    public void show(String name, int speed) {
        System.out.println(name + " runs at speed of " + speed + " km/h");
    }
}
