package sealed;

sealed public class Animals permits Birds, Dog {

    private void eat(String animals){
        System.out.println(animals + " is eating");
    }

    protected void drink(String animals){
        System.out.println(animals + " is drinking");
    }

    void move(String animals){
        System.out.println(animals + " is moving");
    }

    public void breathe(String animals){
        System.out.println(animals + " is breathing");
    }

}
