package J03_Conditionals;
import java.util.Scanner;

public class C08_CheckDivisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to check if it's divisible by 3 or 5: ");
        int number = sc.nextInt();

        if (number % 5 == 0 || number % 3 == 0) {
            System.out.println("The number is divisible.");
        } else {
            System.out.println("The number is not divisible.");
        }

    }

}
