package J05_PatternPrinting;
import java.util.Scanner;
public class C09_FlippedTraingle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of the Flipped Star Triangle: ");
        int n = sc.nextInt();

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
/*
    Logic:
    I used nested loops where the outer loop starts from the given height
    and decreases after each iteration.
    The inner loop prints stars equal to the current row value (i).
    Since the value of i decreases by 1 after every row,
    one less star is printed in each new row.
    This creates an inverted (flipped) star triangle pattern.
*/