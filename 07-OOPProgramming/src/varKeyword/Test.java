package varKeyword;

import java.util.function.Function;

public class Test {



    public static void main(String[] args)
    {
        // Using 'var' for local variable type inference
        var message = "Hello, World!";
        var number = 42;
        var decimal = 3.14;

        System.out.println(message);
        System.out.println("Number: " + number);
        System.out.println("Decimal: " + decimal);

        var person = new Person();

        int age;
        //var text = null; // compile-time error: cannot infer type for 'var' with null initializer
        //number = "100"; // compile-time error: incompatible types: String cannot be converted to int

        var numbers = new int[]{1, 2, 3, 4, 5};

        //lambda
       // var stringLength = (var str) -> str.length(); // compilations-time error: 'var' not allowed in lambda parameters
    }

}
