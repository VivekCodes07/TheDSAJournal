package J08_ObjectOrientedProgramming.L04_StaticAndFinal;

class Bank {

    String accountHolder;
    int accountNumber;

    static String bankName = "State Bank";

    Bank(String accountHolder, int accountNumber) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    void displayAccountDetails() {

        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Bank: " + Bank.bankName);
        System.out.println();
    }

    static void displayBankName() {

        System.out.println("Bank: " + Bank.bankName);
    }

    static void changeBankName(String newBankName) {

        Bank.bankName = newBankName;
    }
}

public class C02_StaticMethods {

    public static void main(String[] args) {

        Bank account1 = new Bank("Vivek", 101);
        Bank account2 = new Bank("Rahul", 102);

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        Bank.displayBankName();

        Bank.changeBankName("HDFC Bank");

        System.out.println();

        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}

/*
 A static method belongs to the class, not to an object.

 So I can call it directly using the class name:

     Bank.displayBankName();


 FLOW

     Bank.displayBankName()
             ↓
     Bank class
             ↓
     static method
             ↓
     Bank.bankName


 A static method can directly access static members:

     static String bankName;

     static void displayBankName() {

         System.out.println(Bank.bankName);
     }


 But a static method cannot directly access
 instance variables:

     String accountHolder;

     static void displayAccountHolder() {

         System.out.println(accountHolder); // ERROR
     }


 WHY?

     accountHolder
          ↓
     belongs to an object

     displayAccountHolder()
          ↓
     belongs to the class

 Java doesn't know which object's
 accountHolder should be used.


 MEMORY PERSPECTIVE

     Bank Class
         |
         ├── bankName
         ├── displayBankName()
         └── changeBankName()


     Heap

     account1 → Bank Object
                accountHolder = "Vivek"
                accountNumber = 101

     account2 → Bank Object
                accountHolder = "Rahul"
                accountNumber = 102


 The static method belongs to the class,
 while instance data belongs to individual objects.


 SIMPLE RULE

     Instance method
          ↓
     Works with an object

     Static method
          ↓
     Works with the class
*/