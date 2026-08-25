package J08_ObjectOrientedProgramming.L07_Inheritance;

/*
Hierarchical Inheritance

In hierarchical inheritance, multiple child classes
inherit from the same parent class.

                    Vehicle
                   /       \
                  ↓         ↓
                Car        Bike

Both Car and Bike inherit the common properties
and behavior of Vehicle.

Each child can then add its own specific behavior.
*/

public class C03_HierarchicalInheritance {

    public static void main(String[] args) {

        Car car = new Car("Toyota", 2024, 4);

        Bike bike = new Bike("Yamaha", 2025, true);

        System.out.println("----- CAR -----");

        System.out.println("Brand: " + car.brand);
        System.out.println("Year: " + car.year);
        System.out.println("Number of Doors: " + car.numberOfDoors);

        System.out.println();

        // This method is inherited from Vehicle.
        car.start();

        // This method belongs specifically to Car.
        car.openTrunk();


        System.out.println();


        System.out.println("----- BIKE -----");

        System.out.println("Brand: " + bike.brand);
        System.out.println("Year: " + bike.year);
        System.out.println("Has Gear: " + bike.hasGear);

        System.out.println();

        // This method is inherited from Vehicle.
        bike.start();

        // This method belongs specifically to Bike.
        bike.kickStart();
    }
}


/*
Vehicle is the parent class.

It contains the properties and behavior
that are common to different types of vehicles.

Car and Bike both inherit from Vehicle.
*/
class Vehicle {

    String brand;
    int year;

    Vehicle(String brand, int year) {

        this.brand = brand;
        this.year = year;
    }

    void start() {
        System.out.println(brand + " vehicle has started.");
    }
}


/*
Car is a child class of Vehicle.

It inherits the common features of Vehicle
and adds behavior specific to a car.

Car IS-A Vehicle.
*/
class Car extends Vehicle {

    int numberOfDoors;

    Car(
            String brand,
            int year,
            int numberOfDoors
    ) {

        // Calls the parent constructor
        // to initialize the inherited properties.
        super(brand, year);

        this.numberOfDoors = numberOfDoors;
    }

    void openTrunk() {
        System.out.println("Car trunk is now open.");
    }
}


/*
Bike is another child class of Vehicle.

It also inherits the common features of Vehicle
but adds behavior specific to a bike.

Bike IS-A Vehicle.
*/
class Bike extends Vehicle {

    boolean hasGear;

    Bike(
            String brand,
            int year,
            boolean hasGear
    ) {

        // Calls the parent constructor
        // to initialize the inherited properties.
        super(brand, year);

        this.hasGear = hasGear;
    }

    void kickStart() {
        System.out.println("Bike is being kick-started.");
    }
}