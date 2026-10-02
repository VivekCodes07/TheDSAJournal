package J08_ObjectOrientedProgramming.L12_NestedClasses;

public class C02_InnerClass {

    public static void main(String[] args) {

        Student student = new Student("Vivek", 101);

        // An inner class object is created through an outer object.
        Student.Address address = student.new Address("Koderma", "Jharkhand");

        student.showStudent();

        address.showAddress();
        address.showCompleteDetails();
    }
}


class Student {

    private String name;
    private int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void showStudent() {

        System.out.println("Student: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }


    class Address {

        private String city;
        private String state;

        Address(String city, String state) {
            this.city = city;
            this.state = state;
        }

        void showAddress() {

            System.out.println("City: " + city);
            System.out.println("State: " + state);
        }

        void showCompleteDetails() {

            // Direct access to the outer Student object's fields.
            System.out.println("\nStudent: " + name);
            System.out.println("Roll Number: " + rollNumber);

            // Access to Address's own fields.
            System.out.println("City: " + city);
            System.out.println("State: " + state);
        }
    }
}