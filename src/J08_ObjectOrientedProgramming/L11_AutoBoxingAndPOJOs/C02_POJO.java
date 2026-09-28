package J08_ObjectOrientedProgramming.L11_AutoBoxingAndPOJOs;

/*
I am learning what a POJO is.

POJO means:

Plain Old Java Object

It is not a special keyword.

It is simply a normal Java class
that I can use to represent data.

For example, a Student object can contain:

name
age
marks
*/

class Student {

    /*
    These fields represent the data
    of a Student object.
    */
    private String name;
    private int age;
    private double marks;


    /*
    Constructor

    When I create a Student object,
    these values are stored inside that object.
    */
    Student(String name, int age, double marks) {

        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    /*
    Getter methods allow me to read
    the private data from outside the class.
    */
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getMarks() {
        return marks;
    }
}


public class C02_POJO {

    public static void main(String[] args) {

        /*
        I am creating a Student object.

        Stack:

        student
           |
           ↓

        Heap:

        Student object
        name  = "Vivek"
        age   = 20
        marks = 85.5
        */
        Student student = new Student("Vivek", 20, 85.5);


        /*
        student is a reference.

        It does not directly contain all
        the Student data.

        It points to the Student object
        created in the Heap.
        */
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Marks: " + student.getMarks());
    }
}