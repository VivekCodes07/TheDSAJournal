package J08_ObjectOrientedProgramming.L11_AutoBoxingAndPOJOs;

/*
I am learning what actually happens when
Java compiles and runs a .java file.

I already know that:

One .java file
    ↓
Can contain multiple top-level classes
    ↓
But at most one can be public

And if a top-level class is public:

Public class name
        =
.java file name

Now I want to understand this
from the execution point of view.
*/


/*
This is a normal top-level class.

It is not public.

So it does not have to match
the file name.

I can still use this class
from the public class below.
*/
class Calculator {

    int add(int first, int second) {

        return first + second;
    }
}


/*
The file name is:

C03_PublicClassRule.java

So the public class is:

C03_PublicClassRule

The names match.

This makes the source file valid.
*/
public class C03_PublicClassRule {

    public static void main(String[] args) {

        /*
        When I run this program,
        execution starts from main().

        The JVM looks for:

        public static void main(String[] args)

        inside the class I asked Java to run.
        */
        System.out.println("Program started.");


        /*
        Calculator is another class
        written in the same .java file.

        During compilation, Java does not
        combine everything into one class.

        Instead, it produces separate
        .class files.

        Conceptually:

        C03_PublicClassRule.java
                  |
                  | javac
                  ↓
        ┌─────────────────────┐
        │ C03_PublicClassRule │
        │ Calculator          │
        └─────────────────────┘
                  |
                  ↓
        ┌────────────────────────────┐
        │ C03_PublicClassRule.class │
        │ Calculator.class           │
        └────────────────────────────┘
        */
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 20);

        System.out.println("Result: " + result);

        System.out.println("Program finished.");
    }
}


/*
Now I need to understand why this is NOT allowed:

public class C03_PublicClassRule {
}

public class Calculator {
}

Both are public top-level classes.

The same source file would now contain:

C03_PublicClassRule.java
        |
        ├── public C03_PublicClassRule
        |
        └── public Calculator

Java does not allow two public
top-level classes in one source file.
*/


/*
There is another important part
of the rule.

Suppose I write:

public class Calculator {
}

but the file is:

C03_PublicClassRule.java

Now the public class name and
file name do not match.

Java expects the source file for
that public class to be:

Calculator.java

So this would also be invalid.
*/


/*
Now I can understand the complete
compilation and execution flow.

STEP 1 — I write source code

C03_PublicClassRule.java
        |
        ├── Calculator
        |
        └── C03_PublicClassRule


STEP 2 — javac compiles the source

javac C03_PublicClassRule.java


STEP 3 — Java creates separate
.class files

Calculator.class
C03_PublicClassRule.class


STEP 4 — I run the public class

java C03_PublicClassRule


STEP 5 — JVM loads the class

C03_PublicClassRule.class
        |
        ↓
       main()
        |
        ↓
Program starts executing


STEP 6 — main() creates Calculator

Calculator calculator = new Calculator();

Now a Calculator object is created
and the add() method can be called.


So the source file is only where
I write the classes together.

After compilation, each class gets
its own compiled representation.
*/


/*
FINAL MEMORY PICTURE

SOURCE CODE

C03_PublicClassRule.java
        |
        ├── class Calculator
        |
        └── public class C03_PublicClassRule
                     |
                   main()
                     |
                     ↓
                  execution


             javac
               |
               ↓

COMPILED FILES

Calculator.class
C03_PublicClassRule.class


Then:

java C03_PublicClassRule
            |
            ↓
           JVM
            |
            ↓
C03_PublicClassRule.class
            |
            ↓
          main()
            |
            ↓
       Program executes


So I should remember:

.java
    ↓
Source code

javac
    ↓
Compiler

.class
    ↓
Compiled bytecode

JVM
    ↓
Executes bytecode


And separately:

One .java file
    ↓
Multiple top-level classes are possible
    ↓
At most one can be public
    ↓
Public class name = file name
*/
