# Lesson 4 — Access Modifiers

## What Am I Learning?

In the previous lesson, I learned about **Encapsulation**.

Encapsulation taught me an important idea:

> An object should control its own internal data instead of allowing everyone to change it directly.

For example, a bank account should not allow outside code to directly change its balance.

```java
class BankAccount {

    private double balance;
}
```

But this creates another question:

> **Who should be allowed to access something inside a class?**

That's where **Access Modifiers** come in.

Access modifiers control the visibility of:

* Classes
* Variables
* Methods
* Constructors

Java provides four access levels:

```text
public
protected
default
private
```

Think of access modifiers as **security levels for your code**.

---

# 1. Real-World Mental Model

Imagine a company like a bank.

Inside the bank, there might be:

```text
Bank
│
├── Customer
├── BankAccount
├── Employee
├── Manager
└── Admin
```

Not everyone should have access to everything.

For example:

```text
Customer
   ↓
Can check account balance

Bank employee
   ↓
Can perform certain account operations

Manager
   ↓
Can access additional employee functionality

Internal system logic
   ↓
Should remain completely hidden
```

This is exactly the problem access modifiers help solve.

---

# 2. The Four Access Modifiers

The four access levels are:

| Modifier    | Same Class | Same Package | Subclass | Other Package |
| ----------- | ---------- | ------------ | -------- | ------------- |
| `public`    | Yes        | Yes          | Yes      | Yes           |
| `protected` | Yes        | Yes          | Yes      | Limited       |
| `default`   | Yes        | Yes          | No*      | No            |
| `private`   | Yes        | No           | No       | No            |

The easiest way to remember them:

```text
public
   ↓
Anywhere

protected
   ↓
Same package + subclasses

default
   ↓
Same package

private
   ↓
Same class
```

The access level becomes more restrictive as we move down.

```text
MOST ACCESSIBLE
       ↓
    public
       ↓
  protected
       ↓
    default
       ↓
    private
       ↓
LEAST ACCESSIBLE
```

---

# 3. `public` — Anyone Can Access It

`public` provides the widest access.

If something is public, code outside the class can use it.

Example:

```java
class BankAccount {

    public void deposit(double amount) {
        System.out.println("Depositing money...");
    }
}
```

Another class can use it:

```java
BankAccount account = new BankAccount();

account.deposit(5000);
```

## Real-World Example

Think about an ATM.

A customer doesn't need to know how the bank internally processes a deposit.

They simply need a way to perform the operation:

```text
Customer
   ↓
deposit()
   ↓
Bank Account
```

The `deposit()` method could be public because it is part of the functionality that outside code is allowed to use.

```java
public void deposit(double amount) {
    // Deposit logic
}
```

### Mental Model

```text
public
   ↓
"This is available to the outside world."
```

---

# 4. `private` — Internal Only

`private` is the most restrictive access modifier.

A private member can only be accessed inside the same class.

Example:

```java
class BankAccount {

    private double balance;
}
```

Outside code cannot do this:

```java
BankAccount account = new BankAccount();

account.balance = 50000; // Error
```

Why?

Because `balance` is private.

```text
private
   ↓
Only this class can access it
```

---

# 5. Why Would a Real Application Use `private`?

This is where access modifiers become really important.

Imagine an e-commerce application.

A `User` object might contain:

```java
class User {

    private String password;
    private double accountBalance;
}
```

Would we want this?

```java
user.password = "123456";
user.accountBalance = 999999;
```

Obviously not.

The user object should control how these values change.

Instead:

```java
class User {

    private double accountBalance;

    public void addMoney(double amount) {

        if (amount > 0) {
            accountBalance += amount;
        }
    }
}
```

Now outside code cannot directly manipulate the balance.

It has to go through the class:

```java
user.addMoney(5000);
```

This is **encapsulation + access modifiers working together**.

---

# 6. `private` Protects Internal State

Consider a bank account.

Bad design:

```java
class BankAccount {

    public double balance;
}
```

Now anyone can do:

```java
account.balance = -100000;
```

There is no protection.

Better design:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }
}
```

Now:

```text
Outside code
      |
      ↓
deposit()
      |
      ↓
Validation
      |
      ↓
balance
```

The outside world doesn't directly control the data.

The object controls its own state.

---

# 7. `public` + `private` Usually Work Together

A very common pattern in real applications is:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

Here:

```text
private balance
       ↓
Protected internal state

public deposit()
       ↓
Controlled way to modify state

public getBalance()
       ↓
Controlled way to read state
```

This is one of the most important patterns to understand.

---

# 8. Public Interface vs Internal Implementation

Think about using an ATM.

You press:

```text
Withdraw ₹5,000
```

You don't need to know:

```text
How the bank validates your account
How the transaction is recorded
How the balance is calculated
How fraud checks work
How the database is updated
```

You only interact with the public functionality.

The same idea applies to classes.

```text
                 BankAccount
        ┌─────────────────────────┐
        │                         │
        │  PUBLIC                 │
        │                         │
        │  deposit()              │
        │  withdraw()             │
        │  getBalance()           │
        │                         │
        ├─────────────────────────┤
        │                         │
        │  PRIVATE                │
        │                         │
        │  balance                │
        │  validateAmount()       │
        │  internal calculations  │
        │                         │
        └─────────────────────────┘
```

The public methods are the **interface**.

The private members are the **implementation details**.

---

# 9. Private Methods

Variables aren't the only things that can be private.

Methods can also be private.

Example:

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (isValidAmount(amount)) {
            balance += amount;
        }
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
```

Outside code can call:

```java
account.deposit(5000);
```

But it cannot call:

```java
account.isValidAmount(5000); // Error
```

Why?

Because `isValidAmount()` is only an internal helper method.

### Real-World Mental Model

Think of a restaurant.

A customer sees:

```text
Order Food
Pay Bill
Cancel Order
```

They don't see internal operations like:

```text
calculateKitchenQueue()
validateOrder()
updateInventory()
calculateTax()
```

Those are internal implementation details.

Similarly, a class can expose only the operations that outside code actually needs.

---

# 10. Default Access

There is another access level called **default access**.

Default means:

> I don't write any access modifier.

Example:

```java
class Employee {

    String name;

    void displayName() {
        System.out.println(name);
    }
}
```

There is no:

```java
public
protected
private
```

Therefore these members have default access.

Default members are accessible inside the **same package**.

---

# 11. Real-World Example of Default Access

Imagine a backend application organized into packages:

```text
com.company.payment
    |
    ├── Payment
    ├── PaymentService
    └── PaymentValidator
```

Maybe `PaymentValidator` is an internal helper used only by the payment package.

```java
class PaymentValidator {

    boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
```

Because it has default access, classes in the same package can use it.

But classes from another package don't get direct access.

```text
com.company.payment
        |
        +---- Payment
        +---- PaymentService
        +---- PaymentValidator

        ↓

default access works
```

```text
com.company.admin
        |
        +---- Admin

        ↓

default access does not work
```

So:

```text
default
   ↓
Package-level access
```

---

# 12. `protected` — Useful With Inheritance

`protected` is mainly useful when working with **inheritance**.

Example:

```java
class Employee {

    protected String name;
}
```

A subclass can access it:

```java
class Developer extends Employee {

    void displayName() {
        System.out.println(name);
    }
}
```

Why?

Because `Developer` inherits from `Employee`.

```text
Employee
    |
    ↓
Developer

protected
    ↓
Accessible to subclass
```

---

# 13. Real-World Example of `protected`

Imagine an application with different types of employees:

```text
Employee
   |
   +---- Developer
   |
   +---- Designer
   |
   +---- Manager
```

The base `Employee` class might contain information that subclasses need.

```java
class Employee {

    protected String name;
    protected double salary;
}
```

Then:

```java
class Developer extends Employee {

    void showEmployeeInfo() {
        System.out.println(name);
        System.out.println(salary);
    }
}
```

`Developer` can access the protected members because it is a subclass.

This becomes much clearer once I study **inheritance**.

---

# 14. Access Modifiers With Variables

A class can contain variables with different visibility levels.

```java
class Employee {

    public String name;

    protected double salary;

    int employeeId;          // default

    private String password;
}
```

Think of them as four different levels:

```text
name
 ↓
public
 ↓
Everyone

salary
 ↓
protected
 ↓
Same package + subclasses

employeeId
 ↓
default
 ↓
Same package

password
 ↓
private
 ↓
Same class
```

---

# 15. Access Modifiers With Methods

Methods can also use all four access levels.

```java
class BankAccount {

    public void deposit(double amount) {
        // Outside code can use this
    }

    protected void calculateInterest() {
        // Package/subclasses can use this
    }

    void generateStatement() {
        // Same package can use this
    }

    private void validateAmount(double amount) {
        // Only this class can use this
    }
}
```

This allows me to decide exactly which parts of a class should be exposed.

---

# 16. Access Modifiers With Constructors

Constructors can also have access modifiers.

For example:

```java
class BankAccount {

    private BankAccount() {
    }
}
```

Now:

```java
BankAccount account = new BankAccount();
```

will produce an error because the constructor is private.

Why would a real application do this?

Sometimes a class should **control how its objects are created**.

For example, certain design patterns or utility classes may prevent normal object creation.

I don't need to master the use cases yet. The important idea is:

```text
Constructor access modifier
        ↓
Controls who can create objects
```

---

# 17. Access Modifiers With Classes

Top-level classes can be:

```java
public class Employee {
}
```

or:

```java
class Employee {
}
```

The second one has default access.

A top-level class cannot be:

```java
private class Employee {
}
```

or:

```java
protected class Employee {
}
```

So for now, remember:

```text
Top-level class
      |
      +---- public
      |
      +---- default
```

---

# 18. Access Modifiers and Packages

Packages become important when understanding access control.

Imagine:

```text
com.amazon.users
    |
    +---- User
    +---- Customer
    +---- UserService
```

and:

```text
com.amazon.admin
    |
    +---- AdminService
```

If `User` has a default member:

```java
class User {

    String username;
}
```

Then:

```text
com.amazon.users
       |
       +---- User
       +---- Customer
       +---- UserService

       ↓

Can access username
```

But:

```text
com.amazon.admin
       |
       +---- AdminService

       ↓

Cannot directly access username
```

This is one reason packages and access modifiers work well together.

---

# 19. The Most Important Real-World Example

Let's combine everything into a simple banking example.

```java
class BankAccount {

    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
```

Now think about the design.

### Internal Data

```java
private String accountHolder;
private double balance;
```

The outside world cannot directly modify them.

### Public Operations

```java
public void deposit()
public void withdraw()
public double getBalance()
```

These are the operations that outside code is allowed to use.

### Internal Logic

```java
private boolean isValidAmount()
```

This is only an internal helper.

The result is:

```text
                  BankAccount
                       |
          ┌────────────┴────────────┐
          ↓                         ↓
      PUBLIC                     PRIVATE
          |                         |
    deposit()                  balance
    withdraw()                 accountHolder
    getBalance()               validation logic
          |                         |
          └────────────┬────────────┘
                       ↓
                 Encapsulation
```

This is the connection between the previous lesson and this lesson.

---

# 20. Access Modifiers Are About Visibility

When deciding which modifier to use, don't start by asking:

> "Which keyword should I memorize?"

Instead ask:

> **"Who actually needs access to this?"**

For example:

```text
Does everyone need access?
        |
        ↓
      public
```

```text
Does only this class need access?
        |
        ↓
      private
```

```text
Does the same package need access?
        |
        ↓
      default
```

```text
Does the same package or a subclass need access?
        |
        ↓
     protected
```

This is a much better way to think about access modifiers.

---

# 21. Which Modifier Should I Prefer?

For normal classes, a good starting mindset is:

> **Don't expose something unless it actually needs to be exposed.**

For example, instead of:

```java
class BankAccount {

    public double balance;
}
```

prefer:

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }
}
```

Now the class controls its own state.

This reduces the chance of other code accidentally breaking the object's data.

---

# 22. Access Modifiers vs Encapsulation

These concepts are connected, but they are **not the same thing**.

### Access Modifiers

These are Java language features:

```text
public
protected
default
private
```

They control **visibility**.

### Encapsulation

This is an OOP design principle.

It means:

```text
Protect internal state
        +
Control how it is accessed
        +
Expose meaningful behavior
```

So:

```text
Access Modifiers
       ↓
Java feature
       ↓
Controls visibility
```

while:

```text
Encapsulation
       ↓
OOP principle
       ↓
Controls how an object exposes its state/behavior
```

Access modifiers are one of the tools Java gives me to achieve encapsulation.

---

# 23. Final Mental Model

Whenever I see an access modifier, I should ask:

> **Who should be allowed to access this?**

Then:

```text
public
   ↓
Anywhere
```

```text
protected
   ↓
Same package + subclasses
```

```text
default
   ↓
Same package
```

```text
private
   ↓
Same class
```

The most important idea is:

```text
Access Modifiers
       ↓
Control Visibility
       ↓
Control What Other Code Can See
       ↓
Protect Internal Implementation
       ↓
Help Build Encapsulated Classes
```

---

# 24. Real-World Examples to Remember

Instead of memorizing random examples, connect each modifier to a real application.

### Banking Application

```text
private
   ↓
balance
accountPassword
internal validation
```

```text
public
   ↓
deposit()
withdraw()
getBalance()
```

### E-Commerce Application

```text
private
   ↓
cart items
internal price calculations
payment information
```

```text
public
   ↓
addToCart()
removeFromCart()
checkout()
```

### Netflix-Style Application

```text
private
   ↓
internal recommendation calculations
user preferences
internal playback state
```

```text
public
   ↓
play()
pause()
stop()
```

The outside world interacts with the **public behavior** without needing access to the internal implementation.

---

# 25. What I Learned

I should now understand:

```text
Access Modifiers
      |
      +---- public
      |       ↓
      |   Accessible everywhere
      |
      +---- protected
      |       ↓
      |   Same package + subclasses
      |
      +---- default
      |       ↓
      |   Same package
      |
      +---- private
              ↓
          Same class
```

And the bigger picture:

```text
Access Modifiers
       ↓
Control Visibility
       ↓
Protect Internal Data
       ↓
Expose Only What Is Necessary
       ↓
Help Achieve Encapsulation
```

---

# 26. Self-Test

Before moving to the next OOP concept, I should be able to answer these without looking at my notes:

1. What are the four access modifiers in Java?
2. What does `private` mean?
3. Why would a bank account make `balance` private?
4. Why would `deposit()` be public?
5. What happens when I don't write an access modifier?
6. What is the difference between `default` and `protected`?
7. Why is `protected` useful with inheritance?
8. Can a top-level class be `private`?
9. Why might a method be private?
10. What does a private constructor do?
11. How do access modifiers help encapsulation?
12. Why shouldn't every variable simply be public?
13. Explain the difference between a public interface and private implementation.
14. Explain all four modifiers using a real-world application.

---

# Final Memory Trick

If I forget everything else, remember this:

```text
public
   ↓
Anywhere

protected
   ↓
Same package + subclasses

default
   ↓
Same package

private
   ↓
Same class
```

And the main question:

> **"Who should be allowed to access this?"**

That's the real purpose of **Access Modifiers**.
