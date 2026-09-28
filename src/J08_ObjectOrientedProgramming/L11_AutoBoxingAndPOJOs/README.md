# Lesson 11 — AutoBoxing, Abstract Classes & POJOs

## Why Am I Learning This?

I already know:

* Classes and Objects
* Constructors
* Encapsulation
* Inheritance
* Abstraction
* Abstract Classes
* Polymorphism
* Interfaces

Now I am moving towards:

* Collections
* Generics
* DSA
* Backend development

Before going further, I need to understand an important difference in Java:

```text
Primitive Values
       ↓
Objects
```

Java has both.

Sometimes I work directly with a primitive:

```java
int age = 20;
```

Sometimes Java needs an object:

```java
Integer age = 20;
```

So this lesson is mainly about understanding:

```text
Primitive
    ↓
Wrapper Class
    ↓
Boxing / Unboxing
    ↓
AutoBoxing / AutoUnboxing
    ↓
Collections + Generics
```

Then I will connect this with:

```text
Java Class
    ↓
Object
    ↓
POJO
    ↓
Data Representation
```

And finally:

```text
.java file
    ↓
Top-level classes
    ↓
Compiler
    ↓
.class files
    ↓
JVM
    ↓
Execution
```

My goal is not just to memorize these terms.

I want to understand **what Java is actually doing when the program runs**.

---

# What Am I Going To Learn?

1. Primitive Types vs Reference Types
2. Why Wrapper Classes Exist
3. Wrapper Classes
4. Boxing and Unboxing
5. AutoBoxing and AutoUnboxing
6. Where Java Automatically Boxes and Unboxes
7. AutoBoxing with Collections and Generics
8. `NullPointerException` During Unboxing
9. `==` vs `.equals()`
10. How `Integer` Works
11. Integer Caching
12. Abstract Class Revision and Interview Questions
13. POJO Classes
14. Why POJOs Are Useful in Frameworks
15. Why Only One Public Top-Level Class Is Allowed in a Java File
16. Final Mental Picture

---

# 1. Primitive Types vs Reference Types

Before Wrapper Classes, I need to be completely clear about this difference.

## Primitive Types

Examples:

```java
int age = 20;
double salary = 50000.0;
char grade = 'A';
boolean active = true;
```

Here `age` directly represents the primitive value:

```text
age
 ↓
20
```

There is no `Integer` object involved.

Common primitive types are:

```text
byte
short
int
long
float
double
char
boolean
```

## Reference Types

Now look at:

```java
Student student = new Student();
```

This is different.

`student` is a reference to an object.

For learning purposes, I can visualize it like this:

```text
Conceptual Memory Model

Stack                         Heap

student ───────────────────→ Student object
                             
                              fields
                              methods
                              object data
```

The important thing is not the physical location.

The important thing is:

```text
student
   ↓
reference
   ↓
Student object
```

So I should remember:

```text
Primitive
    ↓
variable directly represents a value

Reference Type
    ↓
variable holds a reference
    ↓
reference points to an object
```

This difference becomes extremely important when I start working with Wrapper Classes.

---

# 2. Why Wrapper Classes Exist

Now I have a problem.

Suppose I want to create a collection of integers:

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

Notice that I use:

```text
Integer
```

and not:

```text
int
```

I cannot write:

```java
ArrayList<int> numbers = new ArrayList<>();
```

because `int` is a primitive type.

Generics work with reference types.

So Java provides object versions of primitive types.

That is the purpose of Wrapper Classes.

The basic idea is:

```text
primitive
    ↓
Wrapper Class
    ↓
object representation
```

For example:

```text
int
 ↓
Integer
```

Now an integer value can participate in places where Java expects an object.

---

# 3. Wrapper Classes

Java provides Wrapper Classes for primitive types.

| Primitive | Wrapper     |
| --------- | ----------- |
| `byte`    | `Byte`      |
| `short`   | `Short`     |
| `int`     | `Integer`   |
| `long`    | `Long`      |
| `float`   | `Float`     |
| `double`  | `Double`    |
| `char`    | `Character` |
| `boolean` | `Boolean`   |

The most important one for me right now is:

```text
int
 ↓
Integer
```

Compare:

```java
int number = 10;
```

and:

```java
Integer number = 10;
```

They may look similar, but internally they represent different things.

```text
int
 ↓
primitive value

Integer
 ↓
reference
 ↓
Integer object
 ↓
represents an int value
```

### Conceptual Memory Model

For:

```java
int number = 10;
```

I can visualize:

```text
Stack

number = 10
```

For:

```java
Integer number = 10;
```

Java performs AutoBoxing, so conceptually:

```text
Stack                         Heap

number ───────────────────→ Integer object
                              value = 10
```

The exact physical organization is JVM-dependent, so I use this only as a **conceptual memory model**.

The important difference is:

```text
int
 ↓
variable represents the primitive value

Integer
 ↓
variable stores a reference
 ↓
reference points to an Integer object
```

This is the foundation for Boxing and Unboxing.

---

# 4. Boxing and Unboxing

Now I know:

```text
int     → primitive
Integer → object
```

So what happens when I convert:

```text
int → Integer
```

This is called **Boxing**.

## Boxing

Example:

```java
int number = 10;

Integer value = Integer.valueOf(number);
```

Conceptually:

```text
number
  ↓
int primitive value
  ↓
Integer.valueOf()
  ↓
Integer object
```

The primitive value is represented by a Wrapper object.

Conceptually, memory now looks like:

```text
Stack                         Heap

number = 10

value ─────────────────────→ Integer object
                              value = 10
```

So:

```text
Boxing

primitive
    ↓
Wrapper Object
```

## Unboxing

Now I go in the opposite direction.

```java
Integer value = Integer.valueOf(10);

int number = value.intValue();
```

The flow is:

```text
Integer reference
      ↓
Integer object
      ↓
intValue()
      ↓
int primitive
```

Conceptually:

```text
Stack                         Heap

value ─────────────────────→ Integer object
                              value = 10

number = 10
```

So:

```text
Unboxing

Wrapper Object
      ↓
primitive
```

The two conversions are:

```text
Boxing
int → Integer

Unboxing
Integer → int
```

---

# 5. AutoBoxing and AutoUnboxing

Java does not always require me to write:

```java
Integer.valueOf()
```

or:

```java
intValue()
```

Java can perform these conversions automatically.

This is where the word **Auto** comes from.

## AutoBoxing

```java
int number = 10;

Integer value = number;
```

I wrote:

```text
int → Integer
```

Java automatically performs the boxing.

Conceptually, this is similar to:

```java
Integer value = Integer.valueOf(number);
```

So:

```text
int
 ↓
Java automatically boxes it
 ↓
Integer object
 ↓
value stores a reference to that object
```

This is **AutoBoxing**.

### Memory Picture

```text
Stack                         Heap

number = 10

value ─────────────────────→ Integer object
                              value = 10
```

## AutoUnboxing

Now:

```java
Integer value = 10;

int number = value;
```

Java automatically converts the `Integer` object back to an `int`.

Conceptually:

```java
int number = value.intValue();
```

So:

```text
Integer reference
      ↓
Integer object
      ↓
Java automatically extracts the int value
      ↓
int primitive
      ↓
number
```

### Memory Picture

```text
Stack                         Heap

value ─────────────────────→ Integer object
                              value = 10

number = 10
```

The object does not become the primitive variable.

Instead, Java extracts the primitive value represented by the object.

### The Important Difference

The conversion itself is not different.

```text
Boxing
int → Integer
```

means I perform it explicitly.

```text
AutoBoxing
int → Integer
```

means Java performs it automatically.

Same conversion, different way of triggering it.

---

# 6. Where Java Automatically Boxes and Unboxes

Now I want to understand where I will actually see this in code.

Consider:

```java
Integer number = 10;
```

What did I write?

```text
10
 ↓
int value
 ↓
AutoBoxing
 ↓
Integer object
 ↓
number stores a reference
```

Conceptually:

```text
Stack                         Heap

number ───────────────────→ Integer object
                              value = 10
```

Now:

```java
int value = number;
```

The execution becomes conceptually:

```text
number
 ↓
reference
 ↓
Integer object
 ↓
extract primitive int value
 ↓
10
 ↓
value
```

This is AutoUnboxing.

I should train myself to mentally expand these conversions.

Instead of only seeing:

```java
Integer number = 10;
```

I should think:

```text
primitive value
      ↓
AutoBoxing
      ↓
Integer object
      ↓
reference stored in number
```

And instead of only seeing:

```java
int value = number;
```

I should think:

```text
Integer reference
      ↓
Integer object
      ↓
AutoUnboxing
      ↓
primitive int
      ↓
value
```

---

# 7. AutoBoxing with Collections and Generics

This is where this concept becomes very important for DSA.

Suppose I have:

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

The collection expects:

```text
Integer
```

Now I write:

```java
numbers.add(10);
```

But `10` is an `int` value.

So Java performs:

```text
10
 ↓
int
 ↓
AutoBoxing
 ↓
Integer object
 ↓
ArrayList
```

Conceptually:

```java
numbers.add(Integer.valueOf(10));
```

Now suppose I retrieve the value:

```java
int number = numbers.get(0);
```

`get(0)` gives me an `Integer` reference.

But my variable expects an `int`.

So Java performs AutoUnboxing:

```text
ArrayList
    ↓
Integer reference
    ↓
Integer object
    ↓
AutoUnboxing
    ↓
int value
    ↓
number
```

This is why AutoBoxing and AutoUnboxing matter for DSA.

I will constantly see:

```java
ArrayList<Integer>
```

instead of:

```java
ArrayList<int>
```

---

# 8. NullPointerException During Unboxing

This is one of the most important dangers.

Remember:

```text
int
 ↓
primitive
```

A primitive cannot be `null`.

But:

```text
Integer
 ↓
reference type
```

can be `null`.

For example:

```java
Integer number = null;
```

Now what does `number` contain?

```text
number
   ↓
null
```

There is no Integer object being referenced.

### Conceptual Memory Model

```text
Stack                         Heap

number ───────→ null

No Integer object is being referenced.
```

Now suppose I write:

```java
int value = number;
```

Java needs to perform AutoUnboxing:

```text
number
 ↓
null
 ↓
AutoUnboxing
 ↓
Java needs an Integer object/value
 ↓
but the reference points to nothing
 ↓
NullPointerException
```

So I should remember:

```java
Integer number = null;

int value = number;
```

is dangerous because Java cannot extract an `int` value from `null`.

The key idea is:

```text
Integer
 ↓
can hold null

int
 ↓
cannot hold null
```

---

# 9. `==` vs `.equals()`

Now I need to understand another important difference.

For primitive values:

```java
int a = 10;
int b = 10;

System.out.println(a == b);
```

`==` compares the primitive values.

```text
10 == 10
 ↓
true
```

But with objects:

```java
Integer a = 10;
Integer b = 10;
```

`a` and `b` are references.

So:

```java
a == b
```

checks whether the references refer to the same object.

Conceptually:

```text
Stack                         Heap

a ─────────────────────────→ Integer object

b ─────────────────────────→ Integer object
```

There may be two different objects, or the references may point to the same object.

`==` asks:

```text
"Are a and b pointing to the same object?"
```

`.equals()` is used for logical value comparison.

```java
a.equals(b)
```

asks:

```text
"Do these Integer objects represent the same value?"
```

So my mental rule is:

```text
Primitive
    ↓
== compares values

Object
    ↓
== compares references

Object
    ↓
.equals() compares logical value
```

For Wrapper objects, I should normally use:

```java
a.equals(b)
```

when I want to compare their values.

---

# 10. How `Integer` Works

`Integer` is not just a special syntax for `int`.

It is a real Java class.

Conceptually:

```text
Integer
   ↓
class
   ↓
Integer objects
   ↓
represent int values
```

For example:

```java
Integer number = 100;
```

The variable:

```text
number
```

is a reference.

The actual Integer object represents the value `100`.

Conceptually:

```text
Stack                         Heap

number ───────────────────→ Integer object
                              value = 100
```

This is different from:

```java
int number = 100;
```

where:

```text
Stack

number = 100
```

is a conceptual representation of the primitive variable.

So the mental difference is:

```text
int number = 100;

number
  ↓
primitive value
100
```

versus:

```text
Integer number = 100;

number
  ↓
reference
  ↓
Integer object
  ↓
represents 100
```

This distinction helps me understand why things like:

* `null`
* `==`
* `.equals()`
* object identity
* Integer caching

matter for Wrapper Classes.

---

# 11. Integer Caching

There is another detail I need to know about `Integer`.

Java can cache and reuse certain `Integer` objects.

The important idea is:

```text
Integer value
      ↓
some values can be cached
      ↓
cached objects can be reused
```

So two different `Integer` references can sometimes point to the same object.

For example:

```java
Integer a = 100;
Integer b = 100;
```

Conceptually, they may look like:

```text
Stack                         Heap

a ──────┐
        │
        ↓
    Integer object
     value = 100
        ↑
        │
b ──────┘
```

In such a situation:

```java
a == b
```

can be:

```text
true
```

because both references may point to the same cached object.

This is exactly why I should not use `==` to compare Integer values.

I should use:

```java
a.equals(b)
```

when I mean:

```text
"Do these two Integer objects represent the same value?"
```

### Important Mental Rule

I should not build my code around Integer caching.

Remember:

```text
==       → reference identity
.equals  → logical value
```

Caching can affect the result of `==`, but it does not change what `==` means.

---

# 12. Abstract Class Revision and Interview Questions

I already studied Abstract Classes, so I am using this lesson to connect the idea with what I already know.

Suppose:

```java
abstract class Animal {

    abstract void sound();
}
```

and:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks.");
    }
}
```

Then:

```java
Animal animal = new Dog();
```

I should read this from the memory/execution point of view.

```text
Reference Type
      ↓
Animal

Actual Object
      ↓
Dog
```

Conceptually:

```text
Stack                         Heap

animal ───────────────────→ Dog object
```

The reference type affects what members I can access through `animal`.

The actual object is still a `Dog`.

When I call:

```java
animal.sound();
```

the overridden `Dog` implementation runs.

This connects directly with the polymorphism I already learned.

### Interview Questions I Should Be Able To Answer

**What is an abstract class?**

A class that can contain abstract methods and cannot be directly instantiated.

**Can an abstract class have constructors?**

Yes.

**Can an abstract class have normal methods?**

Yes.

**Can I create an object directly from an abstract class?**

No.

**Can an abstract class have fields?**

Yes.

**Why use an abstract class?**

To provide common structure and behavior for related child classes while leaving some behavior for subclasses to implement.

---

# 13. POJO Classes

Now I am going to connect this with normal Java classes.

Suppose I write:

```java
class Student {

    String name;
    int age;
    double marks;
}
```

And create:

```java
Student student = new Student();
```

This is simply a normal Java object.

Now I will often hear the term:

```text
POJO
```

POJO means:

```text
Plain Old Java Object
```

A POJO is basically a simple Java class/object used to represent data without requiring some special framework structure.

There is no:

```java
pojo
```

keyword.

There is no special POJO syntax.

It is just a normal Java class.

For example:

```java
class Student {

    private String name;
    private int age;
    private double marks;

    Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getMarks() {
        return marks;
    }
}
```

Then:

```java
Student student = new Student("Vivek", 20, 85.5);
```

Memory-wise, using the same conceptual model:

```text
Stack                         Heap

student ───────────────────→ Student object
                              │
                              ├── name = "Vivek"
                              ├── age = 20
                              └── marks = 85.5
```

So:

```text
Student class
      ↓
defines the structure

Student object
      ↓
contains actual data

POJO
      ↓
simple Java object used to represent data
```

---

# 14. Why POJOs Are Useful in Frameworks

The important idea is that applications work with data.

For example, a backend application may need objects representing:

```text
User
Product
Order
Employee
Student
Payment
```

Instead of keeping all related values separately:

```text
name
age
email
```

I can group them into an object:

```text
User
 ├── name
 ├── age
 └── email
```

Then:

```java
User user = new User(...);
```

Now one object represents one piece of application data.

This becomes especially useful when working with frameworks and backend applications because data needs to move between different parts of the application.

For example:

```text
Database
   ↓
Java Object
   ↓
Application Logic
   ↓
API Response
```

POJO-style classes give me a simple structure for representing that data.

The important point is:

```text
POJO is not a framework feature.

POJO is a simple Java object
used to represent application data.
```

---

# 15. Why Only One Public Top-Level Class Is Allowed in a Java File

This is something I want to understand properly instead of memorizing the rule.

Suppose my file is:

```text
C03_PublicClassRule.java
```

Inside it I can have:

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }
}

public class C03_PublicClassRule {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result = calculator.add(10, 20);

        System.out.println(result);
    }
}
```

There are two top-level classes:

```text
Calculator
C03_PublicClassRule
```

But only one is public.

That is valid.

## What Happens During Compilation?

When I compile:

```text
C03_PublicClassRule.java
```

the Java compiler reads the source file.

Conceptually:

```text
C03_PublicClassRule.java
        │
        ├── class Calculator
        │
        └── public class C03_PublicClassRule
```

The compiler can produce separate bytecode files:

```text
Calculator.class
C03_PublicClassRule.class
```

So the `.java` file is not the same thing as the `.class` file.

This is important.

```text
SOURCE

C03_PublicClassRule.java
        │
        │ javac
        ↓
BYTECODE

Calculator.class
C03_PublicClassRule.class
```

## What Happens When I Run It?

When I run:

```text
java C03_PublicClassRule
```

Java uses:

```text
C03_PublicClassRule
```

as the class I want to launch.

The JVM loads the corresponding class and looks for:

```java
public static void main(String[] args)
```

Execution starts there.

Then:

```java
Calculator calculator = new Calculator();
```

creates a Calculator object.

Conceptually:

```text
Stack                         Heap

calculator ───────────────→ Calculator object
```

Then:

```java
calculator.add(10, 20);
```

calls the method on that object.

The method returns:

```text
30
```

and:

```java
System.out.println(result);
```

prints:

```text
30
```

So the complete execution flow is:

```text
C03_PublicClassRule.java
          ↓
        javac
          ↓
   .class bytecode files
          ↓
java C03_PublicClassRule
          ↓
          JVM
          ↓
C03_PublicClassRule.class
          ↓
        main()
          ↓
   new Calculator()
          ↓
  Calculator object
          ↓
     add(10, 20)
          ↓
          30
          ↓
        output
```

## Why Only One Public Top-Level Class?

A Java compilation unit can contain multiple top-level classes, but it can have at most one public top-level class.

So this is valid:

```java
class Calculator {
}

public class C03_PublicClassRule {
}
```

But this is invalid:

```java
public class Calculator {
}

public class C03_PublicClassRule {
}
```

There cannot be two public top-level classes in the same source file.

## Why Must the Public Class Name Match the File Name?

If I have:

```java
public class C03_PublicClassRule {
}
```

the source file must be:

```text
C03_PublicClassRule.java
```

Not:

```text
Calculator.java
```

So the relationship is:

```text
C03_PublicClassRule.java
        ↓
public class C03_PublicClassRule
```

If I write:

```text
Calculator.java
```

but inside:

```java
public class C03_PublicClassRule {
}
```

the compiler reports an error because the public class name and source filename do not match.

### The Most Important Clarification

I should **not** think:

```text
"The JVM allows only one class per file."
```

That is not what is happening.

Instead:

```text
.java source file
       ↓
compilation-unit rule
       ↓
at most one public top-level class
       ↓
public class name must match filename
       ↓
compiler creates .class files
       ↓
JVM executes bytecode
```

The JVM does not execute the `.java` file directly.

It executes compiled bytecode.

That is the actual reason I wanted to understand.

---

# 16. Final Mental Picture

Now I want to connect the entire lesson into one flow.

## Primitive vs Reference

```text
Primitive
    ↓
direct value

int number = 10;
```

versus:

```text
Reference
    ↓
reference
    ↓
object

Integer number = 10;
```

### Wrapper Memory Model

This is the conceptual model I want to remember:

```text
int number = 10;

Stack

number = 10
```

versus:

```text
Integer number = 10;

Stack                         Heap

number ───────────────────→ Integer object
                              value = 10
```

The important thing is:

```text
int
 ↓
primitive value

Integer
 ↓
reference
 ↓
Integer object
 ↓
represents an int value
```

The Stack/Heap diagram is only a **conceptual memory model**. The important concept is the difference between a primitive value and a reference to an object.

## Boxing

```text
int
 ↓
Boxing
 ↓
Integer object
```

## Unboxing

```text
Integer reference
 ↓
Integer object
 ↓
Unboxing
 ↓
int value
```

## Automatic Conversion

```text
int
 ↓
AutoBoxing
 ↓
Integer object
```

```text
Integer reference
 ↓
Integer object
 ↓
AutoUnboxing
 ↓
int
```

## Collections

```text
ArrayList<Integer>
        ↓
expects Integer
        ↓
int value
        ↓
AutoBoxing
        ↓
Integer object
        ↓
stored
```

Retrieving:

```text
Integer reference
   ↓
Integer object
   ↓
AutoUnboxing
   ↓
int value
```

## Null

```text
Integer
   ↓
reference type
   ↓
can be null
   ↓
no Integer object is referenced
   ↓
AutoUnboxing
   ↓
NullPointerException
```

## Equality

```text
Primitive
   ↓
== compares values
```

```text
Object
   ↓
== compares references
```

```text
Object
   ↓
.equals()
   ↓
compares logical value
```

## Integer Caching

```text
Integer
   ↓
some values can be cached
   ↓
objects can be reused
   ↓
references can point to same object
   ↓
== can sometimes be true
```

Therefore:

```java
a.equals(b);
```

is the safer mental rule for comparing Integer values.

## Abstract Class

```text
Abstract Class
      ↓
common structure / behavior
      ↓
Child Class
      ↓
Actual Object
```

And:

```text
Reference Type
      ↓
what I can access

Actual Object
      ↓
what object actually exists
```

## POJO

```text
Java Class
      ↓
defines structure
      ↓
Object
      ↓
contains actual data
      ↓
POJO
      ↓
represents application data
```

## Java Source File

```text
.java file
      ↓
top-level classes
      ↓
at most one public top-level class
      ↓
public class name = filename
      ↓
javac
      ↓
.class bytecode
      ↓
JVM
      ↓
main()
      ↓
program execution
```

---

# What I Should Be Able To Explain Now

After this lesson, I should be able to explain these without just memorizing definitions.

### Primitive vs Reference

```text
int
 ↓
primitive value

Integer
 ↓
reference
 ↓
Integer object
```

### Boxing

```text
int → Integer
```

### Unboxing

```text
Integer → int
```

### AutoBoxing

```text
int → Integer
```

Java performs it automatically.

### AutoUnboxing

```text
Integer → int
```

Java performs it automatically.

### Collections

```text
ArrayList<Integer>
```

uses Wrapper Classes because generics work with reference types.

### NullPointerException

```text
Integer
 ↓
null
 ↓
AutoUnboxing
 ↓
NullPointerException
```

### `==` vs `.equals()`

```text
==       → reference identity for objects
.equals  → logical value comparison
```

### POJO

```text
Plain Old Java Object
```

A simple Java class/object used mainly to represent and carry data.

### Public Class Rule

```text
One .java file
      ↓
at most one public top-level class
      ↓
public class name must match filename
```

And most importantly:

```text
.java
 ↓
compiler
 ↓
.class
 ↓
JVM
 ↓
execution
```

---

# My Final Mental Model

I want to remember this lesson as one connected story:

```text
Java has primitive values and objects
                ↓
Primitive
    ↓
direct value

Reference Type
    ↓
reference
    ↓
object
                ↓
Sometimes I need an object for a primitive
                ↓
Wrapper Classes
                ↓
int → Integer
                ↓
Boxing / AutoBoxing
                ↓
Integer → int
                ↓
Unboxing / AutoUnboxing
                ↓
Collections and Generics
                ↓
ArrayList<Integer>
                ↓
Integer can be null
                ↓
Unboxing null
                ↓
NullPointerException
                ↓
Integer is an object
                ↓
== checks reference identity
.equals() checks logical value
                ↓
Integer caching can reuse objects
                ↓
I already know Abstract Classes
                ↓
Reference Type → what I can access
Actual Object → what actually exists
                ↓
Simple data classes → POJOs
                ↓
Java source file
                ↓
at most one public top-level class
                ↓
public class name = filename
                ↓
javac
                ↓
.class bytecode
                ↓
JVM
                ↓
main()
                ↓
program execution
```

The main thing I want to carry forward is not just the definitions.

I want to understand:

```text
What variable do I have?
        ↓
Primitive or reference?
        ↓
If reference, what object does it refer to?
        ↓
What value does that object represent?
        ↓
Is Java performing Boxing or Unboxing?
        ↓
What happens if the reference is null?
        ↓
Am I comparing values or references?
        ↓
What happens during the next line of execution?
```

That memory/execution mindset will make Collections, Generics, DSA and backend Java much easier to understand later.
