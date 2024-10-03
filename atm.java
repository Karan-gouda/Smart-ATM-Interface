list all the class used in this code and exolain about every class // Bank Account Class - Encapsulation, Methods
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor - Object Creation
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter for Balance
    public double getBalance() {
        return balance;
    }

    // Method to Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

// ATM Class - Object Interaction
class ATM {
    private BankAccount account;

    // Constructor to link an account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to interact with the ATM menu
    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}

// Main Class - Object Creation and Interaction
public class ATMSystem {
    public static void main(String[] args) {
        // Create a BankAccount object with initial details
        BankAccount myAccount = new BankAccount("John Doe", "123456789", 1000.00);
        
        // Create an ATM object linked to the bank account
        ATM atm = new ATM(myAccount);
        
        // Start the ATM system
        atm.startATM();
    }
}