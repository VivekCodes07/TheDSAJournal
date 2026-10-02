package J08_ObjectOrientedProgramming.L12_NestedClasses;

/*
 Anonymous Class

 Why am I learning this?
 Sometimes I need to create an object of an interface or class
 only once, and I don't want to create a separate named class
 just for that one implementation.

 An anonymous class lets me define the implementation and create
 its object at the same time.

 Here, Notification is an interface that defines send().
 Instead of creating a separate EmailNotification class,
 I directly provide the implementation while creating the object.
 */

public class C04_AnonymousClass {

    public static void main(String[] args) {

        /*
         We cannot directly create an object of an interface:

         Notification notification = new Notification();  // Not allowed

         But an anonymous class allows us to provide the missing
         implementation immediately.

         new Notification() {
             ...
         };

         This creates an unnamed class that implements Notification
         and then creates an object of that class.
         */
        Notification notification = new Notification() {

            /*
             The anonymous class must implement the abstract
             method declared inside the Notification interface.
             */
            @Override
            public void send(String message) {

                System.out.println("Sending Email Notification...");
                System.out.println("Message: " + message);
            }
        };

        /*
         The object is still referenced using the Notification
         interface reference.

         At runtime, the send() method of the anonymous class
         implementation will be executed.
         */
        notification.send("Your order has been shipped.");
    }
}


/*
 This interface defines what every Notification should be able to do.

 It does not care whether the notification is sent through:
 - Email
 - SMS
 - WhatsApp
 - Push Notification

 The actual implementation can be provided wherever it is needed.
 */
interface Notification {

    void send(String message);
}
