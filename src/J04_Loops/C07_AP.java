package J04_Loops;

import java.util.Scanner;

public class C07_AP {

    // Display the AP: 2, 5, 8, 11... up to 'n' terms
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        int a = 2;      // First term
        int d = 3;      // Common difference

        // Find the last (nth) term
        int lastTerm = a + (n - 1) * d;

        System.out.println("\nArithmetic Progression:");

        // Start from the first term and keep adding the common difference
        for (int currentTerm = a; currentTerm <= lastTerm; currentTerm += d) {
            System.out.print(currentTerm + " ");
        }

        sc.close();
    }
}

/*
    AP Logic

    Start at the first term (a).

    Keep moving by the common difference (d).

    Stop when you reach the nth term.

    lastTerm = a + (n - 1) * d

    Visualization:

    a ----d----> ----d----> ----d----> ... ----d----> lastTerm

    Example:
    a = 2
    d = 3
    n = 5

    lastTerm = 2 + (5 - 1) * 3 = 14

    Output:
    2 5 8 11 14
*/