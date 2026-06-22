package J01_Basics;

/*
 * A package is used to organize related Java files.
 * You can think of it like a folder that keeps similar classes together.
 */
public class C01_FirstProgram {

    /*
     * public  -> This method can be accessed from anywhere.
     * static  -> Java can call this method without creating an object of the class.
     * void    -> This method does not return any value.
     * main    -> Special method where program execution starts.
     * String[] args -> Stores command-line arguments passed to the program.
     */
    public static void main(String[] args) {

        /*
         * System  -> A built-in Java class.
         * out     -> Represents the standard output stream (console).
         * println -> Prints the text and then moves the cursor to the next line.
         * \n      -> Newline character.
         */
        System.out.println("Hey everyone,\nit's my first program in Java.");

        /*
         * print() works like println(),
         * but it does not move to a new line after printing.
         */
        System.out.print("I will be moving forward to learn more.");
    }
}