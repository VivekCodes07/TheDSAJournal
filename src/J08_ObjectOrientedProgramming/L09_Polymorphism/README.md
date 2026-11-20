# L09 — Polymorphism

## Why am I learning this?

Before learning polymorphism, I already understood classes, objects, inheritance, and methods.

But there was something interesting about inheritance.

Suppose I have an `Animal` class and a `Dog` class that extends it. Both classes can have a method called `sound()`.

Now imagine I write:

```java
Animal animal = new Dog();
animal.sound();
```

The reference type is `Animal`, but the actual object is `Dog`.

So which `sound()` method will Java execute?

This is where polymorphism comes into the picture.

Polymorphism allows the same method call or reference to behave differently depending on the situation.

It helps me write flexible and reusable code without repeatedly checking which specific object I am working with.

## 1. What exactly is Polymorphism?

The word Polymorphism comes from two words:

- Poly = Many
- Morph = Forms

So, polymorphism means **one thing having many forms**.

In Java, polymorphism allows the same method name or common parent reference to represent different behaviors.

For example, imagine different animals:

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

Here, all three classes have a method named `sound()`.

But the behavior is different:

- Animal → Animal makes a sound
- Dog → Dog barks
- Cat → Cat meows

The method call remains the same, but the behavior can change depending on the object.

This is polymorphism.

## 2. Types of Polymorphism in Java

Java mainly supports two types of polymorphism:

1. Compile-time Polymorphism
2. Runtime Polymorphism

Let's understand them separately.

## 3. Compile-time Polymorphism — Method Overloading

Compile-time polymorphism is achieved through **method overloading**.

Method overloading means creating multiple methods with the same name but different parameter lists inside the same class.

The parameters can differ by:

- Number of parameters
- Type of parameters
- Order of parameter types

Example:

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

All three methods have the same name: `add()`.

But their parameters are different.

Now let's call them:

```java
public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println(calc.add(10, 20));

        System.out.println(calc.add(10, 20, 30));

        System.out.println(calc.add(10.5, 20.5));
    }
}
```

Output:

```text
30
60
31.0
```

### How does Java decide which method to call?

This is the important part.

When Java sees:

```java
calc.add(10, 20);
```

The compiler checks the available `add()` methods and their parameter lists.

It finds:

```java
int add(int a, int b)
```

So this method is selected.

When Java sees:

```java
calc.add(10, 20, 30);
```

It selects:

```java
int add(int a, int b, int c)
```

The compiler determines the applicable method during compilation.

That is why it is called compile-time polymorphism.

### Important rule: Return type alone cannot overload a method

This is invalid:

```java
int calculate(int a, int b) {
    return a + b;
}

double calculate(int a, int b) {
    return a + b;
}
```

Why?

Because both methods have exactly the same name and parameter list.

Changing only the return type does not create a valid overloaded method.

### What if I change only the parameter names?

This is also invalid:

```java
void show(int age) {
}

void show(int marks) {
}
```

Both methods have the same parameter type and count.

Parameter names do not decide overloading.

### What I should remember

Method overloading:
- Same method name.
- Different parameter lists.
- Usually happens within the same class.
- The compiler selects the applicable overloaded method.

## 4. Runtime Polymorphism — Method Overriding

Runtime polymorphism is achieved through **method overriding**.

Method overriding happens when a child class provides its own implementation of an instance method that it inherits from its parent class.

Let's understand this using inheritance.

```java
class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Here:

- `Animal` is the parent class.
- `Dog` is the child class.
- Both classes have a method named `sound()`.
- The child class provides its own implementation of the inherited method.

This is method overriding.

Now let's create an object:

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

The child class implementation is executed instead of the parent class implementation.

But runtime polymorphism becomes more interesting when we use a parent class reference.

## 5. Parent Reference and Child Object

Consider this statement:

```java
Animal animal = new Dog();
```

This is one of the most important statements in Java OOP.

Let's break it into two parts.

```java
Animal animal
```

This declares a reference variable named `animal` whose reference type is `Animal`.

```java
new Dog()
```

This creates an actual `Dog` object.

So we have:

- Reference type = Animal
- Actual object type = Dog

The reference type and actual object type do not always have to be the same.

This is possible because `Dog` extends `Animal`.

### Complete example

```java
class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();
    }
}
```

Output:

```text
Dog barks
```

But why?

The answer is **Dynamic Method Dispatch**.

## 6. Dynamic Method Dispatch

Dynamic Method Dispatch is the mechanism through which Java determines at runtime which overridden method should execute.

Let's understand the execution step by step.

### Step 1 — Object creation

```java
Animal animal = new Dog();
```

Java creates a `Dog` object in the heap.

The reference variable `animal` refers to that object.

Conceptually:

```text
Stack                         Heap

animal ---------------------> Dog Object
                               |
                               | sound()
                               | bark()
                               |
```

The actual object is a `Dog`, not an `Animal`.

### Step 2 — Method call

```java
animal.sound();
```

Now Java needs to decide which `sound()` implementation should execute.

Two important things happen:

**At compile-time:**

The compiler checks the reference type, which is `Animal`.

It checks whether `sound()` is accessible through the `Animal` reference.

Since `Animal` contains `sound()`, the method call is valid.

**At runtime:**

Java looks at the actual object type.

The actual object is `Dog`.

Since `Dog` overrides `sound()`, Java executes the `Dog` implementation.

Output:

```text
Dog barks
```

### The most important distinction

| Compile-time | Runtime |
|---|---|
| Reference type matters | Actual object type matters |
| Checks whether the method can be accessed | Selects the overridden implementation |
| Animal | Dog |

This is the core idea behind runtime polymorphism.

## 7. Why Can't I Call Every Child Class Method?

This is another important concept.

Consider:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void bark() {
        System.out.println("Barking...");
    }
}
```

Now:

```java
public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();

        animal.bark();
    }
}
```

This code will not compile.

Why?

Because `animal` is an `Animal` reference.

The compiler checks the members available through the `Animal` class.

`Animal` has `sound()`, but it does not have `bark()`.

Even though the actual object is a `Dog`, the compiler does not allow us to call `bark()` through an `Animal` reference.

This gives me an important rule:

**The reference type determines which members I can access, while the actual object type determines which overridden instance method executes.**

### Can I access the child-specific method?

Yes, by using type casting:

```java
Animal animal = new Dog();

Dog dog = (Dog) animal;

dog.bark();
```

Output:

```text
Barking...
```

Here, we explicitly cast the reference to `Dog`.

But I must be careful.

If the actual object is not a `Dog`, this cast can throw a `ClassCastException` at runtime.

A safer approach is to use `instanceof`:

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.bark();
}
```

## 8. One Parent Reference, Multiple Child Objects

Now let's understand why runtime polymorphism is useful.

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();

        animal = new Animal();
        animal.sound();
    }
}
```

Output:

```text
Dog barks
Cat meows
Animal sound
```

Notice something:

I created only one reference variable:

```java
Animal animal;
```

But that reference can point to different compatible objects at different times.

First, it refers to a `Dog` object.

Then, it refers to a `Cat` object.

Finally, it refers to an `Animal` object.

The same method call:

```java
animal.sound();
```

produces different behavior depending on the actual object.

This is runtime polymorphism in its clearest form.

## 9. Polymorphism with Methods and Arrays

Polymorphism becomes especially useful when I have multiple objects that share a common parent class.

For example:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Animal()
        };

        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
```

Output:

```text
Dog barks
Cat meows
Animal sound
```

I can store different child objects inside an array of their common parent type.

Then I can process all of them using the same loop.

I don't need separate loops for `Dog`, `Cat`, and `Animal`.

This is one practical advantage of polymorphism.

## 10. Method Overloading vs Method Overriding

I should never confuse these two concepts.

| Method Overloading | Method Overriding |
|---|---|
| Same method name, different parameters | Child class redefines inherited method |
| Usually within the same class | Requires inheritance |
| Compile-time polymorphism | Runtime polymorphism |
| Compiler selects the applicable overload | Runtime dispatch selects overridden implementation |
| Return type alone cannot distinguish overloads | Return type must be compatible with the overridden method |

Example of overloading:

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

Example of overriding:

```java
class Parent {

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child");
    }
}
```

## 11. Important Rules of Method Overriding

I need to remember these rules:

1. The child class must inherit the method from the parent class.
2. The method name and parameter list must match.
3. The return type must be the same or a compatible covariant return type.
4. The child class cannot reduce the visibility of the overridden method.
5. `private` methods cannot be overridden because they are not inherited.
6. `final` methods cannot be overridden.
7. `static` methods are hidden, not overridden.
8. Constructors cannot be overridden.
9. The `@Override` annotation helps the compiler verify that I am actually overriding a method.

### What is `@Override`?

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

`@Override` tells the compiler that I intend to override an inherited method.

If I accidentally write a different method signature, the compiler will report an error instead of silently treating it as an ordinary new method.

## 12. Special Case — Static Methods and Method Hiding

Static methods belong to the class rather than individual objects.

They are not overridden in the runtime-polymorphism sense.

Example:

```java
class Parent {

    static void show() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {

    static void show() {
        System.out.println("Child static method");
    }
}

public class Main {

    public static void main(String[] args) {

        Parent obj = new Child();

        obj.show();
    }
}
```

Output:

```text
Parent static method
```

Why?

Because static method calls are resolved using the reference type in this example.

This is called **Method Hiding**, not method overriding.

In real code, it is better to call static methods using the class name:

```java
Parent.show();
Child.show();
```

## 13. Special Case — Fields Are Not Polymorphic

Method overriding and field access behave differently.

Example:

```java
class Parent {

    int value = 10;
}

class Child extends Parent {

    int value = 20;
}

public class Main {

    public static void main(String[] args) {

        Parent obj = new Child();

        System.out.println(obj.value);
    }
}
```

Output:

```text
10
```

Even though the actual object is `Child`, the field is accessed using the reference type.

Fields are hidden, not overridden.

This is why I should not apply the dynamic method dispatch rule to fields.

## 14. Using `super` in Overridden Methods

Sometimes I want the child class to perform its own behavior while also calling the parent class implementation.

I can use `super`.

```java
class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {

        super.sound();

        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sound();
    }
}
```

Output:

```text
Animal makes a sound
Dog barks
```

`super.sound()` explicitly calls the parent class implementation.

## 15. Real-World Use of Polymorphism

Imagine I am building a payment application.

Different payment methods have different implementations:

- UPI payment
- Credit card payment
- Net banking payment

But all of them perform a common operation: `pay()`.

```java
class Payment {

    void pay() {
        System.out.println("Processing payment");
    }
}

class UpiPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Payment through UPI");
    }
}

class CardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Payment through Card");
    }
}

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

The main code doesn't need to know the internal implementation of every payment method.

It works with a common parent type.

In a real payment system, I would often use an interface such as `PaymentMethod` instead of a concrete parent class. The polymorphism concept remains the same.

## 16. Final Mental Picture

There are two important ideas I should remember.

### Compile-time Polymorphism

```text
Same method name
       |
Different parameters
       |
Compiler selects applicable method
       |
Method Overloading
```

### Runtime Polymorphism

```text
Parent Reference
       |
       v
Child Object
       |
       v
Overridden Method Call
       |
       v
JVM selects implementation
       |
       v
Child Class Method Executes
```

The most important statement in this entire lesson is:

```java
Animal animal = new Dog();
animal.sound();
```

- `Animal` determines which members are accessible through the reference.
- `Dog` determines which overridden instance method executes at runtime.

That is the foundation of runtime polymorphism in Java.

## 17. Common Mistakes I Should Avoid

1. Thinking that method overloading and overriding are the same.
2. Thinking that the reference type and actual object type must always match.
3. Assuming that a parent reference can directly access every child-specific method.
4. Assuming that all methods are selected at runtime.
5. Thinking that static methods are overridden.
6. Thinking that fields use dynamic method dispatch.
7. Forgetting that constructors cannot be overridden.
8. Forgetting to use `@Override` when overriding methods.

## 18. What I Should Be Able to Explain After This Lesson

- What is polymorphism and why do we need it?
- What are the two types of polymorphism in Java?
- What is method overloading?
- What is method overriding?
- What is the difference between overloading and overriding?
- What is runtime polymorphism?
- What is Dynamic Method Dispatch?
- What is the difference between reference type and actual object type?
- Why can a parent reference point to a child object?
- Why can't a parent reference access child-specific methods?
- What is method hiding?
- Why are fields not polymorphic?
- What is the use of `super` in an overridden method?
- What is the role of `@Override`?

## 19. Practice Questions

### Conceptual Questions

1. Define polymorphism with an example.
2. Explain compile-time and runtime polymorphism.
3. Explain method overloading with a Java program.
4. Explain method overriding with a Java program.
5. What is Dynamic Method Dispatch?
6. Differentiate between method overloading and method overriding.
7. Explain the difference between reference type and actual object type.
8. Can a parent class reference point to a child class object? Explain.
9. Can static methods be overridden? Explain method hiding.
10. Why can't constructors be overridden?

### Output-Based Questions

**Question 1**

```java
class A {

    void show() {
        System.out.println("A");
    }
}

class B extends A {

    @Override
    void show() {
        System.out.println("B");
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

**Question 2**

```java
class Calculator {

    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(double a, double b) {
        System.out.println(a + b);
    }
}

public class Main {

    public static void main(String[] args) {

        Calculator c = new Calculator();

        c.add(10, 20);
        c.add(10.5, 20.5);
    }
}
```

Predict the output. Which methods are selected?

**Question 3**

```java
class Parent {

    int value = 10;

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    int value = 20;

    @Override
    void show() {
        System.out.println("Child");
    }
}

public class Main {

    public static void main(String[] args) {

        Parent obj = new Child();

        System.out.println(obj.value);
        obj.show();
    }
}
```

Predict both outputs and explain why the field and method behave differently.

---

## Final takeaway

Polymorphism is not just about having multiple methods with the same name.

It is about writing code that can work with a common type while allowing different objects to provide their own behavior.

**One common reference, multiple possible implementations, and behavior selected according to the actual object at runtime.**