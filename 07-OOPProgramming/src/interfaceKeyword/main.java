package interfaceKeyword;

public class main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.eat();
        bird.drink();
        bird.fly();
        bird.land();
        bird.live();
        bird.print();

        int age = CanFly.getAge();
        System.out.println("Age from CanFly interface: " + age);
    }
}
