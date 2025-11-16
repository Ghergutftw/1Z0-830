package encapsulation;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Ferrari", 350, true);
        System.out.println(car.isAutomatic());
    }

}
