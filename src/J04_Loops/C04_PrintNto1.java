package J04_Loops;
import java.util.Scanner;
public class C04_PrintNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number from where the reverse you want: ");
        int number = sc.nextInt();

        for(int i = number; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
