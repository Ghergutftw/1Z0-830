package interfaceKeyword;

public interface CanFly extends Exists {

    void fly();
    void land();

    static int getAge(){
        return 0;
    }

    default void print(){
        System.out.println("I can fly");
    }
}
