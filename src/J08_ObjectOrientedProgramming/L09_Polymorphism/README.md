# Mastering Polymorphism in Object-Oriented Programming (OOP)

## Overview

In this lesson, I am learning **Polymorphism**, one of the four core pillars of Object-Oriented Programming.

The word polymorphism comes from:

```text
Poly  → Many
Morph → Forms
```

So, polymorphism literally means **"many forms."**

In Java, polymorphism allows the **same method or reference to represent different behaviors** depending on the situation.

The main idea I want to understand is:

```text
One common method
       ↓
Different implementations
       ↓
Different behavior
```

Polymorphism becomes especially powerful when I combine it with **inheritance**, because I can use a parent type to work with different child objects.

---

## Learning Objectives

By the end of this lesson, I will be able to:

* **Define** polymorphism and understand why it is useful in OOP.
* **Differentiate** between compile-time and runtime polymorphism.
* **Implement** method overloading.
* **Implement** method overriding.
* **Understand** how the compiler chooses overloaded methods.
* **Understand** how the JVM chooses overridden methods at runtime.
* **Use** parent references with child objects.
* **Understand** how polymorphism makes code more flexible and extensible.

---

## Prerequisites

Before starting this lesson, I should be comfortable with:

* Classes and Objects
* Constructors
* `this` keyword
* Encapsulation
* Access Modifiers
* Inheritance
* `super` keyword

I should already understand the relationship:

```text
Parent Class
     ↓
Child Class
```

because runtime polymorphism builds directly on inheritance.

---

# Lesson Outline

## 1. Introduction to Polymorphism

### What Does Polymorphism Mean?

Polymorphism means **many forms**.

In Java, it allows the same method name or reference to behave differently depending on the context.

For example, suppose I have:

```java
void makeSound()
```

A `Dog` can implement it as:

```text
makeSound() → Bark
```

while a `Cat` can implement it as:

```text
makeSound() → Meow
```

The method name is the same:

```text
makeSound()
```

but the behavior is different.

That is the basic idea of polymorphism.

---

## Why Do I Need Polymorphism?

Without polymorphism, I might need separate methods for every type:

```java
dog.bark();
cat.meow();
cow.moo();
```

With polymorphism, I can work with a common parent type:

```java
animal.makeSound();
```

and let the actual object determine what happens.

This gives me:

* Flexibility
* Reusability
* Cleaner code
* Easier maintenance
* Better extensibility

The important idea is:

> I can write code around a common type while allowing different objects to provide different behavior.

---

# 2. Types of Polymorphism in Java

In Java, I mainly study two forms of polymorphism:

```text
                    Polymorphism
                         |
              +----------+----------+
              |                     |
              ↓                     ↓
       Compile-Time             Runtime
       Polymorphism             Polymorphism
              |                     |
              ↓                     ↓
      Method Overloading     Method Overriding
```

---

# 3. Compile-Time Polymorphism

Compile-time polymorphism is achieved through **method overloading**.

### What is Method Overloading?

Method overloading means creating multiple methods with:

* The same method name
* Different parameter lists

For example:

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

Both methods are called:

```text
add()
```

but their parameter lists are different:

```text
add(int, int)

add(int, int, int)
```

Now I can call:

```java
Calculator calculator = new Calculator();

calculator.add(10, 20);

calculator.add(10, 20, 30);
```

The compiler can look at the arguments and determine which `add()` method should be used.

That's why this is called:

**Compile-Time Polymorphism**

or

**Static Polymorphism**

---

## What Can Change in Method Overloading?

The parameter list can differ by:

### Number of Parameters

```java
add(int a, int b)

add(int a, int b, int c)
```

### Type of Parameters

```java
add(int a, int b)

add(double a, double b)
```

### Order of Parameters

```java
display(String name, int age)

display(int age, String name)
```

---

## Important Rule

I cannot overload a method by changing only its return type.

This is invalid:

```java
int add(int a, int b) {
    return a + b;
}

double add(int a, int b) {
    return a + b;
}
```

The parameter list is exactly the same.

The compiler cannot distinguish the methods just because their return types are different.

---

# 4. Runtime Polymorphism

Runtime polymorphism is achieved through **method overriding**.

### What is Method Overriding?

Method overriding happens when a child class provides its own implementation of a method that already exists in the parent class.

For example:

```java
class Animal {

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks.");
    }
}
```

Here, `Dog` inherits `makeSound()` from `Animal`, but provides its own implementation.

So:

```text
Animal
   |
   ↓
makeSound()
   |
   ↓
Dog overrides it
```

Now:

```java
Dog dog = new Dog();

dog.makeSound();
```

Output:

```text
Dog barks.
```

---

# 5. Parent Reference + Child Object

This is one of the most important concepts in runtime polymorphism.

I can write:

```java
Animal animal = new Dog();
```

At first, this might look confusing.

There are two different things here:

```text
Reference Type → Animal
Actual Object  → Dog
```

The reference is an `Animal` reference:

```text
Animal animal
```

but the object created in memory is a `Dog`:

```text
new Dog()
```

So:

```java
animal.makeSound();
```

calls:

```text
Dog's makeSound()
```

even though the reference type is `Animal`.

This is runtime polymorphism.

---

# 6. How Runtime Polymorphism Works

I can visualize it like this:

```text
Animal animal = new Dog();
        |
        ↓
Reference points to
        |
        ↓
Dog object
        |
        ↓
animal.makeSound()
        |
        ↓
Dog's overridden makeSound()
        |
        ↓
"Dog barks."
```

The important point is that the **actual object** determines which overridden method runs.

The decision happens at runtime.

This is also called:

**Dynamic Method Dispatch**

or

**Dynamic Binding**

---

# 7. Compile-Time vs Runtime Polymorphism

| Compile-Time Polymorphism       | Runtime Polymorphism              |
| ------------------------------- | --------------------------------- |
| Method Overloading              | Method Overriding                 |
| Same method name                | Same method signature             |
| Different parameters            | Child provides new implementation |
| Compiler decides                | JVM decides at runtime            |
| Does not require inheritance    | Requires inheritance              |
| Also called static polymorphism | Also called dynamic polymorphism  |

---

# 8. Polymorphism with Multiple Child Classes

Suppose I have:

```text
              Animal
             /      \
            ↓        ↓
          Dog        Cat
```

The parent has:

```java
void makeSound()
```

The children provide different implementations:

```text
Dog
 ↓
Bark

Cat
 ↓
Meow
```

Now I can write:

```java
Animal dog = new Dog();
Animal cat = new Cat();

dog.makeSound();
cat.makeSound();
```

The method call is the same:

```java
makeSound()
```

but the behavior is different.

```text
dog.makeSound()
      ↓
   Bark


cat.makeSound()
      ↓
   Meow
```

This is where polymorphism becomes really useful.

---

# 9. Memory POV

Consider:

```java
Animal animal = new Dog();
```

I should separate the **reference** from the **object**.

Conceptually:

```text
Stack                         Heap

animal ───────────────────→ Dog Object
                              |
                              ├── Animal state
                              |
                              └── Dog state
```

The variable `animal` stores a reference.

The actual `Dog` object exists in the heap.

When I call:

```java
animal.makeSound();
```

Java follows the reference to the actual object.

The actual object is a `Dog`.

Therefore, the overridden `Dog.makeSound()` implementation runs.

```text
animal.makeSound()
        ↓
Actual object = Dog
        ↓
Dog.makeSound()
        ↓
"Dog barks."
```

This is the key memory and runtime flow I need to understand.

---

# 10. The Core Mental Model

I can remember polymorphism using two simple patterns.

### Compile-Time Polymorphism

```text
Same method name
       ↓
Different parameters
       ↓
Compiler decides
```

Example:

```text
add(int, int)

add(int, int, int)
```

### Runtime Polymorphism

```text
Parent reference
       +
Child object
       ↓
Overridden method
       ↓
JVM decides at runtime
```

Example:

```java
Animal animal = new Dog();

animal.makeSound();
```

---

# Practice Exercises

## Exercise 1 — Payment Gateway System

Create a parent class:

```java
PaymentProcessor
```

with a method:

```java
processPayment(double amount)
```

Create two child classes:

```text
CreditCardPayment
PayPalPayment
```

Override `processPayment()` in both classes.

Then create:

```java
PaymentProcessor payment = new CreditCardPayment();
```

and:

```java
PaymentProcessor payment = new PayPalPayment();
```

Call:

```java
payment.processPayment(5000);
```

Observe how the same method call produces different behavior.

---

## Exercise 2 — Shape Calculator

Create a class:

```java
ShapeArea
```

Create overloaded methods called:

```java
calculateArea()
```

For example:

```text
calculateArea(double radius)
calculateArea(double length, double width)
```

Use them to calculate:

* Circle area
* Rectangle area

Observe how the compiler selects the appropriate method based on the parameters.

---

# Common Mistakes I Should Avoid

### Mistake 1: Thinking Overloading and Overriding Are the Same

They are different.

```text
Overloading
    ↓
Same class
    ↓
Different parameters
```

```text
Overriding
    ↓
Parent + Child
    ↓
Same method signature
    ↓
Different implementation
```

### Mistake 2: Thinking Return Type Creates Overloading

It doesn't.

The parameter list must be different.

### Mistake 3: Confusing Reference Type with Object Type

In:

```java
Animal animal = new Dog();
```

remember:

```text
Reference Type → Animal
Object Type    → Dog
```

### Mistake 4: Thinking the Reference Type Always Determines the Method

For overridden instance methods, the actual object determines the implementation at runtime.

---

# Key Takeaways

* **Polymorphism** means many forms.
* It allows the same method or reference to represent different behaviors.
* Java mainly has:

    * Compile-time polymorphism
    * Runtime polymorphism
* **Method overloading** gives compile-time polymorphism.
* **Method overriding** gives runtime polymorphism.
* Overloading requires different parameter lists.
* Overriding happens between a parent and child class.
* Runtime polymorphism commonly uses a **parent reference pointing to a child object**.
* The actual object determines which overridden method executes.
* Polymorphism makes code more flexible, reusable, and easier to extend.

The biggest idea I want to remember is:

```text
                POLYMORPHISM
                     |
              "Many Forms"
                     |
          +----------+----------+
          |                     |
          ↓                     ↓
   Compile-Time             Runtime
          |                     |
          ↓                     ↓
    Overloading             Overriding
          |                     |
          ↓                     ↓
  Compiler decides        JVM decides
                                |
                                ↓
                     Parent reference
                              +
                        Child object
                                |
                                ↓
                       Different behavior
```

## Lesson Files

```text
L09_Polymorphism/
│
├── README.md
├── C01_MethodOverloading.java
└── C02_MethodOverriding.java
```

In `C01_MethodOverloading.java`, I will focus on **compile-time polymorphism and method overloading**.

In `C02_MethodOverriding.java`, I will focus on **runtime polymorphism, method overriding, parent references, and child objects**.
