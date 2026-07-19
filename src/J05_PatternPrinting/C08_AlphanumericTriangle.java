package J05_PatternPrinting;

import java.util.Scanner;

public class C08_AlphanumericTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height of Alphanumeric Triangle: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print((char) (j + 64) + " ");
                } else {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop controls the rows
    and the inner loop prints the elements in each row.
    I checked whether the current row number (i) is even or odd.
    If the row is odd, I printed numbers from 1 up to the current row.
    If the row is even, I converted the column number into its
    corresponding uppercase alphabet using (char)(j + 64).
    This creates an alternating alphanumeric triangle pattern
    where odd rows contain numbers and even rows contain alphabets.
*/