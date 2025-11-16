package recordClasses;

public class OuterPerson {


    public record InnerPerson(String name){
        public void greet(){
            System.out.println("Hello, " + name + "!");
        }
    }

}
