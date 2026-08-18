package J08_ObjectOrientedProgramming.L03_ConstructorsAndThis;

public class C01_DefaultValues {
    public static void main(String[] args) {

        Student s1 = new Student();

        // Default Values
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.rollNumber);
        System.out.println(s1.college);

        s1.markAttendance();

         int x;
        // Local variables have no default values, we must initialize it before we use it
        //System.out.println(x); // Error
    }
}

/*
int     --> 0
float   --> 0.0
Boolean --> false
String  --> null
*/

class Student {
    String name;
    int age;
    int rollNumber;
    String college;

    void markAttendance() {
        System.out.println("Attendance marked for " + name);
    }
}
