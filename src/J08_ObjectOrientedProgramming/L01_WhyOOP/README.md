# Lesson 1 — Why OOP?

## 🧠 What I am actually trying to understand

I don't want to start OOP by memorizing definitions.

I want to understand:

* Why did we need OOP?
* What problem is it solving?
* What exactly is an object?
* What exactly is a class?
* Why do objects need state and behavior?
* What does this have to do with memory?
* How does this help me build something like Netflix, Amazon, or Udemy?

My first mental shift is:

> **Instead of thinking only about the steps my program has to perform, I start thinking about the entities that exist inside my system.**

---

# 1. How I Used to Think About a Program

Before OOP, I naturally think like this:

```text
Data
  ↓
Methods
  ↓
Conditions
  ↓
Loops
  ↓
Output
```

For example, if I have to create a student program:

```java
String name = "Vivek";
int age = 20;
double cgpa = 8.2;
```

Then I might have methods like:

```java
void displayStudent() {
    // display student information
}
```

For a small program, this is completely fine.

But now imagine I have **10,000 students**.

I would start dealing with things like:

```text
student1Name
student1Age
student1Cgpa

student2Name
student2Age
student2Cgpa

student3Name
student3Age
student3Cgpa

...
```

Now the problem isn't that Java can't store the data.

The problem is that **I'm not modeling the actual thing properly**.

I'm treating one student as a bunch of unrelated variables.

I need a way to say:

> "This group of data and behavior belongs to a Student."

And this is where OOP starts making sense.

---

# 2. The Mental Shift OOP Gives Me

Instead of thinking:

```text
name
age
cgpa
rollNumber
marks
```

as separate pieces of data, I start thinking:

```text
                 STUDENT
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
        STATE              BEHAVIOR
          │                   │
       name                study()
       age                 attendClass()
       cgpa                giveExam()
       marks               displayInfo()
```

Now I'm treating `Student` as an actual entity.

It has:

```text
STATE + BEHAVIOR
```

This is one of my first important OOP mental models.

---

# 3. State — What Does an Object Know?

State means the information that describes the current condition of an object.

For a `Student`:

```text
name
age
rollNumber
cgpa
marks
```

For a Netflix `User`:

```text
name
email
subscriptionType
watchHistory
```

For an Amazon `Product`:

```text
productId
name
price
stock
category
```

So I can think:

> **State = the data an object has at a particular moment.**

---

# 4. Behavior — What Can an Object Do?

Behavior represents the actions associated with an object.

A Student might:

```text
study()
giveExam()
attendClass()
```

A Netflix user might:

```text
playMovie()
pauseMovie()
addToWatchlist()
```

An Amazon order might:

```text
placeOrder()
cancelOrder()
updateStatus()
```

So:

> **Behavior = what an object can do.**

Therefore:

```text
                 OBJECT
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
        STATE              BEHAVIOR
          │                   │
        data              methods/actions
```

---

# 5. Real-World Example — Netflix

Let's stop thinking about OOP as just a Java concept.

Imagine I'm building **Netflix**.

Netflix isn't one giant thing.

There are many entities:

```text
Netflix
   │
   ├── User
   ├── Movie
   ├── Series
   ├── Episode
   ├── Subscription
   ├── WatchHistory
   └── Payment
```

Each of these can become a meaningful object in my program.

For example:

```text
                    USER
                     │
           ┌─────────┴─────────┐
           ↓                   ↓
         STATE              BEHAVIOR
           │                   │
        name                play()
        email               pause()
        plan                stop()
        history             addToWatchlist()
```

Now imagine millions of Netflix users.

I don't want one giant variable containing information about everyone.

Instead, I can conceptually have:

```text
User Object 1 → Vivek
User Object 2 → Rahul
User Object 3 → Aman
User Object 4 → Priya
...
```

Every object follows the same basic model but has its own state.

For example:

```text
Vivek's User Object
-------------------
name = "Vivek"
plan = "Premium"


Rahul's User Object
-------------------
name = "Rahul"
plan = "Basic"
```

Same type of object.

Different state.

---

# 6. Real-World Example — Amazon

Now imagine I'm building Amazon.

What entities immediately come to my mind?

```text
User
Product
Cart
Order
Payment
Address
Delivery
```

A `Product` could have:

```text
STATE
----------------
productId
name
price
stock
rating
```

and behavior such as:

```text
BEHAVIOR
----------------
updatePrice()
updateStock()
checkAvailability()
```

An `Order` could have:

```text
STATE
----------------
orderId
amount
status
items
```

and:

```text
BEHAVIOR
----------------
place()
cancel()
calculateTotal()
updateStatus()
```

Now objects can interact:

```text
User
  │
  │ adds
  ↓
Product
  │
  ↓
Cart
  │
  │ checkout
  ↓
Order
  │
  ↓
Payment
  │
  ↓
Delivery
```

This is the kind of system OOP helps me model.

---

# 7. Real-World Example — Udemy

Suppose I'm designing Udemy.

I can identify:

```text
Student
Instructor
Course
Lecture
Quiz
Review
Certificate
Payment
```

A `Course` could have:

```text
STATE
----------------
courseName
price
instructor
students
lectures
rating
```

and:

```text
BEHAVIOR
----------------
addLecture()
removeLecture()
enrollStudent()
calculateRating()
```

A `Student` could have:

```text
STATE
----------------
name
email
enrolledCourses
progress
```

and:

```text
BEHAVIOR
----------------
enroll()
watchLecture()
takeQuiz()
writeReview()
```

Now I'm no longer just thinking about variables.

I'm designing a **system of objects that interact with each other**.

---

# 8. So What Is an Object?

Now the word "object" makes more sense.

An object represents an **actual entity inside my running program**.

For example:

```text
Netflix
   ↓
User
   ↓
Vivek's User Object
```

or:

```text
Amazon
   ↓
Product
   ↓
iPhone Product Object
```

or:

```text
Udemy
   ↓
Course
   ↓
Java Course Object
```

An object has its own state and behavior.

So:

```text
OBJECT
  │
  ├── STATE
  │
  └── BEHAVIOR
```

---

# 9. Then What Is a Class?

Now I need a way to define what these objects should look like.

That's where a **class** comes in.

I can think of a class as a blueprint or model.

For example:

```java
class Student {

    String name;
    int age;
    double cgpa;

    void study() {
        System.out.println("Studying...");
    }
}
```

I'm basically telling Java:

> "A Student object should have these pieces of data and this behavior."

The class itself is the **definition/model**.

The actual object comes later.

So:

```text
CLASS
  ↓
Blueprint / Model

OBJECT
  ↓
Actual instance
```

---

# 10. Class vs Object — My Mental Model

A real-world analogy helps.

Suppose I have a house blueprint.

```text
          HOUSE BLUEPRINT
                 │
       ┌─────────┼─────────┐
       ↓         ↓         ↓
     House 1   House 2   House 3
```

The blueprint describes the structure.

The actual houses exist separately.

Similarly:

```text
             STUDENT CLASS
            (Blueprint)
                  │
        ┌─────────┼─────────┐
        ↓         ↓         ↓
      Vivek     Rahul      Aman
      Object    Object     Object
```

The class defines the structure.

The objects are actual instances created from that structure.

---

# 11. Where Memory Comes Into the Picture

This is where I want to develop a different way of learning Java.

When I see:

```java
Student s1 = new Student();
```

I don't want to simply memorize:

> "This creates an object."

I want to ask:

> **Where is the object?**

> **What is `s1`?**

> **What does `new` actually do?**

> **Where does the object's data live?**

> **How does Java connect `s1` to the object?**

For now, I'll use this simplified mental model:

```text
STACK
┌─────────────────┐
│ s1              │
│                 │
│ reference ──────┼──────────────┐
└─────────────────┘              │
                                 ↓
                              HEAP
                         ┌───────────────┐
                         │ Student       │
                         │ Object        │
                         │               │
                         │ name          │
                         │ age           │
                         │ cgpa          │
                         └───────────────┘
```

The important thing I should understand already is:

> **`s1` is not the object itself.**

It is a **reference** that refers to the object.

I'll go much deeper into this in Lesson 2.

---

# 12. Connecting This to Netflix + Memory

Suppose Netflix has a Java class:

```java
class User {

    String name;
    String email;
}
```

And somewhere in the program:

```java
User vivek = new User();
```

My simplified mental picture becomes:

```text
STACK
┌─────────────────────┐
│ vivek               │
│       │             │
└───────┼─────────────┘
        │
        │ reference
        ↓
HEAP
┌────────────────────────┐
│ User Object            │
│                        │
│ name                   │
│ email                  │
└────────────────────────┘
```

If Netflix creates another user:

```java
User rahul = new User();
```

I now conceptually have:

```text
STACK                         HEAP

┌───────────────┐             ┌───────────────┐
│ vivek ────────┼────────────→│ User Object 1 │
└───────────────┘             │ Vivek         │
                              └───────────────┘

┌───────────────┐             ┌───────────────┐
│ rahul ────────┼────────────→│ User Object 2 │
└───────────────┘             │ Rahul         │
                              └───────────────┘
```

This is the beginning of understanding how a real application can have many objects existing at runtime.

---

# 13. Why OOP Helps Me With Large Applications

Now I can see the bigger picture.

Imagine Amazon.

Without proper organization, I'd have huge amounts of:

```text
userName
productName
orderAmount
paymentStatus
deliveryAddress
...
```

But with OOP, I can model:

```text
User
Product
Cart
Order
Payment
Delivery
```

Each object has its own responsibility.

Then those objects communicate.

```text
             Amazon System
                  │
       ┌──────────┼──────────┐
       ↓          ↓          ↓
     User       Product     Order
       │                      │
       ↓                      ↓
     Cart  ─────────────→   Payment
                              │
                              ↓
                           Delivery
```

So OOP gives me a way to **break a huge problem into understandable entities**.

---

# 14. OOP Is Not Just "Put Everything in Classes"

This is something I want to remember early.

Just putting code inside classes doesn't automatically mean I've designed good OOP.

For example, I shouldn't create:

```text
Student
│
├── study()
├── giveExam()
├── processPayment()
├── sendEmail()
├── generateTimetable()
├── resizeImage()
└── calculateElectricityBill()
```

😂

This makes no sense.

I should instead ask:

> **Who should be responsible for this behavior?**

For example:

```text
Student
   ↓
study()

Payment
   ↓
processPayment()

EmailService
   ↓
sendEmail()

Timetable
   ↓
generateTimetable()
```

This idea of **responsibility** will become extremely important later when I start designing real OOP systems.

---

# 15. The Four Pillars — Just the Big Picture

Eventually I'm going to learn four major OOP principles:

```text
┌──────────────────────────┐
│           OOP            │
├──────────────────────────┤
│ Encapsulation            │
│ Inheritance              │
│ Polymorphism             │
│ Abstraction              │
└──────────────────────────┘
```

I don't need to memorize their definitions yet.

Instead, I should understand that they help me solve different problems when my object-oriented system becomes more complex.

I'll understand each one properly later.

---

# 16. My JavaScript Connection

Since I already know JavaScript OOP, I can use it as a bridge.

In JavaScript:

```javascript
class Student {

    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    study() {
        console.log("Studying...");
    }
}
```

Then:

```javascript
const s1 = new Student("Vivek", 20);
```

Java has the same broad idea:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void study() {
        System.out.println("Studying...");
    }
}
```

Then:

```java
Student s1 = new Student("Vivek", 20);
```

So I already understand an important idea from JavaScript:

```text
class
   ↓
new
   ↓
object
   ↓
constructor initializes it
```

But I should remember:

> **Java and JavaScript have important differences in how their object models work.**

I'll learn Java's model instead of assuming they're identical.

---

# 17. My First OOP + Memory Mental Model

At this stage, this is the picture I want in my head:

```text
                    CLASS
                 (Blueprint)
                      │
                      │ new
                      ↓
                    OBJECT
                      │
             ┌────────┴────────┐
             ↓                 ↓
           STATE            BEHAVIOR
             │                 │
          fields            methods
```

And at runtime:

```text
                  JVM
                   │
                   ↓
              Object created
                   │
                   ↓
                  HEAP
                   │
                   ↑
              reference
                   │
                 STACK
                   │
                   ↓
                  s1
```

I don't need to know every JVM implementation detail yet.

I just need to start separating:

```text
REFERENCE ≠ OBJECT
```

That's going to become extremely important.

---

# 18. The Biggest Mental Shift

Before OOP:

```text
"What steps should my program perform?"
```

After learning OOP:

```text
"What entities exist in my system?"
             ↓
"What does each entity know?"
             ↓
"What can each entity do?"
             ↓
"Who should be responsible for what?"
             ↓
"How do these objects interact?"
```

For example, in Amazon:

```text
User
 ↓
Cart
 ↓
Order
 ↓
Payment
 ↓
Delivery
```

In Netflix:

```text
User
 ↓
Subscription
 ↓
Movie / Series
 ↓
WatchHistory
```

In Udemy:

```text
Student
 ↓
Course
 ↓
Lecture
 ↓
Quiz
 ↓
Certificate
```

This is how I should start seeing applications.

---

# 🧠 What I Should Remember From Lesson 1

If I forget everything else, I should remember these:

```text
CLASS
↓
Blueprint / Model

OBJECT
↓
Actual instance

OBJECT
↓
STATE + BEHAVIOR

REFERENCE
↓
Refers to an object

OOP
↓
Model a system using objects
```

And the most important idea:

> **OOP isn't something I learn just because Java requires it. It is a way of organizing a large program so that the program's entities, data, behavior, responsibilities, and relationships are easier to understand and manage.**

---

# ❌ Things I Must Not Confuse

### Class ≠ Object

```text
Class  → blueprint
Object → actual instance
```

### Reference ≠ Object

```text
Reference → points/references to an object
Object    → actual runtime entity
```

### State ≠ Behavior

```text
State    → what the object has/knows
Behavior → what the object can do
```

### OOP ≠ Just Classes

```text
OOP =
Objects
+ State
+ Behavior
+ Responsibilities
+ Relationships
```

---

# 🧪 Self-Test

Before moving to Lesson 2, I should be able to explain these **without looking at my notes**.

### Q1.

Why did we need OOP in the first place?

### Q2.

What is the difference between state and behavior?

### Q3.

What is a class?

### Q4.

What is an object?

### Q5.

If I have:

```java
User vivek = new User();
User rahul = new User();
```

How many objects do I have?

How many references do I have?

### Q6.

In:

```java
User vivek = new User();
```

what is `vivek`?

### Q7.

If Netflix has 10 million users, do I need 10 million classes?

Why?

### Q8.

Why would `Payment` and `Student` usually be separate objects instead of putting everything inside one giant class?

### Q9.

What is the difference between:

```text
Class
Object
Reference
```

### Q10.

When I see:

```java
User vivek = new User();
```

can I visualize the reference and object separately?

If yes, draw the Stack → Heap diagram myself.

---

# 🚀 What Comes Next?

Now I understand **why objects exist**.

Next, I want to understand exactly **how Java creates them**.

The line I'll investigate is:

```java
Student s1 = new Student();
```

I don't want to memorize that this "creates an object."

I want to understand:

```text
What happens before new?
        ↓
What does new do?
        ↓
Where is the object created?
        ↓
Where is the reference?
        ↓
What happens in Stack?
        ↓
What happens in Heap?
        ↓
How does the JVM connect the reference to the object?
        ↓
How can multiple references/objects exist?
```

### Lesson 2 — Classes & Objects

**Goal:**

> **When I write `new Student()`, I should be able to visualize what is happening in memory instead of treating it as magic.**
