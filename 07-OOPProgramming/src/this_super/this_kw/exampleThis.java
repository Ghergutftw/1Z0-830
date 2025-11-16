package this_super.this_kw;

public class exampleThis {

    String car;
    String year;


    public exampleThis(){
        //damn
        this("DefaultCar", "2000");
    }


    public exampleThis(String car, String year) {
        // Este nevoie doar daca sunt same name
        this.car = car;
        this.year = year;
    }

    public void printHello(){
        System.out.println("hello");
        this.printWorld();
    }

    public void printWorld(){
        System.out.println("hello world");
    }


    public static void main(String[] args) {
        exampleThis vehicle = new exampleThis("Car", "2020");
        System.out.println("Vehicle: " + vehicle.car + ", Year: " + vehicle.year);
    }

}
