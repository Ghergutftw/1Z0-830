package calculator;

public class Calculator {

    public void calculate(double a, double b, Operation operation) {
        operation.performOperation(a, b);
    }

}
