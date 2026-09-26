# L10 — Interfaces

## What Am I Learning?

In this lesson, I am learning about **Interfaces**, one of the most important features of Java's Object-Oriented Programming system.

I already learned about **Abstraction** using abstract classes. An interface gives me another way to define a common **contract** that different classes can follow.

The basic idea is:

```text
Interface
    ↓
Defines WHAT should be done
    ↓
Class implements the interface
    ↓
Class defines HOW it should be done
```

For example:

```java
interface Vehicle {

    void start();
    void accelerate();
    void brake();
}
```

The interface is not concerned with how a vehicle actually starts, accelerates, or brakes.

It only defines the behavior that a `Vehicle` should provide.

---

# Learning Objectives

By the end of this lesson, I will be able to:

* Understand what an interface is and why it is useful.
* Create an interface using the `interface` keyword.
* Implement an interface using the `implements` keyword.
* Implement interface methods inside a class.
* Understand how interfaces provide abstraction.
* Understand the difference between a class reference and an interface reference.
* Understand why an interface reference is useful.
* Use an interface reference with different implementation objects.
* Understand how interfaces connect with runtime polymorphism.
* Understand how a class can implement multiple interfaces.

---

# Prerequisites

Before starting this lesson, I should be comfortable with:

* Classes and Objects
* Constructors
* Encapsulation
* Access Modifiers
* Inheritance
* `super` keyword
* Abstraction
* Abstract Classes
* Abstract Methods
* Polymorphism

The most important concepts I need to understand are **abstraction, inheritance, and polymorphism**, because interfaces build on these ideas.

---

# 1. What Is an Interface?

An interface is a **contract** that defines what a class should provide.

I create an interface using the `interface` keyword:

```java
interface Vehicle {

    void start();
    void accelerate();
    void brake();
}
```

Here, `Vehicle` defines three behaviors:

```text
start()
accelerate()
brake()
```

But it does not tell me how these behaviors should work.

A class can then implement the interface:

```java
class FuelCar implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting the car...");
    }

    @Override
    public void accelerate() {
        System.out.println("Car is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Stopping the car...");
    }
}
```

So:

```text
Vehicle
   ↓
Defines WHAT
   ↓
FuelCar
   ↓
Defines HOW
```

My mental model is:

> **Interface = WHAT**
>
> **Implementation class = HOW**

---

# 2. `implements` Keyword

A class uses the `implements` keyword when it wants to follow an interface.

```java
class FuelCar implements Vehicle {
}
```

This means:

> `FuelCar` agrees to follow the `Vehicle` contract.

Since `Vehicle` requires:

```java
void start();
void accelerate();
void brake();
```

`FuelCar` must provide implementations for these methods.

```text
Vehicle
   |
   | start()
   | accelerate()
   | brake()
   |
   ↓
FuelCar
   |
   └── Provides implementations
```

---

# 3. Implementing Interface Methods

When I implement an interface method, I provide the actual behavior.

For example:

```java
@Override
public void start() {
    System.out.println("Starting the car...");
}
```

The interface says:

```text
start() must exist
```

The class says:

```text
This is how start() works for me
```

So:

```text
Interface
    ↓
WHAT should happen?
    ↓
Implementation class
    ↓
HOW should it happen?
```

The `@Override` annotation tells Java that I am implementing a method declared by the interface.

---

# 4. Why Do I Need Interfaces?

Suppose I have different types of vehicles:

```text
FuelCar
ElectricCar
Bike
```

All of them can:

```text
start()
accelerate()
brake()
```

But the actual implementation can be completely different.

For example:

```text
FuelCar
   ↓
Engine starts

ElectricCar
   ↓
Electric motor starts

Bike
   ↓
Bike engine starts
```

Instead of creating unrelated structures, I can define one common contract:

```java
interface Vehicle {

    void start();
    void accelerate();
    void brake();
}
```

Now all these classes can follow the same contract:

```text
                 Vehicle
                    |
          +---------+---------+
          |         |         |
          ↓         ↓         ↓
       FuelCar  ElectricCar   Bike
```

This gives me a **common structure** while allowing each class to have its own implementation.

---

# 5. Creating an Object from an Implementation Class

I can create an object normally using the implementing class:

```java
FuelCar car = new FuelCar();
```

Here:

```text
Reference type → FuelCar
Actual object  → FuelCar
```

So I can access methods available through the `FuelCar` reference:

```java
car.start();
car.accelerate();
car.brake();
```

If `FuelCar` has its own method:

```java
void openTrunk() {
    System.out.println("Trunk opened.");
}
```

I can also call:

```java
car.openTrunk();
```

because my reference type is `FuelCar`.

So:

```text
FuelCar reference
       ↓
Specific FuelCar view
       ↓
FuelCar-specific behavior is accessible
```

---

# 6. Interface Reference

Now I can write:

```java
Vehicle car = new FuelCar();
```

This looks different:

```text
Reference type → Vehicle
Actual object  → FuelCar
```

But the object created is still a `FuelCar`.

Changing the reference type does **not** change the actual object.

The important difference is what I can access through the reference.

Since the reference type is `Vehicle`, I can access the behavior defined by the `Vehicle` interface:

```java
car.start();
car.accelerate();
car.brake();
```

But if `openTrunk()` exists only inside `FuelCar`:

```java
car.openTrunk();
```

this will not work.

Why?

Because the `Vehicle` interface does not promise that every vehicle has an `openTrunk()` method.

So:

```text
Vehicle reference
       ↓
Vehicle view
       ↓
Vehicle-defined behavior
```

---

# 7. Class Reference vs Interface Reference

These two statements create the same type of object:

```java
FuelCar car = new FuelCar();
```

and:

```java
Vehicle car = new FuelCar();
```

In both cases:

```text
Actual object → FuelCar
```

The difference is the **reference type**.

## Class Reference

```java
FuelCar car = new FuelCar();
```

I am saying:

> I specifically want to work with a `FuelCar`.

```text
FuelCar reference
       ↓
Specific FuelCar view
```

I can access both:

* Methods defined by `FuelCar`
* Methods inherited by `FuelCar`

---

## Interface Reference

```java
Vehicle car = new FuelCar();
```

I am saying:

> I don't care which specific vehicle this is. I only need the behavior promised by `Vehicle`.

```text
Vehicle reference
       ↓
Common Vehicle view
```

I can directly access only the behavior available through the `Vehicle` interface.

---

## The Important Rule

The easiest way for me to remember this is:

```text
Reference type
      ↓
What I can directly access

Actual object
      ↓
What actually exists
```

So:

```java
Vehicle car = new FuelCar();
```

means:

```text
Reference type → Vehicle
Object type    → FuelCar
```

The object is still a `FuelCar`.

The `Vehicle` reference simply gives me a **Vehicle-level view** of that object.

---

# 8. Why Is an Interface Reference Useful?

At first, this can feel unnecessary:

```java
FuelCar car = new FuelCar();
```

already works.

So why would I use:

```java
Vehicle car = new FuelCar();
```

The real advantage appears when I have multiple classes implementing the same interface.

For example:

```text
                 Vehicle
                    |
          +---------+---------+
          |         |         |
          ↓         ↓         ↓
       FuelCar  ElectricCar   Bike
```

Now I can write:

```java
Vehicle v1 = new FuelCar();
Vehicle v2 = new ElectricCar();
Vehicle v3 = new Bike();
```

All three references have the same reference type:

```text
Vehicle
```

But they point to different objects:

```text
v1 → FuelCar
v2 → ElectricCar
v3 → Bike
```

I can then use the same method call:

```java
v1.start();
v2.start();
v3.start();
```

But each object can provide its own implementation.

```text
v1.start()
    ↓
FuelCar.start()

v2.start()
    ↓
ElectricCar.start()

v3.start()
    ↓
Bike.start()
```

This is where **interfaces and polymorphism work together**.

---

# 9. When Should I Use a Class Reference?

I should use a class reference when I specifically need the functionality of that particular class.

For example:

```java
FuelCar car = new FuelCar();

car.start();
car.brake();
car.openTrunk();
```

Here I specifically care that the object is a `FuelCar`.

I need access to functionality that may not exist in the `Vehicle` interface.

So:

```text
Class reference
      ↓
I need specific implementation behavior
```

---

# 10. When Should I Use an Interface Reference?

I should use an interface reference when I only care about the common behavior defined by the interface.

For example:

```java
Vehicle vehicle = new FuelCar();

vehicle.start();
vehicle.brake();
```

Here I don't care whether the object is:

```text
FuelCar
ElectricCar
Bike
```

I only care that it follows the `Vehicle` contract.

So:

```text
Interface reference
      ↓
I only need common behavior
      ↓
Different implementations can be used
```

This makes my code less dependent on one specific implementation.

---

# 11. Interface Reference + Polymorphism

This connects directly with the polymorphism I just learned.

Suppose:

```java
interface Vehicle {

    void start();
}
```

and:

```text
FuelCar implements Vehicle
ElectricCar implements Vehicle
Bike implements Vehicle
```

I can write:

```java
Vehicle vehicle = new FuelCar();
```

or:

```java
Vehicle vehicle = new ElectricCar();
```

or:

```java
Vehicle vehicle = new Bike();
```

The reference type remains:

```text
Vehicle
```

but the actual object changes.

Therefore:

```java
vehicle.start();
```

can produce different behavior.

```text
Vehicle reference
        ↓
     Actual object
        ↓
+---------+------------+------+
|         |            |      |
FuelCar  ElectricCar  Bike
|         |            |      |
↓         ↓            ↓
start()  start()      start()
```

This is **runtime polymorphism**.

The method that actually runs depends on the object stored in the reference.

---

# 12. Complete Runnable Example

Now I want to put everything together in one program.

This example demonstrates:

* Creating an interface
* Implementing an interface
* Multiple implementation classes
* Class references
* Interface references
* Runtime polymorphism
* Interface references as method parameters

```java
interface Vehicle {

    void start();

    void accelerate();

    void brake();
}

class FuelCar implements Vehicle {

    @Override
    public void start() {
        System.out.println("Fuel car: Engine started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Fuel car: Accelerating using the engine.");
    }

    @Override
    public void brake() {
        System.out.println("Fuel car: Applying brakes.");
    }

    public void openTrunk() {
        System.out.println("Fuel car: Trunk opened.");
    }
}

class ElectricCar implements Vehicle {

    @Override
    public void start() {
        System.out.println("Electric car: Motor started silently.");
    }

    @Override
    public void accelerate() {
        System.out.println("Electric car: Accelerating using the electric motor.");
    }

    @Override
    public void brake() {
        System.out.println("Electric car: Applying regenerative brakes.");
    }
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike: Engine started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike: Accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Bike: Applying brakes.");
    }
}

public class C01_Interfaces {

    static void testVehicle(Vehicle vehicle) {

        vehicle.start();
        vehicle.accelerate();
        vehicle.brake();

        System.out.println();
    }

    public static void main(String[] args) {

        // Class reference
        FuelCar car = new FuelCar();

        car.start();
        car.openTrunk();

        System.out.println();

        // Interface reference
        Vehicle vehicle = new FuelCar();

        vehicle.start();
        vehicle.accelerate();
        vehicle.brake();

        System.out.println();

        // Same interface reference type,
        // but different actual objects
        Vehicle vehicle1 = new FuelCar();
        Vehicle vehicle2 = new ElectricCar();
        Vehicle vehicle3 = new Bike();

        vehicle1.start();
        vehicle2.start();
        vehicle3.start();

        System.out.println();

        // Passing different implementations
        // to a method that expects Vehicle
        testVehicle(new FuelCar());
        testVehicle(new ElectricCar());
        testVehicle(new Bike());
    }
}
```

## Expected Output

```text
Fuel car: Engine started.
Fuel car: Trunk opened.

Fuel car: Engine started.
Fuel car: Accelerating using the engine.
Fuel car: Applying brakes.

Fuel car: Engine started.
Electric car: Motor started silently.
Bike: Engine started.

Fuel car: Engine started.
Fuel car: Accelerating using the engine.
Fuel car: Applying brakes.

Electric car: Motor started silently.
Electric car: Accelerating using the electric motor.
Electric car: Applying regenerative brakes.

Bike: Engine started.
Bike: Accelerating.
Bike: Applying brakes.
```

## What Is Happening Here?

### Step 1 — Interface

```java
interface Vehicle
```

defines the common contract:

```text
start()
accelerate()
brake()
```

It tells me **what a vehicle should be able to do**.

---

### Step 2 — Implementations

These classes implement the contract:

```java
FuelCar implements Vehicle
ElectricCar implements Vehicle
Bike implements Vehicle
```

Each class decides **how** those methods should work.

---

### Step 3 — Class Reference

```java
FuelCar car = new FuelCar();
```

Here:

```text
Reference type → FuelCar
Actual object  → FuelCar
```

Therefore I can access:

```java
car.openTrunk();
```

because `openTrunk()` belongs specifically to `FuelCar`.

---

### Step 4 — Interface Reference

```java
Vehicle vehicle = new FuelCar();
```

Here:

```text
Reference type → Vehicle
Actual object  → FuelCar
```

I can access:

```java
vehicle.start();
vehicle.accelerate();
vehicle.brake();
```

because these methods are part of the `Vehicle` contract.

But I cannot directly do:

```java
vehicle.openTrunk();
```

because `openTrunk()` is not part of `Vehicle`.

---

### Step 5 — Runtime Polymorphism

```java
Vehicle vehicle1 = new FuelCar();
Vehicle vehicle2 = new ElectricCar();
Vehicle vehicle3 = new Bike();
```

All three references have the same type:

```text
Vehicle
```

But they point to different objects:

```text
vehicle1 → FuelCar
vehicle2 → ElectricCar
vehicle3 → Bike
```

So when I call:

```java
vehicle1.start();
vehicle2.start();
vehicle3.start();
```

Java chooses the correct implementation based on the **actual object**.

That is runtime polymorphism.

---

### Step 6 — Interface as a Method Parameter

The method:

```java
static void testVehicle(Vehicle vehicle)
```

does not care about the specific class.

It only requires:

```text
"Give me anything that follows the Vehicle contract."
```

So all of these are valid:

```java
testVehicle(new FuelCar());
testVehicle(new ElectricCar());
testVehicle(new Bike());
```

This is one of the biggest practical benefits of interfaces.

---

# 13. Using an Interface as a Method Parameter

This is where the concept becomes even more useful.

I can create a method:

```java
static void startVehicle(Vehicle vehicle) {

    vehicle.start();
}
```

Now I can pass different implementations:

```java
startVehicle(new FuelCar());
startVehicle(new ElectricCar());
startVehicle(new Bike());
```

I don't need separate methods such as:

```text
startFuelCar()
startElectricCar()
startBike()
```

I only need:

```java
startVehicle(Vehicle vehicle);
```

The method is basically saying:

> I don't care which vehicle you give me. I only care that it follows the `Vehicle` contract.

This makes my code more flexible and easier to extend.

---

# 14. Memory POV

Consider:

```java
Vehicle vehicle = new FuelCar();
```

The reference and object are two different things.

Conceptually:

```text
Stack                         Heap

vehicle ──────────────────→ FuelCar Object
                              |
                              ├── start()
                              ├── accelerate()
                              ├── brake()
                              └── openTrunk()
```

The actual object is:

```text
FuelCar
```

The reference type is:

```text
Vehicle
```

So I can think of it as:

```text
Actual Object
     ↓
FuelCar

Reference
     ↓
Vehicle view
```

The object remains a `FuelCar`.

The interface reference simply lets me interact with that object through the `Vehicle` contract.

---

# 15. Multiple Interfaces

Java also allows a class to implement multiple interfaces.

For example:

```java
interface Camera {

    void takePhoto();
}

interface GPS {

    void getLocation();
}
```

A class can implement both:

```java
class Smartphone implements Camera, GPS {

    @Override
    public void takePhoto() {
        System.out.println("Taking photo.");
    }

    @Override
    public void getLocation() {
        System.out.println("Getting location.");
    }
}
```

Here:

```text
Camera ────────┐
               ↓
           Smartphone
               ↑
GPS ───────────┘
```

The `Smartphone` class follows both contracts.

This is important because Java does not allow a class to extend multiple classes.

This is invalid:

```java
class Smartphone extends Camera, GPS {
}
```

But this is valid:

```java
class Smartphone implements Camera, GPS {
}
```

So interfaces allow me to combine multiple contracts in one class.

---

# 16. Interface vs Abstract Class

Both interfaces and abstract classes can be used for abstraction, but they are designed for slightly different purposes.

| Abstract Class                         | Interface                                          |
| -------------------------------------- | -------------------------------------------------- |
| Declared using `abstract class`        | Declared using `interface`                         |
| Class extends it using `extends`       | Class implements it using `implements`             |
| A class can extend only one class      | A class can implement multiple interfaces          |
| Can have instance variables            | Fields are `public static final` by default        |
| Can have constructors                  | Cannot have constructors                           |
| Can have abstract and concrete methods | Can have abstract, `default`, and `static` methods |
| Useful for a common base               | Useful for a common contract                       |

My mental model is:

```text
Abstract Class
      ↓
Common base
      ↓
Shared state + shared behavior
```

while:

```text
Interface
      ↓
Common contract
      ↓
A class agrees to provide certain behavior
```

A simple way to decide is:

```text
Do these classes share a common base/state?
                ↓
          Abstract Class


Do these classes simply need to follow
the same behavior/contract?
                ↓
             Interface
```

---

# 17. The Mental Model I Should Remember

The easiest way for me to remember an interface is:

```text
Interface
    ↓
Contract
    ↓
Class agrees to follow it
    ↓
Class provides implementation
```

For example:

```text
Vehicle
   ↓
"Every vehicle must be able to start."
   ↓
FuelCar
   ↓
"Here is how I start."
```

So:

```text
Interface → WHAT
Class     → HOW
```

And when using references:

```text
Class reference
      ↓
Specific implementation
```

while:

```text
Interface reference
      ↓
Common contract
      ↓
Different implementations
```

---

# Practice Exercises

## Exercise 1 — Payment System

Create an interface:

```java
Payment
```

with:

```java
void pay(double amount);
```

Create three implementing classes:

```text
UPIPayment
CreditCardPayment
PayPalPayment
```

Each class should provide its own implementation of `pay()`.

Then create:

```java
Payment payment = new UPIPayment();
```

Call:

```java
payment.pay(5000);
```

Then change the actual object:

```java
payment = new CreditCardPayment();
```

and:

```java
payment = new PayPalPayment();
```

Observe how the same interface reference can point to different implementation objects.

---

## Exercise 2 — Smartphone

Create two interfaces:

```text
Camera
GPS
```

Give them methods:

```text
takePhoto()
getLocation()
```

Create a `Smartphone` class that implements both interfaces.

Then create a `Smartphone` object and call both methods.

---

## Exercise 3 — Vehicle System

Create an interface:

```java
Vehicle
```

with:

```java
start()
accelerate()
brake()
```

Create:

```text
FuelCar
ElectricCar
Bike
```

Implement the interface in all three classes.

Then create:

```java
Vehicle v1 = new FuelCar();
Vehicle v2 = new ElectricCar();
Vehicle v3 = new Bike();
```

Call the same methods on all three references and observe how each object behaves differently.

---

# Common Mistakes I Should Avoid

## Mistake 1 — Using `extends` Instead of `implements`

A class extends another class:

```java
class Dog extends Animal {
}
```

A class implements an interface:

```java
class Dog implements Animal {
}
```

So I should remember:

```text
Class → extends → Class

Class → implements → Interface
```

---

## Mistake 2 — Trying to Create an Interface Object

I cannot do:

```java
Vehicle vehicle = new Vehicle();
```

An interface does not represent a concrete implementation.

Instead:

```java
Vehicle vehicle = new FuelCar();
```

Here:

```text
Vehicle → reference type
FuelCar → actual object
```

---

## Mistake 3 — Forgetting Interface Methods

If a normal class implements an interface, it must provide implementations for its required abstract methods.

```java
interface Vehicle {

    void start();
}
```

So:

```java
class FuelCar implements Vehicle {

    @Override
    public void start() {
        System.out.println("Starting...");
    }
}
```

---

## Mistake 4 — Confusing Reference Type and Object Type

For:

```java
Vehicle vehicle = new FuelCar();
```

remember:

```text
Reference type → Vehicle
Actual object  → FuelCar
```

The reference type does not change the actual object.

---

## Mistake 5 — Thinking Interface References Are Always Better

They are not automatically better.

If I specifically need `FuelCar` functionality:

```java
FuelCar car = new FuelCar();
```

makes sense.

If I only need common vehicle behavior:

```java
Vehicle car = new FuelCar();
```

is usually more flexible.

So I should choose the reference type based on what my code actually needs.

---

# Key Takeaways

* An **interface** defines a contract that implementing classes agree to follow.
* I use the `interface` keyword to create an interface.
* A class uses `implements` to implement an interface.
* Interface methods define behavior that implementing classes provide.
* Interfaces are an important way to achieve abstraction.
* A class can implement multiple interfaces.
* A class cannot extend multiple classes.
* A class reference gives me access to the specific class's view.
* An interface reference gives me access to the behavior promised by the interface.
* The actual object does not change when I change the reference type.
* Interface references become powerful when multiple classes implement the same interface.
* Interfaces and runtime polymorphism work closely together.
* I should use a class reference when I need specific implementation behavior.
* I should use an interface reference when I only care about the common contract.

The most important idea I want to remember is:

```text
Reference type
      ↓
What I can directly access

Actual object
      ↓
What actually exists


Class reference
      ↓
Specific implementation


Interface reference
      ↓
Common contract
      ↓
Different implementations
```

---

# Lesson Files

```text
L10_Interfaces/
│
├── README.md
├── C01_Interfaces.java
├── C02_InterfaceReferences.java
└── C03_MultipleInterfaces.java
```

### `C01_Interfaces.java`

I will learn the basic structure of an interface, the `implements` keyword, and how a class provides implementations for interface methods.

### `C02_InterfaceReferences.java`

I will learn the difference between a class reference and an interface reference, and how interface references connect with runtime polymorphism.

### `C03_MultipleInterfaces.java`

I will learn how one class can implement multiple interfaces and why this is useful in Java.

---

# Final Mental Picture

```text
                         INTERFACE
                             |
                             ↓
                          CONTRACT
                             |
                       "WHAT to do?"
                             |
              +--------------+--------------+
              |              |              |
              ↓              ↓              ↓
           FuelCar      ElectricCar       Bike
              |              |              |
              ↓              ↓              ↓
             HOW            HOW            HOW
```

When I write:

```java
Vehicle vehicle = new FuelCar();
```

I can think of it as:

```text
                         Vehicle
                            |
                            ↓
                    Common contract
                            |
                            ↓
                    Vehicle reference
                            |
                            ↓
                      FuelCar object
                            |
                            ↓
                  FuelCar implementation
```

The simplest way for me to remember interfaces is:

> **An interface defines the contract. The implementing class defines the behavior.**

And when I use an interface as a reference:

> **I am choosing to work with what the object can do through the common contract, rather than tying my code to one specific implementation.**
