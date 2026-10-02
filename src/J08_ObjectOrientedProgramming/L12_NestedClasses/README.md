# Lesson 12 — Nested Classes

## Why Am I Learning This?

So far, I have learned how to create classes, objects, constructors, inheritance, abstraction, polymorphism and interfaces.

Now I want to understand **Nested Classes**.

At first, putting one class inside another class may look unnecessary.

But sometimes a class is strongly related to another class and is useful only within that particular context.

Java allows me to define that class inside another class.

This helps me with:

* Better code organization
* Logical grouping of related classes
* Encapsulation
* Small helper classes
* Understanding Java's own APIs and libraries
* Writing cleaner real-world Java code

The important thing is that I don't want to simply memorize four types.

I want to understand:

> **Why does each type exist, how is it connected to its surrounding code, and when would I actually use it?**

---

# What Am I Going To Learn?

In this lesson, I will learn four commonly used types of nested classes:

```text
Nested Classes
│
├── Static Nested Class
├── Inner Class
├── Local Class
└── Anonymous Class
```

I will learn them in this order:

```text
Static Nested Class
        ↓
Inner Class
        ↓
Local Class
        ↓
Anonymous Class
```

Each type represents a different kind of relationship:

```text
Static Nested Class
→ Related to the outer class

Inner Class
→ Related to a specific outer object

Local Class
→ Needed only inside a specific method/block

Anonymous Class
→ One-off implementation without a class name
```

---

# 1. First Understand The Problem

Suppose I have a bank account:

```java
class BankAccount {

}
```

Now I want to define some rules related specifically to bank accounts:

```text
Minimum balance
Withdrawal limit
Transaction rules
```

I could create another top-level class:

```java
class AccountRules {

}
```

But now `BankAccount` and `AccountRules` are completely separate.

If `AccountRules` exists mainly to support `BankAccount`, I can keep them together:

```java
class BankAccount {

    static class AccountRules {

    }
}
```

Now the relationship is clear:

```text
BankAccount
     │
     └── AccountRules
```

This is the basic idea behind **Nested Classes**.

---

# 2. What Is A Nested Class?

A nested class is simply a class declared inside another class.

```java
class Outer {

    class Inner {

    }
}
```

Here:

```text
Outer
  │
  └── Inner
```

`Outer` is the outer class.

`Inner` is the nested class.

The main reason for doing this is **logical grouping**.

If one class is closely related to another class, I can keep them together instead of creating two unrelated top-level classes.

---

# 3. Types Of Nested Classes

For this lesson, I will use this four-part classification:

```text
Nested Classes
│
├── Static Nested Class
├── Inner Class
├── Local Class
└── Anonymous Class
```

One terminology detail is important:

> **Nested class** is the broad term. Technically, an inner class is a non-static nested class.

For learning these concepts practically, I will treat the four types separately because each has a different use case.

---

# 4. Static Nested Class

A static nested class is a class declared inside another class using the `static` keyword.

```java
class BankAccount {

    static class AccountRules {

    }
}
```

The important idea is:

> A static nested class is related to the outer class, but it does not require an object of the outer class.

---

## Key Properties

### 1. No Outer Object Required

I can create it without creating an object of the outer class first.

```java
BankAccount.AccountRules rules =
        new BankAccount.AccountRules();
```

I don't need:

```java
BankAccount account = new BankAccount();
```

---

### 2. Related To The Outer Class

It is placed inside the outer class because the two concepts are logically related.

```text
BankAccount
     │
     └── AccountRules
```

---

### 3. Direct Access To Static Members

A static nested class can directly access static members of the outer class.

```java
class BankAccount {

    static String bankName = "SBI";

    static class AccountRules {

        void showBank() {
            System.out.println(bankName);
        }
    }
}
```

---

### 4. No Direct Access To Instance Members

Suppose the outer class has:

```java
String accountHolder;
```

The static nested class cannot directly use:

```java
System.out.println(accountHolder);
```

because `accountHolder` belongs to a particular `BankAccount` object.

If the nested class needs it, I must provide a `BankAccount` object explicitly.

---

### 5. It Behaves Like A Normal Class

A static nested class can have:

* Fields
* Methods
* Constructors
* Static members
* Its own nested classes

It is not a restricted or special kind of object.

---

# 5. Practical Example — BankAccount And AccountRules

This example fits a static nested class naturally.

Account rules are common to the bank account system.

They don't belong specifically to Vivek's account or Rahul's account.

```java
class BankAccount {

    private static String bankName = "State Bank of India";

    static class AccountRules {

        void showRules() {

            System.out.println("Bank: " + bankName);
            System.out.println("Minimum Balance: ₹1000");
            System.out.println("ATM Withdrawal Limit: ₹20,000");
        }
    }
}
```

I can use it like this:

```java
BankAccount.AccountRules rules =
        new BankAccount.AccountRules();

rules.showRules();
```

The relationship is:

```text
BankAccount
     │
     ├── bankName
     │
     └── AccountRules
             │
             └── Common rules
```

The rules belong to the **BankAccount system**, not to one particular account object.

---

# 6. Static Nested Class And Instance Data

Now suppose I have:

```java
class BankAccount {

    private String accountHolder;

    static class AccountRules {

        void showAccountHolder() {
            // Cannot directly access accountHolder
        }
    }
}
```

Why can't `AccountRules` directly access `accountHolder`?

Because `accountHolder` belongs to an individual object.

For example:

```java
BankAccount vivekAccount = new BankAccount();
BankAccount rahulAccount = new BankAccount();
```

There are two different objects.

The static nested class doesn't automatically know which one I mean.

So I can explicitly provide the object:

```java
void showAccountHolder(BankAccount account) {

    System.out.println(account.accountHolder);
}
```

The flow becomes:

```text
AccountRules
      │
      │ receives BankAccount reference
      ↓
BankAccount object
      │
      └── accountHolder
```

### Main Rule

> A static nested class can directly access outer static members, but it needs an explicit outer object/reference to access outer instance members.

---

# 7. Inner Class

Now I remove the `static` keyword.

```java
class Student {

    String name;

    class Address {

        void showStudentName() {
            System.out.println(name);
        }
    }
}
```

This is an **Inner Class**.

The main difference is:

> An inner class is associated with a specific object of the outer class.

---

## Key Properties

### 1. Outer Object Required

I need an outer object before I can create the inner class object.

```java
Student student =
        new Student("Vivek");

Student.Address address =
        student.new Address();
```

---

### 2. Connected To A Specific Object

The inner class object is associated with the particular outer object used to create it.

```text
Student object
      │
      └── Address object
```

---

### 3. Direct Access To Instance Members

Because the inner class is connected to an outer object, it can directly access that object's instance members.

```java
class Student {

    String name;

    class Address {

        void showName() {
            System.out.println(name);
        }
    }
}
```

---

### 4. Can Also Access Static Members

An inner class can also access static members of the outer class.

So its access is broader than a static nested class when it comes to outer instance data.

---

# 8. Practical Example — Student And Address

This is a natural example because an address belongs to a particular student.

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    class Address {

        void showAddress() {

            System.out.println(
                    name + " lives in Mohali."
            );
        }
    }
}
```

Usage:

```java
Student vivek =
        new Student("Vivek");

Student.Address address =
        vivek.new Address();

address.showAddress();
```

The relationship is:

```text
Vivek Student Object
        │
        └── Address
```

If I create another student:

```java
Student rahul =
        new Student("Rahul");
```

then:

```text
Vivek
  │
  └── Address

Rahul
  │
  └── Address
```

Each inner-class object is connected to its own outer object.

---

# 9. Static Nested Class vs Inner Class

This is one of the most important comparisons in this lesson.

| Static Nested Class                           | Inner Class                                |
| --------------------------------------------- | ------------------------------------------ |
| Does not require outer object                 | Requires outer object                      |
| Related to outer class                        | Associated with outer object               |
| Directly accesses outer static members        | Can access outer static members            |
| Cannot directly access outer instance members | Can directly access outer instance members |
| Created with `new Outer.Nested()`             | Created with `outer.new Inner()`           |

The easiest mental model:

```text
Static Nested Class
        ↓
"I am related to the class."


Inner Class
        ↓
"I am connected to an object."
```

---

# 10. Local Class

Now I move from class-level relationships to **method-level scope**.

A local class is declared inside:

* A method
* A constructor
* A block

Example:

```java
class Order {

    void calculateBill() {

        class BillCalculator {

            double calculate(double price, double tax) {
                return price + tax;
            }
        }

        BillCalculator calculator =
                new BillCalculator();

        double total =
                calculator.calculate(500, 90);

        System.out.println("Total: ₹" + total);
    }
}
```

The structure is:

```text
Order
 │
 └── calculateBill()
        │
        └── BillCalculator
```

`BillCalculator` only exists within the scope of `calculateBill()`.

---

# 11. Local Class — Key Properties

### 1. Method-Level Scope

The class is declared inside a method, constructor or block.

---

### 2. Limited Visibility

I can only use the local class within the scope where it was declared.

---

### 3. Useful For Small Helpers

It is useful when I need a helper class for one specific operation.

---

### 4. Keeps Implementation Local

If no other part of my program needs the helper, I don't have to expose it as a separate top-level class.

---

### 5. Can Access Surrounding Context

A local class can access members of its surrounding class and local variables that are final or effectively final.

---

# 12. Why Is `BillCalculator` A Good Local Class?

Suppose I have:

```java
void calculateBill()
```

and inside that method I need some calculation logic.

But I don't need `BillCalculator` anywhere else.

Creating a separate class would add unnecessary code outside the place where it is actually used.

So I can keep it exactly where it is needed:

```text
calculateBill()
      │
      └── BillCalculator
```

This is the main idea:

> If a helper class is useful only inside one particular block of code, I can keep its scope limited to that block.

---

# 13. Anonymous Class

The last type is an **Anonymous Class**.

An anonymous class is a class that has **no explicit name**.

It is commonly useful when I need a one-off implementation of:

* An interface
* An abstract class

For example:

```java
interface ClickListener {

    void onClick();
}
```

Instead of creating another named class:

```java
class MyClickListener implements ClickListener {

    @Override
    public void onClick() {
        System.out.println("Button clicked!");
    }
}
```

I can directly create the implementation:

```java
ClickListener listener = new ClickListener() {

    @Override
    public void onClick() {
        System.out.println("Button clicked!");
    }
};
```

There is no explicit class name.

That is why it is called **anonymous**.

---

# 14. Anonymous Class — Key Properties

### 1. No Explicit Class Name

I define the class without giving it a name.

---

### 2. Class And Object Creation Together

The class definition and object creation happen in the same expression.

```java
new ClickListener() {

    @Override
    public void onClick() {

    }
};
```

---

### 3. Usually Used For One-Off Behavior

If I need a specific implementation only in one place, creating a separate named class may be unnecessary.

---

### 4. Works With Interfaces And Abstract Classes

An anonymous class can:

* Implement an interface
* Extend a class
* Extend an abstract class

---

### 5. Cannot Be Reused By A Class Name

Since I never give the class a name, I cannot later write:

```java
new MyClickListener();
```

because there is no `MyClickListener` class.

---

# 15. Practical Example — Button Click

Suppose I have:

```java
interface ClickListener {

    void onClick();
}
```

I only need one specific implementation:

```java
ClickListener listener = new ClickListener() {

    @Override
    public void onClick() {
        System.out.println("Button clicked!");
    }
};
```

The idea is:

```text
ClickListener
      ↑
      │
Anonymous implementation
      │
      └── Custom click behavior
```

I don't need to create a separate named class just for this small behavior.

---

# 16. Local Class vs Anonymous Class

These two can look similar, so I need to clearly separate them.

## Local Class

The class has a name:

```java
class BillCalculator {

}
```

But it exists only within a local scope.

```text
Named
  ↓
Limited scope
```

## Anonymous Class

The class has no explicit name:

```java
new ClickListener() {

}
```

```text
Unnamed
   ↓
Usually one-off implementation
```

So:

```text
Local Class
    → Named + local scope


Anonymous Class
    → Unnamed + immediate implementation
```

---

# 17. Object Creation Syntax

## Static Nested Class

```java
Outer.Nested object =
        new Outer.Nested();
```

Example:

```java
BankAccount.AccountRules rules =
        new BankAccount.AccountRules();
```

---

## Inner Class

```java
Outer outer =
        new Outer();

Outer.Inner object =
        outer.new Inner();
```

Example:

```java
Student student =
        new Student("Vivek");

Student.Address address =
        student.new Address();
```

---

## Local Class

```java
void method() {

    class Helper {

    }

    Helper helper =
            new Helper();
}
```

---

## Anonymous Class

```java
ClickListener listener =
        new ClickListener() {

            @Override
            public void onClick() {

            }
        };
```

---

# 18. Complete Comparison

| Type                    | Main Relationship              | Outer Object Required? | Class Name? | Typical Use               |
| ----------------------- | ------------------------------ | ---------------------: | ----------: | ------------------------- |
| **Static Nested Class** | Related to outer class         |                     No |         Yes | Shared/class-level helper |
| **Inner Class**         | Related to outer object        |                    Yes |         Yes | Object-specific behavior  |
| **Local Class**         | Related to a method/block      |                     No |         Yes | Small local helper        |
| **Anonymous Class**     | Related to a specific use case |                    No* |          No | One-off implementation    |

`*` An anonymous class does not require an outer-class object simply because it is anonymous.

---

# 19. The Big Picture

I can now visualize the four types like this:

```text
                         Nested Classes
                              │
          ┌───────────────────┼───────────────────┐
          │                   │                   │
          ↓                   ↓                   ↓
   Static Nested           Inner               Local
       Class               Class               Class
          │                   │                   │
          │                   │                   └── Inside method/block
          │                   │
          │                   └── Connected to
          │                       outer object
          │
          └── Connected to
              outer class

                              │
                              ↓
                       Anonymous Class
                              │
                              └── No explicit name
```

---

# 20. The Most Important Mental Model

I don't want to memorize four unrelated definitions.

I want to remember the relationship each type creates.

```text
STATIC NESTED CLASS
        ↓
Related to the OUTER CLASS
        ↓
No outer object required


INNER CLASS
        ↓
Related to an OUTER OBJECT
        ↓
Outer object required


LOCAL CLASS
        ↓
Related to a METHOD / BLOCK
        ↓
Limited scope


ANONYMOUS CLASS
        ↓
Related to a specific USE CASE
        ↓
No explicit class name
```

---

# 21. How Do I Decide Which One To Use?

I can ask myself:

### Is the class logically related to another class but independent of its objects?

```text
        ↓
Static Nested Class
```

### Does the class need to work directly with a particular outer object?

```text
        ↓
Inner Class
```

### Do I need a helper only inside one method or block?

```text
        ↓
Local Class
```

### Do I need a small one-off implementation?

```text
        ↓
Anonymous Class
```

---

# 22. Common Mistakes

## Mistake 1 — Thinking every nested class needs an outer object

Not true.

A static nested class does not.

```java
Outer.Nested obj =
        new Outer.Nested();
```

---

## Mistake 2 — Thinking static nested classes can directly access instance variables

They cannot.

```java
class Outer {

    int value;

    static class Nested {

        void show() {
            // System.out.println(value);
        }
    }
}
```

I need an explicit object:

```java
void show(Outer outer) {

    System.out.println(outer.value);
}
```

---

## Mistake 3 — Confusing static nested and inner classes

Remember:

```text
Static Nested
    ↓
No outer object


Inner
    ↓
Outer object required
```

---

## Mistake 4 — Thinking anonymous class means an object with no class

An anonymous class **is still a class**.

It simply has no explicit name.

The class definition and object creation happen together.

---

## Mistake 5 — Using nested classes without understanding the relationship

I should not use nested classes just because Java allows them.

I should ask:

> **Why does this class belong here?**

If the relationship doesn't make sense, a normal top-level class may be clearer.

---

# 23. What I Should Be Able To Explain After This Lesson

Before moving forward, I should be able to explain:

* What is a nested class?
* Why would I put one class inside another?
* What is a static nested class?
* Why doesn't a static nested class require an outer object?
* What can a static nested class access directly?
* What is an inner class?
* Why does an inner class require an outer object?
* How does an inner class access outer instance data?
* What is a local class?
* Why would I keep a class inside a method?
* What is an anonymous class?
* Why would I use an anonymous class?
* What is the difference between a local and anonymous class?
* How do I create objects of each type?
* When would each type make sense?

If I can explain these concepts in my own words, I have actually understood Nested Classes instead of simply memorizing their syntax.

---

# Files For This Lesson

I will keep each concept in a separate file so that I can learn and revise them independently.

```text
L12_NestedClasses/
│
├── C01_StaticNestedClass.java
├── C02_InnerClass.java
├── C03_LocalClass.java
└── C04_AnonymousClass.java
```

Each file will use an example that naturally fits the concept:

```text
C01_StaticNestedClass
        ↓
BankAccount → AccountRules

C02_InnerClass
        ↓
Student → Address

C03_LocalClass
        ↓
Order → BillCalculator

C04_AnonymousClass
        ↓
Button → ClickListener
```

This way, I am learning **why the type exists**, not just copying its syntax.

---

# Final Takeaway

Nested classes are four different ways of keeping related code together.

```text
Static Nested Class
    → Related to the outer class


Inner Class
    → Related to a specific outer object


Local Class
    → Needed only inside a specific method/block


Anonymous Class
    → One-off unnamed implementation
```

The two distinctions I absolutely need to remember are:

```text
Static Nested Class
        vs
Inner Class

No outer object             Outer object required
        ↓                           ↓
Related to class              Related to object
```

And:

```text
Local Class
    → Has a name
    → Limited scope


Anonymous Class
    → No explicit name
    → Usually one-off behavior
```

The goal of this lesson is not to memorize four types.

The goal is to look at Java code and understand:

> **What is this nested class related to, why is it nested here, and why was this particular type chosen?**

Once I can answer those questions, I have understood Nested Classes.
