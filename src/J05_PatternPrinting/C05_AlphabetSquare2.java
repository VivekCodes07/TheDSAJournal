package J05_PatternPrinting;
import java.util.Scanner;
public class C05_AlphabetSquare2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Alphabet Square: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print((char)(i + 64) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop handles the rows
    and the inner loop handles the columns.
    Instead of using the column number, I converted the row number (i)
    into its corresponding uppercase alphabet using (char)(i + 64).
    Since the value of i stays the same for an entire row,
    the same alphabet gets printed across that row,
    creating the required alphabet square pattern.
*/