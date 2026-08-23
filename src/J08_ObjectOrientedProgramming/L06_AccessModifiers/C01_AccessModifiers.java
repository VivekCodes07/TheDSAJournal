package J08_ObjectOrientedProgramming.L06_AccessModifiers;

/*
Lesson 4 — Access Modifiers

Access modifiers control who is allowed to access
a class, variable, method, or constructor.

public    -> accessible from anywhere
protected -> same package + subclasses
default   -> same package
private   -> same class
*/

class BankAccount {

    /*
    public

    I use public when other parts of my program
    should be able to access something directly.
    */
    public String accountHolder;


    /*
    protected

    Accessible within the same package and by
    subclasses. I will understand the subclass
    part better when I learn inheritance.
    */
    protected String accountType;


    /*
    default

    When I don't write public, protected, or private,
    Java gives the member default access.

    It can be accessed by classes in the same package.
    */
    int accountNumber;


    /*
    private

    Only BankAccount can directly access balance.

    This protects the object's internal state and
    is one of the main ways I achieve encapsulation.
    */
    private double balance;


    public BankAccount(String accountHolder, String accountType,
                       int accountNumber, double balance) {

        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.accountNumber = accountNumber;

        if (balance >= 0) {
            this.balance = balance;
        }
    }


    /*
    Since balance is private, I don't let outside code
    change it directly.

    Instead, I expose controlled operations through
    public methods.
    */
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }


    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }


    /*
    I can also provide controlled read access to
    private data using a public method.
    */
    public double getBalance() {
        return balance;
    }
}


public class C01_AccessModifiers {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(
                "Vivek",
                "Savings",
                12345,
                10000
        );


        /*
        public

        I can access accountHolder directly because
        it is public.
        */
        account.accountHolder = "Vivek";

        System.out.println(
                "Account Holder: " + account.accountHolder
        );


        /*
        protected

        This works because this class is in the
        same package as BankAccount.
        */
        System.out.println(
                "Account Type: " + account.accountType
        );


        /*
        default

        This also works because both classes are
        in the same package.
        */
        System.out.println("Account Number: " + account.accountNumber);


        /*
        private

        I cannot access balance directly.

        account.balance = 50000; // Error

        Instead, I interact with the private data
        through the public methods provided by the class.
        */
        account.deposit(5000);
        account.withdraw(2000);

        System.out.println(
                "Balance: " + account.getBalance()
        );
    }
}