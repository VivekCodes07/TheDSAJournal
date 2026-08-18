package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

class Employee {

    String name;
    int employeeId;
    String department;

    Employee(String name, int employeeId, String department) {

        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }

    void displayDetails() {

        System.out.println("Name: " + this.name);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Department: " + this.department);
    }

    void showCurrentObject() {

        System.out.println("Current object: " + this);
    }

    void work() {

        this.displayDetails();
        System.out.println(this.name + " is working.");
    }
}

public class C05_ThisKeyword {

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("Vivek", 101, "Engineering");

        Employee employee2 =
                new Employee("Rahul", 102, "Marketing");

        employee1.displayDetails();

        System.out.println();

        employee2.displayDetails();

        System.out.println();

        employee1.work();

        System.out.println();

        employee1.showCurrentObject();
    }
}

/*
 WHAT IS 'this'?

 'this' refers to the current object.

 When I create:

 Employee employee1 =
        new Employee("Vivek", 101, "Engineering");

 Inside the constructor:

 this → employee1

 When I create:

 Employee employee2 =
        new Employee("Rahul", 102, "Marketing");

 Inside the constructor:

 this → employee2


 COMMON USES OF 'this'

 1. To distinguish instance variables from parameters:

    this.name = name;

    this.name → current object's field
    name      → constructor parameter


 2. To access the current object's fields:

    this.name
    this.employeeId


 3. To call the current object's method:

    this.displayDetails();


 4. 'this' can be used to refer to the current object itself:

    System.out.println(this);


 MEMORY FLOW

 Employee employee1 =
        new Employee("Vivek", 101, "Engineering");

             ↓

 Create Employee object

             ↓

 Constructor starts

             ↓

 this points to that Employee object

             ↓

 this.name = name

             ↓

 Object's fields are initialized

             ↓

 Constructor finishes

             ↓

 employee1 refers to the same object


 STACK                         HEAP

 employee1 ----------------> Employee Object
                             ├── name = "Vivek"
                             ├── employeeId = 101
                             └── department = "Engineering"

 During constructor execution:

 this ----------------------> Same Employee Object


 IMPORTANT

 'this' does NOT create a new object.

 It is simply a reference to the current object.

 I can remember:

 this = current object
*/