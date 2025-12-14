package lambdas;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Animals() {
            @Override
            public void show(String animal, int speed) {
                System.out.println(animal + " runs at " + speed + " km/h");
            }
        };
        animal.show("Dog", 100);

        //Deci e ca o clasa anonima, doar ca faptul ca are DOAR o interfata ii permite sa fie facuta prin lambda
        Animals animal2 = (name, speed) ->
                System.out.println(name + " runs at " + speed + " km/h");
        animal2.show("Cat", 50);

        Animals animal3 = Main::display;
        animal3.show("Bird", 150);
    }

    public static void display(String name, int speed) {
        System.out.println(name + " runs at " + speed + " km/h");
    }
}