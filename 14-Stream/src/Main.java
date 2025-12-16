import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        collect();
    }

    static void exampleStream() {
        List<Integer> list = List.of(3, 5, 6, 123, 12, 31, 1, 3, 5, 7, 8);

        /*
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
        */

        Function<Integer, Integer> square = integer -> integer * integer;
        Predicate<Integer> isOdd = integer -> integer % 2 == 1;

        list.stream()
                .filter(isOdd)
                .map(square)
                .sorted() // natural order
                .distinct() // remove duplicates intermediate operator --> Returns a new stream
                .forEach(System.out::println); // terminal operator --> Doesnt remove a stream

        System.out.println("======");

        List<String> animals = List.of("cat", "dog", "bird", "fish");
        Stream<String> stream = animals.stream();
        Stream<String> stringStream = stream.map(String::toUpperCase);
        stringStream.forEach(System.out::println);
    }

    static void reduce(){
        /*

        List<Integer> nums = List.of(1,2,3,4,5);
        // 1+2, result + 3, result + 4, result + 5
        Optional<Integer> sum = nums.stream().reduce(Integer::sum);
        sum.ifPresent(System.out::println);

        //No more optional because we give it a 0 at the start, so no NPE
        Integer sum2 = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        //No more optional because we give it a 0 at the start, so no NPE
        Integer elementProduct = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println(elementProduct);

        //max value
        Optional<Integer> maxValue = nums.stream().reduce((a, b) -> a > b ? a : b);
        maxValue.ifPresent(System.out::println);

        */

         List<Employee> employees = List.of(
                 new Employee("Alice", 70000, Employee.Sex.FEMALE),
                 new Employee("Bob", 50000, Employee.Sex.MALE),
                 new Employee("Charlie", 60000, Employee.Sex.MALE),
                 new Employee("Andy", 30000, Employee.Sex.MALE),
                 new Employee("Diana", 80000, Employee.Sex.FEMALE)
         );

        Optional<Employee> highestPaidEmployee = employees.stream().reduce((employee1, employee2)
                -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2);
        highestPaidEmployee.ifPresent(employee -> System.out.println(employee.getName()));

                                                //create a list of salaries // then it adds them to 0
        Integer totalSalary = employees.stream().map(Employee::getSalary).reduce(0, Integer::sum);
        System.out.println("Total Salary: " + totalSalary);

        Optional<String> concatenatedNames = employees.stream().map(Employee::getName)
                .reduce((name1, name2) -> name1 + ", " + name2);
        concatenatedNames.ifPresent(System.out::println);
    }

    static void collect(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Charlie", "Diana", "Eve");
        List<String> collectedNames = names.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        System.out.println(collectedNames);

        Set<String> collectedSetNames = names.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toSet());
        System.out.println(collectedSetNames);

        String joinedNames = names.stream().collect(Collectors.joining("_" , "&" , "#"));
        System.out.println("Joined : " + joinedNames);

        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length : " + collect);
        //Grouped by length : {3=[Bob, Eve], 5=[Alice, Diana], 7=[Charlie, Charlie]}


        Map<Boolean, List<String>> partitionedByLength = names.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));
        System.out.println("Partitioned by length : " + partitionedByLength);
        //Partitioned by length : {false=[Bob, Eve], true=[Alice, Charlie, Charlie, Diana]}


        LinkedList<String> linkedList = names.stream()
                .filter(s -> s.length() > 4)
                // convert to data structure
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Linked List : " + linkedList);

        List<Employee> employees = List.of(
                new Employee("Alice", 70000, Employee.Sex.FEMALE),
                new Employee("Bob", 50000, Employee.Sex.MALE),
                new Employee("Charlie", 60000, Employee.Sex.MALE),
                new Employee("Andy", 30000, Employee.Sex.MALE),
                new Employee("Diana", 80000, Employee.Sex.FEMALE)
        );

        // group by gender and average salary
        Map<Employee.Sex, Double> genderGap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(genderGap);
        //{FEMALE=75000.0, MALE=46666.666666666664}

        SalaryCollector totalSalaries = employees.stream().map(Employee::getSalary).collect(
                SalaryCollector::new, SalaryCollector::accept, SalaryCollector::combine
        );
        System.out.println(totalSalaries.toString());
    }

    static class SalaryCollector {
        private int total = 0;
        private int count = 0;

        public void accept(int salary){
            this.total += salary;
            this.count++;
        }

        // used for pararell working so that at the end they can be combined
        public void combine(SalaryCollector other){
            this.total += other.total;
            this.count += other.count;
        }

        public int getTotal() {
            return total;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "SalaryCollector{" +
                    "total=" + total +
                    ", count=" + count +
                    '}';
        }
    }

}