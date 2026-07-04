package J04_Loops;

// Print all alphabets with their corresponding ASCII Values.
public class C06_ASCIIValues {
    public static void main(String[] args) {

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch + " = " + (int)ch);
        }
    }
}
