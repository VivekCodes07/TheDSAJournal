package J05_PatternPrinting;
import java.util.Scanner;
public class C07_NumberTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of the Number Triangle: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop controls the number of rows
    and the inner loop prints the numbers in each row.
    The inner loop starts from 1 and runs up to the current row number (i),
    so each new row contains one more number than the previous row.
    This creates an increasing number triangle pattern.
*/