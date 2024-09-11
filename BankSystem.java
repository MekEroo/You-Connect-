import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    // Constructor
    public BankSystem() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    // Register a new user
    public User registerUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
        System.out.println("User registered successfully!");
        return user;
    }

    // Login method
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Login failed! Invalid username or password.");
        return null;
    }

    // Create a new bank account for a user
    public Account createAccount(String accountNumber, User user) {
        Account account = new Account(accountNumber, user);
        accounts.add(account);
        System.out.println("Account created successfully!");
        return account;
    }

    // Find account by account number
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Transfer money between two accounts
    public void transferFunds(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Transfer successful!");
            } else {
                System.out.println("Insufficient balance for transfer.");
            }
        } else {
            System.out.println("Invalid accounts for transfer.");
        }
    }
}
