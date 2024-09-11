import java.util.UUID; // For generating unique account numbers

public class Account {
    private String accountNumber;
    private double balance;
    private User user;

    // Constructor that generates a random account number
    public Account(User user) {
        this.accountNumber = generateRandomAccountNumber();
        this.user = user;
        this.balance = 0.0;  // Start with zero balance
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Generate a random account number using UUID
    private String generateRandomAccountNumber() {
        return UUID.randomUUID().toString().substring(0, 10); // Shorten to 10 characters
    }
}
