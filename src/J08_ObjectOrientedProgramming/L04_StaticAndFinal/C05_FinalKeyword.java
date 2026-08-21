package J08_ObjectOrientedProgramming.L04_StaticAndFinal;

class BankAccount {

    String accountHolder;

    final int accountNumber;

    static final String BANK_NAME = "State Bank";

    BankAccount(String accountHolder, int accountNumber) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    void displayAccountDetails() {

        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Bank: " + BankAccount.BANK_NAME);
    }
}

public class C05_FinalKeyword {

    public static void main(String[] args) {

        BankAccount account1 =
                new BankAccount("Vivek", 101);

        BankAccount account2 =
                new BankAccount("Rahul", 102);

        account1.displayAccountDetails();

        System.out.println();

        account2.displayAccountDetails();
    }
}

/*
 WHAT AM I LEARNING?
 -------------------

 The final keyword can be used with a variable
 when I don't want that variable to be reassigned.

 Example:

     final int accountNumber;


 FLOW
 ----

     new BankAccount("Vivek", 101)
              ↓
        Object is created
              ↓
        Constructor runs
              ↓
        accountNumber gets 101
              ↓
        accountNumber cannot be reassigned


 WHY USE final?
 --------------

 An account number should not change after
 the account has been created.

 So I can write:

     final int accountNumber;


 This is NOT allowed after initialization:

     account1.accountNumber = 500;


 final means:

     "This variable can be assigned only once."


 MEMORY PERSPECTIVE
 ------------------

     account1 → BankAccount Object
                |
                ├── accountHolder = "Vivek"
                |
                └── accountNumber = 101
                                    ↑
                                  final


     account2 → BankAccount Object
                |
                ├── accountHolder = "Rahul"
                |
                └── accountNumber = 102
                                    ↑
                                  final


 Each object has its own accountNumber,
 but once assigned, that object's value
 cannot be reassigned.


 STATIC FINAL
 ------------

     static final String BANK_NAME = "State Bank";


 static
     ↓
 One shared value belongs to the class


 final
     ↓
 Cannot be reassigned


 Therefore:

     static final
          ↓
     One shared value
          +
     Cannot be reassigned


 I can access it using:

     BankAccount.BANK_NAME


 SIMPLE MEMORY TRICK
 -------------------

     final variable
          ↓
     Assigned once
          ↓
     Cannot be reassigned


     static final variable
          ↓
     One shared class-level value
          +
     Cannot be reassigned
*/