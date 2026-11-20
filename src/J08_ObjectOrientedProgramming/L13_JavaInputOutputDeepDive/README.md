# Lesson 13 — Java I/O From First Principles

## Why Am I Learning This?

Until now, I have mainly focused on Java's core programming and OOP concepts:

* Classes and objects
* Constructors
* `this`
* `static`
* Encapsulation
* Inheritance
* Abstraction
* Polymorphism
* Interfaces
* Nested classes

Now I want to understand something I use in almost every Java program:

```java
System.out.println("Hello");
```

And when I need input:

```java
Scanner scanner = new Scanner(System.in);
```

I don't want to treat these as magic Java statements.

I want to understand **what is actually happening underneath them**.

I want to understand:

* What I/O means
* What a stream is
* How to read the anatomy of I/O code
* What the `System` class does
* What `System.in`, `System.out`, and `System.err` are
* How static fields and object references are involved
* Why `System.out` refers to a `PrintStream`
* Why `System.in` refers to an `InputStream`
* How Java reads bytes
* Why characters are different from bytes
* Why `InputStreamReader` exists
* Why buffering exists
* What `BufferedReader` does
* Why `Scanner` exists
* How `Scanner` and `BufferedReader` differ
* How Java's I/O classes are connected
* What wrapping and layering mean
* How exceptions are involved in I/O
* How resources are managed
* How all of this connects to file I/O

The goal is:

> **Understand the system instead of memorizing the syntax.**

---

# Lesson Progression

This lesson follows a deliberate progression from **syntax → objects → streams → layers → higher-level APIs → complete I/O architecture**.

```text
1. Why I/O?
      ↓
2. What Is a Stream?
      ↓
3. Anatomy of Java I/O Code
      ↓
4. Object References Behind I/O
      ↓
5. The System Class
      ↓
6. System.out → PrintStream
      ↓
7. System.in → InputStream
      ↓
8. Reading Bytes with read()
      ↓
9. Bytes vs Characters
      ↓
10. InputStreamReader
      ↓
11. Character Encoding
      ↓
12. Buffering
      ↓
13. BufferedReader
      ↓
14. Parsing Input
      ↓
15. Scanner
      ↓
16. Scanner vs BufferedReader
      ↓
17. nextInt() + nextLine() Gotcha
      ↓
18. Important I/O Hierarchy
      ↓
19. PrintStream and PrintWriter
      ↓
20. flush()
      ↓
21. IOException
      ↓
22. Layering and Wrapping
      ↓
23. Try-With-Resources
      ↓
24. Connection to File I/O
      ↓
25. Complete I/O Mental Model
```

## Why This Order?

The order is intentional.

I first understand **how to read Java I/O code anatomically** before learning individual I/O classes.

Then I move from:

```text
System.out
System.in
```

to the lower-level mechanism:

```text
InputStream
```

Then I learn how bytes become characters:

```text
InputStreamReader
```

Then I add buffering:

```text
BufferedReader
```

Then I move to the higher-level parsing API:

```text
Scanner
```

Finally, I learn how these pieces fit together through:

```text
Hierarchy
Layering
Wrapping
Resource Management
File I/O
```

So the overall learning path is:

```text
Understand the syntax
        ↓
Understand the objects
        ↓
Understand the streams
        ↓
Understand the layers
        ↓
Understand the higher-level APIs
        ↓
Understand the complete I/O architecture
```

---

# 1. What Does I/O Mean?

I/O stands for:

> **Input / Output**

A program constantly communicates with the outside world.

It receives data, processes it, and produces data.

```text
Input
  ↓
Java Program
  ↓
Output
```

## Input

Input is data coming **into** my program.

Examples:

* Keyboard input
* File data
* Network data

For example:

```text
Keyboard
   ↓
Java Program
```

If I type:

```text
Vivek
```

that is input.

## Output

Output is data going **out of** my program.

Examples:

* Console output
* File output
* Network output

For example:

```text
Java Program
   ↓
Console
```

If Java prints:

```text
Hello Vivek
```

that is output.

The fundamental idea is:

```text
Outside World
      ↓
    Input
      ↓
Java Program
      ↓
    Output
      ↓
Outside World
```

---

# 2. What Is a Stream?

A **stream** represents a flow of data between a source and a destination.

I can think of it like a pipe through which data travels.

```text
Source
  ↓
Stream
  ↓
Destination
```

For input:

```text
Keyboard
   ↓
Input Stream
   ↓
Java Program
```

For output:

```text
Java Program
   ↓
Output Stream
   ↓
Console
```

The important idea is:

> **A stream is a mechanism through which data flows between two places.**

---

# 3. Before I/O: How Do I Read the Anatomy of Java Code?

This is one of the most important parts of this lesson.

Before learning different I/O classes, I want to learn how to **look inside the syntax**.

Consider:

```java
Student student = new Student();

student.study();
```

I already know the OOP concepts involved.

```text
Student
   ↓
type / class

student
   ↓
reference variable

new Student()
   ↓
object creation

student.study()
   ↓
method call through the reference
```

The important pattern is:

```text
Reference
   ↓
Object
   ↓
Method
```

This exact OOP idea appears everywhere in Java I/O.

---

# 4. Anatomy of `System.out.println()`

Now consider:

```java
System.out.println("Hello");
```

Instead of memorizing it, I want to break it apart.

```text
System.out.println("Hello")
   │      │       │       │
   │      │       │       └── argument
   │      │       └────────── method
   │      └────────────────── field
   └───────────────────────── class
```

Let's understand each part.

## `System`

`System` is a Java class:

```text
java.lang.System
```

It provides system-related functionality and gives access to the standard streams.

## `out`

`out` is a static field of the `System` class.

Conceptually:

```java
class System {

    public static final PrintStream out = ...;

}
```

This is only a simplified mental model.

The important part is:

```text
System
   ↓
static field: out
```

## `PrintStream`

The `out` field refers to a `PrintStream` object.

So:

```text
System
   ↓
out
   ↓
PrintStream reference
   ↓
PrintStream object
```

## `println()`

`println()` is an instance method of `PrintStream`.

Therefore:

```java
System.out.println("Hello");
```

conceptually means:

```text
System
  ↓
access static field "out"
  ↓
get PrintStream object reference
  ↓
call println()
  ↓
pass "Hello"
```

The complete anatomy is:

```text
System
  ↓
static field: out
  ↓
reference to PrintStream object
  ↓
println()
  ↓
"Hello"
```

---

# 5. Why Is `System.out` an Object Reference?

This is where my previous OOP knowledge becomes important.

Normally, I create objects like:

```java
Student student = new Student();
```

Here:

```text
new Student()
    ↓
Student object
    ↓
student reference
```

But with:

```java
System.out
```

I never personally wrote:

```java
PrintStream out = new PrintStream(...);
```

So who created the object?

The Java runtime initializes the standard streams and makes their references available through the `System` class.

Conceptually:

```text
Java Runtime
     ↓
PrintStream object
     ↓
reference stored in
     ↓
System.out
```

So when I write:

```java
System.out.println("Hello");
```

I am using an object that has already been created and whose reference is stored in a static field.

---

# 6. Object Creation vs Object Referencing

These are two different concepts.

## Object Creation

```java
new Student();
```

creates an object.

## Reference Declaration

```java
Student student;
```

declares a reference.

## Together

```java
Student student = new Student();
```

creates an object and stores its reference.

With `System.out`, I don't see the object creation because the object is initialized by the Java runtime/library.

The important lesson is:

> **I don't have to create an object myself to use an object.**

Libraries and frameworks frequently create objects and expose references to them.

---

# 7. The Same OOP Pattern in My Own Code

Suppose I write:

```java
class College {

    static Student student = new Student();
}

class Student {

    void study() {
        System.out.println("Studying...");
    }
}
```

Then:

```java
College.student.study();
```

works conceptually as:

```text
College
   ↓
static field: student
   ↓
Student object reference
   ↓
study()
```

Compare that with:

```java
System.out.println("Hello");
```

```text
System
   ↓
static field: out
   ↓
PrintStream object reference
   ↓
println()
```

The OOP concept is the same.

The difference is **who initialized the object**.

---

# 8. Anatomy of `System.in.read()`

Now that I understand `System.out`, I can understand:

```java
System.in.read();
```

Break it down:

```text
System.in.read()
   │     │    │
   │     │    └── instance method
   │     └─────── static field
   └───────────── class
```

Conceptually:

```text
System
   ↓
static field: in
   ↓
reference to InputStream object
   ↓
read()
```

So `System.in` follows the same object-reference idea as `System.out`.

---

# 9. Anatomy of `Scanner`

Consider:

```java
Scanner scanner = new Scanner(System.in);
```

Break it down:

```text
Scanner
   ↓
type / class

scanner
   ↓
reference variable

new Scanner(...)
   ↓
creates Scanner object

System.in
   ↓
input source passed to Scanner
```

Conceptually:

```text
System.in
   ↓
InputStream
   ↓
Scanner object
   ↓
scanner reference
```

Then:

```java
scanner.nextInt();
```

means:

```text
scanner reference
   ↓
Scanner object
   ↓
nextInt()
```

Again:

> **Reference → Object → Method**

The OOP foundation has not changed.

---

# 10. Anatomy of `BufferedReader`

Now consider:

```java
BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(System.in)
        );
```

This looks complicated at first, but the anatomy makes it much easier.

Start from the inside:

```text
System.in
```

Then:

```text
System.in
   ↓
InputStream
```

Then:

```text
InputStream
   ↓
InputStreamReader
```

Then:

```text
InputStreamReader
   ↓
BufferedReader
```

Finally:

```text
BufferedReader object
   ↓
reader reference
```

So the complete structure is:

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
BufferedReader
   ↓
reader
```

This is called **wrapping** or **layering**.

I will understand exactly why these layers exist later in the lesson.

---

# 11. Java's Standard Streams

Now that I understand the anatomy, I can study Java's three standard streams:

```java
System.in
System.out
System.err
```

| Stream       | Purpose         | Type          |
| ------------ | --------------- | ------------- |
| `System.in`  | Standard input  | `InputStream` |
| `System.out` | Standard output | `PrintStream` |
| `System.err` | Standard error  | `PrintStream` |

Conceptually:

```text
System
 ├── in  → InputStream
 ├── out → PrintStream
 └── err → PrintStream
```

These are static fields of the `System` class.

---

# 12. `System.out` — Standard Output

`System.out` represents standard output.

For a normal console application:

```text
Java Program
     ↓
System.out
     ↓
PrintStream
     ↓
Console
```

The important relationship is:

```text
System.out
    ↓
PrintStream reference
    ↓
PrintStream object
    ↓
println()
```

---

# 13. `PrintStream`

`PrintStream` is a Java class that provides convenient output methods.

Important methods include:

```java
print()
println()
printf()
```

Example:

```java
System.out.print("Hello ");
System.out.println("Vivek");
System.out.printf("Age: %d", 20);
```

Because `System.out` refers to a `PrintStream` object, I can call these methods through it.

---

# 14. `System.err` — Standard Error

Java also provides:

```java
System.err
```

It is another `PrintStream`.

Example:

```java
System.err.println("Something went wrong.");
```

For now, the mental model is:

```text
System.out → normal output
System.err → error output
```

Both are references to `PrintStream` objects.

---

# 15. `System.in` — Standard Input

Now move to input.

```java
System.in
```

represents standard input.

Its type is:

```java
InputStream
```

Conceptually:

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
Java Program
```

This means `System.in` gives the program access to incoming **byte-oriented data**.

---

# 16. Byte Streams

One major I/O family is:

```text
InputStream
OutputStream
```

They are **byte-oriented**.

## `InputStream`

Used for reading bytes:

```text
Source
   ↓
InputStream
   ↓
Program
```

## `OutputStream`

Used for writing bytes:

```text
Program
   ↓
OutputStream
   ↓
Destination
```

Byte streams are useful for raw or binary data such as:

* Images
* Videos
* PDFs
* Binary files
* Raw network data

The key idea is:

```text
InputStream  → read bytes
OutputStream → write bytes
```

---

# 17. Reading Directly From `System.in`

I can read directly from `System.in` using:

```java
int data = System.in.read();
```

Example:

```java
import java.io.IOException;

public class C03_SystemInRead {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a character: ");

        int data = System.in.read();

        System.out.println("You entered: " + (char) data);
    }
}
```

If I enter:

```text
A
```

`read()` reads the incoming byte.

---

# 18. Why Does `read()` Return `int`?

This is an important detail.

`InputStream.read()` returns:

```java
int
```

not:

```java
byte
```

because it needs to represent both actual byte values and the special end-of-stream value.

Conceptually:

```text
read()
  ↓
 ┌─────────────────┐
 │ 0–255 → data    │
 │ -1    → EOF     │
 └─────────────────┘
```

So:

```java
int data = System.in.read();
```

can represent:

```text
0–255 → actual byte value
-1    → end of stream
```

---

# 19. `InputStream` vs `Reader`

Java has two major models for handling input:

```text
InputStream
Reader
```

The key difference is:

```text
InputStream → bytes
Reader      → characters
```

### Byte-oriented

```text
InputStream
    ↓
bytes
```

### Character-oriented

```text
Reader
   ↓
characters
```

This distinction is fundamental to Java I/O.

---

# 20. Why Do We Need `Reader`?

Computers ultimately transfer and store data as bytes.

But when I work with text, I want to work with characters.

For example:

```text
V
i
v
e
k
```

So I need a bridge between:

```text
Bytes
  ↓
Character interpretation
  ↓
Characters
```

That is where character-oriented I/O comes in.

---

# 21. `InputStreamReader`

`System.in` gives me an:

```text
InputStream
```

But I may want to work with characters.

`InputStreamReader` acts as a bridge:

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
Reader
   ↓
Characters
```

Example:

```java
import java.io.IOException;
import java.io.InputStreamReader;

public class C04_InputStreamReader {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader =
                new InputStreamReader(System.in);

        int data = reader.read();

        System.out.println((char) data);
    }
}
```

---

# 22. What Does `InputStreamReader` Actually Do?

It converts byte-oriented input into character-oriented input.

Conceptually:

```text
Bytes
  ↓
InputStreamReader
  ↓
Characters
```

This is why it sits between:

```text
InputStream
```

and:

```text
Reader
```

It acts as an adapter/bridge between the two models.

---

# 23. Character Encoding

How can Java convert bytes into characters?

It needs a character encoding.

Conceptually:

```text
Bytes
  ↓
Character Encoding
  ↓
Characters
```

One common encoding is:

```text
UTF-8
```

For this lesson, I don't need to study Unicode and encoding internals deeply.

I only need the basic idea:

> **`InputStreamReader` uses a character encoding to decode incoming bytes into characters.**

---

# 24. Why Do We Need Buffering?

Suppose my program needs to read a large amount of data.

Constantly interacting with the underlying source for every small piece of data can be inefficient.

Instead, Java can read a larger chunk and temporarily keep it in memory.

That temporary area is called a:

> **Buffer**

Conceptually:

```text
Source
  ↓
Large chunk
  ↓
Buffer
  ↓
Program
```

The program can then consume data from the buffer.

---

# 25. `BufferedReader`

`BufferedReader` provides buffered character input.

It wraps a `Reader`.

Example:

```java
BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(System.in)
        );
```

The complete flow is:

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
Reader
   ↓
BufferedReader
```

Each layer has a different responsibility.

---

# 26. Why Does `BufferedReader` Exist?

`BufferedReader` gives me:

1. Buffered input
2. Convenient character reading
3. `readLine()`

For example:

```java
String name = reader.readLine();
```

Complete example:

```java
import java.io.*;

public class C05_BufferedReader {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        System.out.print("Enter your name: ");

        String name = reader.readLine();

        System.out.println("Hello " + name);
    }
}
```

---

# 27. What Does `readLine()` Return?

This:

```java
reader.readLine();
```

returns a:

```text
String
```

So:

```java
String name = reader.readLine();
```

has this flow:

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
BufferedReader
   ↓
readLine()
   ↓
String
```

This is much more convenient than manually reading individual bytes.

---

# 28. Reading Numbers With `BufferedReader`

`BufferedReader` reads text.

So if I want an integer, I need to parse the text.

```java
String input = reader.readLine();

int age = Integer.parseInt(input);
```

Example:

```java
import java.io.*;

public class C06_BufferedReaderParsing {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        System.out.print("Enter your age: ");

        int age = Integer.parseInt(reader.readLine());

        System.out.println("Age: " + age);
    }
}
```

The flow is:

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
BufferedReader
   ↓
String
   ↓
Integer.parseInt()
   ↓
int
```

---

# 29. Why Does `Scanner` Exist?

At this point, I may think:

> Why should I manually convert strings into numbers?

For example:

```java
int age = Integer.parseInt(reader.readLine());
```

Java provides `Scanner` for easier input parsing.

```java
Scanner scanner = new Scanner(System.in);
```

Now I can write:

```java
int age = scanner.nextInt();
```

or:

```java
double price = scanner.nextDouble();
```

or:

```java
String name = scanner.next();
```

`Scanner` gives me a higher-level way to read and parse input.

---

# 30. How `Scanner` Works

Example:

```java
import java.util.Scanner;

public class C07_Scanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

Conceptually:

```text
Keyboard
   ↓
System.in
   ↓
Scanner
   ↓
Parsing
   ↓
int / double / String / ...
```

So:

```text
BufferedReader → mainly reads text
Scanner        → reads and parses input
```

---

# 31. `Scanner` vs `BufferedReader`

Both are useful, but they solve slightly different problems.

| `Scanner`                        | `BufferedReader`                           |
| -------------------------------- | ------------------------------------------ |
| Easier to use                    | More manual                                |
| Parses primitive values directly | Usually requires parsing                   |
| Convenient                       | More performance-oriented                  |
| Generally slower for heavy input | Generally faster                           |
| Good for simple programs         | Good for large/performance-sensitive input |

## Use `Scanner` when:

```text
I want simple and readable input.
```

## Use `BufferedReader` when:

```text
I want faster input and more control.
```

For DSA problems involving large input, I will commonly prefer `BufferedReader` or a custom fast-input approach.

---

# 32. The `nextInt()` + `nextLine()` Problem

Consider:

```java
int age = scanner.nextInt();
String name = scanner.nextLine();
```

This can produce unexpected behavior.

Why?

`nextInt()` reads the integer but leaves the newline character in the input.

Then:

```java
nextLine()
```

reads that remaining newline.

A common solution is:

```java
int age = scanner.nextInt();
scanner.nextLine();

String name = scanner.nextLine();
```

The first `nextLine()` consumes the leftover newline.

This is an important `Scanner` behavior to remember.

---

# 33. The I/O Hierarchy

Now I can organize the classes I have learned.

## Byte-Oriented I/O

```text
InputStream
     ↓
   bytes

OutputStream
     ↓
   bytes
```

## Character-Oriented I/O

```text
Reader
   ↓
characters

Writer
   ↓
characters
```

Important input relationship:

```text
InputStream
    ↓
InputStreamReader
    ↓
Reader
    ↓
BufferedReader
```

Important output classes include:

```text
OutputStream
├── FileOutputStream
└── PrintStream

Writer
├── OutputStreamWriter
└── PrintWriter
```

This is a **simplified learning hierarchy**, not the complete Java API hierarchy.

---

# 34. `PrintStream` and `PrintWriter`

I already know:

```java
System.out
```

refers to a:

```text
PrintStream
```

`PrintStream` provides:

```java
print()
println()
printf()
```

For character-oriented output, Java also provides:

```text
PrintWriter
```

Example:

```java
import java.io.PrintWriter;

public class C09_PrintWriter {

    public static void main(String[] args) {

        PrintWriter writer =
                new PrintWriter(System.out);

        writer.println("Hello from PrintWriter");

        writer.flush();
    }
}
```

For this lesson, the key distinction is:

```text
PrintStream → byte-oriented output API
PrintWriter → character-oriented output API
```

---

# 35. What Is `flush()`?

Some output classes use buffering.

That means output may temporarily remain in memory before being sent to the destination.

`flush()` tells the output object:

> **Send any buffered output now.**

Conceptually:

```text
Program
   ↓
Buffer
   ↓
flush()
   ↓
Destination
```

Example:

```java
writer.println("Hello");
writer.flush();
```

This becomes especially important with:

* Files
* Network connections
* Long-running programs
* Buffered output

---

# 36. `IOException`

I/O operations can fail.

For example:

* A file doesn't exist
* Permission is denied
* A connection is interrupted
* Reading fails
* Writing fails

Java represents many such failures using:

```java
IOException
```

Example:

```java
import java.io.IOException;

public class C10_IOException {

    public static void main(String[] args) throws IOException {

        int data = System.in.read();

        System.out.println(data);
    }
}
```

The:

```java
throws IOException
```

means:

> This method may encounter an I/O-related exception, and I am allowing it to be propagated to the caller.

I will study exception handling separately in more depth.

---

# 37. Why Are I/O Classes Layered?

Now this code should make sense:

```java
BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(System.in)
        );
```

It is not unnecessarily complicated.

Each layer adds a capability.

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
Reader
   ↓
BufferedReader
```

### `System.in`

Provides the input source.

### `InputStream`

Provides byte-oriented input.

### `InputStreamReader`

Converts bytes into characters.

### `BufferedReader`

Adds buffering and convenient text-reading methods.

So the design is:

```text
Small responsibility
       +
Small responsibility
       +
Small responsibility
       ↓
Combined functionality
```

---

# 38. Wrapping

When one I/O object is placed inside another:

```java
new BufferedReader(
    new InputStreamReader(System.in)
);
```

the outer object is **wrapping** the inner object.

Conceptually:

```text
BufferedReader
      ↓
   wraps
      ↓
InputStreamReader
      ↓
   wraps
      ↓
System.in
```

This is a common design approach in Java I/O.

Instead of creating one giant class that handles everything, Java composes smaller objects with focused responsibilities.

---

# 39. Try-With-Resources

Many I/O resources need to be closed after use.

Java provides **try-with-resources** for automatic resource management.

Example:

```java
import java.io.*;

public class C11_TryWithResources {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("data.txt"))) {

            String line = reader.readLine();

            System.out.println(line);
        }
    }
}
```

When the `try` block finishes, Java automatically closes the resource.

This is useful for:

* Files
* Streams
* Database connections
* Network resources

One important point:

> I should not casually close `System.in` in a small program.

Closing it can close the underlying standard input for the rest of the application.

---

# 40. Connection to File I/O

Everything I learned here applies to files too.

For binary data:

```text
File
 ↓
FileInputStream
 ↓
InputStream
```

For text:

```text
File
 ↓
FileReader
 ↓
Reader
 ↓
BufferedReader
```

For output:

```text
File
 ↓
FileOutputStream
 ↓
OutputStream
```

or:

```text
File
 ↓
FileWriter
 ↓
Writer
```

So learning Java I/O through `System.in` and `System.out` gives me the foundation for file handling.

---

# 41. Complete Input Mental Model

## Direct `System.in`

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
read()
   ↓
byte value
```

## `InputStreamReader`

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
characters
```

## `BufferedReader`

```text
Keyboard
   ↓
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
Reader
   ↓
BufferedReader
   ↓
readLine()
   ↓
String
```

## `Scanner`

```text
Keyboard
   ↓
System.in
   ↓
Scanner
   ↓
parsing
   ↓
int / double / String / ...
```

---

# 42. Complete Output Mental Model

Normal output:

```text
My Java Program
      ↓
System.out
      ↓
PrintStream reference
      ↓
PrintStream object
      ↓
println()
      ↓
Console
```

Error output:

```text
My Java Program
      ↓
System.err
      ↓
PrintStream
      ↓
Error output
```

---

# 43. The Most Important Anatomy To Remember

## `System.out.println()`

```text
System
  ↓
class
  ↓
out
  ↓
static field
  ↓
PrintStream reference
  ↓
PrintStream object
  ↓
println()
```

## `System.in.read()`

```text
System
  ↓
class
  ↓
in
  ↓
static field
  ↓
InputStream reference
  ↓
InputStream object
  ↓
read()
```

## `Scanner scanner = new Scanner(System.in)`

```text
System.in
   ↓
InputStream reference
   ↓
InputStream object
   ↓
passed to Scanner
   ↓
Scanner object
   ↓
scanner reference
```

## `BufferedReader`

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
Reader
   ↓
BufferedReader
   ↓
reader reference
   ↓
readLine()
```

---

# 44. The Complete Java I/O Picture

```text
                              JAVA I/O
                                  │
                    ┌─────────────┴─────────────┐
                    ↓                           ↓
                  INPUT                       OUTPUT
                    ↓                           ↓
                System.in                  System.out
                    ↓                           ↓
              InputStream                  PrintStream
                    │                           │
          ┌─────────┴─────────┐                 │
          ↓                   ↓                 ↓
      Scanner        InputStreamReader       print()
          │                   ↓               println()
          │                Reader              printf()
          │                   ↓
          │            BufferedReader
          │                   ↓
          │              readLine()
          │                   ↓
          │                String
          │
          ↓
      Parsed values
```

The fundamental split is:

```text
InputStream / OutputStream
        ↓
       bytes

Reader / Writer
        ↓
    characters
```

---

# 45. What I Learned

After completing this lesson, I should understand:

### Foundations

* What I/O means
* What input and output are
* What a stream represents
* Difference between input and output streams

### OOP Connection

* How to read the anatomy of I/O code
* What a reference is
* Difference between object creation and object referencing
* Why I can use objects I did not personally create
* How static fields are involved
* How the OOP pattern applies to Java I/O

### Standard Streams

* What the `System` class does
* What `System.in` is
* What `System.out` is
* What `System.err` is
* Why `System.out` refers to a `PrintStream`
* Why `System.in` refers to an `InputStream`

### Byte and Character I/O

* What `InputStream` is
* What `OutputStream` is
* What `Reader` is
* What `Writer` is
* Difference between bytes and characters
* Why `InputStreamReader` exists
* How bytes become characters
* What character encoding means at a basic level

### Buffered Input

* Why buffering is useful
* What `BufferedReader` does
* What `readLine()` returns
* How to parse numbers with `BufferedReader`

### Scanner

* Why `Scanner` exists
* How `Scanner` works with `System.in`
* Difference between `Scanner` and `BufferedReader`
* The `nextInt()` + `nextLine()` problem

### I/O Architecture

* Important I/O hierarchy
* What `PrintStream` is
* What `PrintWriter` is
* What `flush()` means
* Why `IOException` appears
* Why I/O classes are layered
* What wrapping means
* How try-with-resources works
* How these concepts connect to file I/O

---

# 46. Files in This Lesson

```text
L13_JavaIO/
├── C01_IOBasics.java
├── C02_SystemStreams.java
├── C03_SystemInRead.java
├── C04_InputStreamReader.java
├── C05_BufferedReader.java
├── C06_BufferedReaderParsing.java
├── C07_Scanner.java
├── C08_StreamHierarchy.java
├── C09_PrintWriter.java
├── C10_IOException.java
└── C11_TryWithResources.java
```

Each file focuses on a specific concept so that I can understand the lesson progressively instead of putting everything into one large program.

---

# Final Mental Model

I don't want to remember Java I/O as a collection of unrelated classes.

I want to see the system as a collection of objects connected together.

## Input

```text
Source
  ↓
InputStream
  ↓
Reader / Scanner
  ↓
My Program
```

## Output

```text
My Program
  ↓
PrintStream / Writer
  ↓
Destination
```

And underneath all of it is the OOP concept I already know:

```text
Class
  ↓
Field / Reference
  ↓
Object
  ↓
Method
```

So when I see:

```java
System.out.println("Hello");
```

I should no longer think:

> "This is just the syntax Java uses to print."

I should think:

```text
System
  ↓
static field: out
  ↓
reference to PrintStream object
  ↓
println()
```

When I see:

```java
System.in.read();
```

I should think:

```text
System
  ↓
static field: in
  ↓
reference to InputStream object
  ↓
read()
```

And when I see:

```java
BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(System.in)
        );
```

I should think:

```text
System.in
   ↓
InputStream
   ↓
InputStreamReader
   ↓
BufferedReader
   ↓
reader reference
   ↓
readLine()
```

This is the real purpose of this lesson:

> **I am not just learning how to take input or print output. I am learning how Java's I/O system is built, how objects are connected, and how the OOP concepts I already know are being used underneath everyday Java code.**
