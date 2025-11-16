package access_modifiers.package_one;

public class Dog {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.protectedMethod();
    }

}
