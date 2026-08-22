# Lesson 3 — Encapsulation

## What Am I Learning?

So far, I can create a class and initialize objects using constructors.

For example:

```java
class BankAccount {

    String accountHolder;
    double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
}
```

Now I can create an account:

```java
BankAccount account = new BankAccount("Vivek", 5000);
```

But there is a problem.

Because `balance` is directly accessible, I can do this:

```java
account.balance = -50000;
```

Java allows it.

Now my object contains invalid data:

```text
BankAccount
-----------------
accountHolder = "Vivek"
balance       = -50000
```

So I need a way to **protect the object's data**.

This is where **encapsulation** comes in.

---

# 1. What Is Encapsulation?

The simplest way I understand encapsulation is:

> **Encapsulation means protecting an object's internal data and controlling how that data can be accessed or changed.**

Instead of:

```text
Outside Code
     |
     v
Object
     |
     +---- directly change balance
```

I want:

```text
Outside Code
     |
     | controlled methods
     v
Object
     |
     +---- private data
     |
     +---- validation
```

So the object becomes responsible for protecting its own state.

---

# 2. `private` — Hiding Internal Data

Java gives me the `private` access modifier.

Instead of:

```java
class BankAccount {

    String accountHolder;
    double balance;
}
```

I can make the data private:

```java
class BankAccount {

    private String accountHolder;
    private double balance;
}
```

Now outside code cannot directly access these variables.

This will not work:

```java
BankAccount account = new BankAccount("Vivek", 5000);

account.balance = -50000; // Error
```

Because:

```text
private
   ↓
Accessible only from inside the class
```

But the class itself can still access its private variables.

---

# 3. Encapsulation With a Constructor

Since I have already learned constructors and `this`, I can use them here.

```java
class BankAccount {

    private String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
}
```

Now:

```java
BankAccount account = new BankAccount("Vivek", 5000);
```

The constructor initializes the object's state.

But I should also think about **validation**.

For example, a bank account should not start with a negative balance.

```java
class BankAccount {

    private String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {

        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        }
    }
}
```

Now the class itself controls how its state is initialized.

---

# 4. Methods Control How State Changes

Making a variable `private` is only part of encapsulation.

I also need to control how that data changes.

Instead of allowing:

```java
account.balance = 5000;
```

I can provide a method:

```java
void deposit(double amount) {

    if (amount > 0) {
        balance += amount;
    }
}
```

And for withdrawal:

```java
void withdraw(double amount) {

    if (amount > 0 && amount <= balance) {
        balance -= amount;
    }
}
```

Now the object controls its own state.

```text
Outside Code
     |
     | deposit()
     | withdraw()
     v
BankAccount
     |
     +---- private balance
     |
     +---- validates amount
     |
     +---- changes balance
```

The outside code **requests an operation** instead of directly changing the data.

---

# 5. Getters — Reading Private Data

Sometimes I want outside code to read private data.

For example:

```java
System.out.println(account.balance);
```

doesn't work because `balance` is private.

So I can create a getter:

```java
double getBalance() {
    return balance;
}
```

Now I can do:

```java
System.out.println(account.getBalance());
```

The outside code is not directly accessing `balance`.

Instead:

```text
Outside Code
     |
     | getBalance()
     v
BankAccount
     |
     v
private balance
```

A getter gives controlled **read access**.

---

# 6. Setters — Changing Private Data

A setter is used to change a private variable.

For example:

```java
void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
}
```

Now:

```java
account.setAccountHolder("Rahul");
```

instead of:

```java
account.accountHolder = "Rahul";
```

But I should be careful with setters.

For example, this is technically encapsulated:

```java
void setBalance(double balance) {
    this.balance = balance;
}
```

But now I can still do:

```java
account.setBalance(-50000);
```

So simply creating getters and setters does **not automatically mean good encapsulation**.

Sometimes I should expose meaningful operations instead.

For a bank account:

```java
deposit()
withdraw()
```

are better than:

```java
setBalance()
```

because they allow the class to enforce business rules.

---

# 7. Complete Example

Now I can combine everything I have learned.

```java
class BankAccount {

    private String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {

        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        }
    }

    void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    String getAccountHolder() {
        return accountHolder;
    }

    double getBalance() {
        return balance;
    }
}
```

Using the class:

```java
public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Vivek", 5000);

        account.deposit(2000);
        account.withdraw(1000);

        System.out.println(account.getAccountHolder());
        System.out.println(account.getBalance());
    }
}
```

Output:

```text
Vivek
6000.0
```

Notice that I never do:

```java
account.balance = 6000;
```

The object manages its own balance.

---

# 8. Why Is This Better?

Without encapsulation:

```text
Outside Code
     |
     +---- directly changes balance
     |
     +---- can create invalid data
```

With encapsulation:

```text
Outside Code
     |
     | deposit()
     | withdraw()
     v
BankAccount
     |
     +---- validates input
     |
     +---- updates balance
```

The class becomes responsible for maintaining a valid state.

This becomes extremely useful in real applications.

For example:

* Bank account → balance should not become invalid
* Product → stock should not become negative
* YouTube video → views should not decrease randomly
* User account → password should not be freely modified
* Shopping cart → product quantities should follow rules

---

# 9. Encapsulation vs `private`

I should not memorize:

```text
Encapsulation = private variables
```

That's incomplete.

Instead:

```text
private
   ↓
Tool for restricting access
```

while:

```text
Encapsulation
   ↓
Design principle
   ↓
Protect state
   +
Control access
   +
Control modifications
```

So:

```text
private
   ↓
Helps me achieve encapsulation
```

---

# 10. Memory Perspective

`private` does **not** create a special type of memory.

Suppose:

```java
class BankAccount {

    private double balance;
}
```

When I create:

```java
BankAccount account = new BankAccount("Vivek", 5000);
```

conceptually:

```text
STACK                         HEAP

account ----------------> BankAccount Object
                              |
                              +-- accountHolder
                              |
                              +-- balance
```

The `balance` variable still belongs to the object.

The difference is **access control**.

Outside the class:

```text
account.balance
      |
      X
   Not allowed
```

Inside `BankAccount`:

```text
BankAccount
     |
     +---- balance
     |
     +---- deposit()
     |
     +---- withdraw()
```

So I remember:

> **`private` controls access to the data. It does not mean the data is stored somewhere completely different in memory.**

---

# 11. My Mental Model

When I think about encapsulation, I should imagine an object like a protected machine:

```text
                 OBJECT
        +-----------------------+
        |                       |
        |    PRIVATE STATE      |
        |                       |
        |    balance            |
        |    accountHolder      |
        |                       |
        |-----------------------|
        |                       |
        |   CONTROLLED METHODS  |
        |                       |
        |    deposit()          |
        |    withdraw()         |
        |    getBalance()       |
        |                       |
        +-----------------------+
                  ^
                  |
             Outside Code
```

The outside world doesn't directly manipulate the internal state.

It interacts with the object through controlled methods.

---

# 12. The Core Idea

The most important thing I should remember is:

```text
Object owns its state
        ↓
State is protected
        ↓
Outside code uses methods
        ↓
Object validates the operation
        ↓
Object updates its own state
```

For example:

```java
account.withdraw(5000);
```

is better than:

```java
account.balance -= 5000;
```

because the object gets to decide whether the withdrawal is valid.

---

# 13. Final Mental Model

When I hear **Encapsulation**, I should think:

```text
Encapsulation
      |
      +---- Protect internal state
      |
      +---- Hide implementation details
      |
      +---- Control access
      |
      +---- Validate changes
      |
      +---- Expose meaningful methods
```

And:

```text
private
   ↓
Restricts direct access


methods
   ↓
Provide controlled interaction


validation
   ↓
Protects object state
```

So my one-line memory trick is:

> **Encapsulation means: the object owns its state and controls how the outside world can interact with that state.**

---

# 14. Self-Test

Before moving on, I should be able to answer:

1. What problem does encapsulation solve?
2. What does `private` mean?
3. Why should `balance` be private?
4. Why is `withdraw()` better than directly changing `balance`?
5. What is a getter?
6. What is a setter?
7. Why are getters and setters alone not necessarily good encapsulation?
8. What is the difference between `private` and encapsulation?

If I can explain these in my own words, I understand the core idea of encapsulation.
