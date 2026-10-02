package J08_ObjectOrientedProgramming.L12_NestedClasses;

/*
 Local Class

 Why am I learning this?
 Sometimes a class is needed only inside one particular method.
 In that case, creating a separate top-level class is unnecessary.

 A local class allows me to define a class inside a method,
 so its scope and usage remain limited to that method.

 Here, PaymentReceipt is needed only while processing a payment.
 So instead of creating it as a separate class, we define it
 directly inside the processPayment() method.
 */

public class C03_LocalClass {

    public static void main(String[] args) {

        Payment payment = new Payment("Vivek", 75000);
        payment.processPayment();
    }
}


/*
 Payment represents the main object responsible for processing
 a customer's payment.

 The PaymentReceipt class is not required outside this class,
 so it is kept local to the processPayment() method.
 */
class Payment {

    private String customerName;
    private double amount;

    Payment(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    void processPayment() {

        /*
         PaymentReceipt is a local class because it is declared
         inside a method instead of directly inside the class.

         Why make it local?
         The receipt is needed only during payment processing.
         No other method needs to directly create or use it.

         A local class can also access the instance members
         of its enclosing class.

         Here, PaymentReceipt can directly access:
         - customerName
         - amount

         because it is defined inside an instance method of Payment.
         */

        class PaymentReceipt {

            /*
             This method generates the receipt using the payment
             details from the enclosing Payment object.
             */
            void generateReceipt() {

                System.out.println("----- Payment Receipt -----");
                System.out.println("Customer: " + customerName);
                System.out.println("Amount: ₹" + amount);
                System.out.println("Status: Payment Successful");
                System.out.println("---------------------------");
            }
        }

        /*
         The local class can be instantiated just like any
         other class, but only within the method where it is declared.

         The scope of PaymentReceipt is limited to processPayment().
         */
        PaymentReceipt receipt = new PaymentReceipt();

        receipt.generateReceipt();
    }
}
