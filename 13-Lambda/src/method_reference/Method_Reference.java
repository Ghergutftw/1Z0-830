package method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Method_Reference {
    public static void main(String[] args) {
        List<String> animals = List.of("Dog", "Cat", "Cow", "Cock",  "Bird", "Fish");

        animals.forEach(s -> System.out.println(s)); // lambda

        animals.forEach(System.out::println); // method reference

        Consumer<String> animalConsumer = System.out::println;
        animals.forEach(animalConsumer);

        Consumer<List<String>> animalsConsumer = System.out::println;
        animalsConsumer.accept(animals);


        //Static Method Reference
        Function<String, Boolean> startWithB = s -> s.startsWith("B");
        Function<String, Integer> toNumber = Integer::parseInt;
        Integer number = toNumber.apply("123");

        //Method Reference via Object
        String word = "hello";
        Supplier<String> supplier = word::toUpperCase;
        System.out.println(supplier.get());

        //Constructor Reference
        Supplier<ArrayList<String>> arrayListSupplier = ArrayList::new;
        ArrayList<String> myList = arrayListSupplier.get();

    }
}
