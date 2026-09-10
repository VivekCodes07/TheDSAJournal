package J08_ObjectOrientedProgramming.L08_Abstraction;

abstract class Employee {

    String name;

    Employee(String name) {

        this.name = name;
    }

    // Every employee must work,
    // but each type of employee can work differently.
    abstract void work();

    // Normal method inside an abstract class
    void displayName() {

        System.out.println("Employee Name: " + this.name);
    }
}

class Developer extends Employee {

    Developer(String name) {

        super(name);
    }

    @Override
    void work() {

        System.out.println(this.name + " is writing code.");
    }
}

public class C01_AbstractClass {

    public static void main(String[] args) {

        Developer developer = new Developer("Vivek");

        developer.displayName();
        developer.work();

        /*
           MEMORY + ABSTRACTION

           I cannot create an object directly from
           the abstract Employee class:

               Employee employee = new Employee();

           Instead, I create a Developer object.


           MEMORY FLOW

               developer
                    |
                    ↓
               Developer Object
                    |
                    ├── name = "Vivek"
                    |
                    └── inherited Employee part


           When I call:

               developer.work();

           the abstract Employee class only tells me:

               "Every Employee must have work()."

           It does NOT tell me exactly how an employee works.

           Developer provides the actual implementation:

               work()
                 ↓
               "Vivek is writing code."


           So the idea is:

               Abstract Class
                    ↓
                 WHAT
                    ↓
               Child Class
                    ↓
                 HOW


           An abstract class can also contain normal
           variables, constructors and normal methods.

           So abstraction does NOT mean
           "everything is abstract."
         */
    }
}