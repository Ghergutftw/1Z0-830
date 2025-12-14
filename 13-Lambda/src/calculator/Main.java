package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        var a = scanner.nextInt();
        System.out.println("Enter the second number: ");
        var b = scanner.nextInt();

        Calculator calculator = new Calculator();
        /* with annomyous class
        calculator.calculate(a, b, new Operation() {
            @Override
            public void performOperation(double a, double b) {

            }5
        });
         */

        calculator.calculate(a,b,(x, y) -> {
            System.out.println(x + " + " + y + " = " + (x + y));
            System.out.println(x + " - " + y + " = " + (x - y));
            System.out.println(x + " * " + y + " = " + (x * y));
            System.out.println(x + " / " + y + " = " + (x / y));
        });
    }

}
