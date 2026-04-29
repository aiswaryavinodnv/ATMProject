import java.util.Scanner;

public class Atm {

    // Account details
    static String cardNumber = "1234";
    static String pin = "0000";
    static double balance = 10000.00;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Ask for card number
        System.out.print("Enter Card Number: ");
        String enteredCard = sc.nextLine();

        if (!enteredCard.equals(cardNumber)) {
            System.out.println("Invalid card number. Exiting.");
            sc.close();
            return;
        }

        // Step 2: Ask for PIN (max 3 attempts)
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            String enteredPin = sc.nextLine();

            if (enteredPin.equals(pin)) {
                loggedIn = true;
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Card blocked. Too many wrong attempts.");
            sc.close();
            return;
        }

        // Step 3: Show menu
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = sc.nextLine();
            choice = Integer.parseInt(input);

            if (choice == 1) {
                System.out.println("Your balance is: Rs. " + balance);

            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: Rs. ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                } else {
                    balance += amount;
                    System.out.println("Deposited successfully. New balance: Rs. " + balance);
                }

            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: Rs. ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                } else if (amount > balance) {
                    System.out.println("Insufficient balance!");
                } else {
                    balance -= amount;
                    System.out.println("Please collect your cash. Remaining balance: Rs. " + balance);
                }

            } else if (choice == 4) {
                System.out.println("Thank you for using our ATM. Goodbye!");

            } else {
                System.out.println("Invalid choice. Please enter 1 to 4.");
            }
        }

        sc.close();
    }
}