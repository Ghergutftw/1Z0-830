package finalKeyword;

public class FinalTest {

    public static final int NUMBER = 10;

    public static void main(String[] args) {
        /*
        Car car = new Car();
        System.out.println(car.model);
        car.model = "Honda"; // This line will cause a compilation error
         */

        int number = NUMBER - 2;

        for (int i = 0; i <= NUMBER; i++) {

            System.out.println(i + " ");
        }
    }

}
