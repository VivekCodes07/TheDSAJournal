package J02_Conditionals;
import java.util.Scanner;
public class C06_FourDigitCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        double number = sc.nextInt();

        if (number > 999 && number < 10000) {
            System.out.println("The number is of 4 digit.");
        } else {
            System.out.println("The number is not of 4 digit.");
        }
    }
}
