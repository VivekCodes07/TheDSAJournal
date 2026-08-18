package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

class ParameterizedBankAccount {

    String accountHolder;
    String accountType;
    double balance;

    // Parameterized Constructor
    ParameterizedBankAccount(String accountHolder, String accountType, double balance) {

        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    void displayAccountDetails() {

        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: ₹" + balance);
    }
}

public class C03_ParameterizedConstructor {

    public static void main(String[] args) {

        ParameterizedBankAccount account =
                new ParameterizedBankAccount(
                        "Vivek",
                        "Savings",
                        10000
                );

        account.displayAccountDetails();
    }
}

/*
   KEY TAKEAWAY

   A parameterized constructor allows me to provide the
   initial values of an object at the time of its creation.

   Instead of creating an empty object and assigning values
   separately:

   ParameterizedBankAccount account = new ParameterizedBankAccount();

   account.accountHolder = "Vivek";
   account.accountType = "Savings";
   account.balance = 10000;

   I can initialize the object directly:

   ParameterizedBankAccount account =
           new ParameterizedBankAccount(
                   "Vivek",
                   "Savings",
                   10000
           );


   FLOW

   1. Java reaches:

      new ParameterizedBankAccount("Vivek", "Savings", 10000)

   2. A new ParameterizedBankAccount object is created.

   3. The parameterized constructor is called.

   4. The values are passed into the constructor parameters:

      accountHolder = "Vivek"
      accountType   = "Savings"
      balance       = 10000

   5. 'this' refers to the newly created object.

   6. The constructor initializes the object's fields:

      this.accountHolder = accountHolder;
      this.accountType = accountType;
      this.balance = balance;

   7. The constructor finishes.

   8. The reference to the object is stored in 'account'.


   MEMORY PERSPECTIVE

   STACK                         HEAP

   account -------------------> ParameterizedBankAccount Object
                                ├── accountHolder = "Vivek"
                                ├── accountType   = "Savings"
                                └── balance       = 10000


   IMPORTANT:

   In:

   this.accountHolder = accountHolder;

   this.accountHolder → field belonging to the current object

   accountHolder      → constructor parameter

   So I can remember:

   this.field = parameter;

   The same concept applies to:

   this.accountType = accountType;
   this.balance = balance;
  */