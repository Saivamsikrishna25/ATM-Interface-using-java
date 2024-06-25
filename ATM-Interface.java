import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Transaction enum to represent types of transactions
enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER
}

// Transaction class to hold transaction details
class Transaction {
    private TransactionType type;
    private double amount;
    private String recipient;

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.recipient = null;
    }

    public Transaction(TransactionType type, double amount, String recipient) {
        this.type = type;
        this.amount = amount;
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        switch (type) {
            case DEPOSIT:
                return "DEPOSIT: +" + amount + ", New Balance: " + amount;
            case WITHDRAW:
                return "WITHDRAW: -" + amount + ", New Balance: " + amount;
            case TRANSFER:
                return "TRANSFER: -" + amount + " to " + recipient + ", New Balance: " + amount;
            default:
                return "";
        }
    }
}

// Account class to represent a bank account
class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount));
        System.out.println("Deposit successful. New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction(TransactionType.WITHDRAW, amount));
            System.out.println("Withdrawal successful. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new Transaction(TransactionType.TRANSFER, amount, recipient.getAccountNumber()));
            System.out.println("Transfer successful. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Transfer failed.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.toString());
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// ATM class to handle the ATM interface
public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice = 0;

        while (choice != 5) {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. View Transaction History");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void transfer() {
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        Account recipient = new Account(recipientAccountNumber);
        account.transfer(recipient, amount);
    }

    public static void main(String[] args) {
        // Example usage:
        Account userAccount = new Account("12345"); // Replace with actual account details
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
