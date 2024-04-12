public class CalcOperations {


    public static double calc(double num1, double num2, Operation operation) {

        switch (operation) {
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            case MULTIPLICATION:
                return num1 * num2;
            case DIVISION:
                if (num2 != 0) {
                    return  num1 / num2;
                } else if (num1 == 0) {
                    return 0;
                } else {
                    System.out.println("Error: Division by zero");
                    return Double.NaN;
                }
            default:
                System.out.println("Invalid operation");
                return Double.NaN;
        }
    }

}
