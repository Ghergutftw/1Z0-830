package interfaceKeyword;

public class People implements CanFed {
    @Override
    public void eat() {
        System.out.println("The person is eating.");
    }

    @Override
    public void drink() {
        System.out.println("The person is drinking.");
    }
}
