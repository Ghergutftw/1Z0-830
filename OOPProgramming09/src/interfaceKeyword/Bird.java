package interfaceKeyword;

public class Bird implements CanFed, CanFly {

    @Override
    public void eat() {
        System.out.println("The bird is eating.");
    }

    @Override
    public void drink() {
        System.out.println("The bird is drinking.");
    }

    @Override
    public void fly() {
        System.out.println("The bird is flying.");
    }

    @Override
    public void land() {
        System.out.println("The bird has landed.");
    }

    @Override
    public void live() {
        System.out.println("The bird is living.");
    }
}
