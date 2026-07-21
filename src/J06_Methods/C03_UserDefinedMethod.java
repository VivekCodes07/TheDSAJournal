package J06_Methods;

public class C03_UserDefinedMethod {

    // User-defined method
    public static void greet() {
        System.out.println("Welcome to Java Methods!");
        System.out.println("This is a user-defined method.");
    }

    public static void main(String[] args) {

        System.out.println("Main method starts.");

        // Calling the user-defined method
        greet();

        System.out.println("Main method ends.");
    }
}
/*
    greet() is a user-defined method because
    we have created it ourselves.

    public  -> The method can be accessed from anywhere.
    static  -> We can call the method without creating an object.
    void    -> The method does not return any value.

    We call the method inside the main() method by writing:
    greet();
*/