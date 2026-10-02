package J08_ObjectOrientedProgramming.L12_NestedClasses;

public class C01_StaticNestedClass {

    public static void main(String[] args) {

        // A static nested class does not require an outer class object.
        BankAccount.AccountRules rules =
                new BankAccount.AccountRules();

        rules.showRules();

        // An outer object is only needed when we want instance data.
        BankAccount account =
                new BankAccount("Vivek", "Koderma Branch");

        rules.showAccountDetails(account);
    }
}


class BankAccount {

    private static String bankName = "State Bank of India";

    private String accountHolder;
    private String branchName;

    BankAccount(String accountHolder, String branchName) {
        this.accountHolder = accountHolder;
        this.branchName = branchName;
    }


    static class AccountRules {

        private static final int MINIMUM_BALANCE = 1000;
        private static final int MAX_WITHDRAWAL = 50000;

        void showRules() {

            // Direct access to the outer class's static member.
            System.out.println("Bank: " + bankName);
            System.out.println("Minimum Balance: ₹" + MINIMUM_BALANCE);
            System.out.println("Maximum Withdrawal: ₹" + MAX_WITHDRAWAL);
        }

        void showAccountDetails(BankAccount account) {

            // Instance members require an explicit outer object.
            System.out.println("\nAccount Holder: " + account.accountHolder);
            System.out.println("Branch: " + account.branchName);
        }
    }
}