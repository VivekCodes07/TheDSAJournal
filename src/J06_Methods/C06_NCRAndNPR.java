package J06_Methods;
import java.util.Scanner;
public class C06_NCRAndNPR {
    public static int factorial(int n) {
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static int nPr(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter r: ");
        int r = sc.nextInt();

        if (r > n) {
            System.out.println("r cannot be greater than n.");
            sc.close();
            return;
        }

        System.out.println("nCr = " + nCr(n, r));
        System.out.println("nPr = " + nPr(n, r));

        sc.close();
    }
}
/*
    factorial() is a helper method that calculates
    the factorial of a given number and returns it.

    Instead of writing the factorial logic again and again,
    we simply call this method whenever we need n!, r!,
    or (n-r)!.
*/

/*
    nPr() calculates the number of permutations.

    Formula:
    nPr = n! / (n-r)!

    Here, order matters, so different arrangements
    are counted separately.
*/

/*
    nCr() calculates the number of combinations.

    Formula:
    nCr = n! / (r! * (n-r)!)

    Here, order does not matter, so different
    arrangements of the same group are counted only once.
*/

/*
    In the main() method, we take n and r as input
    from the user and then call the nPr() and nCr()
    methods to get the required results.
*/