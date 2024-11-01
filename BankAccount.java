import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private static int accountCounter = 1000;
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize account
    public BankAccount(String accountHolder, double initialBalance, int pin) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.pin = pin;
        this.accountNumber = ++accountCounter;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: $" + initialBalance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            transactionHistory.add("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Account balance: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void printAccountHolder() {
        System.out.println("Account holder: " + accountHolder);
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get account holder details and initial balance
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        System.out.print("Set a 4-digit PIN for your account: ");
        int pin = scanner.nextInt();

        BankAccount account = new BankAccount(name, initialBalance, pin);
        System.out.println("Account created successfully! Your account number is: " + account.accountNumber);

        // PIN verification loop
        System.out.print("Enter your PIN to access the account: ");
        int enteredPin = scanner.nextInt();
        while (enteredPin != account.pin) {
            System.out.print("Incorrect PIN. Please try again: ");
            enteredPin = scanner.nextInt();
        }

        // Menu for banking options
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
