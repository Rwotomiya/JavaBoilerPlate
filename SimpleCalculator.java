import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the first number
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Prompt the user for the second number
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Prompt the user to select an operation
        System.out.print("Choose an operation from here(+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        // Variable to store the result
        double result = 0;

        // Perform the calculation based on the chosen operation
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    scanner.close();
                    return;  // Exit if division by zero is attempted
                }
                break;
            default:
                System.out.println("Invalid operation. Please choose +, -, *, or /.");
                scanner.close();
                return;
        }

        // Display the result
        System.out.println("The result is: " + result);

        // Close the Scanner
        scanner.close();
    }
}