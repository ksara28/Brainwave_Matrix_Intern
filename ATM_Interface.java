
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String pin;
    private double balance;

    public Account(int accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class ATM {
    private Map<Integer, Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);

        // Initialize accounts
        accounts.put(1234, new Account(1234, "1234", 1000.0));
        accounts.put(5678, new Account(5678, "5678", 500.0));
    }

    public void run() {
        while (true) {
            System.out.println("Welcome to ATM");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Thank you for using ATM");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void login() {
        System.out.print("Enter account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account account = accounts.get(accountNumber);

        if (account != null && account.getPin().equals(pin)) {
            accountMenu(account);
        } else {
            System.out.println("Invalid account number or PIN");
        }
    }

    private void accountMenu(Account account) {
        while (true) {
            System.out.println("Account Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    deposit(account);
                    break;
                case 4:
                    System.out.println("Logged out");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void checkBalance(Account account) {
        System.out.println("Balance: " + account.getBalance());
    }

    private void withdraw(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    private void deposit(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful");
        } else {
            System.out.println("Invalid amount");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}

example account no:1234
pin no:1234