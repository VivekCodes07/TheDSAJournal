# Lesson 2 — Classes and Objects

## What am I learning?

In this lesson, I will learn the two most fundamental building blocks of Java OOP:

* **Class**
* **Object**

I will also understand:

* Reference variables
* The `new` keyword
* Object state and behavior
* How objects are created in memory
* How Java executes an object-related statement

The core idea:

> **A class is a blueprint. An object is an actual instance created from that blueprint.**

---

# Why do I need Classes and Objects?

Imagine I am building an **Employee Management System**.

Every employee has some information:

```text
Employee
├── name
├── employeeId
├── department
└── salary
```

And an employee can perform actions:

```text
Employee
├── work()
├── takeLeave()
└── displayDetails()
```

Instead of managing these separately for every employee, I can create an `Employee` class that groups the related data and behavior together.

---

# 1. What is a Class?

A **class is a blueprint that defines the data and behavior an object can have.**

```java
class Employee {

    String name;
    int employeeId;
    String department;
    double salary;

    void work() {
        System.out.println(name + " is working");
    }
}
```

Here:

```text
State / Data
├── name
├── employeeId
├── department
└── salary

Behavior
└── work()
```

But this class is only a **blueprint**.

I haven't created an employee yet.

Think of it like a car design:

```text
Car Class
├── brand
├── model
├── color
└── speed
```

The design isn't an actual car.

---

# 2. What is an Object?

An **object is an actual instance of a class.**

I can create an Employee object using:

```java
Employee employee1 = new Employee();
```

Now I have an actual Employee object.

I can create another:

```java
Employee employee2 = new Employee();
```

So:

```text
Employee Class
      │
      ├── employee1
      ├── employee2
      └── employee3
```

All objects follow the same class structure, but each object can have different data.

For example:

```java
employee1.name = "Vivek";
employee2.name = "Rahul";
```

---

# 3. Class vs Object

| Class             | Object                |
| ----------------- | --------------------- |
| Blueprint         | Actual instance       |
| Defines structure | Contains actual state |
| Defines behavior  | Uses that behavior    |
| `Employee`        | `employee1`           |
| `Car`             | `car1`                |
| `Student`         | `student1`            |

A simple way to remember:

```text
Class  → What should it look like?
Object → What is the actual thing?
```

---

# 4. Understanding `Employee employee1 = new Employee();`

This single line contains three important things:

```java
Employee employee1 = new Employee();
```

### `Employee`

The type/class.

```text
Employee
   ↓
What type of object can employee1 refer to?
```

### `employee1`

A **reference variable**.

It is used to access the object.

### `new Employee()`

Creates a new Employee object.

So mentally:

```text
Employee employee1 = new Employee();

Employee
   ↓
Type

employee1
   ↓
Reference

new Employee()
   ↓
Create object
```

---

# 5. What is a Reference?

This is extremely important.

I should not think:

```text
employee1 = object
```

Instead:

```text
employee1 → object
```

The variable `employee1` contains a reference to the object.

Simplified:

```text
employee1 ─────────→ Employee Object
```

This distinction becomes very important later when learning inheritance and polymorphism.

---

# 6. Giving Data to an Object

Consider:

```java
class Student {

    String name;
    int rollNumber;
    String course;
}
```

Create an object:

```java
Student student1 = new Student();
```

Then give it data:

```java
student1.name = "Vivek";
student1.rollNumber = 101;
student1.course = "Computer Science";
```

Now the object represents:

```text
Student Object
├── name = "Vivek"
├── rollNumber = 101
└── course = "Computer Science"
```

This is the object's **state**.

---

# 7. Objects Can Have Behavior

Objects can also contain methods.

Example:

```java
class BankAccount {

    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void displayBalance() {
        System.out.println("Balance: ₹" + balance);
    }
}
```

Create an object:

```java
BankAccount account = new BankAccount();

account.accountHolder = "Vivek";
account.balance = 10000;
```

Then:

```java
account.deposit(5000);
```

The object's state changes:

```text
Before:
balance = ₹10,000

        ↓
deposit(₹5,000)

After:
balance = ₹15,000
```

So an object combines:

```text
State + Behavior
```

---

# 8. One Class Can Create Many Objects

A single class can create many independent objects.

```java
Car car1 = new Car();
Car car2 = new Car();

car1.brand = "BMW";
car2.brand = "Toyota";
```

Conceptually:

```text
             Car Class
                 │
        ┌────────┴────────┐
        ↓                 ↓
      car1              car2
      BMW              Toyota
```

Changing:

```java
car1.brand = "Audi";
```

doesn't change `car2.brand`.

Why?

Because they are two different objects.

---

# 9. Memory Perspective — Object Creation Flow

Consider:

```java
Employee employee = new Employee();
```

Let's understand what happens step by step.

### Step 1 — `main()` starts

The JVM begins executing:

```java
main()
```

A stack frame is created for `main()`.

```text
STACK
┌───────────────┐
│ main()        │
└───────────────┘
```

---

### Step 2 — JVM reaches `new Employee()`

```java
Employee employee = new Employee();
```

Java needs to create an Employee object.

Conceptually:

```text
new Employee()
      ↓
Create Employee object
```

---

### Step 3 — Object is allocated

In our simplified JVM memory model, the object is created in the **heap**.

```text
HEAP
┌────────────────────┐
│ Employee Object    │
│                    │
│ name = null        │
│ employeeId = 0     │
│ department = null  │
│ salary = 0.0       │
└────────────────────┘
```

The instance fields receive their default values.

---

### Step 4 — Reference is returned

Java now has a reference to that object.

That reference is assigned to:

```java
employee
```

So conceptually:

```text
STACK                         HEAP

employee ───────────────→ Employee Object
                            ┌──────────────┐
                            │ name = null  │
                            │ id = 0       │
                            │ salary = 0.0 │
                            └──────────────┘
```

This is the key distinction:

> **`employee` is the reference. The object exists separately.**

---

### Step 5 — I assign a value

Suppose I write:

```java
employee.name = "Vivek";
```

Java follows the reference:

```text
employee
   ↓
Employee Object
   ↓
name
   ↓
"Vivek"
```

Now:

```text
Employee Object
├── name = "Vivek"
├── employeeId = 0
├── department = null
└── salary = 0.0
```

---

### Step 6 — I call a method

Suppose:

```java
employee.work();
```

Java uses the reference to access the object and execute the method for that object.

A simplified execution flow:

```text
employee.work()
      ↓
Find Employee object
      ↓
Call work()
      ↓
Create stack frame for work()
      ↓
Execute method
      ↓
Method finishes
      ↓
work() stack frame is removed
```

The Employee object itself remains in the heap as long as it is still reachable.

---

# 10. Memory Perspective — Two Objects

Consider:

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();
```

Two separate objects are created.

```text
STACK

employee1 ───────────→ HEAP
                        Employee Object 1

employee2 ───────────→ HEAP
                        Employee Object 2
```

More visually:

```text
STACK                         HEAP

employee1 ───────────────→ ┌───────────────┐
                           │ Employee #1   │
                           │ name = Vivek  │
                           └───────────────┘

employee2 ───────────────→ ┌───────────────┐
                           │ Employee #2   │
                           │ name = Rahul  │
                           └───────────────┘
```

Each object has its own instance state.

---

# 11. Two References Can Point to One Object

Now consider:

```java
Employee employee1 = new Employee();

Employee employee2 = employee1;
```

This does **not** create a second object.

Instead:

```text
employee1 ─────┐
               ├────→ Employee Object
employee2 ─────┘
```

So if:

```java
employee2.name = "Rahul";
```

then:

```java
System.out.println(employee1.name);
```

also gives:

```text
Rahul
```

because both references point to the same object.

---

# 12. What is `null`?

A reference can point to no object:

```java
Employee employee = null;
```

Conceptually:

```text
employee ─────→ null
```

There is no Employee object being referenced.

Therefore:

```java
employee.work();
```

will result in a:

```text
NullPointerException
```

because Java cannot call a method through a reference that doesn't refer to an object.

---

# 13. Default Values of Object Fields

When an object is created, its instance fields receive default values.

For example:

```java
class Student {

    String name;
    int rollNumber;
    double marks;
    boolean passed;
}
```

A new object initially has:

```text
name       → null
rollNumber → 0
marks      → 0.0
passed     → false
```

Important:

> These default values apply to fields. Local variables must be initialized before use.

---

# 14. Complete Example

### `C01_ClassesAndObjects.java`

```java
class Employee {

    String name;
    int employeeId;
    String department;
    double salary;

    void work() {
        System.out.println(name + " is working");
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

public class C01_ClassesAndObjects {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.name = "Vivek";
        employee1.employeeId = 101;
        employee1.department = "Engineering";
        employee1.salary = 60000;

        employee2.name = "Rahul";
        employee2.employeeId = 102;
        employee2.department = "Marketing";
        employee2.salary = 50000;

        employee1.work();
        employee1.displayDetails();

        System.out.println();

        employee2.work();
        employee2.displayDetails();
    }
}
```

---

# 15. Common Mistakes

### Mistake 1 — Thinking declaration creates an object

```java
Employee employee;
```

This only declares a reference.

Object creation requires:

```java
new Employee();
```

---

### Mistake 2 — Thinking the reference is the object

```java
Employee employee = new Employee();
```

Think:

```text
employee → object
```

not:

```text
employee = object
```

---

### Mistake 3 — Thinking this creates two objects

```java
Employee e1 = new Employee();
Employee e2 = e1;
```

It creates **one object and two references**.

---

### Mistake 4 — Thinking one class can create only one object

```java
Employee e1 = new Employee();
Employee e2 = new Employee();
Employee e3 = new Employee();
```

This creates three independent objects.

---

# 16. Quick Revision

I should remember:

```text
Class
↓
Blueprint

Object
↓
Actual instance

Reference
↓
Used to access an object

new
↓
Creates a new object
```

And:

```java
Employee employee = new Employee();
```

means:

```text
1. Employee → type
2. employee → reference
3. new Employee() → create object
4. Reference → points to object
```

The most important memory idea:

```text
STACK                         HEAP

employee ───────────────→ Employee Object
```

And if:

```java
Employee e2 = employee;
```

then:

```text
employee ─────┐
              ├────→ SAME OBJECT
e2 ───────────┘
```

---

# 17. What's Next?

Right now, I create an Employee like this:

```java
Employee employee = new Employee();

employee.name = "Vivek";
employee.employeeId = 101;
employee.department = "Engineering";
employee.salary = 60000;
```

But this is inconvenient.

I want to initialize the object while creating it:

```java
Employee employee = new Employee(
    "Vivek",
    101,
    "Engineering",
    60000
);
```

How can I make Java initialize an object like this?

That is what I will learn in:

# Lesson 3 — Constructors

I will learn:

* What constructors are
* Why constructors exist
* Default constructors
* Parameterized constructors
* Constructor overloading
* How constructors participate in object creation
* Constructor execution from a memory perspective
