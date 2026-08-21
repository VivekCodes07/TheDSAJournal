package J08_ObjectOrientedProgramming.L04_StaticAndFinal;

class Employee {

    String name;
    int employeeId;

    static String company = "Google";

    Employee(String name, int employeeId) {

        this.name = name;
        this.employeeId = employeeId;
    }

    void displayDetails() {

        System.out.println("Name: " + this.name);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Company: " + Employee.company);
        System.out.println();
    }
}

public class C01_StaticVariables {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Vivek", 101);

        Employee employee2 = new Employee("Rahul", 102);

        employee1.displayDetails();
        employee2.displayDetails();

        Employee.company = "Microsoft";

        employee1.displayDetails();
        employee2.displayDetails();
    }
}

/*
 WHAT AM I LEARNING?

 A static variable belongs to the CLASS rather than
 to individual objects.

 Here:

     static String company = "Google";

 There is only ONE company variable for the Employee class.


 INSTANCE VARIABLE vs STATIC VARIABLE
 -------------------------------------

     String name;
     int employeeId;

     ↓

     Instance variables

     Each Employee object gets its own copy.


     static String company;

     ↓

     Static variable

     The Employee class has one shared copy.


 MEMORY FLOW
 -----------

 When I write:

     Employee employee1 = new Employee("Vivek", 101);

     Employee employee2 = new Employee("Rahul", 102);


 The 'new' keyword creates TWO separate Employee objects.

     employee1 ─────→ Employee Object 1
                      name = "Vivek"
                      employeeId = 101


     employee2 ─────→ Employee Object 2
                      name = "Rahul"
                      employeeId = 102


 But there is only ONE static company variable:

              Employee Class
                    |
                    ↓
              company = "Google"
                 ↑        ↑
                 |        |
            employee1  employee2


 CONSTRUCTOR'S ROLE
 ------------------

 The constructor initializes the instance variables
 of each newly created object:

     Employee(String name, int employeeId) {

         this.name = name;
         this.employeeId = employeeId;
     }

 Here:

     this.name
         ↓
     current object's name

     name
         ↓
     constructor parameter


 WHY DO I USE 'this' IN displayDetails()?
 ----------------------------------------

 I don't have to use it there, but I can:

     this.name
     this.employeeId

 'this' explicitly tells me that these variables
 belong to the current Employee object.

 For example:

     employee1.displayDetails();

 Inside the method:

     this
       ↓
     employee1


 If employee2 calls the method:

     employee2.displayDetails();

 Then:

     this
       ↓
     employee2


 CAN OBJECTS ACCESS STATIC VARIABLES?
 ------------------------------------

 Yes.

 I could write:

     employee1.company

 or:

     employee2.company

 Both access the SAME static variable.

 I prefer:

     Employee.company

 because it clearly shows that company belongs
 to the Employee class.


 CAN AN OBJECT CHANGE IT?
 ------------------------

 Yes.

 For example:

     employee1.company = "Microsoft";

 This does NOT create another company variable.

 It changes the ONE shared static variable.

 So now:

     employee1.company → "Microsoft"
     employee2.company → "Microsoft"
     Employee.company  → "Microsoft"


 MEMORY PERSPECTIVE
 ------------------

     STACK                         HEAP

     employee1 ───────────────→ Employee Object 1
                                name = "Vivek"
                                employeeId = 101

     employee2 ───────────────→ Employee Object 2
                                name = "Rahul"
                                employeeId = 102


                         Employee Class
                              |
                              ↓
                       company = "Google"


 The objects have their own instance data,
 but company is shared at the class level.


 SIMPLE MEMORY TRICK
 -------------------

     Instance variable
          ↓
     Object owns it
          ↓
     Every object gets its own copy


     static variable
          ↓
     Class owns it
          ↓
     One shared copy


 IMPORTANT:

 The static variable is NOT copied into every object.

 Objects can access it, but the variable belongs
 to the class.
*/