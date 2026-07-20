package J05_PatternPrinting;
import java.util.Scanner;
public class C10_FlippedNumberTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of the Flipped Number Triangle: ");
        int n = sc.nextInt();

        for(int i = n; i >= 1; i--) {
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
    I used nested loops where the outer loop starts from the given height
    and decreases after each iteration.
    The inner loop prints numbers from 1 up to the current row value (i).
    Since the value of i decreases by 1 after every row,
    each new row contains one less number than the previous row.
    This creates an inverted (flipped) number triangle pattern.
*/