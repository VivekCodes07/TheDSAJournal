package J01_Basics;

/*
 ╔══════════════════════════════════════════════╗
 ║                VARIABLES IN JAVA            ║
 ╚══════════════════════════════════════════════╝

 A variable is a named memory location used
 to store data that can be accessed and modified
 throughout the program.

 Syntax:
     dataType variableName = value;
*/

public class C02_Variables {

    public static void main(String[] args) {

        /*
         * Whole Numbers (int)
         */
        int age = 20;

        /*
         * Decimal Numbers (double)
         */
        double cgpa = 8.75;

        /*
         * Single Character (char)
         */
        char grade = 'A';

        /*
         * True / False Values (boolean)
         */
        boolean isLearningJava = true;

        /*
         * Text Data (String)
         */
        String name = "Vivek";

        /*
         * Output
         */
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("CGPA  : " + cgpa);
        System.out.println("Grade : " + grade);
        System.out.println("Java? : " + isLearningJava);
    }
}