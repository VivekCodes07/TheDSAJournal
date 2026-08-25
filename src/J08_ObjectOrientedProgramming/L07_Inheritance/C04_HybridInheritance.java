package J08_ObjectOrientedProgramming.L07_Inheritance;

/*
    HYBRID INHERITANCE

    Hybrid inheritance is a combination of two or more
    types of inheritance.

    In this example, we combine:

    1. Multilevel Inheritance
    2. Hierarchical Inheritance


                    Account
                   /       \
                  /         \
         SavingsAccount   CurrentAccount
                |
                |
         PremiumSavings


    Multilevel Inheritance:

    Account
       ↓
    SavingsAccount
       ↓
    PremiumSavings


    Hierarchical Inheritance:

             Account
             /    \
            ↓      ↓
        Savings  Current
*/


/*
    Parent / Base Class
*/
class Account {

    String accountHolder;

    Account(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void showAccountHolder() {
        System.out.println("Account Holder: " + accountHolder);
    }
}


/*
    Account → SavingsAccount

    SavingsAccount inherits from Account.
*/
class SavingsAccount extends Account {

    double interestRate;

    SavingsAccount(String accountHolder, double interestRate) {
        super(accountHolder);
        this.interestRate = interestRate;
    }

    void showInterestRate() {
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}


/*
    Account → SavingsAccount → PremiumSavings

    This is multilevel inheritance.
*/
class PremiumSavings extends SavingsAccount {

    double bonusInterest;

    PremiumSavings(
            String accountHolder,
            double interestRate,
            double bonusInterest
    ) {
        super(accountHolder, interestRate);
        this.bonusInterest = bonusInterest;
    }

    void showBonusInterest() {
        System.out.println("Bonus Interest: " + bonusInterest + "%");
    }
}


/*
    Account → CurrentAccount

    Account has multiple child classes:
    SavingsAccount and CurrentAccount.

    This represents hierarchical inheritance.
*/
class CurrentAccount extends Account {

    double minimumBalance;

    CurrentAccount(String accountHolder, double minimumBalance) {
        super(accountHolder);
        this.minimumBalance = minimumBalance;
    }

    void showMinimumBalance() {
        System.out.println("Minimum Balance: ₹" + minimumBalance);
    }
}


/*
    Main Class
*/
public class C04_HybridInheritance {

    public static void main(String[] args) {

        PremiumSavings premium = new PremiumSavings("Vivek", 6.5, 1.5);

        premium.showAccountHolder();
        premium.showInterestRate();
        premium.showBonusInterest();

        System.out.println();

        CurrentAccount current = new CurrentAccount("Rahul", 5000);

        current.showAccountHolder();
        current.showMinimumBalance();
    }
}