package functionalInterfaces;

import java.util.List;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        list.stream()
                .map(input -> input * 2) // function
                .filter(input -> input % 2 == 0) // predicate
                .forEach(System.out::println); // consumer (it is the end)

        Supplier<Integer> supplier = () -> 10;
        System.out.println(list.contains(supplier.get()));
    }
}
