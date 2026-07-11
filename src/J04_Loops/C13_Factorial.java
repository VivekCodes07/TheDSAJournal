package J04_Loops;
import java.util.Scanner;
public class C13_Factorial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number whose factorial you want: ");
        long number = sc.nextInt();
        long factorial = 1;
        long i = 1;
        while (i <= number) {
            factorial *= i;
            i++;
        }

        System.out.println("Factorial: " + factorial);
    }
}
