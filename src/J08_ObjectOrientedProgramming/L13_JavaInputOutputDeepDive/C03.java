package J08_ObjectOrientedProgramming.L13_JavaInputOutputDeepDive;

import java.io.IOException;

public class C03 {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter x: ");
        int data = System.in.read();
        System.out.println((char)data);
    }
}
