package J06_Methods;

import java.util.Scanner;

public class C05_MethodWithReturnType {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int result = sum(a, b);

        System.out.println("Sum = " + result);

        sc.close();
    }
}
/*
    sum(int a, int b) is a method with a return type.

    Here, int is the return type, which means
    the method returns an integer value.

    The return statement sends the calculated
    value back to the main() method.

    In the main() method, we store the returned
    value in a variable:

    int result = sum(a, b);

    Then we print the returned value.
*/