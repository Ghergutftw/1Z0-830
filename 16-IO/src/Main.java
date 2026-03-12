import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static String FILE_NAME = "file.txt";
    private static Object object;

    public static void main(String[] args) {
        serialization();
    }

    static void writer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        try {
            Writer writer = new FileWriter(FILE_NAME);
            writer.write(input);
            System.out.println("Successfully wrote to the file.");
            scanner.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void reader() {
        try {
            Reader reader = new FileReader(FILE_NAME);
            while (reader.ready()) {
                reader.skip(1);
                System.out.print((char) reader.read());
                Thread.sleep(50);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static void coping() {
        try {
            Reader reader = new FileReader(FILE_NAME);
            Writer writer = new FileWriter("Copy_" + FILE_NAME);

            StringBuffer copyOfText = new StringBuffer();

            while (reader.ready()) {
                copyOfText.append((char) reader.read());
            }

            writer.write(copyOfText.toString());
            reader.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void serialization() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Benjamin", "Ghergut", 21, false, 1, "kaka"));
        personList.add(new Person("Jaja", "Cocolino", 41, true, 2, "Marta"));
        personList.add(new Person("Daniel", "Jaja", 61, true, 3, "pookie"));
        personList.add(new Person("Lucian", "Cocolino", 28, false, 4, "lucy"));
        try {
            FileOutputStream fileOut = new FileOutputStream("Persons.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(personList);
            out.close();
            fileOut.close();
            System.out.println("Object has been serialized");
            deserialization();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void deserialization() {
        try {
            FileInputStream input = new FileInputStream("Persons.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            Object object = objectInputStream.readObject();
            ArrayList<Person> list = (ArrayList<Person>) object;
            System.out.println("");
            list.forEach(arg0 -> System.out.println(arg0.toString()));
            input.close();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
