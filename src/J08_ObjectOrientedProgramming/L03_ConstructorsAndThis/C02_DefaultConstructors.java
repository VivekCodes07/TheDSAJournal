package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

class BankAccount {

    String accountHolder;
    String accountType;
    double balance;

    // Default Constructor
    BankAccount() {

        accountHolder = "New Customer";
        accountType = "Savings";
        balance = 0.0;
    }

    void displayAccountDetails() {

        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: ₹" + balance);
    }
}

public class C02_DefaultConstructors {

    public static void main(String[] args) {

        // Creating a BankAccount object
        BankAccount account = new BankAccount();

        // Constructor has already initialized the object
        account.displayAccountDetails();
    }
}

/*
   KEY TAKEAWAY

   A constructor is automatically called when an object is created.

   In this example:

   BankAccount account = new BankAccount();

   The flow is:

   1. A new BankAccount object is created.
   2. The BankAccount() constructor runs automatically.
   3. Default values are assigned to the object's fields.
   4. The reference to the object is stored in 'account'.

   So instead of doing this:

   BankAccount account = new BankAccount();
   account.accountHolder = "New Customer";
   account.accountType = "Savings";
   account.balance = 0.0;

   I can initialize the object directly inside the constructor.

   MEMORY PERSPECTIVE

   STACK                         HEAP

   account -------------------> BankAccount Object
                                ├── accountHolder = "New Customer"
                                ├── accountType   = "Savings"
                                └── balance       = 0.0

   IMPORTANT:

   A constructor has the same name as the class
   and does not have a return type.

   BankAccount() { }   // Constructor

   void BankAccount() { }   // Method, NOT a constructor
 */