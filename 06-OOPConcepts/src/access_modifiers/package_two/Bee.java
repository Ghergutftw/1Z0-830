package access_modifiers.package_two;

import access_modifiers.package_one.Cat;

public class Bee {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.publicMethod();
    }

}
