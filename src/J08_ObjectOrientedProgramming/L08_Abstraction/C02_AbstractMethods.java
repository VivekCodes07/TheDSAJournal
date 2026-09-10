package J08_ObjectOrientedProgramming.L08_Abstraction;

abstract class EmployeeType {

    String name;

    EmployeeType(String name) {
        this.name = name;
    }

    /*
    Every employee must have a way of working.

    But the parent class does not know exactly
    how every employee works.

    So I declare work() as an abstract method.
    */
    abstract void work();
}

class DeveloperEmployee extends EmployeeType {

    DeveloperEmployee(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println(this.name + " is writing code.");
    }
}

class TeacherEmployee extends EmployeeType {

    TeacherEmployee(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println(this.name + " is teaching students.");
    }
}

public class C02_AbstractMethods {

    public static void main(String[] args) {

        DeveloperEmployee developer = new DeveloperEmployee("Vivek");

        TeacherEmployee teacher = new TeacherEmployee("Rahul");

        developer.work();
        teacher.work();

        /*
        MEMORY + ABSTRACTION

        EmployeeType is the abstract parent.

                    EmployeeType
                         |
                    abstract work()
                         |
                    +----+----+
                    |         |
                    ↓         ↓
               Developer   Teacher


        The parent defines WHAT every employee
        should be able to do:

            work()

        But it does not define HOW every employee
        should perform that work.

        Developer decides:

            work()
              ↓
            Writing code


        Teacher decides:

            work()
              ↓
            Teaching students


        So the basic idea is:

            Parent
              ↓
             WHAT
              ↓
            Child
              ↓
             HOW


        MEMORY FLOW

        Stack:

            developer ───────→ Developer object
            teacher ─────────→ Teacher object


        Heap:

            Developer object
                |
                └── name = "Vivek"


            Teacher object
                |
                └── name = "Rahul"


        The abstract EmployeeType class does not
        create a separate object.

        It provides the common structure and
        forces child classes to implement
        the abstract work() method.


        IMPORTANT

        If a normal child class extends an
        abstract class, it must implement all
        inherited abstract methods.

        Otherwise, that child class must also
        be declared abstract.
        */
    }
}