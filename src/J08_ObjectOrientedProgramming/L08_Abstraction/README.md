# Lesson 11 — Abstraction

## 📌 What Am I Learning?

In this lesson, I am learning **Abstraction**, one of the four major pillars of Object-Oriented Programming.

Abstraction means:

> **Hiding unnecessary implementation details and exposing only the essential functionality.**

In simple words:

```text
Show WHAT something does
        ↓
Hide HOW it does it
```

For example, when I drive a car, I only need to interact with things like:

```text
start()
accelerate()
brake()
```

I don't need to know exactly how the engine, fuel injection, braking system, or other internal components work.

```text
Me
 ↓
Car Controls
 ↓
Internal Implementation
```

I only need to know **what the car can do**, not every detail of **how it does it**.

---

# 1. Why Do I Need Abstraction?

Imagine I am building a payment system.

Internally, making a payment might involve:

```text
Payment
   |
   ├── Validate user
   ├── Check balance
   ├── Perform security checks
   ├── Communicate with bank
   ├── Process transaction
   └── Return result
```

But the user doesn't need to interact with all of these steps.

They only need:

```java
payment.pay();
```

The complex implementation can remain hidden.

For example:

```java
class Payment {

    void pay() {

        // Complex payment processing
        // validation
        // security checks
        // bank communication
        // transaction processing
    }
}
```

The user simply calls:

```java
payment.pay();
```

This is the basic idea behind abstraction.

```text
WHAT should happen?
        ↓
      Expose
        ↓
HOW it happens
        ↓
       Hide
```

### In simple words:

> **Abstraction allows me to focus on what an object does instead of how it does it.**

---

# 2. How Do I Achieve Abstraction in Java?

Java mainly provides two ways to achieve abstraction:

```text
                 Abstraction
                     |
          ┌──────────┴──────────┐
          ↓                     ↓
   Abstract Classes        Interfaces
```

In this lesson, I will focus on:

> **Abstract Classes**

Interfaces will be studied separately.

---

# 3. What Is an Abstract Class?

I can create an abstract class using the `abstract` keyword.

```java
abstract class Vehicle {

}
```

An abstract class is a class that is generally used as a **base/parent class** for other classes.

I cannot directly create an object of an abstract class.

```java
Vehicle vehicle = new Vehicle(); // ERROR
```

Instead, another class can inherit from it:

```java
class Car extends Vehicle {

}
```

Now `Car` can be used to create objects:

```java
Car car = new Car();
```

### Basic Structure

```text
Abstract Class
      ↓
   Parent/Base
      ↓
    Child Class
      ↓
   Creates Object
```

Think of an abstract class as a **blueprint for other classes**.

---

# 4. What Is an Abstract Method?

An abstract class can contain an **abstract method**.

An abstract method is a method that has:

* A method declaration
* No method body

Example:

```java
abstract class Vehicle {

    abstract void start();
}
```

Notice that there is no `{ }` body after `start()`.

Instead, I am telling the child class:

> **Every Vehicle must have a `start()` method, but I am not deciding how it starts.**

The child class must provide the implementation.

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts using a key.");
    }
}
```

Now `Car` has decided **how** a car starts.

---

# 5. WHAT vs HOW

This is probably the most important idea to understand in abstraction.

The parent class defines:

```text
WHAT should happen?
```

The child class defines:

```text
HOW should it happen?
```

Example:

```java
abstract class Vehicle {

    abstract void start();
}
```

The parent says:

```text
"Every vehicle must be able to start."
```

But it doesn't say how.

The child decides:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts using a key.");
    }
}
```

Another child could implement it differently:

```java
class Bike extends Vehicle {

    @Override
    void start() {

        System.out.println("Bike starts using a self-start button.");
    }
}
```

So:

```text
                    Vehicle
                       |
                abstract start()
                       |
              "Vehicle must start"
                       |
             ┌─────────┴─────────┐
             ↓                   ↓
           Car                  Bike
             ↓                   ↓
       "How Car starts"    "How Bike starts"
```

The **same abstract behavior** can have **different implementations**.

---

# 6. Abstract Class Can Have Normal Methods Too

An important thing to remember is:

> **An abstract class does NOT have to contain only abstract methods.**

It can contain:

* Variables
* Constructors
* Abstract methods
* Normal methods

Example:

```java
abstract class Vehicle {

    String brand;

    Vehicle(String brand) {

        this.brand = brand;
    }

    abstract void start();

    void displayBrand() {

        System.out.println("Brand: " + this.brand);
    }
}
```

So:

```text
                Abstract Class
                     |
        ┌────────────┼────────────┐
        ↓            ↓            ↓
    Variables    Constructor    Methods
                                  |
                         ┌────────┴────────┐
                         ↓                 ↓
                  Abstract Method     Normal Method
```

This makes abstract classes useful because they can provide **common functionality** to all child classes while still forcing children to implement specific behaviors.

---

# 7. Complete Example

Let's combine everything.

### Parent Class

```java
abstract class Vehicle {

    String brand;

    Vehicle(String brand) {

        this.brand = brand;
    }

    abstract void start();

    void displayBrand() {

        System.out.println("Brand: " + this.brand);
    }
}
```

### Child Class

```java
class Car extends Vehicle {

    Car(String brand) {

        super(brand);
    }

    @Override
    void start() {

        System.out.println("Car starts using a key.");
    }
}
```

### Main Class

```java
public class Main {

    public static void main(String[] args) {

        Car car = new Car("Toyota");

        car.displayBrand();
        car.start();
    }
}
```

### Output

```text
Brand: Toyota
Car starts using a key.
```

Here:

```text
Vehicle
   |
   ├── brand
   ├── constructor
   ├── start() → abstract
   └── displayBrand() → normal
          |
          ↓
         Car
          |
          └── start() → implemented
```

---

# 8. Why Can't I Create an Object of an Abstract Class?

Consider:

```java
abstract class Vehicle {

    abstract void start();
}
```

Now imagine:

```java
Vehicle vehicle = new Vehicle();
```

What should happen if I call:

```java
vehicle.start();
```

The problem is:

```text
Vehicle.start()
       ↓
No implementation!
```

The abstract class only says:

> "A vehicle must have a `start()` method."

It doesn't provide the actual implementation.

That's why Java doesn't allow:

```java
new Vehicle(); // ERROR
```

Instead, I create an object of a concrete child class:

```java
Car car = new Car();
```

Because `Car` provides the actual implementation of `start()`.

---

# 9. Memory Perspective

Suppose I create:

```java
Car car = new Car("Toyota");
```

The reference variable `car` is stored in the **Stack**, while the actual object is created in the **Heap**.

```text
STACK                         HEAP

car ───────────────────→   Car Object
                             |
                             ├── brand
                             |
                             ├── Vehicle part
                             |
                             └── Car part
```

The abstract `Vehicle` class does **not** get a separate object.

Instead, the `Car` object contains the inherited state and behavior from `Vehicle`.

So I can think of it like:

```text
Car Object
    |
    ├── inherited Vehicle members
    |
    └── Car-specific members
```

---

# 10. What Happens When I Call an Abstract Method?

Suppose:

```java
Car car = new Car("Toyota");

car.start();
```

The flow is:

```text
car.start()
     ↓
Car's start()
     ↓
Car provides the implementation
     ↓
"Car starts using a key."
```

The abstract method in the parent acts like a **requirement**.

```text
Vehicle
   ↓
"You MUST have start()"
   ↓
Car
   ↓
"Okay, this is HOW my start() works."
```

---

# 11. Abstraction vs Encapsulation

Abstraction and encapsulation are often confused because both involve **hiding something**.

But they solve different problems.

---

## Encapsulation

Encapsulation focuses mainly on **protecting and controlling access to data**.

Example:

```java
class BankAccount {

    private double balance;

    public double getBalance() {

        return balance;
    }
}
```

Here, `balance` is hidden using `private`.

The goal is:

```text
Encapsulation
      ↓
Protect Data
      ↓
Control Access
```

Think:

> **"Who can access my data?"**

---

## Abstraction

Abstraction focuses on **hiding implementation details and exposing essential behavior**.

Example:

```java
abstract class Vehicle {

    abstract void start();
}
```

The user knows:

```text
Vehicle can start
```

But doesn't need to know the implementation at the parent level.

Think:

> **"What should I expose and what implementation should I hide?"**

---

## Quick Comparison

| Encapsulation                           | Abstraction                                 |
| --------------------------------------- | ------------------------------------------- |
| Protects data                           | Hides implementation details                |
| Controls access                         | Shows essential functionality               |
| Mainly uses `private`, getters, setters | Uses abstract classes and interfaces        |
| Focuses on **data security/control**    | Focuses on **design and complexity hiding** |
| "Who can access this?"                  | "What should be exposed?"                   |

### Memory Trick

```text
Encapsulation
     ↓
Protect DATA
     ↓
Control ACCESS


Abstraction
     ↓
Hide IMPLEMENTATION
     ↓
Expose ESSENTIAL BEHAVIOR
```

---

# 12. Abstract Class — Important Rules

Here are the rules I need to remember:

### Rule 1 — Use the `abstract` keyword

```java
abstract class Vehicle {

}
```

---

### Rule 2 — I cannot create an object of an abstract class

```java
Vehicle v = new Vehicle(); // ERROR
```

---

### Rule 3 — An abstract class can have abstract methods

```java
abstract void start();
```

---

### Rule 4 — An abstract class can also have normal methods

```java
void display() {

    System.out.println("Vehicle");
}
```

---

### Rule 5 — An abstract class can have constructors

```java
Vehicle(String brand) {

    this.brand = brand;
}
```

---

### Rule 6 — A child class must implement inherited abstract methods

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts.");
    }
}
```

If the child doesn't implement the abstract methods, then the child itself must be declared `abstract`.

---

# 13. Common Mistakes

### ❌ Mistake 1 — Trying to create an object of an abstract class

```java
abstract class Vehicle {

}

Vehicle v = new Vehicle(); // ERROR
```

---

### ❌ Mistake 2 — Giving an abstract method a body

```java
abstract void start() {

    System.out.println("Starting");
}
```

An abstract method should not have a body.

Correct:

```java
abstract void start();
```

---

### ❌ Mistake 3 — Forgetting to implement the abstract method

```java
abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle {

    // ERROR
}
```

`Car` must implement `start()`:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts.");
    }
}
```

---

### ❌ Mistake 4 — Thinking an abstract class can contain only abstract methods

This is completely valid:

```java
abstract class Vehicle {

    abstract void start();

    void stop() {

        System.out.println("Vehicle stopped.");
    }
}
```

An abstract class can contain both **abstract and normal methods**.

---

# 14. When Should I Use Abstraction?

I should think about abstraction when:

* Several classes share some common behavior.
* I want to force child classes to implement certain methods.
* I want to hide complex implementation details.
* I want to create a common structure for related classes.
* I want different classes to implement the same behavior differently.

For example:

```text
             Vehicle
                |
       ┌────────┼────────┐
       ↓        ↓        ↓
      Car      Bike     Truck
```

All vehicles may need:

```java
start()
```

But the implementation can be different for each:

```text
Car
 ↓
start() → Engine starts


Bike
 ↓
start() → Engine starts differently


Truck
 ↓
start() → Truck engine starts
```

The parent defines the **common requirement**.

The children define the **specific implementation**.

---

# 15. Abstraction in One Picture

```text
                  ABSTRACTION
                       |
                       ↓
              Hide Complexity
                       |
                       ↓
             Show Essential Behavior
                       |
                       ↓
                  WHAT?
                       |
             ┌─────────┴─────────┐
             ↓                   ↓
      Abstract Class        Interface
             |
             ↓
      Abstract Method
             |
             ↓
       Parent defines
            WHAT
             |
             ↓
       Child defines
            HOW
```

---

# 16. 🧠 Memory Trick

Remember abstraction using this:

```text
Abstraction
     ↓
Hide unnecessary details
     ↓
Show essential behavior
     ↓
Focus on WHAT
     ↓
Hide HOW
```

For an abstract method:

```text
Parent
   ↓
WHAT should happen?
   ↓
Abstract Method
   ↓
Child
   ↓
HOW should it happen?
   ↓
Implementation
```

---

# 17. 🎯 Key Takeaways

After completing this lesson, I should understand:

* What abstraction means.
* Why abstraction is useful.
* What an abstract class is.
* How to create an abstract class.
* What an abstract method is.
* Why abstract methods don't have implementations.
* Why I cannot create objects of abstract classes.
* How child classes implement abstract methods.
* That abstract classes can have variables.
* That abstract classes can have constructors.
* That abstract classes can have normal methods.
* The difference between abstraction and encapsulation.
* How abstraction focuses on **WHAT**, while hiding **HOW**.

---

# 18. 📝 Practice

Before moving to the next lesson, I should try creating an abstract class myself.

### Challenge

Create an abstract class:

```java
abstract class Animal {

    abstract void makeSound();

    void sleep() {

        System.out.println("Animal is sleeping.");
    }
}
```

Then create:

```text
Dog
Cat
```

Both should extend `Animal`.

Implement:

```java
makeSound()
```

differently in each class.

Expected idea:

```text
Animal
   |
   ├── makeSound() → abstract
   └── sleep() → normal
        |
        ├── Dog
        |    └── "Dog barks"
        |
        └── Cat
             └── "Cat meows"
```

The goal is to understand:

```text
Same requirement
       ↓
Different implementations
```

---

# Final Definition

> **Abstraction = Show WHAT is needed, hide HOW it is implemented.**

Or even simpler:

```text
WHAT → Expose
HOW  → Hide
```

That's the core idea behind **Abstraction in Java**.
