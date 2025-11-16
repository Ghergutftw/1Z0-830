package access_modifiers.package_one;

public class Cat {


    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.privateMethod();
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }

    void defaultMethod() {
        System.out.println("This is a default method");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method");
    }

    public void publicMethod() {
        System.out.println("This is a public method");
    }

}
