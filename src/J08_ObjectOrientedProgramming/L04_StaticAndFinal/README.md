# Lesson 4 — Static & Final in Java

## What am I learning?

So far, I have learned that each object has its own data.

For example:

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();
```

Each object has its own:

```text
name
employeeId
salary
```

But sometimes I want something to belong to the **class itself**, not to every object.

That's where `static` comes in.

I will also learn `final`, which is used when I want something to **stay unchanged**.

---

# 1. `static` — Belongs to the Class

Normally, an instance variable belongs to an object:

```java
employee1.name
employee2.name
```

Each employee has their own name.

But suppose every employee belongs to the same company.

I don't want every object to have a separate copy of:

```java
String company = "Google";
```

Instead:

```java
static String company = "Google";
```

Now `company` belongs to the **Employee class**.

```text
                Employee Class
                      |
                      |
                company = "Google"
                  /           \
                 /             \
                ↓               ↓
          employee1         employee2
```

There is **one shared `company` variable**.

---

# 2. Static Variable

Example:

```java
class Employee {

    String name;

    static String company = "Google";
}
```

I can access the static variable using the class:

```java
System.out.println(Employee.company);
```

All employees share the same value.

```text
             Employee Class
                    |
                    ↓
             company = "Google"
```

Now suppose I create two objects:

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();
```

There is still only **one** `company` variable.

```text
                 Employee Class
                       |
                       ↓
               company = "Google"
                  ↑             ↑
                  |             |
             employee1      employee2
```

Both objects can access it:

```java
System.out.println(employee1.company);
System.out.println(employee2.company);
```

Both will print:

```text
Google
```

Why?

Because both objects are accessing the **same static variable**.

---

# 3. Can an Object Change a Static Variable?

Yes.

Java allows me to access and modify a static variable through an object.

For example:

```java
employee1.company = "Microsoft";
```

Now:

```java
System.out.println(employee1.company);
System.out.println(employee2.company);
System.out.println(Employee.company);
```

All three will print:

```text
Microsoft
```

Why?

Because all three are referring to the **same static variable**.

```text
employee1.company ──┐
                    |
                    ├──→ Employee.company
                    |
employee2.company ──┘
```

Changing it through one object changes the shared value for everyone.

So:

```text
employee1.company
       ↓
same variable
       ↑
employee2.company
       ↑
Employee.company
```

They are simply different ways of accessing the **same class-level variable**.

---

# 4. Which Way Should I Prefer?

Although Java allows:

```java
employee1.company = "Microsoft";
```

I should normally write:

```java
Employee.company = "Microsoft";
```

Why?

Because this makes the ownership clear.

When I write:

```java
Employee.company
```

I immediately understand:

```text
company
   ↓
belongs to Employee class
```

Whereas:

```java
employee1.company
```

can make it look like `company` belongs specifically to `employee1`.

So my preferred way is:

```java
Employee.company = "Microsoft";
```

And for reading:

```java
System.out.println(Employee.company);
```

This is clearer because `company` is a **class-level variable**.

---

# 5. Static vs Instance Variable

## Instance Variable

```java
String name;
```

Belongs to each object.

For example:

```text
employee1 → name = "Vivek"
employee2 → name = "Rahul"
```

Each object has its **own copy**.

---

## Static Variable

```java
static String company;
```

Belongs to the class.

```text
Employee class → company
```

There is **one shared copy** for the class.

So I remember:

```text
Instance variable
       ↓
Belongs to object
       ↓
Each object gets its own copy


static variable
       ↓
Belongs to class
       ↓
One shared copy
       ↓
Objects can access/change that same copy
```

---

# 6. The Most Important Mental Model for `static`

I should **not** think:

```text
employee1 has company

employee2 has company
```

Instead, I should think:

```text
Employee class has company
              ↑
              |
       Objects can access it
```

This distinction is extremely important.

The objects are **not owners** of the static variable.

They are simply able to access the variable because it belongs to their class.

Think of it like this:

```text
                  Employee Class
                        |
                        ↓
                 company = "Google"
                   ↑           ↑
                   |           |
              employee1    employee2
               access        access
```

One class-level variable.

Multiple objects can access it.

---

# 7. Static Method

A method can also be `static`.

```java
class Employee {

    static void companyPolicy() {

        System.out.println("Employees must follow company policies.");
    }
}
```

I can call it without creating an object:

```java
Employee.companyPolicy();
```

Why?

Because the method belongs to the **class**, not to an individual Employee object.

```text
Employee Class
      |
      ↓
static companyPolicy()
```

There is no need for:

```java
Employee employee = new Employee();
```

before calling it.

---

# 8. Important Rule of Static Methods

A static method cannot directly access instance variables.

For example:

```java
class Employee {

    String name;

    static void displayName() {

        System.out.println(name); // Error
    }
}
```

Why?

Because:

```text
name
 ↓
belongs to an object
```

while:

```text
displayName()
 ↓
belongs to the class
```

Java doesn't know **which Employee object's `name`** I want.

Imagine:

```text
Employee Class
      |
      ↓
static displayName()

       ???

employee1 → name = "Vivek"
employee2 → name = "Rahul"
```

Which `name` should the static method print?

Java cannot assume one.

That's why this doesn't work directly.

---

## But Static + Static works

```java
class Employee {

    static String company = "Google";

    static void displayCompany() {

        System.out.println(company);
    }
}
```

This works because both belong to the class:

```text
Employee Class
     |
     ├── company
     |
     └── displayCompany()
```

So I remember:

```text
static method
      ↓
can directly access
      ↓
static members

but not instance members
```

---

# 9. Static Block

A static block is used to execute code when the class is initialized.

```java
class Employee {

    static String company;

    static {

        company = "Google";

        System.out.println("Static block executed.");
    }
}
```

The static block is executed as part of **class initialization**.

A simplified flow is:

```text
Class initialization
        ↓
Static variables initialized
        ↓
Static block executes
        ↓
Program continues
```

A static block is useful when I need to perform some **one-time class-level initialization**.

For example:

```java
class Employee {

    static String company;

    static {

        company = "Google";

        System.out.println("Company initialized.");
    }
}
```

The important idea is:

```text
static block
      ↓
class-level initialization
      ↓
executed once during class initialization
```

---

# 10. `String[] args`

I have been writing this from the beginning:

```java
public static void main(String[] args)
```

Now I can finally understand what it means.

Let's break it down:

```text
public
   ↓
Access modifier

static
   ↓
main belongs to the class

void
   ↓
main returns nothing

main
   ↓
Starting point of the program

String[] args
   ↓
Array of command-line arguments
```

`args` is simply a `String` array.

For example:

```java
public static void main(String[] args) {

    System.out.println(args[0]);
}
```

If I run:

```text
java C04_StringArgs Vivek 101
```

then:

```text
args[0] → "Vivek"
args[1] → "101"
```

So:

```text
String[] args
      ↓
A String array
      ↓
Stores values passed from the command line
```

---

# 11. `final`

`final` means:

> **I don't want this variable to be reassigned.**

For example:

```java
final double PI = 3.14159;
```

I cannot later do:

```java
PI = 4.5; // Error
```

Once a `final` variable has been assigned a value, it cannot be reassigned.

Think:

```text
final
  ↓
"This variable cannot be assigned again."
```

---

# 12. Final Variable

Example:

```java
class Bank {

    final String IFSC_CODE = "BANK001";
}
```

The IFSC code should not be changed after initialization.

So:

```java
final String IFSC_CODE = "BANK001";
```

makes sense.

I cannot do:

```java
IFSC_CODE = "BANK002"; // Error
```

because the variable is `final`.

---

# 13. Static + Final Together

These two keywords are commonly used together for constants:

```java
static final double PI = 3.14159;
```

Think of them separately:

```text
static
  ↓
Shared by the class

final
  ↓
Cannot be reassigned
```

So:

```text
static final
      ↓
One shared value
      +
Cannot be reassigned
```

This makes `static final` perfect for constants.

Example:

```java
class Bank {

    static final String BANK_NAME = "ABC Bank";
}
```

I can access it directly through the class:

```java
System.out.println(Bank.BANK_NAME);
```

There is no need to create a `Bank` object.

---

# 14. Memory Perspective

For normal instance variables:

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();
```

Conceptually:

```text
STACK                         HEAP

employee1  ----------------> Employee Object 1
                              |
                              └── name = "Vivek"


employee2  ----------------> Employee Object 2
                              |
                              └── name = "Rahul"
```

Each object has its own instance data.

But for a static variable:

```text
                 Employee Class
                       |
                       ↓
                 company = "Google"
                       ↑
                       |
                  ┌────┴────┐
                  ↓         ↓
             employee1   employee2
```

There is only **one shared copy** of `company`.

The objects don't each contain their own `company` variable.

Instead:

```text
Employee Class
      |
      └── company
```

and both objects can access that same variable.

So:

```text
Instance variable
       ↓
Object-level data
       ↓
Each object has its own copy


static variable
       ↓
Class-level data
       ↓
One shared copy
       ↓
Objects can access the same copy
```

---

# 15. Final Mental Model

## `static`

```text
static
   ↓
"Belongs to the class"
```

### Static Variable

```text
static variable
      ↓
Class-level variable
      ↓
One shared copy
      ↓
Objects can access/change it
```

### Static Method

```text
static method
      ↓
Class-level method
      ↓
Can be called using the class
      ↓
Employee.companyPolicy();
```

### Static Block

```text
static block
      ↓
Class-level initialization
      ↓
Runs during class initialization
```

---

## `String[] args`

```text
String[] args
      ↓
String array
      ↓
Contains command-line arguments
```

---

## `final`

```text
final
   ↓
"Don't reassign this variable."
```

---

## `static final`

```text
static final
      ↓
Shared by the class
      +
Cannot be reassigned
      ↓
Constant
```

---

# The Flow I Should Remember

```text
                         Java Members
                              |
              ┌───────────────┴───────────────┐
              ↓                               ↓
           Object                           Class
              |                               |
              ↓                               ↓
      Instance variables              static variables
      Instance methods                static methods
              |                               |
              ↓                               ↓
      Object-level data              Class-level data
              |                               |
              ↓                               ↓
      Each object has its             One shared copy
      own copy                         for the class
```

And:

```text
final
   ↓
Prevents reassignment
```

Therefore:

```text
static final
      ↓
Shared + cannot be reassigned
      ↓
Constant
```

> **`static` answers:**
> "Who owns this — the object or the class?"

> **`final` answers:**
> "Can this be reassigned?"

That is the core idea I should carry forward.
