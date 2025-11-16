import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        helloWorld();
    }

    public static void varArgs(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the numbers you want to sum to (with a space between)");
        String[] input = sc.nextLine().split(" ");
        sumNumbers(input);
    }

    public static void sumNumbers(String... numbers){
        int sum = 0;
        StringBuilder enteredNumbers = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
            if(i != numbers.length - 1){
                enteredNumbers.append(numbers[i]).append("+");
            }else{
                enteredNumbers.append(numbers[i]);
            }
        }

        System.out.println(enteredNumbers + " = " + sum);
    }



    public static class HelloWorld{
        public String helloWorld(){
            return "Hello World";
        }
    }
    
}