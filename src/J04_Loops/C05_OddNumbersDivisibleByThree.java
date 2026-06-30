package J04_Loops;
// Print all odd numbers divisible by 3 from 1 to 100.
public class C05_OddNumbersDivisibleByThree {
    public static void main(String[] args) {
        System.out.println("Printing Odd numbers divisible by 3 upto 100:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
