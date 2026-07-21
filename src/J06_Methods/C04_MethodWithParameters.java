package J06_Methods;

import java.util.Scanner;

public class C04_MethodWithParameters {

    public static void sum(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        sum(a, b);

        sc.close();
    }
}
/*
    sum(int a, int b) is a method with parameters.

    Here, a and b are called parameters because
    they receive the values passed from the main() method.

    In the main() method, we take input from the user
    and pass those values to the sum() method like this:

    sum(a, b);

    The sum() method receives the values,
    adds them, and prints the result.
*/