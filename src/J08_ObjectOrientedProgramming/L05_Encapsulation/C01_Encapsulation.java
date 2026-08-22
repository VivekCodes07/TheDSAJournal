class BankAccount {

    private String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        }
    }

    // Deposit money into the account
    void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money from the account
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    // Getter for accountHolder
    String getAccountHolder() {
        return accountHolder;
    }

    // Getter for balance
    double getBalance() {
        return balance;
    }

    // Setter for accountHolder
    void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
}


public class C01_Encapsulation {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Vivek", 5000);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());

        System.out.println();

        account.deposit(2000);
        System.out.println("Balance: " + account.getBalance());

        System.out.println();

        account.withdraw(1000);
        System.out.println("Balance: " + account.getBalance());

        System.out.println();

        account.withdraw(10000);
        System.out.println("Balance: " + account.getBalance());

        /*
         * This is not allowed because balance is private:
         *
         * account.balance = -50000;
         *
         * The balance can only be changed through
         * controlled methods such as deposit() and withdraw().
         */
    }
}