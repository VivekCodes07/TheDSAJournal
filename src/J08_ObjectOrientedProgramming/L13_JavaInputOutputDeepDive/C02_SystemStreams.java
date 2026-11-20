package J08_ObjectOrientedProgramming.L13_JavaInputOutputDeepDive;

import java.io.InputStream;
import java.io.PrintStream;

public class C02_SystemStreams {

    public static void main(String[] args) {

        InputStream input = System.in;
        PrintStream output = System.out;
        PrintStream error = System.err;

        output.println("System.in  → Standard Input");
        output.println("System.out → Standard Output");
        output.println("System.err → Standard Error");

        error.println("This message is sent through System.err.");

        output.println();
        output.println("Input object type: " + input.getClass().getName());
        output.println("Output object type: " + output.getClass().getName());
        output.println("Error object type: " + error.getClass().getName());
    }
}