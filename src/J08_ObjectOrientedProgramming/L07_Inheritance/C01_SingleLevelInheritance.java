package J08_ObjectOrientedProgramming.L07_Inheritance;

/*
Single Level Inheritance / Basic Inheritance

In basic inheritance, one child class inherits
the properties and methods of one parent class.

            User
              ↓
       DeliveryPartner

DeliveryPartner gets the common features of User
and can also have its own features and behavior.

This allows us to reuse code instead of writing
the same properties and methods again.
*/

public class C01_SingleLevelInheritance {

    public static void main(String[] args) {

        DeliveryPartner partner =
                new DeliveryPartner(
                        "Rahul",
                        501,
                        "DL-4521"
                );

        System.out.println("Name: " + partner.name);
        System.out.println("User ID: " + partner.userId);
        System.out.println("Partner ID: " + partner.partnerId);

        System.out.println();

        // This method is inherited from User.
        partner.login();

        // This method belongs specifically to DeliveryPartner.
        partner.acceptDelivery();
    }
}


/*
User is the parent class.

It contains the common information and behavior
that can be shared by different types of users.

The child class will inherit these features.
*/
class User {

    String name;
    int userId;

    User(String name, int userId) {

        this.name = name;
        this.userId = userId;
    }

    void login() {

        System.out.println(
                name + " has logged into the application."
        );
    }
}


/*
DeliveryPartner is the child class.

It inherits the common features of User
and adds behavior that is specific to
a delivery partner.

DeliveryPartner IS-A User.
*/
class DeliveryPartner extends User {

    String partnerId;

    DeliveryPartner(
            String name,
            int userId,
            String partnerId
    ) {

        // Calls the User constructor to initialize
        // the properties inherited by DeliveryPartner.
        super(name, userId);

        this.partnerId = partnerId;
    }

    void acceptDelivery() {

        System.out.println(
                name + " accepted a new delivery."
        );
    }
}