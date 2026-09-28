
import java.util.*;

public class ATM {

    static double balance = 1000.0;

    static ArrayList<String> transactions = new ArrayList<>();

    // Check Balance
    static void checkBalance() {
        System.out.println("Your balance is: ₹" + balance);
    }

    // Deposit
    static void deposit(Scanner sc) {

        System.out.print("Enter deposit amount: ₹");
        double amount = sc.nextDouble();

        if (amount > 0) {

            balance = balance + amount;

            transactions.add("Deposited: ₹" + amount);

            System.out.println("Deposit successful!");
            System.out.println("Updated balance: ₹" + balance);

        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw
    static void withdraw(Scanner sc) {

        System.out.print("Enter withdrawal amount: ₹");
        double amount = sc.nextDouble();

        if (amount > 0 && amount <= balance) {

            balance = balance - amount;

            transactions.add("Withdrawn: ₹" + amount);

            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: ₹" + balance);

        } else if (amount > balance) {

            System.out.println("Insufficient balance!");

        } else {

            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Transaction History
    static void showTransactions() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactions.isEmpty()) {

            System.out.println("No transactions yet.");

        } else {

            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int correctPin = 1234;
        int attempts = 0;
        boolean loginSuccessful = false;

        // PIN LOGIN
        while (attempts < 3) {

            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            if (pin == correctPin) {

                System.out.println("Login successful!");
                loginSuccessful = true;
                break;

            } else {

                attempts++;

                System.out.println("Wrong PIN!");
                System.out.println("Attempts left: " + (3 - attempts));
            }
        }

        if (!loginSuccessful) {

            System.out.println("Your account is blocked!");
            sc.close();
            return;
        }

        // ATM MENU
        int choice;

        do {

            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(sc);
                    break;

                case 3:
                    withdraw(sc);
                    break;

                case 4:
                    showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
