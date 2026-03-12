import java.io.*;
import java.util.Scanner;

public class Main {

    final static String FILE_NAME="file.txt";

    public static void main(String[] args) {
        coping();
    }

    static void writer(){
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

    static void reader(){
        try{
            Reader reader = new FileReader(FILE_NAME);
            while(reader.ready()){
                reader.skip(1);
                System.out.print((char)reader.read());
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

    static void coping(){
        try{
            Reader reader = new FileReader(FILE_NAME);
            Writer writer = new FileWriter("Copy_"+FILE_NAME);

            StringBuffer copyOfText = new StringBuffer();

            while(reader.ready()){
                copyOfText.append((char)reader.read());
            }

            writer.write(copyOfText.toString());
            reader.close();
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
