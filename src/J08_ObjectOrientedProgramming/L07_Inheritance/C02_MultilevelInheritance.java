package J08_ObjectOrientedProgramming.L07_Inheritance;

/*
Multilevel Inheritance

In multilevel inheritance, inheritance happens
through multiple levels.

            Person
               ↓
           Employee
               ↓
            Manager

Manager inherits from Employee.

Employee inherits from Person.

Therefore, Manager can access features
from both Employee and Person.
*/

public class C02_MultilevelInheritance {

    public static void main(String[] args) {

        Manager manager =
                new Manager(
                        "Vivek",
                        25,
                        1001,
                        "Engineering"
                );

        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Employee ID: " + manager.employeeId);
        System.out.println("Department: " + manager.department);

        System.out.println();

        // This method is inherited from Person.
        manager.introduce();

        // This method is inherited from Employee.
        manager.work();

        // This method belongs specifically to Manager.
        manager.manageTeam();
    }
}


/*
Person is the top-level parent class.

It contains information and behavior
that is common to people.

Employee will inherit these features.
*/
class Person {

    String name;
    int age;

    Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    void introduce() {

        System.out.println("Hello, my name is " + name + ".");
    }
}


/*
Employee is a child class of Person.

It inherits the features of Person
and adds information and behavior
specific to an employee.

Employee IS-A Person.
*/
class Employee extends Person {

    int employeeId;

    Employee(
            String name,
            int age,
            int employeeId
    ) {

        // Calls the Person constructor
        // to initialize the inherited properties.
        super(name, age);

        this.employeeId = employeeId;
    }

    void work() {

        System.out.println(name + " is working in the company.");
    }
}


/*
Manager is a child class of Employee.

It inherits from Employee, which itself
inherits from Person.

Therefore, Manager can access features
from both classes.

Manager IS-A Employee.
Manager IS-A Person.
*/
class Manager extends Employee {

    String department;

    Manager(
            String name,
            int age,
            int employeeId,
            String department
    ) {

        // Calls the Employee constructor.
        super(name, age, employeeId);

        this.department = department;
    }

    void manageTeam() {
        System.out.println(name + " is managing the " + department + " team.");
    }
}