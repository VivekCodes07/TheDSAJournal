package J08_ObjectOrientedProgramming.L04_StaticAndFinal;

public class C04_StringArgs {

    public static void main(String[] args) {

        System.out.println("Number of arguments: " + args.length);

        for (int i = 0; i < args.length; i++) {

            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}

/*
 WHAT IS String[] args?
 ----------------------

 I have been writing:

     public static void main(String[] args)

 since I started Java.

 Now I understand what it actually means.

     String[]
         ↓
     An array that can store Strings

     args
         ↓
     The name of that array


 WHY DOES main() HAVE args?
 --------------------------

 args allows me to pass values to my Java program
 when I start the program.

 For example, I can run:

     java C04_StringArgs Vivek 101 CSE

 Java receives these values and puts them inside
 the args array.


 HOW DOES THE FLOW WORK?
 -----------------------

 When I run:

     java C04_StringArgs Vivek 101 CSE

 The flow is:

     Program starts
          ↓
     JVM calls main()
          ↓
     Values are passed to String[] args
          ↓
     args stores the values
          ↓
     I can access them using indexes


 So the array looks like:

     args
      |
      ├── [0] → "Vivek"
      ├── [1] → "101"
      └── [2] → "CSE"


 WHY DO I USE INDEXES?
 ---------------------

 args is an array, so it follows the same
 indexing rule as other Java arrays.

     args[0]
         ↓
     First argument

     args[1]
         ↓
     Second argument

     args[2]
         ↓
     Third argument


 IMPORTANT: EVERYTHING IS A STRING
 ---------------------------------

 Even if I pass:

     101

 Java receives it as:

     "101"

 because args is a String array.

 So:

     args[1]

 contains:

     "101"

 not:

     101


 If I actually need an int, I have to convert it:

     int id = Integer.parseInt(args[1]);


 WHAT DOES args.length MEAN?
 ---------------------------

 args.length tells me how many arguments
 were passed to the program.

 If I run:

     java C04_StringArgs Vivek 101 CSE

 then:

     args.length = 3


 MEMORY PERSPECTIVE
 ------------------

 args is a reference variable.

 It points to a String array created by Java.

     STACK                         HEAP

     args ───────────────────→ String Array
                               [0] → "Vivek"
                               [1] → "101"
                               [2] → "CSE"


 So:

     args
       ↓
     reference to the array

     args[0]
       ↓
     first element of that array


 WHY IS main() STATIC?
 ---------------------

 I have already learned that static means
 something belongs to the class.

 The JVM needs to start my program by calling:

     main()

 But I haven't created an object yet.

 So Java cannot depend on:

     new C04_StringArgs()

 just to start the program.

 That's why main() is static.

 The JVM can directly call:

     C04_StringArgs.main(...)


 THE COMPLETE PICTURE
 --------------------

     public
       ↓
     JVM can access main()

     static
       ↓
     JVM can call main()
     without creating an object

     void
       ↓
     main() returns nothing

     main
       ↓
     Starting point of the program

     String[] args
       ↓
     Array containing command-line arguments


 SIMPLE MEMORY TRICK
 -------------------

     String[]
         ↓
     Type of the array

     args
         ↓
     Reference to the array

     args[0]
         ↓
     First value

     args.length
         ↓
     Number of values
*/