package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

class Teacher {

    String name;
    String subject;
    int experience;

    // Constructor 1
    Teacher() {

        this("Unknown");
    }

    // Constructor 2
    Teacher(String name) {

        this(name, "Not Assigned");
    }

    // Constructor 3
    Teacher(String name, String subject) {

        this(name, subject, 0);
    }

    // Constructor 4 - Final initialization
    Teacher(String name, String subject, int experience) {

        this.name = name;
        this.subject = subject;
        this.experience = experience;
    }

    void displayDetails() {

        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Experience: " + experience + " years");
        System.out.println();
    }
}

public class C06_ChainingOfConstructors {

    public static void main(String[] args) {

        Teacher teacher1 = new Teacher();

        Teacher teacher2 = new Teacher("Mr. Sharma");

        Teacher teacher3 = new Teacher(
                "Mr. Sharma",
                "Mathematics"
        );

        Teacher teacher4 = new Teacher(
                "Mr. Sharma",
                "Mathematics",
                10
        );

        teacher1.displayDetails();
        teacher2.displayDetails();
        teacher3.displayDetails();
        teacher4.displayDetails();
    }
}

/*
 WHAT AM I LEARNING?

 Constructor chaining means one constructor calls
 another constructor of the same class.

 I use this(...) to call another constructor.


 WHY DO I NEED IT?

 I can create a Teacher with different amounts
 of information.

 No information:

     new Teacher();

 Only the name:

     new Teacher("Mr. Sharma");

 Name + subject:

     new Teacher("Mr. Sharma", "Mathematics");

 Name + subject + experience:

     new Teacher("Mr. Sharma", "Mathematics", 10);


 Instead of writing the same initialization code
 in every constructor, I let the constructors
 call each other.


 HOW THE CHAIN WORKS

 If I write:

     new Teacher("Mr. Sharma");


 Java enters:

     Teacher(String name)

 Then:

     this(name, "Not Assigned");

 calls:

     Teacher(String name, String subject)

 Then:

     this(name, subject, 0);

 calls:

     Teacher(String name, String subject, int experience)

 Finally, the object's fields are initialized:

     this.name = name;
     this.subject = subject;
     this.experience = experience;


 So the flow is:

     Teacher("Mr. Sharma")
              ↓
     Teacher("Mr. Sharma", "Not Assigned")
              ↓
     Teacher("Mr. Sharma", "Not Assigned", 0)
              ↓
     Object gets initialized


 WHY IS THIS BETTER?

 Without constructor chaining, I would have to
 repeat the same initialization code in multiple
 constructors.

 With chaining, the final constructor contains
 the actual initialization only once.


 MEMORY PERSPECTIVE

 When I write:

     new Teacher("Mr. Sharma");

 only ONE Teacher object is created.

 The constructors are not creating new objects.

 They are simply passing the SAME object through
 the constructor chain.

     new Teacher("Mr. Sharma")
              ↓
        Constructor 1
              ↓
        Constructor 2
              ↓
        Constructor 3
              ↓
        Object initialized


 IMPORTANT RULE

 this(...) must be the FIRST statement
 inside a constructor.

 Correct:

     Teacher() {
         this("Unknown");
     }


 SIMPLE MEMORY TRICK

 this(...)
     ↓
 Calls another constructor
 of the same class.

 this.name
     ↓
 Refers to the current
 object's field.
*/