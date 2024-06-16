import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Welcome to the Bank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String accHolder = scan.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initDeposit = scan.nextDouble();
                    bank.createAccount(accHolder, initDeposit);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNumber = scan.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scan.nextDouble();
                    Account depositAccount = bank.findAccount(accNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accNumber = scan.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    Account withdrawAccount = bank.findAccount(accNumber);
                    if (withdrawAccount != null) {
                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Your Account Number: ");
                    String fromAccNumber = scan.nextLine();
                    System.out.print("Enter Target Account Number: ");
                    String toAccNumber = scan.nextLine();
                    System.out.print("Enter Amount to Transfer: ");
                    double transferAmount = scan.nextDouble();
                    Account fromAccount = bank.findAccount(fromAccNumber);
                    Account toAccount = bank.findAccount(toAccNumber);
                    if (fromAccount != null && toAccount != null) {
                        if (fromAccount.transfer(toAccount, transferAmount)) {
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Your Account Number: ");
                    accNumber = scan.nextLine();
                    Account balanceAccount = bank.findAccount(accNumber);
                    if(balanceAccount != null){
                        System.out.println("Your Account balance is: " + balanceAccount.getBalance());
                    }
                    else{
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Admin Password: ");
                    String password = scan.nextLine();
                    if(password.equals(bank.getAdminPassword())){
                        bank.displayAllAccounts();
                    } else{
                        System.out.println("Incorrect Password!!");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using the Bank Management System.");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}