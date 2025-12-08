import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        niceFunctions();
    }

    static void try_catch_finally(){
        int number1, number2, result;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter first number  : ");
            number1 = input.nextInt();
            System.out.println("Enter second number  : ");
            number2 = input.nextInt();
            result = number1 / number2;
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("You have entered an invalid number");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("Goodbye!");
        }
    }

    static void throw_exception(){
        int number1, number2, result;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        number1 = input.nextInt();
        System.out.print("Enter second number: ");
        number2 = input.nextInt();
        try {
            if(number2 == 0) throw new ArithmeticException("You can't divide by zero");
            result = number1 / number2;
            System.out.println("The result is: " + result);

        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }


    }

    static void throws_exception(){
        try {
            divide();
        } catch (ArithmeticException | NumberFormatException e) {

            System.out.println("An exception occurred: " + e.getMessage());
            throw e;
        }
    }

    static void divide() throws ArithmeticException, NumberFormatException{
        int a = Integer.parseInt("10a");
        int b = Integer.parseInt("0");
        int c = a / b;
        System.out.println();
    }

    static void niceFunctions(){
        int number1, number2, result;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        number1 = input.nextInt();
        System.out.print("Enter second number: ");
        number2 = input.nextInt();

        if(number2 == 0) throw new ArithmeticException("You can't divide by zero");

        result = number1 / number2;
        System.out.println("The result is: " + result);
    }


}