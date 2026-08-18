package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

class Car {

    String brand;
    String model;
    int year;

    // Constructor 1: No arguments
    Car() {
        brand = "Unknown";
        model = "Unknown";
        year = 0;
    }

    // Constructor 2: Brand and model
    Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        year = 0;
    }

    // Constructor 3: Brand, model and year
    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {

        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println();
    }
}

public class C04_ConstructorOverloading {

    public static void main(String[] args) {

        // Using the no-argument constructor
        Car car1 = new Car();

        // Using the two-parameter constructor
        Car car2 = new Car("BMW", "M5");

        // Using the three-parameter constructor
        Car car3 = new Car("BMW", "M5", 2026);

        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}

/*
   KEY TAKEAWAY

   Constructor overloading means having multiple constructors
   inside the same class with different parameter lists.

   In this example, the Car class has three constructors:

   1. Car()

   2. Car(String brand, String model)

   3. Car(String brand, String model, int year)


   FLOW

   When I write:

   Car car1 = new Car();

   Java looks for a constructor with 0 arguments.

               new Car()
                   ↓
                Car()


   When I write:

   Car car2 = new Car("BMW", "M5");

   Java looks for a constructor with 2 arguments.

               new Car("BMW", "M5")
                         ↓
               Car(String, String)


   When I write:

   Car car3 = new Car("BMW", "M5", 2026);

   Java looks for a constructor with 3 arguments.

               new Car("BMW", "M5", 2026)
                         ↓
               Car(String, String, int)


   MEMORY PERSPECTIVE

   Each 'new' creates a separate Car object.

   STACK                         HEAP

   car1 ----------------------> Car Object 1
                                brand = "Unknown"
                                model = "Unknown"
                                year = 0

   car2 ----------------------> Car Object 2
                                brand = "BMW"
                                model = "M5"
                                year = 0

   car3 ----------------------> Car Object 3
                                brand = "BMW"
                                model = "M5"
                                year = 2026


   IMPORTANT:

   Constructor overloading is decided by the:

       Number of parameters
       +
       Type of parameters
       +
       Order of parameters

   The return type does NOT matter for constructor overloading
   because constructors do not have return types.


   SIMPLE MEMORY TRICK

   Same class
       ↓
   Multiple constructors
       ↓
   Different parameter lists
       ↓
   Java chooses the matching constructor
 */


/*
 WHY DO I USE 'this'?

 I don't always need the 'this' keyword.

 If there is no naming conflict, I can directly access
 the object's instance variable:

 BankAccount() {
     accountHolder = "New Customer";
 }

 But when a constructor parameter has the same name as
 the instance variable, I use 'this' to refer to the
 current object's field:

 BankAccount(String accountHolder) {
     this.accountHolder = accountHolder;
 }

 Here:

 this.accountHolder → instance variable of the current object
 accountHolder      → constructor parameter

 So I can remember:

 this.field = parameter;

 'this' means: "the current object".
*/