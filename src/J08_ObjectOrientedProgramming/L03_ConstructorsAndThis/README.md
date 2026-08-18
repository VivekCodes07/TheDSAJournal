# Lesson 3 — Constructors & `this` Keyword

## What Am I Learning?

In the previous lesson, I created objects like this:

```java
Employee employee = new Employee();

employee.name = "Vivek";
employee.employeeId = 101;
employee.department = "Engineering";
```

This works, but it is not very convenient.

I want to initialize an object **at the time it is created**.

That's where **constructors** come in.

I will also learn the **`this` keyword**, which helps an object refer to its own instance variables and methods.

---

# 1. Why Do I Need Constructors?

Imagine a company application where I need to create hundreds of employees.

Without constructors:

```java
Employee employee1 = new Employee();

employee1.name = "Vivek";
employee1.employeeId = 101;
employee1.department = "Engineering";
employee1.salary = 60000;
```

Then again:

```java
Employee employee2 = new Employee();

employee2.name = "Rahul";
employee2.employeeId = 102;
employee2.department = "Marketing";
employee2.salary = 50000;
```

This becomes repetitive.

With a constructor:

```java
Employee employee1 = new Employee(
    "Vivek",
    101,
    "Engineering",
    60000
);
```

The object can be initialized immediately when it is created.

### Main Idea

```text
Without constructor
        ↓
Create object
        ↓
Set fields manually
        ↓
Object initialized


With constructor
        ↓
Create object
        ↓
Pass required data
        ↓
Constructor initializes object
```

---

# 2. What Is a Constructor?

A **constructor** is a special block of code that runs when an object is created.

Example:

```java
class Employee {

    String name;
    int employeeId;

    Employee() {
        System.out.println("Employee object created");
    }
}
```

Now:

```java
Employee employee = new Employee();
```

The constructor runs automatically.

Output:

```text
Employee object created
```

## Important Properties of a Constructor

A constructor:

* Has the same name as the class
* Has no return type
* Runs automatically when an object is created
* Is mainly used to initialize an object

Example:

```java
class Employee {

    Employee() {
        System.out.println("Constructor executed");
    }
}
```

This is a constructor:

```java
Employee()
```

This is **not** a constructor:

```java
void Employee()
```

Because adding a return type makes it a **method**.

---

# 3. No-Argument Constructor

A constructor with no parameters is commonly called a **no-argument constructor**.

Example:

```java
class Employee {

    String name;
    int employeeId;

    Employee() {
        System.out.println("Employee created");
    }
}
```

Creating the object:

```java
Employee employee = new Employee();
```

causes:

```text
new Employee()
      ↓
Constructor runs
      ↓
Employee object initialized
```

---

# 4. Constructor With Parameters

Suppose I want to provide employee information while creating the object.

```java
class Employee {

    String name;
    int employeeId;
    String department;

    Employee(String name, int employeeId, String department) {

        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }
}
```

Now I can write:

```java
Employee employee = new Employee(
    "Vivek",
    101,
    "Engineering"
);
```

Instead of:

```java
Employee employee = new Employee();

employee.name = "Vivek";
employee.employeeId = 101;
employee.department = "Engineering";
```

The constructor initializes the object **during object creation**.

---

# 5. Why Do I Need `this`?

Look carefully at this constructor:

```java
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }
}
```

There are two variables named `name`:

```text
this.name
   ↓
Employee object's instance variable

name
   ↓
Constructor parameter
```

Therefore:

```java
this.name = name;
```

means:

```text
this.name
   =
name

object's name
   =
parameter name
```

This is one of the most important uses of `this`.

---

# 6. What Is `this`?

`this` refers to the **current object**.

For example:

```java
Employee employee1 = new Employee("Vivek");
```

While the constructor is executing for `employee1`:

```text
this
 ↓
employee1
```

If I create:

```java
Employee employee2 = new Employee("Rahul");
```

then while the constructor is executing for `employee2`:

```text
this
 ↓
employee2
```

So `this` changes depending on **which object is currently executing the code**.

### Mental Model

Think of `this` as:

> "The object whose code is currently running."

---

# 7. Memory Perspective — Constructor Flow

Consider:

```java
Employee employee = new Employee("Vivek", 101);
```

Let's follow the flow.

## Step 1 — `new` Is Encountered

```java
new Employee("Vivek", 101)
```

Java needs to create an `Employee` object.

---

## Step 2 — Memory Is Allocated

In our simplified memory model, an `Employee` object is created in the heap.

```text
HEAP

Employee Object
┌─────────────────────┐
│ name                │
│ employeeId          │
└─────────────────────┘
```

---

## Step 3 — Constructor Is Called

Java executes:

```java
Employee("Vivek", 101)
```

The constructor receives:

```text
name = "Vivek"
employeeId = 101
```

---

## Step 4 — `this` Refers to the New Object

Inside the constructor:

```java
this.name = name;
```

`this` refers to the object currently being initialized.

```text
this
 ↓
Employee Object
```

---

## Step 5 — Values Are Assigned

```java
this.name = "Vivek";
this.employeeId = 101;
```

The object now contains:

```text
Employee Object
├── name = Vivek
└── employeeId = 101
```

---

## Step 6 — Constructor Finishes

The constructor finishes execution.

The reference to the newly created object is assigned to:

```java
employee
```

Final simplified view:

```text
STACK                         HEAP

employee ───────────────→ Employee Object
                            ┌────────────────┐
                            │ name = Vivek   │
                            │ id = 101       │
                            └────────────────┘
```

## Overall Flow

```text
new Employee(...)
       ↓
Object created
       ↓
Constructor called
       ↓
Constructor parameters receive values
       ↓
this refers to current object
       ↓
Object fields are initialized
       ↓
Constructor finishes
       ↓
Reference is assigned
```

---

# 8. Constructor Overloading

Just like methods can be overloaded, **constructors can also be overloaded**.

Example:

```java
class Employee {

    String name;
    int employeeId;
    String department;

    Employee() {
        System.out.println("Default constructor");
    }

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int employeeId, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }
}
```

Now I can create objects in different ways:

```java
Employee e1 = new Employee();

Employee e2 = new Employee("Vivek");

Employee e3 = new Employee(
    "Rahul",
    102,
    "Marketing"
);
```

Java chooses the constructor based on the **number and types of arguments**.

### Mental Model

```text
new Employee()
        ↓
No-argument constructor

new Employee("Vivek")
        ↓
String constructor

new Employee("Rahul", 102, "Marketing")
        ↓
String, int, String constructor
```

---

# 9. `this` Can Call Another Constructor

I can use:

```java
this()
```

to call another constructor of the **same class**.

Example:

```java
class Employee {

    String name;
    int employeeId;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
}
```

Now:

```java
Employee employee = new Employee();
```

Flow:

```text
new Employee()
      ↓
Employee()
      ↓
this("Unknown", 0)
      ↓
Employee(String, int)
      ↓
Object initialized
```

## Important Rule

When using `this()` to call another constructor:

```java
this(...);
```

**must be the first statement inside the constructor.**

Correct:

```java
Employee() {

    this("Unknown", 0);

    System.out.println("Employee created");
}
```

Wrong:

```java
Employee() {

    System.out.println("Hello");

    this("Unknown", 0);
}
```

---

# 10. `this` Can Call Another Method

`this` can also explicitly refer to the current object's method.

Example:

```java
class Employee {

    String name;

    void displayName() {
        System.out.println(name);
    }

    void displayDetails() {
        this.displayName();
    }
}
```

Here:

```java
this.displayName();
```

means:

> Call `displayName()` for the current object.

Usually, I can simply write:

```java
displayName();
```

Both refer to the current object's method in this situation.

So these are effectively equivalent here:

```java
displayName();
```

and:

```java
this.displayName();
```

---

# 11. Real-World Example — Bank Account

Constructors become very useful in real applications.

Consider a banking application:

```java
class BankAccount {

    String accountHolder;
    long accountNumber;
    double balance;

    BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
```

Now:

```java
BankAccount account1 =
        new BankAccount("Vivek", 1001, 10000);

BankAccount account2 =
        new BankAccount("Rahul", 1002, 25000);
```

Each object is initialized immediately.

Conceptually:

```text
BankAccount Class
       │
       ├── account1
       │     ├── Vivek
       │     ├── 1001
       │     └── ₹10000
       │
       └── account2
             ├── Rahul
             ├── 1002
             └── ₹25000
```

The constructor ensures that every `BankAccount` object receives its initial information when it is created.

---

# 12. Constructor vs Method

| Constructor                 | Method                       |
| --------------------------- | ---------------------------- |
| Same name as class          | Can have any valid name      |
| No return type              | Has a return type or `void`  |
| Runs during object creation | Called explicitly            |
| Mainly initializes objects  | Performs behavior/operations |
| Called automatically        | Usually called manually      |

Example:

```java
class Student {

    Student() {
        // Constructor
    }

    void study() {
        // Method
    }
}
```

When:

```java
Student student = new Student();
```

the constructor runs automatically.

But:

```java
student.study();
```

requires an explicit method call.

---

# 13. Common Mistakes

## Mistake 1 — Giving a Constructor a Return Type

Wrong:

```java
void Employee() {
}
```

This is a **method**, not a constructor.

Correct:

```java
Employee() {
}
```

---

## Mistake 2 — Constructor Name Doesn't Match the Class

Wrong:

```java
class Employee {

    Student() {
    }
}
```

Correct:

```java
class Employee {

    Employee() {
    }
}
```

The constructor name must match the class name.

---

## Mistake 3 — Confusing `this.name` and `name`

```java
Employee(String name) {
    this.name = name;
}
```

Remember:

```text
this.name → object's instance variable
name      → constructor parameter
```

---

## Mistake 4 — Putting `this()` Somewhere Other Than First

Wrong:

```java
Employee() {

    System.out.println("Hello");

    this("Unknown");
}
```

Correct:

```java
Employee() {

    this("Unknown");

    System.out.println("Hello");
}
```

`this()` must be the first statement in the constructor.

---

# 14. Quick Revision

## Constructor

```text
Constructor
    ↓
Runs when an object is created
```

## Parameterized Constructor

```text
Parameterized Constructor
    ↓
Receives values during object creation
```

## `this`

```text
this
    ↓
Refers to the current object
```

Therefore:

```java
this.name = name;
```

means:

```text
current object's name
        =
constructor parameter name
```

And:

```java
this(...)
```

is used to call another constructor of the same class.

---

# 15. Final Mental Model

When I see:

```java
Employee employee = new Employee("Vivek", 101);
```

I should think:

```text
                new Employee(...)
                       ↓
                Object is created
                       ↓
                Constructor called
                       ↓
             Parameters receive values
                       ↓
                  this = object
                       ↓
              Object fields initialized
                       ↓
               Constructor finishes
                       ↓
              Reference is assigned
                       ↓
                    employee
                       ↓
                Employee Object
```

The most important idea of this lesson is:

> **A constructor initializes an object, and `this` allows the object to refer to itself while that initialization and other instance operations are happening.**

---

# 16. Key Takeaways

After completing this lesson, I should understand:

* What a constructor is
* Why constructors are useful
* How no-argument constructors work
* How parameterized constructors work
* Why constructors don't have return types
* What `this` means
* Why `this.name = name` is commonly used
* How `this` refers to the current object
* How constructors are overloaded
* How `this()` calls another constructor
* Why `this()` must be the first statement
* How `this` can call another instance method
* The difference between constructors and methods
* How constructors fit into the object creation process

---

# 17. What's Next?

Now I know how to **create and initialize objects**.

But I currently have another problem.

Consider:

```java
employee.name
employee.salary
employee.department
```

Anyone who has access to the object may be able to directly modify its data.

For example:

```java
employee.salary = -50000;
```

That should obviously not be allowed in a real application.

I need a way to **protect an object's data and control how that data is accessed**.

This leads to the next important OOP concept:

# Lesson 4 — Encapsulation
