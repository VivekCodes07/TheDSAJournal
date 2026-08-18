package J08_ObjectOrientedProgramming.L02_ClassesAndObjects;

// Class = Blueprint
class Employee {

    // Instance variables = State/Data
    String name;
    int employeeId;
    String department;
    double salary;

    // Method = Behavior
    void work() {
        System.out.println(name + " is working.");
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

public class C01_ClassesAndObjects {

    public static void main(String[] args) {

        // Creating the first Employee object
        Employee employee1 = new Employee();

        employee1.name = "Vivek";
        employee1.employeeId = 101;
        employee1.department = "Engineering";
        employee1.salary = 60000;

        // Creating the second Employee object
        Employee employee2 = new Employee();

        employee2.name = "Abhishek";
        employee2.employeeId = 102;
        employee2.department = "Marketing";
        employee2.salary = 50000;

        // Calling methods using employee1
        employee1.work();
        employee1.displayDetails();

        System.out.println();

        // Calling methods using employee2
        employee2.work();
        employee2.displayDetails();

        /*
          MEMORY FLOW

          Employee employee1 = new Employee();

          Step 1:
          JVM executes new Employee().

          Step 2:
          A new Employee object is created in the heap.

          Step 3:
          A reference to that object is returned.

          Step 4:
          employee1 stores that reference.

          Simplified:

          STACK                         HEAP

          employee1 ----------------> Employee Object 1
                                       name = "Vivek"
                                       employeeId = 101
                                       department = "Engineering"
                                       salary = 60000


          employee2 ----------------> Employee Object 2
                                       name = "Rahul"
                                       employeeId = 102
                                       department = "Marketing"
                                       salary = 50000


          employee1 and employee2 point to DIFFERENT objects.
         */


        // Two references pointing to the SAME object
        Employee employee3 = employee1;

        employee3.name = "Vivek Kumar";

        /*
         * Now:
         *
         * employee1 --------┐
         *                    ↓
         *              Employee Object
         *                    ↑
         * employee3 --------┘
         *
         * employee1 and employee3 refer to the SAME object.
         */

        System.out.println();
        System.out.println("After changing through employee3:");

        System.out.println("employee1 name: " + employee1.name);
        System.out.println("employee3 name: " + employee3.name);
    }
}