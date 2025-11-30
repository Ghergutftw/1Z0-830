import java.util.*;

public class Main {
    public static void main(String[] args) {
        map();
    }

    static void list(){
        //Polymorphic
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add(1, "c");
        list1.set(2, "d");
        System.out.println(list1);


        //Involuare simpla
        List<Double> list2 = new ArrayList<>();
        //Involuare dubla
        Collection<String> list3 = new ArrayList<>();

        List list4 = new ArrayList(); //default Object
        list4.add("String");
        String message = (String) list4.get(0);
        System.out.println(message.toLowerCase());
    }

    static void arrayList(){
        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(14);
        ages.add(18);
        ages.add(20);
        System.out.println("ages: " + ages);

        ArrayList<Object> mixedList = new ArrayList<>();
        mixedList.add("Hello");
        mixedList.add(25);
        mixedList.add(3.14);
        mixedList.add(true);
        System.out.println("mixedList: " + mixedList);

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        // Adaugare la o pozitie specifica si shiftare
        animals.add(2, "Elephant");
        animals.add(1, "Tiger");
        // Dog Cat Elephant  -> Dog Tiger Cat Elephant
        System.out.println("animals: " + animals);
        animals.remove("Elephant");
        animals.remove(1);
        System.out.println("animals after removals: " + animals);

        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");

        names.add("Bob");
        names.add("Charlie");

        System.out.println("Size of names list: " + names.size());
        System.out.println("Is names list empty? " + (names.isEmpty() ? "Yes" : "No"));
        System.out.println("Contains 'Bob'? " + (names.contains("Bob") ? "Yes" : "No"));

        // equals
        ArrayList<String> namesCopy = new ArrayList<>();
        namesCopy.add("Alice");
        namesCopy.add("Bob");
        namesCopy.add("Charlie");
        System.out.println("names equals namesCopy? " + (names.equals(namesCopy) ?
                "Yes" : "No"));
    }

    static void conversionBetweenArraysAndLists(){
        // Convert Array to List
        String[] array = {"A", "B", "C"};
        List<String> listFromArray = new ArrayList<>();
        for (String element : array) {
            listFromArray.add(element);
        }
        System.out.println("List from Array: " + listFromArray);

        // Convert List to Array
        List<String> list = new ArrayList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");
        String[] arrayFromList = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrayFromList[i] = list.get(i);
        }
        System.out.print("Array from List: ");
        for (String element : arrayFromList) {
            System.out.print(element + " ");
        }
    }

    static void ListVsArrayVsArrayList(){
        //List -> Array
        List<String> animalsList = new ArrayList<>();
        animalsList.add("Cat");
        animalsList.add("Dog");
        animalsList.add("Cow");
        animalsList.add("Lion");

        /*
        String[] animalsArray = new String[animalsList.size()];

        //for loop
        for (int i = 0; i < animalsList.size(); i++){
            animalsArray[i] = animalsList.get(i);
        }*/

        //Object[] animalsArray = animalsList.toArray();

        //String[] animalsArray = new String[animalsList.size()];
        String[] animalsArray = animalsList.toArray(new String[animalsList.size()]);

        animalsList.add("Ant");

        System.out.println("animalsList = " + animalsList);
        System.out.println("animalsArray = " + Arrays.toString(animalsArray));

        //Array -> List
        String[] carsArray = {"Ferrari", "Mercedes", "BMW", "Ford"};

        List<String> carsList = Arrays.asList(carsArray);
        //ArrayList<String> carsList = new ArrayList<>(Arrays.asList(carsArray));

        //ArrayList<String> carsList = new ArrayList<>();
        //Collections.addAll(carsList,carsArray);

        /*
        for (String car : carsArray){
            carsList.add(car);
        }*/

        //carsList.add("Opel");
        carsArray[1] = "Hyundai";
        carsList.set(2,"Honda");

        System.out.println("carsArray = " + Arrays.toString(carsArray));
        System.out.println("carsList = " + carsList);

    }

    static void sortingArrayList(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(4);

        System.out.println("Before sorting: " + numbers);

        Collections.sort(numbers);

        System.out.println("After sorting: " + numbers);

        ArrayList<String> words = new ArrayList<>();
        words.add("Banana");
        words.add("Abd");
        words.add("Abc");
        words.add("300");
        words.add("231");
        words.add("21");
        words.add("ant");
        words.add("Zebra");
        System.out.println("Before sorting: " + words);
        Collections.sort(words);
        System.out.println("After sorting: " + words);


    }

    static void comparatorInterface(){
        class Person implements Comparable<Person> {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person other) {
                // natural ordering: by age
                return Integer.compare(this.age, other.age);
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        ArrayList<Person> people =  new ArrayList<>();
        people.add(new Person("Ana", 18));
        people.add(new Person("Maria", 19));
        people.add(new Person("Bianca", 20));

        List<Person> sorted = new ArrayList<>(people);
        Collections.sort(sorted);

        System.out.println(sorted);

        // Anonymous Class
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        Collections.sort(people, comparator);
        System.out.println(people);

    }

    static void searchingInArrayList(){
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");

        String targetFruit = "Citrice";

        System.out.println("Ar fi la pozitia " + Collections.binarySearch(fruits, targetFruit));
        /* -4
        Explicatie:
        Collections.binarySearch returneaza un numar negativ daca elementul nu este gasit.
        Acest numar negativ este calculat ca -(insertion point) - 1,
        unde insertion point este pozitia la care elementul ar trebui inserat pentru a
        mentine ordinea sortata a listei.
        In acest caz, "Citrice" ar trebui sa fie inserat la indexul
        3 (intre "Cherry" si "Date"), deci insertion point este 3.
        Astfel, calculul este: -(3) - 1 = -4.
         */
    }

    static void IteratorAndListIterator(){
        ArrayList<Integer> numbersList = new ArrayList<>();

        int i = 1;
        while (i < 51){
            numbersList.add(i);
            i++;
        }
        System.out.println("numbersList = " + numbersList);

        //ListIterator
        ListIterator<Integer> listIterator = numbersList.listIterator();
        while (listIterator.hasNext()){
            int indexes = listIterator.nextIndex();
            System.out.print(indexes + " ");

            int eachElement = listIterator.next();

            if (eachElement % 3 != 0){
                listIterator.set(-1);
            }

        }
        System.out.println();
        System.out.println("newNumbersList = " + numbersList);

        /*
        //Iterator
        Iterator<Integer> iterator = numbersList.iterator();
        while (iterator.hasNext()){

            int eachElement = iterator.next();

            if (eachElement % 3 != 0){
                iterator.remove();
            }

        }
        System.out.println("newNumbersList = " + numbersList);

        */
    }

    static void setInterface(){
        Set<String> animalsSet = new HashSet<>();
        animalsSet.add("Cat");
        animalsSet.add("Dog");
        animalsSet.add("Cow");
        animalsSet.add("Lion");
        animalsSet.add("Ant");
        animalsSet.add("Dog");

        System.out.println("animalsSet = " + animalsSet);
        System.out.println("size of animalsSet = " + animalsSet.size());
        animalsSet.remove("Cow");
        System.out.println("REMOVE COW!");

        System.out.println("Do I have a lion ? " + (animalsSet.contains("Lion") ? "yes" : "no"));
        System.out.println("animalsSet = " + animalsSet);
        System.out.println("size of animalsSet = " + animalsSet.size());

        System.out.println("===================================");

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);

        System.out.println("set1 = " + set1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(4);
        set2.add(6);
        set2.add(8);
        set2.add(9);

        System.out.println("set2 = " + set2);

        System.out.println("are they equal" + (set1.equals(set2) ? "true" : "false"));

        //Intersection -> retainAll()
        Set<Integer> intersectionSet = new HashSet<>(set1);
        //Face 2 operatii, intersectia, iar functia retainAll intoarce faptul daca a fost modificat sau nu
        intersectionSet.retainAll(set2);
        System.out.println("intersection = " + intersectionSet);
        //[1, 4, 6]

        //Union -> addAll()
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("union = " + unionSet);
        //[1, 2, 3, 4, 5, 6, 8, 9]

        //Difference -> removeAll()
        Set<Integer> differenceSet = new HashSet<>(set1);
        //Ce e in set1 si nu e in set 2
        differenceSet.removeAll(set2);
        System.out.println("Difference = " + differenceSet);
        //[2, 3, 5]
    }

    static void hashSet(){
        HashSet<String> carsHashSet = new HashSet<>();
        carsHashSet.add("Mercedes");
        carsHashSet.add("Toyota");
        carsHashSet.add("BMW");
        carsHashSet.add("Dacia");
        carsHashSet.add(null);
        System.out.println("carsHashSet = " + carsHashSet);
        //null, Toyota, Dacia, Mercedes, BMW
    }

    static void linkedHashSet(){
        LinkedHashSet<String> carsLinkedHashSet = new LinkedHashSet<>();
        carsLinkedHashSet.add("Mercedes");
        carsLinkedHashSet.add("Toyota");
        carsLinkedHashSet.add("BMW");
        carsLinkedHashSet.add("Dacia");
        carsLinkedHashSet.add(null);
        System.out.println("carsLinkedHashSet = " + carsLinkedHashSet);
        //Mercedes, Toyota, BMW, Dacia, null
    }

    static void treeSet(){
        class Person implements Comparable<Person> {
            private String name;
            private int age;
            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return  name + " " + age;
            }

            @Override
            public int compareTo(Person other) {
                // Compare based on age first
                if (this.age != other.age) {
                    return Integer.compare(this.age, other.age);
                }
                // If ages are equal, compare by name to ensure uniqueness
                return this.name.compareTo(other.name);
            }
        }
        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new  Person("Maria", 18));
        personTreeSet.add(new  Person("Bianca", 21));
        personTreeSet.add(new  Person("Ana", 19));
        personTreeSet.add(new  Person("David", 19));
        personTreeSet.add(new   Person("Sofia", 5));
        System.out.println("personTreeSet = " + personTreeSet);
        //[Sofia 5, Maria 18, Ana 19, David 19, Bianca 21]
        System.out.println("Descending: "  +  personTreeSet.descendingSet());
        System.out.println("Head Set: " + personTreeSet.headSet(new Person("David", 19), true));
        // inclusive = true ->  [Sofia 5, Maria 18, Ana 19, David 19]
        // inclusive = false ->  [Sofia 5, Maria 18, Ana 19]
        System.out.println("Sub Set(Maria David: " + personTreeSet.subSet(new Person("Maria", 18), true, new Person("David", 19), true));
        // [Maria 18, Ana 19, David 19]
        System.out.println("Tail Set: " + personTreeSet.tailSet(new Person("Ana", 19), true));
        // inclusive = false -> [David 19, Bianca 21]
        // inclusive = true -> [Ana 19, David 19, Bianca 21]
        System.out.println("First: " + personTreeSet.first());
        // Maria 18
        System.out.println("Last: " + personTreeSet.last());
        // Bianca 21

        System.out.println("Remove first element: " + personTreeSet.pollFirst());
        System.out.println("After removing first element: " + personTreeSet);
        System.out.println("Remove last element: " + personTreeSet.pollLast());
        System.out.println("After removing last element: " + personTreeSet);


    }

    static void queue(){
        Queue<String> carsQueue = new LinkedList<>();
        carsQueue.offer("Mercedes");
        carsQueue.offer("Mazda");
        carsQueue.offer("BMW");
        carsQueue.offer("Volvo");
        System.out.println("carsQueue = " + carsQueue +  " size = " + carsQueue.size());
        // carsQueue = [Mercedes, Mazda, BMW, Volvo] size = 4
        System.out.println("First element: " + carsQueue.peek());
        // First element: Mercedes // afiseaza elementul urmator
        System.out.println("Removed element: " + carsQueue.poll());

        System.out.println("carsQueue = " + carsQueue +  " size = " + carsQueue.size());

        int size = carsQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(carsQueue.poll());
        }


    }

    static void deque(){

        Deque<String> carsDeque = new LinkedList<>();
        carsDeque.add("Mercedes");
        carsDeque.add("BMW");
        carsDeque.add("Ferrari");
        carsDeque.addFirst("Ford");
        carsDeque.addLast("Opel");
        carsDeque.push("Honda");
        carsDeque.offer("Hyundai");
        carsDeque.offerFirst("Kia");
        carsDeque.offerLast("Renault");

        System.out.println("carsDeque = " + carsDeque);

        System.out.println("Removed element = " + carsDeque.removeFirst());
        System.out.println("Last version of carsDeque = " + carsDeque);

        System.out.println("Removed element = " + carsDeque.removeLast());
        System.out.println("Last version of carsDeque = " + carsDeque);

    }

    static void map(){
        Map<String, Integer> carsMap = new HashMap<>();
        carsMap.put("Mercedes", 20000);
        carsMap.put("BMW", 15000);
        carsMap.put("Volvo", 18000);
        carsMap.put("Volvo", 15000);
        System.out.println("carsMap = " + carsMap);
        System.out.println("carsMap.get(BMW) = " + carsMap.get("BMW"));
        for (String key : carsMap.keySet()){
            System.out.println("Key: " + key + " -> Value: " + carsMap.get(key));
        }

        for (Map.Entry<String, Integer> entry : carsMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + " -> Value: " + entry.getValue());
        }
    }


}