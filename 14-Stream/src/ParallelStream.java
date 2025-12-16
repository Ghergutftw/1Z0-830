import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream().forEach(System.out::print);
        System.out.println("\n");

        //Concurrent Reduction
        ConcurrentMap<Boolean, List<Integer>> collect = numbers
                .parallelStream()
                .unordered() // ensures the unordered characteristic for concurrent reduction
                .collect(Collectors.groupingByConcurrent(integer -> integer % 2 == 0));

        System.out.println(collect);
        Set<Collector.Characteristics> characteristics = Collectors.groupingByConcurrent(integer -> "Java").characteristics();
        System.out.println(characteristics);

        //Ordering
        System.out.println("List of numbers : ");
        numbers.stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n");

        Comparator<Integer> reverse = Comparator.reverseOrder();
        numbers.sort(reverse);
        numbers.stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n");

        System.out.println("List of numbers with Parallel Stream : ");
        numbers.parallelStream().forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n");

        System.out.println("List of numbers with Another Parallel Stream : ");
        numbers.parallelStream().forEach(integer -> System.out.print(integer + " "));
        System.out.println("\n");

        System.out.println("List of numbers with Another Parallel Stream and with forEachordered : ");
        numbers.parallelStream().forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println("\n");
    }
}
