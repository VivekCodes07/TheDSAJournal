# Inheritance in Java

> **My Goal:** Understand inheritance deeply enough that I can explain it myself, write it without memorizing syntax, and know when I should actually use it.

---

# 1. First Understand the Problem

Imagine I am building a college management system.

I have:

```text
Student
Employee
Teacher
Manager
```

Many of these classes may have common information.

For example:

```text
name
age
email
phone
```

If I put the same variables and methods inside every class:

```java
class Student {

    String name;
    int age;
    String email;

    void displayInfo() {
        // ...
    }
}
```

Then again:

```java
class Employee {

    String name;
    int age;
    String email;

    void displayInfo() {
        // ...
    }
}
```

I am repeating code.

This creates problems:

* Duplicate code
* More maintenance
* More chances of mistakes
* Difficult changes

So instead, I can create a common parent class.

```text
              Person
             /      \
            /        \
       Student      Employee
```

The common properties and methods go into `Person`.

Then `Student` and `Employee` can inherit them.

This is the basic idea behind **Inheritance**.

---

# 2. What Is Inheritance?

**Inheritance is an OOP mechanism that allows one class to acquire accessible properties and methods from another class.**

The class being inherited from is called the:

* Parent class
* Superclass
* Base class

The class that inherits is called the:

* Child class
* Subclass
* Derived class

In Java, inheritance between classes is created using:

```java
extends
```

Example:

```java
class Person {

    String name;
    int age;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {

    int rollNo;

    void study() {
        System.out.println(name + " is studying.");
    }
}
```

Now:

```java
Student student = new Student();

student.name = "Vivek";
student.age = 20;
student.rollNo = 101;

student.displayInfo();
student.study();
```

Output:

```text
Name: Vivek
Age: 20
Vivek is studying.
```

Notice something important:

`Student` never declared:

```java
name
age
displayInfo()
```

Yet it can use them because they came from `Person`.

---

# 3. The Mental Model

When I see:

```java
class Student extends Person
```

I should think:

```text
Student
   │
   ├── gets common things from Person
   │
   ├── can add its own things
   │
   └── can modify suitable inherited behavior
```

So inheritance is basically:

> **Reuse + Extend + Customize**

---

# 4. IS-A Relationship

Inheritance represents an **IS-A relationship**.

Ask:

> Is a Student a Person?

Yes.

Therefore:

```java
class Student extends Person
```

makes sense.

Similarly:

```text
Student    IS-A Person
Employee   IS-A Person
Manager    IS-A Employee
SavingsAccount IS-A BankAccount
```

This is one of the most important rules for deciding whether inheritance makes sense.

---

# 5. IS-A vs HAS-A

Do not confuse inheritance with composition.

### IS-A → Inheritance

```java
class Student extends Person {
}
```

A Student **is a Person**.

### HAS-A → Composition

```java
class Student {

    Address address;
}
```

A Student **has an Address**.

So:

```text
IS-A  → Inheritance
HAS-A → Composition
```

If I cannot naturally say:

> "X is a Y"

then I should question whether inheritance is appropriate.

---

# 6. Why Use Inheritance?

Inheritance mainly gives us:

### 1. Code Reusability

Common code is written once.

### 2. Less Duplication

Child classes don't need to rewrite common functionality.

### 3. Method Overriding

A child can provide its own version of inherited behavior.

### 4. Runtime Polymorphism

Inheritance enables parent references to work with child objects.

### 5. Better Organization

Related classes can be organized into a hierarchy.

---

# 7. The `extends` Keyword

Java uses:

```java
extends
```

to inherit from another class.

Example:

```java
class Employee {

    String name;
    double salary;

    void work() {
        System.out.println(name + " is working.");
    }
}

class Manager extends Employee {

    void manageTeam() {
        System.out.println(name + " is managing the team.");
    }
}
```

Now:

```java
Manager manager = new Manager();

manager.name = "Rahul";
manager.salary = 80000;

manager.work();
manager.manageTeam();
```

Output:

```text
Rahul is working.
Rahul is managing the team.
```

`Manager` inherited:

```text
name
salary
work()
```

and added:

```text
manageTeam()
```

---

# 8. Types of Inheritance in Java

There are five commonly discussed types:

1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance
4. Multiple Inheritance
5. Hybrid Inheritance

However, Java has an important restriction:

> **Java does not support multiple inheritance through classes.**

Multiple inheritance can be achieved using interfaces.

---

# 9. Single Inheritance

Single inheritance means:

```text
One Parent
    ↓
One Child
```

Example:

```text
Person
   ↓
Student
```

Code:

```java
class Person {

    String name;

    void introduce() {
        System.out.println("My name is " + name);
    }
}

class Student extends Person {

    int rollNo;

    void study() {
        System.out.println(name + " is studying.");
    }
}
```

Usage:

```java
Student student = new Student();

student.name = "Vivek";
student.rollNo = 101;

student.introduce();
student.study();
```

Output:

```text
My name is Vivek
Vivek is studying.
```

This is **Single Inheritance**.

---

# 10. Multilevel Inheritance

Multilevel inheritance means inheritance happens in multiple levels.

Example:

```text
Person
   ↓
Employee
   ↓
Manager
```

Code:

```java
class Person {

    String name;

    void displayName() {
        System.out.println("Name: " + name);
    }
}

class Employee extends Person {

    double salary;

    void work() {
        System.out.println(name + " is working.");
    }
}

class Manager extends Employee {

    int teamSize;

    void manageTeam() {
        System.out.println(
            name + " manages " + teamSize + " employees."
        );
    }
}
```

Now:

```java
Manager manager = new Manager();

manager.name = "Rahul";
manager.salary = 90000;
manager.teamSize = 10;

manager.displayName();
manager.work();
manager.manageTeam();
```

Output:

```text
Name: Rahul
Rahul is working.
Rahul manages 10 employees.
```

The inheritance chain is:

```text
Person
   ↓
Employee
   ↓
Manager
```

`Manager` ultimately gets accessible members from both `Employee` and `Person`.

This is **Multilevel Inheritance**.

---

# 11. Hierarchical Inheritance

Hierarchical inheritance means:

```text
       One Parent
       /        \
      ↓          ↓
   Child 1     Child 2
```

Real-world example:

```text
             Employee
             /      \
            /        \
     Developer      Designer
```

Code:

```java
class Employee {

    String name;
    double salary;

    void work() {
        System.out.println(name + " is working.");
    }
}

class Developer extends Employee {

    void writeCode() {
        System.out.println(name + " is writing code.");
    }
}

class Designer extends Employee {

    void designUI() {
        System.out.println(name + " is designing UI.");
    }
}
```

Now:

```java
Developer developer = new Developer();

developer.name = "Aman";
developer.work();
developer.writeCode();
```

And:

```java
Designer designer = new Designer();

designer.name = "Priya";
designer.work();
designer.designUI();
```

Both inherit from:

```text
Employee
```

but have different specialized behavior.

This is **Hierarchical Inheritance**.

---

# 12. Multiple Inheritance

Multiple inheritance means one child has multiple parent classes.

Conceptually:

```text
      Employee       Person
          \          /
           \        /
            Manager
```

In Java, this is **not allowed with classes**.

❌ Invalid:

```java
class Person {
}

class Employee {
}

class Manager extends Person, Employee {
}
```

Java does not allow a class to extend multiple classes.

---

# 13. Why Doesn't Java Support Multiple Class Inheritance?

One major reason is the **Diamond Problem**.

Imagine:

```text
          Person
         /      \
        /        \
   Student      Employee
        \        /
         \      /
          Manager
```

Suppose both `Student` and `Employee` have:

```java
void displayInfo()
```

Now `Manager` inherits from both.

If I write:

```java
manager.displayInfo();
```

Which method should Java use?

```text
Student's displayInfo()
          OR
Employee's displayInfo()
```

There is ambiguity.

Java avoids this problem by not allowing multiple inheritance through classes.

---

# 14. Multiple Inheritance Using Interfaces

Java allows a class to implement multiple interfaces.

Example:

```java
interface Payable {

    void processSalary();
}

interface Reportable {

    void generateReport();
}

class Manager implements Payable, Reportable {

    public void processSalary() {
        System.out.println("Processing salary.");
    }

    public void generateReport() {
        System.out.println("Generating manager report.");
    }
}
```

Now:

```java
Manager manager = new Manager();

manager.processSalary();
manager.generateReport();
```

Output:

```text
Processing salary.
Generating manager report.
```

So remember:

```text
Multiple inheritance through classes
→ ❌ Not supported

Multiple inheritance through interfaces
→ ✅ Supported
```

---

# 15. Hybrid Inheritance

Hybrid inheritance is a combination of two or more inheritance types.

For example:

```text
             Person
             /    \
            /      \
       Employee    Student
          |
       Manager
```

Here we have:

```text
Hierarchical
+
Multilevel
```

Java does not support arbitrary hybrid inheritance through classes if it requires multiple class inheritance.

Interfaces can be used to build more complex inheritance structures.

---

# 16. All Types at a Glance

```text
1. SINGLE

    Person
       |
    Student


2. MULTILEVEL

    Person
       |
    Employee
       |
    Manager


3. HIERARCHICAL

        Employee
        /      \
   Developer  Designer


4. MULTIPLE

   Person     Employee
      \         /
       \       /
        Manager

   ❌ Through classes
   ✅ Through interfaces


5. HYBRID

          Person
          /    \
     Employee  Student
        |
     Manager

   Combination of inheritance types
```

---

# 17. What Gets Inherited?

Suppose:

```java
class BankAccount {

    protected double balance;

    public void deposit(double amount) {
        balance += amount;
    }
}

class SavingsAccount extends BankAccount {

    public void addInterest() {
        balance += balance * 0.04;
    }
}
```

`SavingsAccount` can use:

```text
balance
deposit()
addInterest()
```

But there are important access rules.

---

# 18. Access Modifiers and Inheritance

| Modifier    | Accessible in Child? |
| ----------- | -------------------- |
| `public`    | ✅ Yes                |
| `protected` | ✅ Yes                |
| default     | ✅ Same package       |
| `private`   | ❌ Directly no        |

Example:

```java
class BankAccount {

    private double balance = 5000;
}
```

The child cannot directly do:

```java
class SavingsAccount extends BankAccount {

    void showBalance() {
        System.out.println(balance); // ❌
    }
}
```

A common solution is to provide a method:

```java
class BankAccount {

    private double balance = 5000;

    public double getBalance() {
        return balance;
    }
}
```

Then:

```java
class SavingsAccount extends BankAccount {

    void showBalance() {
        System.out.println(getBalance());
    }
}
```

This is also a good example of how **encapsulation and inheritance work together**.

---

# 19. Constructors Are NOT Inherited

This is very important.

Consider:

```java
class Employee {

    Employee() {
        System.out.println("Employee constructor");
    }
}

class Manager extends Employee {

    Manager() {
        System.out.println("Manager constructor");
    }
}
```

Now:

```java
Manager manager = new Manager();
```

Output:

```text
Employee constructor
Manager constructor
```

The `Manager` constructor did not inherit the `Employee` constructor.

Instead, Java calls the parent constructor first.

---

# 20. Constructor Chaining

Think of object creation like this:

```text
new Manager()
     ↓
Employee constructor
     ↓
Manager constructor
```

For multiple levels:

```text
Person
   ↓
Employee
   ↓
Manager
```

Creating:

```java
new Manager();
```

results in:

```text
Person constructor
        ↓
Employee constructor
        ↓
Manager constructor
```

Parent → Child.

---

# 21. The `super()` Keyword

`super()` is used to call the parent constructor.

Example:

```java
class Employee {

    Employee(String name) {
        System.out.println("Employee: " + name);
    }
}

class Manager extends Employee {

    Manager(String name) {

        super(name);

        System.out.println("Manager created");
    }
}
```

Now:

```java
Manager manager = new Manager("Rahul");
```

Output:

```text
Employee: Rahul
Manager created
```

---

# 22. `super` Has Three Important Uses

### 1. Parent Constructor

```java
super();
```

### 2. Parent Variable

```java
super.salary;
```

### 3. Parent Method

```java
super.displayInfo();
```

---

# 23. `super` With Variables

```java
class Employee {

    double salary = 50000;
}

class Manager extends Employee {

    double salary = 90000;

    void displaySalary() {

        System.out.println(salary);
        System.out.println(super.salary);
    }
}
```

Output:

```text
90000
50000
```

Here:

```java
salary
```

means the child's variable.

While:

```java
super.salary
```

means the parent's variable.

---

# 24. `super` With Methods

Suppose:

```java
class Employee {

    void work() {
        System.out.println("Employee is working.");
    }
}

class Manager extends Employee {

    @Override
    void work() {
        System.out.println("Manager is managing.");
    }

    void showEmployeeWork() {
        super.work();
    }
}
```

Now:

```java
Manager manager = new Manager();

manager.work();
manager.showEmployeeWork();
```

Output:

```text
Manager is managing.
Employee is working.
```

`super.work()` specifically calls the parent version.

---

# 25. Method Overriding

Inheritance allows a child class to **change inherited behavior**.

Example:

```java
class Employee {

    void calculateBonus() {
        System.out.println("Standard employee bonus");
    }
}

class Manager extends Employee {

    @Override
    void calculateBonus() {
        System.out.println("Manager bonus: 15%");
    }
}
```

The method:

```java
calculateBonus()
```

already exists in the parent.

The child provides its own implementation.

This is called:

# Method Overriding

---

# 26. Why Do We Override Methods?

Because a child may need **specialized behavior**.

For example:

```text
Employee
   ↓
calculateBonus()
```

But different employees may have different bonus rules:

```text
Employee → Standard bonus
Manager  → Higher bonus
Developer → Technical performance bonus
Salesman → Sales-based bonus
```

Instead of creating completely unrelated methods, I can override the common behavior.

---

# 27. The `@Override` Annotation

Whenever I override a method, I should normally write:

```java
@Override
```

Example:

```java
class Manager extends Employee {

    @Override
    void calculateBonus() {
        System.out.println("Manager bonus");
    }
}
```

It tells Java:

> "I intend to override a method from the parent class."

It also helps the compiler catch mistakes.

---

# 28. Overloading vs Overriding

Do not mix these up.

## Method Overloading

Same method name, different parameters.

```java
void deposit(double amount)

void deposit(double amount, String note)
```

Usually happens within the same class.

```text
Overloading
    ↓
Compile-time polymorphism
```

---

## Method Overriding

Parent and child have the same method signature.

```java
class Employee {

    void work() {
    }
}

class Manager extends Employee {

    @Override
    void work() {
    }
}
```

```text
Overriding
    ↓
Runtime polymorphism
```

---

# 29. Inheritance + Runtime Polymorphism

This is where inheritance becomes really powerful.

Consider:

```java
class Employee {

    void work() {
        System.out.println("Employee is working.");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Developer is writing code.");
    }
}

class Designer extends Employee {

    @Override
    void work() {
        System.out.println("Designer is designing.");
    }
}
```

Now:

```java
Employee employee;

employee = new Developer();
employee.work();

employee = new Designer();
employee.work();
```

Output:

```text
Developer is writing code.
Designer is designing.
```

The reference type is:

```java
Employee
```

But the actual objects are:

```text
Developer
Designer
```

The correct overridden method is selected at runtime.

This is:

# Runtime Polymorphism

---

# 30. The Most Important Mental Model

When I see:

```java
Employee employee = new Developer();
```

I should separate two things:

```text
Employee
   ↓
Reference Type

Developer
   ↓
Actual Object
```

The **reference type** controls what I can access.

The **actual object** determines which overridden implementation runs.

This is one of the most important ideas in Java OOP.

---

# 31. Upcasting

Upcasting means treating a child object as a parent type.

```java
Developer developer = new Developer();

Employee employee = developer;
```

Or:

```java
Employee employee = new Developer();
```

This is safe because:

```text
Developer IS-A Employee
```

---

# 32. What Happens During Upcasting?

Suppose:

```java
class Employee {

    void work() {
    }
}

class Developer extends Employee {

    void writeCode() {
    }
}
```

Now:

```java
Employee employee = new Developer();
```

I can call:

```java
employee.work();
```

But I cannot directly call:

```java
employee.writeCode();
```

because the reference type is `Employee`.

---

# 33. Downcasting

Downcasting means converting a parent reference back into a child reference.

```java
Employee employee = new Developer();

Developer developer = (Developer) employee;

developer.writeCode();
```

This is explicit:

```java
(Developer)
```

---

# 34. Be Careful With Downcasting

This is dangerous:

```java
Employee employee = new Designer();

Developer developer = (Developer) employee;
```

The actual object is:

```text
Designer
```

not:

```text
Developer
```

So Java throws:

```text
ClassCastException
```

---

# 35. `instanceof`

I can check the object's type before downcasting.

```java
Employee employee = new Developer();

if (employee instanceof Developer) {

    Developer developer = (Developer) employee;

    developer.writeCode();
}
```

This prevents invalid casts.

---

# 36. `final` and Inheritance

A `final` class cannot be inherited.

```java
final class BankAccount {
}
```

This is invalid:

```java
class SavingsAccount extends BankAccount {
}
```

So:

```text
final class
     ↓
Cannot be extended
```

---

# 37. `final` Methods

A `final` method cannot be overridden.

```java
class BankAccount {

    final void displayBankName() {
        System.out.println("ABC Bank");
    }
}
```

This is invalid:

```java
class SavingsAccount extends BankAccount {

    @Override
    void displayBankName() {
        System.out.println("XYZ Bank");
    }
}
```

---

# 38. Static Methods and Inheritance

Static methods are associated with the class rather than a particular object.

For example:

```java
class Employee {

    static void companyPolicy() {
        System.out.println("Employee policy");
    }
}

class Manager extends Employee {

    static void companyPolicy() {
        System.out.println("Manager policy");
    }
}
```

This is called **method hiding**, not normal method overriding.

Remember:

```text
Instance method → Overriding
Static method   → Hiding
```

---

# 39. Private Methods

Private methods are not accessible to child classes.

Therefore they cannot be overridden in the normal sense.

```java
class Employee {

    private void calculateSalary() {
        System.out.println("Salary");
    }
}
```

A child cannot override that method because it cannot access it.

---

# 40. Every Class Ultimately Inherits From `Object`

Java has a root class:

```java
Object
```

Every class ultimately derives from it.

For example:

```text
Object
   ↓
Person
   ↓
Employee
   ↓
Manager
```

This is why every Java object has methods such as:

```java
toString()
equals()
hashCode()
getClass()
```

among others.

---

# 41. Inheritance With Abstract Classes

Inheritance is frequently used with abstract classes.

Example:

```java
abstract class BankAccount {

    protected double balance;

    void deposit(double amount) {
        balance += amount;
    }

    abstract void calculateInterest();
}
```

Now:

```java
class SavingsAccount extends BankAccount {

    @Override
    void calculateInterest() {

        balance += balance * 0.04;

        System.out.println(
            "Savings interest calculated."
        );
    }
}
```

The parent provides common functionality:

```text
deposit()
balance
```

while the child provides specialized behavior:

```text
calculateInterest()
```

---

# 42. A Real-World Example: Banking System

Let's combine everything.

```java
class BankAccount {

    protected String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}
```

Now:

```java
class SavingsAccount extends BankAccount {

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    void addInterest() {

        double interest = balance * 0.04;
        balance += interest;

        System.out.println(
            "Interest added: " + interest
        );
    }
}
```

And:

```java
class CurrentAccount extends BankAccount {

    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    void checkBusinessTransactionLimit() {
        System.out.println(
            "Checking business transaction limit."
        );
    }
}
```

Now:

```java
SavingsAccount savings =
        new SavingsAccount("SA101", 50000);

savings.deposit(5000);
savings.addInterest();
savings.displayBalance();
```

The relationship:

```text
             BankAccount
              /       \
             /         \
SavingsAccount      CurrentAccount
```

This is **Hierarchical Inheritance**.

---

# 43. When Should I Use Inheritance?

Before writing:

```java
class B extends A
```

I should ask:

### Question 1

**Is B actually an A?**

```text
Manager IS-A Employee
```

Yes.

### Question 2

**Does B genuinely share common behavior with A?**

If yes, inheritance might be appropriate.

### Question 3

**Am I using inheritance only because I want to reuse some code?**

If yes, I should consider composition.

---

# 44. Inheritance Is Not Just Code Reuse

This is important.

A beginner often thinks:

> "Inheritance means copying/reusing code."

That's incomplete.

Inheritance gives us a **relationship between types**.

For example:

```text
Person
  ↓
Employee
  ↓
Manager
```

This allows us to say:

```text
Manager IS-A Employee
Employee IS-A Person
Manager IS-A Person
```

And this relationship enables:

* Polymorphism
* Method overriding
* Upcasting
* Flexible program design

So inheritance is more than simply avoiding duplicate code.

---

# 45. Advantages of Inheritance

### Code Reusability

Common functionality can be defined once.

### Less Duplication

Child classes don't need to rewrite common code.

### Method Overriding

Child classes can customize inherited behavior.

### Runtime Polymorphism

Parent references can represent different child objects.

### Better Structure

Related classes can be organized into logical hierarchies.

---

# 46. Disadvantages of Inheritance

Inheritance is powerful, but I shouldn't use it everywhere.

### Tight Coupling

Child classes depend on their parent.

### Parent Changes Can Affect Children

Changing the parent can affect multiple subclasses.

### Deep Hierarchies Become Difficult

For example:

```text
Person
  ↓
Employee
  ↓
Manager
  ↓
SeniorManager
  ↓
RegionalManager
```

Very deep inheritance trees can become difficult to understand.

### Wrong Relationship

If there isn't a genuine IS-A relationship, inheritance can make the design worse.

---

# 47. The Complete Mental Map

I should be able to see inheritance like this:

```text
                    INHERITANCE
                         │
                         ↓
                  Parent + Child
                         │
                         ↓
                      extends
                         │
                         ↓
                  Code Reusability
                         │
                         ↓
                  Method Overriding
                         │
                         ↓
                Runtime Polymorphism
                    /           \
                   /             \
             Upcasting       Downcasting
                                  │
                                  ↓
                              instanceof
```

And separately:

```text
super
 ├── super()
 ├── super.variable
 └── super.method()

final
 ├── final class  → cannot extend
 └── final method  → cannot override

Constructors
 ├── Not inherited
 ├── Parent executes first
 └── Constructor chaining
```

---

# 48. Final Revision

## What is inheritance?

A mechanism where a child class acquires accessible properties and methods from a parent class.

## Keyword?

```java
extends
```

## Relationship?

```text
IS-A
```

## Types?

```text
Single
Multilevel
Hierarchical
Multiple
Hybrid
```

## Does Java support multiple inheritance?

```text
Through classes → ❌
Through interfaces → ✅
```

## Are constructors inherited?

```text
❌ No
```

## Which constructor runs first?

```text
Parent → Child
```

## What is `super()`?

Calls the parent constructor.

## What is `super.variable`?

Accesses the parent variable.

## What is `super.method()`?

Calls the parent method.

## What is overriding?

Child provides its own implementation of an inherited method.

## What is upcasting?

```text
Child → Parent
```

## What is downcasting?

```text
Parent → Child
```

## What can go wrong with downcasting?

```text
ClassCastException
```

## What is `instanceof`?

Checks whether an object is an instance of a particular type.

## Can a final class be inherited?

```text
❌ No
```

## Can a final method be overridden?

```text
❌ No
```

## What is the difference between IS-A and HAS-A?

```text
IS-A  → Inheritance
HAS-A → Composition
```

---

# 49. Questions I Should Be Able to Answer Without Looking

* [ ] What problem does inheritance solve?
* [ ] What exactly happens when I use `extends`?
* [ ] What is a parent class?
* [ ] What is a child class?
* [ ] What is an IS-A relationship?
* [ ] Why is `Student extends Person` logical?
* [ ] What are the five types of inheritance?
* [ ] Which inheritance types does Java support through classes?
* [ ] Why doesn't Java support multiple class inheritance?
* [ ] What is the Diamond Problem?
* [ ] How do interfaces allow multiple inheritance?
* [ ] Are constructors inherited?
* [ ] Why does the parent constructor execute first?
* [ ] What is constructor chaining?
* [ ] What does `super()` do?
* [ ] What does `super.variable` do?
* [ ] What does `super.method()` do?
* [ ] What is method overriding?
* [ ] Why should I use `@Override`?
* [ ] What is the difference between overloading and overriding?
* [ ] How does inheritance enable runtime polymorphism?
* [ ] What is upcasting?
* [ ] What is downcasting?
* [ ] Why can downcasting cause `ClassCastException`?
* [ ] What does `instanceof` do?
* [ ] What happens to private members during inheritance?
* [ ] Can a final class be inherited?
* [ ] Can a final method be overridden?
* [ ] What happens with static methods?
* [ ] Why does every class ultimately inherit from `Object`?
* [ ] When should I use inheritance?
* [ ] When should I prefer composition?

---

# 🧠 The One Thing I Want to Remember

If I forget everything else, remember this:

```text
                INHERITANCE

                  Person
                 /      \
                ↓        ↓
            Student    Employee
                          ↓
                       Manager
```

Inheritance means:

> **A child class represents a specialized version of a parent class.**

The child:

```text
gets common behavior
       +
adds its own behavior
       +
can override behavior
```

And that relationship gives Java the foundation for:

```text
Inheritance
     ↓
Method Overriding
     ↓
Runtime Polymorphism
     ↓
Upcasting / Downcasting
     ↓
Flexible OOP Design
```

**If I truly understand this flow, I understand the core of Java inheritance.**
