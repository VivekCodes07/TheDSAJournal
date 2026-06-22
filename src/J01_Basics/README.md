# Java for DSA - Lesson 1

> Goal: Understand how Java works internally and learn the fundamental building blocks required for DSA.

---

# Table of Contents

1. How Java Works
2. JDK, JRE and JVM
3. Compilation and Execution Flow
4. Structure of a Java Program
5. Output in Java
6. Variables
7. Data Types
8. Taking Input
9. Updating Variables
10. Type Casting
11. Mini DSA Example
12. Key Takeaways

---

# 1. How Java Works

Before writing Java code, let's understand what happens when we run a Java program.

Suppose we write:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Question:

Can the computer understand Java?

Answer:

No.

Computers only understand machine code (0s and 1s).

Therefore Java code must be converted before the computer can execute it.

---

# 2. JDK, JRE and JVM

These three terms confuse almost every beginner.

Let's understand them once and forever.

---

## JVM (Java Virtual Machine)

JVM is responsible for running Java programs.

Think of JVM as a translator.

It takes Java bytecode and converts it into machine code that your operating system understands.

Without JVM, Java programs cannot run.

### Responsibility

* Executes Java programs
* Converts bytecode into machine code
* Manages memory
* Handles garbage collection

---

## JRE (Java Runtime Environment)

JRE contains:

```text
JRE
│
├── JVM
└── Libraries Required To Run Java Programs
```

Think:

JVM = Engine

JRE = Complete Car

If you only want to run Java programs, JRE is enough.

---

## JDK (Java Development Kit)

JDK contains:

```text
JDK
│
├── JRE
│   └── JVM
│
└── Development Tools
```

Development tools include:

* javac (compiler)
* debugger
* documentation tools

If you want to write Java programs, you need JDK.

---

# Relationship

```text
JDK
│
└── JRE
    │
    └── JVM
```

Remember:

* JVM executes Java code
* JRE provides environment to run Java code
* JDK provides tools to develop Java code

---

# 3. Compilation and Execution Flow

Suppose we create:

```java
Main.java
```

Step 1:

We write Java code.

```java
System.out.println("Hello World");
```

↓

Step 2:

Compiler converts source code into bytecode.

```text
javac Main.java
```

Output:

```text
Main.class
```

This .class file contains bytecode.

↓

Step 3:

JVM loads bytecode.

↓

Step 4:

JVM converts bytecode into machine code.

↓

Step 5:

Computer executes machine code.

↓

Output:

```text
Hello World
```

Visual Representation:

```text
Java Source Code
        │
        ▼
     Compiler
      (javac)
        │
        ▼
     Bytecode
   (Main.class)
        │
        ▼
       JVM
        │
        ▼
   Machine Code
        │
        ▼
      Output
```

---

# Why Java Is Platform Independent

In C++:

```text
Code → Machine Code
```

Machine code generated for Windows may not run on Linux.

But Java uses:

```text
Code
 ↓
Bytecode
 ↓
JVM
 ↓
Machine Code
```

As long as a JVM exists on a machine, Java code can run.

Therefore:

```text
Write Once, Run Anywhere
```

---

# 4. Structure of a Java Program

Example:

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

    }

}
```

Let's break it down.

---

## Class

```java
public class Main
```

Every Java program exists inside a class.

Think of a class as a container that holds code.

---

## Main Method

```java
public static void main(String[] args)
```

Execution starts here.

When JVM runs the program, it first looks for:

```java
main()
```

No main method = program cannot start.

---

## Curly Braces

```java
{
}
```

Used to define blocks.

Everything inside belongs together.

---

# 5. Output in Java

Output means displaying information on the screen.

---

## println()

```java
System.out.println("Hello");
```

Output:

```text
Hello
```

Moves cursor to next line.

---

Example:

```java
System.out.println("A");
System.out.println("B");
```

Output:

```text
A
B
```

---

## print()

```java
System.out.print("A");
System.out.print("B");
```

Output:

```text
AB
```

Cursor remains on same line.

---

# 6. Variables

Programs need memory.

Variables allow us to store data.

Example:

```java
int age = 20;
```

Visualize:

```text
age
 ↓
20
```

The variable name is:

```text
age
```

Stored value is:

```text
20
```

---

## Variable Declaration

```java
int age;
```

Memory reserved.

---

## Variable Initialization

```java
age = 20;
```

Value assigned.

---

## Declaration + Initialization

```java
int age = 20;
```

Most common.

---

# 7. Data Types

Different kinds of data require different storage.

---

## int

Stores whole numbers.

```java
int age = 20;
```

Examples:

```java
int marks = 95;
int salary = 50000;
```

---

## double

Stores decimal numbers.

```java
double pi = 3.14159;
```

Examples:

```java
double height = 5.9;
double cgpa = 8.75;
```

---

## char

Stores a single character.

```java
char grade = 'A';
```

Always uses single quotes.

```java
'A'
```

---

## boolean

Stores true or false.

```java
boolean passed = true;
```

Possible values:

```java
true
false
```

---

## String

Stores text.

```java
String name = "Aman";
```

Always uses double quotes.

```java
"Aman"
```

---

# Data Type Summary

| Data Type | Example |
| --------- | ------- |
| int       | 10      |
| double    | 10.5    |
| char      | 'A'     |
| boolean   | true    |
| String    | "Hello" |

---

# 8. Taking Input

For DSA, input is extremely important.

Most coding questions start with:

```text
Take Input
Process Data
Print Output
```

---

## Import Scanner

```java
import java.util.Scanner;
```

---

## Create Scanner Object

```java
Scanner sc = new Scanner(System.in);
```

Think:

Scanner is listening to keyboard input.

---

## Integer Input

```java
int age = sc.nextInt();
```

---

## Decimal Input

```java
double num = sc.nextDouble();
```

---

## Single Word Input

```java
String name = sc.next();
```

Input:

```text
Aman
```

---

## Full Line Input

```java
String sentence = sc.nextLine();
```

Input:

```text
I love DSA
```

---

# Example

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();

        System.out.println(age);

    }

}
```

Input:

```text
21
```

Output:

```text
21
```

---

# 9. Updating Variables

Variables can change.

Example:

```java
int age = 20;
```

Later:

```java
age = 25;
```

Now:

```text
age = 25
```

Old value gets replaced.

---

Example:

```java
int x = 5;

x = 10;

System.out.println(x);
```

Output:

```text
10
```

---

# 10. Type Casting

Sometimes one data type must be converted into another.

---

## Implicit Casting

Smaller type to larger type.

```java
int x = 10;

double y = x;
```

Output:

```text
10.0
```

Java performs conversion automatically.

---

## Explicit Casting

Larger type to smaller type.

```java
double x = 10.8;

int y = (int)x;
```

Output:

```text
10
```

Decimal portion is removed.

---

# 11. Mini DSA Example

Problem:

Take two numbers and print their sum.

---

Solution:

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;

        System.out.println(sum);

    }

}
```

Input:

```text
5
7
```

Output:

```text
12
```

---

# DSA Problem Solving Pattern

Almost every DSA problem follows:

```text
Input
 ↓
Process
 ↓
Output
```

Example:

```text
Take numbers
 ↓
Calculate answer
 ↓
Print answer
```

This simple flow will stay with you throughout your DSA journey.

---

# 12. Key Takeaways

✅ Java source code cannot be executed directly

✅ javac converts source code into bytecode

✅ JVM converts bytecode into machine code

✅ JDK contains JRE

✅ JRE contains JVM

✅ Every Java program starts from main()

✅ Variables store data

✅ Common data types:

* int
* double
* char
* boolean
* String

✅ Scanner is used for input

✅ print() and println() are used for output

✅ Variables can be updated

✅ Type casting converts one data type into another

✅ Every DSA problem follows:

```text
Input
 ↓
Process
 ↓
Output
```
