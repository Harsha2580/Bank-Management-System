import java.util.HashMap;
import java.util.Random;

class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();
    private Random random = new Random();
    private final String adminPassword = "admin123";

    // Method to generate a new unique account number
    private String generateAccountNumber() {
        String accountNumber;
        do {
            accountNumber = String.valueOf(1000000 + random.nextInt(9000000));
        } while (accounts.containsKey(accountNumber)); 
        return accountNumber;
    }

    // Method to create a new account
    public String createAccount(String accountHolderName, double initialDeposit) {
        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully. Your account number is: " + accountNumber);
        return accountNumber;
    }

    // Method to find an account by account number
    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public String getAdminPassword(){
        return adminPassword;
    }

    // Method to display all accounts
    public void displayAllAccounts() {
        for (Account account : accounts.values()) {
            account.display();
            System.out.println();
        }
    }
}
