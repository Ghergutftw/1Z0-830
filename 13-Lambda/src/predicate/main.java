package predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class main {
    public static void main(String[] args) {
        Predicate<String> p0 = s -> s.length() > 5;
        System.out.println(p0.test("Hello")); // false

        Predicate<Integer> p1 = m -> m % 2 == 0;
        Predicate<Integer> p2 = m -> m > 5;

        Predicate<Integer> p3 = p1.and(p2); // m must be even AND greater than 5

        System.out.println(p3.test(10));

        Predicate<String> p4 = s -> s.length() > 3;

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bird");
        animals.add("Fish");
        System.out.println(animals);
        animals.removeIf(p4); // an  animals.removeIf(s -> s.length() > 3)
        System.out.println(animals);

        System.out.println(isEven(10, p1));
    }

    public static boolean isEven (int number, Predicate<Integer> predicate){
        return predicate.test(number);
    }
}
