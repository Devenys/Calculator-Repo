import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorApp {

    private Calculator calculator;

    public CalculatorApp(){
        calculator = new Calculator();
    }

    public void performCalc() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean keepCalcGoing = true;
            while (keepCalcGoing) {
                System.out.println("Enter first number: ");
                double num1 = Double.parseDouble(br.readLine());

                System.out.println("Enter operation (+, -, *, /):");
                String operationStr = br.readLine();

                Operation operation = getOperation(operationStr);
                if (operation == null){
                    System.out.println("Invalid operation.");
                }

                System.out.println("Enter second number: ");
                double num2 = Double.parseDouble(br.readLine());

                double result = calculator.calculate(num1, num2, operation);
                System.out.println("Result: " + result);

                System.out.println("Do you want to continue? (Y/N)");
                String option = br.readLine();
                keepCalcGoing = option.equalsIgnoreCase("Y");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Operation getOperation(String operationStr) {
        switch (operationStr) {
            case "+":
                return Operation.ADDITION;
            case "-":
                return Operation.SUBTRACTION;
            case "*":
                return Operation.MULTIPLICATION;
            case "/":
                return Operation.DIVISION;
            default:
                return null;
        }
    }

}
