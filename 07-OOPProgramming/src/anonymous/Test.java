package anonymous;

public class Test {
    public static void main(String[] args) {
//        Cheetah cheetah = new Cheetah();
//        cheetah.show("Cheetah", 120);
        Animals animal = new Animals() {
            @Override
            public void show(String name, int speed) {
                System.out.println(name + " runs at speed of " + speed + " km/h");
            }
        };

        animal.show("Cheetah", 120);
    }
}
