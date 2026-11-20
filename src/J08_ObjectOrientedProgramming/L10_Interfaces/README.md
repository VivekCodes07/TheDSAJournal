# L10 — Interfaces

## Why am I learning this?

Before starting this lesson, I have already learned:

- **Classes and Objects:** How to create objects and define their behavior.
- **Inheritance:** How one class can inherit properties and methods from another class.
- **Abstraction:** How to expose essential functionality while hiding implementation details.
- **Polymorphism:** How the same reference or method call can produce different behavior.

Now I want to understand something.

Imagine I am building an application that supports different payment methods:

- UPI Payment
- Card Payment
- Net Banking

All these payment methods perform a common operation: `pay()`.

However, their internal implementations are completely different.

UPI might use a UPI ID, card payment might use card details, and net banking might redirect the user to a banking portal.

I want all these classes to follow a common structure without forcing them to inherit from the same parent class.

This is exactly where interfaces become useful.

An interface allows me to define a common contract that different classes can implement.

By the end of this lesson, I want to understand how interfaces work, how they differ from abstract classes, and how they help me write flexible Java programs.

---

## 1. What Is an Interface?

An interface is a reference type in Java that defines a contract for classes that implement it.

It tells a class which operations it must provide, without necessarily specifying how those operations should work.

Let's create a simple interface:

```java
interface Payment {
    void pay();
}
```

Here:

- `interface` is the keyword used to declare an interface.
- `Payment` is the interface name.
- `pay()` is a method declaration.

Notice that `pay()` does not have a method body.

The interface only declares the operation. It does not provide its implementation.

Now, another class can implement this interface and define what `pay()` actually does.

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing UPI payment");
    }
}
```

Another class can implement the same interface differently:

```java
class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing Card payment");
    }
}
```

Both classes follow the same contract, but their implementations are different.

This is the fundamental idea of an interface.

### What Is a Contract?

A contract is a set of rules that a class agrees to follow.

When I write:

```java
class UpiPayment implements Payment
```

I am saying that `UpiPayment` agrees to provide the functionality required by `Payment`.

If the interface declares three abstract methods, a concrete implementing class must provide implementations for all three.

Otherwise, Java reports a compilation error.

An interface therefore establishes a common structure across different classes.

---

## 2. Creating and Implementing an Interface

Let's understand the syntax properly.

### Step 1 — Create an Interface

```java
interface Animal {
    void sound();
}
```

I use the `interface` keyword instead of `class`.

The method `sound()` is declared without a body.

### Step 2 — Implement the Interface

```java
class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

Here, I use the `implements` keyword.

The `Dog` class agrees to follow the contract defined by `Animal`.

It provides the actual implementation of `sound()`.

### Step 3 — Create an Object

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sound();
    }
}
```

Output:

```text
Dog barks
```

### Why Do We Use `implements` Instead of `extends`?

Because a class implements an interface, whereas a class extends another class.

```java
class Dog extends Animal {
}
```

This is invalid if `Animal` is an interface.

The correct syntax is:

```java
class Dog implements Animal {
}
```

I will cover interface-to-interface inheritance later.

---

## 3. Rules of Interface Methods

There is an important rule about methods declared inside an interface.

Consider:

```java
interface Animal {
    void sound();
}
```

Java automatically treats this method as:

```java
interface Animal {
    public abstract void sound();
}
```

This means interface methods declared without a body are implicitly:

- `public`
- `abstract`

I do not need to write these keywords explicitly.

### Why Must the Implemented Method Be Public?

Consider:

```java
class Dog implements Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

This produces a compilation error.

Why?

The interface method is implicitly public, but the implementing method has package-private visibility.

Java does not allow me to reduce the visibility of an overridden method.

Therefore, I must write:

```java
class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

**Remember:** Abstract methods declared in an interface are public by default, so their implementations must also be public.

### What If a Class Does Not Implement Every Method?

Consider:

```java
interface Animal {

    void sound();

    void eat();
}
```

Now:

```java
class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

This class is incomplete because it has not implemented `eat()`.

Java reports a compilation error.

However, I can declare the implementing class as abstract:

```java
abstract class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

An abstract class can leave some interface methods unimplemented.

A concrete subclass must eventually implement all remaining abstract methods.

---

## 4. Interface References and Objects

This is one of the most important concepts in this lesson.

Consider:

```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }
}
```

Now look at this statement:

```java
Payment payment = new UpiPayment();
```

Let's break it down.

### Reference Type

```java
Payment payment;
```

The reference variable `payment` has the type `Payment`.

This means the compiler checks which members are available through the `Payment` interface.

### Actual Object Type

```java
new UpiPayment();
```

This creates an actual `UpiPayment` object.

The reference variable points to that object.

Conceptually:

```text
Stack                         Heap

payment -------------------> UpiPayment Object
                              |
                              | pay()
                              |
```

So:

- Reference type = `Payment`
- Actual object type = `UpiPayment`

This is valid because `UpiPayment` implements `Payment`.

### Can I Call the Method?

Yes.

```java
Payment payment = new UpiPayment();

payment.pay();
```

Output:

```text
UPI Payment
```

Why?

Because `pay()` is declared in the `Payment` interface.

The compiler allows me to call it through the interface reference.

At runtime, Java executes the implementation provided by the actual object, which is `UpiPayment`.

This brings us to runtime polymorphism.

---

## 5. Runtime Polymorphism Using Interfaces

In the previous lesson, I learned that a parent class reference can point to a child class object.

For example:

```java
Animal animal = new Dog();
```

The same concept works with interfaces.

Consider:

```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment through Card");
    }
}
```

Now:

```java
public class Main {

    public static void main(String[] args) {

        Payment payment;

        payment = new UpiPayment();
        payment.pay();

        payment = new CardPayment();
        payment.pay();
    }
}
```

Output:

```text
Payment through UPI
Payment through Card
```

### Let's Understand the Execution

First assignment:

```java
payment = new UpiPayment();
payment.pay();
```

- Reference type: `Payment`
- Actual object type: `UpiPayment`
- Executed method: `UpiPayment.pay()`

Second assignment:

```java
payment = new CardPayment();
payment.pay();
```

- Reference type: `Payment`
- Actual object type: `CardPayment`
- Executed method: `CardPayment.pay()`

The same interface reference can point to different implementing objects.

The JVM selects the appropriate overridden instance method based on the actual object at runtime.

This is called **Runtime Polymorphism**, also known as **Dynamic Method Dispatch**.

### Compile-Time vs Runtime

| Compile-time | Runtime |
|---|---|
| Compiler checks the reference type | JVM uses the actual object's method implementation |
| Checks whether the method exists in the interface | Executes the appropriate implementation |
| `Payment` | `UpiPayment` or `CardPayment` |

This is the same concept I studied in L09, except now I am using an interface instead of a parent class.

---

## 6. Why Can't I Access Class-Specific Methods Through an Interface Reference?

Consider:

```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }

    public void scanQR() {
        System.out.println("Scanning QR code");
    }
}
```

Now:

```java
Payment payment = new UpiPayment();

payment.pay();
payment.scanQR();
```

The second method call produces a compilation error.

Why?

Because `scanQR()` is not declared inside the `Payment` interface.

The compiler checks the reference type, which is `Payment`.

It only allows methods available through that reference type.

Even though the actual object is `UpiPayment`, the reference cannot directly access `scanQR()`.

### How Can I Access the Class-Specific Method?

I can use type casting.

```java
Payment payment = new UpiPayment();

if (payment instanceof UpiPayment) {

    UpiPayment upi = (UpiPayment) payment;

    upi.scanQR();
}
```

Output:

```text
Scanning QR code
```

The `instanceof` check makes sure the actual object is compatible with `UpiPayment` before casting.

However, I should not use casting unnecessarily.

The main purpose of interfaces is to let me work with common functionality without depending on individual implementations.

---

## 7. Implementing Multiple Interfaces

This is one of the biggest advantages of interfaces.

Java does not allow a class to extend multiple classes.

For example:

```java
class C extends A, B {
}
```

This is invalid Java.

But Java allows a class to implement multiple interfaces.

Consider a smartphone.

It can act as:

- A camera
- A music player

I can represent these capabilities using separate interfaces.

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}
```

Now a class can implement both:

```java
class Smartphone implements Camera, MusicPlayer {

    @Override
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }
}
```

Here, `Smartphone` implements two interfaces.

It must provide implementations for both interfaces' abstract methods.

### Why Is This Useful?

I do not need to create one complicated parent class containing every possible capability.

Instead, I can create separate interfaces for separate capabilities.

A class can implement whichever capabilities it supports.

For example:

```java
class Smartphone implements Camera, MusicPlayer {
}

class DigitalCamera implements Camera {
}

class MusicSystem implements MusicPlayer {
}
```

Each class implements only the capabilities it needs.

This is called **multiple inheritance of type through interfaces**.

Important: Java still does not support multiple inheritance of classes. A class can extend only one class but implement multiple interfaces.

---

## 8. Interface Inheritance — Extending Interfaces

Interfaces can also inherit from other interfaces.

For this, I use `extends`.

Consider:

```java
interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}
```

Here, `Pet` extends `Animal`.

That means `Pet` inherits the contract of `Animal`.

Now a class implementing `Pet` must provide both methods:

```java
class Dog implements Pet {

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing");
    }
}
```

Why both?

Because `Pet` inherits the abstract method `eat()` from `Animal` and declares its own method `play()`.

### Can an Interface Extend Multiple Interfaces?

Yes.

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

interface SmartDevice extends Camera, MusicPlayer {
    void connectInternet();
}
```

Now a class implementing `SmartDevice` must implement all three methods.

### Important Rules

| Relationship | Keyword |
|---|---|
| Class extends another class | `extends` |
| Class implements an interface | `implements` |
| Interface extends another interface | `extends` |
| Class implements multiple interfaces | `implements A, B` |

---

## 9. Default Methods in Interfaces

Until now, I have seen methods declared without a body.

But Java also allows interfaces to contain methods with implementations.

One such method is called a **default method**.

Example:

```java
interface Payment {

    void pay();

    default void showReceipt() {
        System.out.println("Payment receipt generated");
    }
}
```

Notice that `showReceipt()` has a method body.

Now:

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }
}
```

I only implemented `pay()`.

I did not implement `showReceipt()`.

Why?

Because `showReceipt()` already has an implementation in the interface.

I can call both methods:

```java
public class Main {

    public static void main(String[] args) {

        UpiPayment payment = new UpiPayment();

        payment.pay();
        payment.showReceipt();
    }
}
```

Output:

```text
UPI Payment
Payment receipt generated
```

### Can I Override a Default Method?

Yes.

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }

    @Override
    public void showReceipt() {
        System.out.println("UPI receipt generated");
    }
}
```

The implementing class can use the default implementation or provide its own.

### Why Were Default Methods Introduced?

Imagine an interface is already implemented by hundreds of classes.

Now I want to add a new method to that interface.

If I add a new abstract method, all existing concrete implementing classes would need to implement it.

That could break existing code.

Default methods allow me to add a method with an existing implementation, helping maintain backward compatibility.

---

## 10. Static Methods in Interfaces

An interface can also contain static methods.

Example:

```java
interface Payment {

    void pay();

    static void showInfo() {
        System.out.println("Payment interface");
    }
}
```

I can call the static method using the interface name:

```java
public class Main {

    public static void main(String[] args) {

        Payment.showInfo();
    }
}
```

Output:

```text
Payment interface
```

Important points:

- Static methods belong to the interface.
- They are called using the interface name.
- They are not inherited as ordinary instance methods by implementing classes.
- They cannot be overridden in the runtime-polymorphism sense.

This is different from a default method, which is an instance method available through implementing objects.

---

## 11. Private Methods in Interfaces

Java 9 introduced private methods in interfaces.

Why?

Suppose an interface contains multiple default methods that share some common logic.

Instead of repeating that logic, I can put it inside a private method.

Example:

```java
interface Payment {

    default void upiPayment() {
        validate();
        System.out.println("Processing UPI payment");
    }

    default void cardPayment() {
        validate();
        System.out.println("Processing Card payment");
    }

    private void validate() {
        System.out.println("Validating payment");
    }
}
```

Here:

- `upiPayment()` is a default method.
- `cardPayment()` is a default method.
- `validate()` is a private helper method.

Both default methods can use `validate()`.

But an implementing class cannot directly call the private method.

Private interface methods help reuse internal logic without exposing it to implementing classes.

They can be instance or static methods.

---

## 12. Variables in Interfaces

Variables declared inside an interface are implicitly:

- `public`
- `static`
- `final`

Example:

```java
interface Payment {

    int MAX_AMOUNT = 100000;
}
```

This is equivalent to:

```java
interface Payment {

    public static final int MAX_AMOUNT = 100000;
}
```

Let's understand what these keywords mean.

- `public`: The constant can be accessed publicly.
- `static`: It belongs to the interface itself, not individual objects.
- `final`: Its value cannot be reassigned.

I can access it using:

```java
System.out.println(Payment.MAX_AMOUNT);
```

But this is invalid:

```java
Payment.MAX_AMOUNT = 200000;
```

Java reports a compilation error because the variable is final.

An interface cannot contain ordinary mutable instance variables like a normal class.

---

## 13. What Happens When Multiple Interfaces Have the Same Default Method?

Consider:

```java
interface A {

    default void show() {
        System.out.println("A");
    }
}

interface B {

    default void show() {
        System.out.println("B");
    }
}
```

Now:

```java
class Test implements A, B {
}
```

This creates a conflict.

Both interfaces provide a default implementation of `show()`.

Java cannot automatically decide which implementation should be used.

Therefore, the implementing class must resolve the conflict.

```java
class Test implements A, B {

    @Override
    public void show() {
        System.out.println("Test implementation");
    }
}
```

Alternatively, I can explicitly call one interface's default implementation:

```java
class Test implements A, B {

    @Override
    public void show() {
        A.super.show();
    }
}
```

Output:

```text
A
```

This is how Java handles conflicting default methods.

---

## 14. Abstract Class vs Interface

This is one of the most important topics in Java OOP.

Both abstract classes and interfaces help me achieve abstraction, but they serve different purposes.

The easiest way to understand their difference is through a real-world example.

### Abstract Class — Common Identity

Imagine I have:

- Car
- Bike
- Truck

All three are vehicles.

They share some common characteristics:

- Brand
- Speed
- Starting behavior
- Stopping behavior

I can create an abstract class called `Vehicle` to represent their common structure.

```java
abstract class Vehicle {

    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    abstract void start();

    void stop() {
        System.out.println(brand + " has stopped");
    }
}
```

Now a child class can extend it:

```java
class Car extends Vehicle {

    Car(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(brand + " car started");
    }
}
```

Here, `Vehicle` provides:

- Shared instance state through `brand`.
- A constructor.
- A common method through `stop()`.
- An abstract method through `start()`.

This is useful when related classes share common state and behavior.

### Interface — Common Capability

Now imagine:

- Bird
- Aeroplane
- Drone

They are completely different types of objects.

However, all three can have one common capability: flying.

I can represent this capability through an interface.

```java
interface Flyable {
    void fly();
}
```

Now:

```java
class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Aeroplane implements Flyable {

    @Override
    public void fly() {
        System.out.println("Aeroplane is flying");
    }
}
```

Both classes can fly, but they are not necessarily part of the same class hierarchy.

The interface defines a common capability without forcing them to share a parent class.

### Complete Comparison

| Abstract Class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| A class extends it | A class implements it |
| Can have constructors | Cannot have constructors |
| Can have instance variables | Cannot have ordinary instance variables |
| Can maintain object state | Cannot maintain ordinary per-object state |
| Can contain abstract and concrete methods | Can contain abstract, default, static and private methods |
| Members can have different access modifiers | Abstract methods are implicitly public |
| A class can extend only one class | A class can implement multiple interfaces |
| Useful for shared state and implementation | Useful for defining contracts and capabilities |

### Can We Use Both Together?

Absolutely.

A class can extend an abstract class and implement multiple interfaces.

```java
abstract class Vehicle {

    abstract void start();
}

interface GPS {

    void navigate();
}

class Car extends Vehicle implements GPS {

    @Override
    void start() {
        System.out.println("Car started");
    }

    @Override
    public void navigate() {
        System.out.println("GPS navigation started");
    }
}
```

Here:

- `Car` extends one abstract class: `Vehicle`.
- `Car` implements one interface: `GPS`.
- It provides implementations for both contracts.

This is perfectly valid Java.

### When Should I Use Which?

Use an abstract class when:

- Related classes share a common identity.
- They need common instance variables.
- They need constructors.
- They share common implementation.
- I want to provide a common base for related classes.

Use an interface when:

- Different classes need to follow the same contract.
- I want to represent a capability.
- Classes may already extend different parent classes.
- I want a class to implement multiple capabilities.
- I want to work with a common type rather than a specific implementation.

**My mental model:**

- Abstract class = What common state and behavior do related objects share?
- Interface = What capability or contract can different objects provide?

---

## 15. Real-World Application — Payment System

Now let's combine interfaces, interface references and runtime polymorphism in one example.

Suppose I am building a payment application.

I want to support different payment methods without making the main application dependent on a specific implementation.

First, I create an interface:

```java
interface PaymentMethod {

    void pay(double amount);

    default void showReceipt() {
        System.out.println("Receipt generated");
    }
}
```

Now I create UPI payment:

```java
class UpiPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
```

Then Card payment:

```java
class CardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}
```

Now I create the main application:

```java
public class Main {

    public static void main(String[] args) {

        PaymentMethod payment;

        payment = new UpiPayment();
        payment.pay(500);
        payment.showReceipt();

        payment = new CardPayment();
        payment.pay(1000);
        payment.showReceipt();
    }
}
```

Output:

```text
Paid 500.0 using UPI
Receipt generated
Paid 1000.0 using Card
Receipt generated
```

### What Did I Achieve?

1. Both payment classes follow the same interface contract.
2. Each class provides its own implementation of `pay()`.
3. The main application works with the `PaymentMethod` reference.
4. I can introduce another payment implementation without changing the interface contract.
5. Runtime polymorphism selects the appropriate implementation.

This is how interfaces help create loosely coupled and extensible applications.

---

## 16. Important Rules and Common Mistakes

I should remember these rules:

1. An interface cannot be instantiated directly.
2. A class uses `implements` to implement an interface.
3. An interface can extend one or multiple interfaces.
4. A class can implement multiple interfaces.
5. A concrete implementing class must implement all inherited abstract methods.
6. Interface abstract methods are implicitly public and abstract.
7. Implemented abstract methods must be public.
8. Interface variables are implicitly public, static and final.
9. Interfaces cannot have constructors.
10. Default methods have implementations and can be inherited by implementing classes.
11. Static interface methods are called using the interface name.
12. Private interface methods help reuse internal implementation logic.
13. An interface reference can point to an object of an implementing class.
14. The reference type controls which members are accessible.
15. The actual object type determines which overridden instance method executes.
16. A class can extend only one class but implement multiple interfaces.
17. Conflicting default methods must be resolved by the implementing class.

---

## 17. Final Mental Picture

I should be able to understand the entire interface concept through this progression:

```text
                 Interface
                     |
                     | Defines a contract
                     |
          -------------------------
          |                       |
     UpiPayment              CardPayment
          |                       |
     Implements                Implements
          |                       |
     pay() method             pay() method
          |                       |
          -------------------------
                     |
                     |
              Interface Reference
                     |
                     |
            Runtime Polymorphism
                     |
                     |
          Appropriate implementation
              executes at runtime
```

The most important statement to remember:

```java
PaymentMethod payment = new UpiPayment();
```

- `PaymentMethod` is the reference type.
- `UpiPayment` is the actual object type.
- The compiler checks whether the method is available through `PaymentMethod`.
- At runtime, the JVM executes the implementation provided by `UpiPayment`.

An interface defines what a class must be capable of doing. The implementing class defines how it actually does it.

---

## 18. What I Should Be Able to Explain After This Lesson

### Basic Understanding

- What is an interface?
- Why do we need interfaces?
- What is a contract?
- How do I create and implement an interface?
- What is the difference between `extends` and `implements`?

### Interface References and Polymorphism

- Can an interface reference point to an implementing class object?
- What is the difference between reference type and actual object type?
- Why can I call an interface method but not a class-specific method?
- How does runtime polymorphism work through interfaces?

### Multiple Interfaces

- Can a class implement multiple interfaces?
- Can an interface extend multiple interfaces?
- What happens when a class implements two interfaces?
- What happens when two interfaces have the same default method?

### Advanced Concepts

- What are default methods?
- Why were default methods introduced?
- What are static methods in interfaces?
- What are private methods in interfaces?
- Why are interface variables implicitly public, static and final?

### Abstract Class vs Interface

- What is an abstract class?
- How is it different from an interface?
- When should I use an abstract class?
- When should I use an interface?
- Can a class extend an abstract class and implement multiple interfaces together?

---

## 19. Practice Questions

### Conceptual Questions

1. Define an interface in Java with an example.
2. Explain the purpose of the `implements` keyword.
3. Why must interface abstract methods be implemented as public?
4. Explain runtime polymorphism using an interface.
5. Can a class implement multiple interfaces? Explain with an example.
6. Can an interface extend multiple interfaces?
7. What are default methods and why were they introduced?
8. Explain static and private methods in interfaces.
9. Differentiate between an abstract class and an interface.
10. Can a class extend an abstract class and implement multiple interfaces?

### Output-Based Questions

**Question 1 — Interface Reference**

```java
interface A {
    void show();
}

class B implements A {

    @Override
    public void show() {
        System.out.println("Class B");
    }
}

public class Main {

    public static void main(String[] args) {

        A obj = new B();

        obj.show();
    }
}
```

Predict the output and explain why.

**Question 2 — Multiple Interfaces**

```java
interface A {
    void show();
}

interface B {
    void display();
}

class Test implements A, B {

    @Override
    public void show() {
        System.out.println("Showing A");
    }

    @Override
    public void display() {
        System.out.println("Displaying B");
    }
}
```

How many methods must `Test` implement? Why?

**Question 3 — Reference Type**

```java
interface Animal {
    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    public void eat() {
        System.out.println("Dog eats");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();
        animal.eat();
    }
}
```

Will the program compile? Explain both method calls.

**Question 4 — Default Method**

```java
interface A {

    default void show() {
        System.out.println("Interface A");
    }
}

class B implements A {
}

public class Main {

    public static void main(String[] args) {

        B obj = new B();

        obj.show();
    }
}
```

Predict the output. Why doesn't class `B` need to implement `show()`?

---

## Final Takeaway

An interface allows different classes to follow a common contract without forcing them to share the same class hierarchy.

Each class can provide its own implementation, while the rest of the application interacts with objects through a common interface reference.

This gives me flexibility, loose coupling and runtime polymorphism.

**Interface = Common contract.**

**Implementing class = Actual implementation.**

**Interface reference = A common way to work with different implementations.**
