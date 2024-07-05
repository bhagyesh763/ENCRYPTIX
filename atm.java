import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class encryptix {
    private BankAccount account;
    private Scanner scanner;

    public encryptix() {
        scanner = new Scanner(System.in);
        account = new BankAccount(1000);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void handleCheckBalance() {
        double balance = account.checkBalance();
        System.out.println("Your current balance is: $" + balance);
    }

    public static void main(String[] args) {
        encryptix atm = new encryptix();
        atm.run();
    }
}
