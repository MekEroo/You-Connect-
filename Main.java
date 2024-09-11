import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;
        Account userAccount = null;

        while (true) {
            System.out.println("\nWelcome to You Connect!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Register new user
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                loggedInUser = bankSystem.registerUser(username, password);
                userAccount = bankSystem.createAccount("ACC" + System.currentTimeMillis(), loggedInUser);

            } else if (choice == 2) {
                // Login existing user
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                loggedInUser = bankSystem.login(username, password);

                if (loggedInUser != null) {
                    // Find the user's account and assign it to userAccount
                    userAccount = bankSystem.findAccountByUser(loggedInUser);

                    // Ensure user has an account, if not, create one
                    if (userAccount == null) {
                        userAccount = bankSystem.createAccount("ACC" + System.currentTimeMillis(), loggedInUser);
                    }

                    // User logged in successfully, proceed with banking operations
                    while (true) {
                        System.out.println("\n1. View Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Transfer");
                        System.out.println("5. Logout");
                        System.out.print("Choose an option: ");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        if (userChoice == 1) {
                            // View balance
                            System.out.println("Your balance: " + userAccount.getBalance());

                        } else if (userChoice == 2) {
                            // Deposit money
                            System.out.print("Enter amount to deposit: ");
                            double amount = scanner.nextDouble();
                            userAccount.deposit(amount);

                        } else if (userChoice == 3) {
                            // Withdraw money
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            userAccount.withdraw(amount);

                        } else if (userChoice == 4) {
                            // Transfer funds
                            System.out.print("Enter the account number to transfer to: ");
                            String targetAccountNumber = scanner.nextLine();
                            System.out.print("Enter the amount to transfer: ");
                            double amount = scanner.nextDouble();
                            Account targetAccount = bankSystem.findAccount(targetAccountNumber);
                            bankSystem.transferFunds(userAccount, targetAccount, amount);

                        } else if (userChoice == 5) {
                            // Logout
                            System.out.println("Logging out...");
                            break;
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using You Connect! Goodbye.");
                break;
            }
        }
        scanner.close();
    }
}
