# Conditionals in Java

## Introduction

Imagine you're building an ATM.

If the user enters the correct PIN,

allow access.

Otherwise,

show an error.

How does the computer decide which action to perform?

It uses **conditional statements**.

Conditionals allow a program to make decisions based on different situations.

Without conditionals, every program would execute the same instructions regardless of the input.

---

# What is a Conditional?

A conditional is a programming statement that allows the program to execute different blocks of code depending on whether a condition is true or false.

Think of it like asking a question.

```
Is the condition true?

Yes → Execute one block

No → Execute another block
```

---

# if Statement

The simplest conditional is the `if` statement.

Syntax

```java
if (condition) {

    // code

}
```

Example

```java
int age = 20;

if (age >= 18) {
    System.out.println("You can vote.");
}
```

Since the condition is true, the message is printed.

---

# if-else Statement

When there are only two possible outcomes, use `if-else`.

Example

```java
int age = 15;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

Only one block executes.

---

# else-if Ladder

Sometimes there are more than two possibilities.

Example

```java
int marks = 85;

if (marks >= 90) {
    System.out.println("Grade A");
}
else if (marks >= 80) {
    System.out.println("Grade B");
}
else if (marks >= 70) {
    System.out.println("Grade C");
}
else {
    System.out.println("Fail");
}
```

Java checks each condition from top to bottom.

As soon as one condition is true, the remaining conditions are skipped.

---

# Nested if Statements

An if statement can exist inside another if statement.

Example

```java
int age = 20;
boolean hasLicense = true;

if (age >= 18) {

    if (hasLicense) {
        System.out.println("You may drive.");
    }

}
```

Nested conditionals are useful when multiple requirements must be satisfied.

---

# switch Statement

When checking one variable against many possible values, `switch` is often cleaner than many `else-if` statements.

Example

```java
int day = 3;

switch(day){

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid Day");

}
```

The `break` statement prevents execution from continuing into the next case.

---

# Logical Operators in Conditions

Conditions often use logical operators.

Example

```java
if(age >= 18 && hasLicense){

    System.out.println("Drive");

}
```

Both conditions must be true.

---

# Common Beginner Mistakes

Using

```java
=
```

instead of

```java
==
```

Missing braces for multiple statements.

Forgetting the `break` statement inside switch.

Writing impossible conditions.

Example

```java
if(age > 18 && age < 10)
```

This can never be true.

---

# Best Practices

Keep conditions simple.

Avoid deeply nested if statements whenever possible.

Use meaningful variable names.

Use switch when checking many values of the same variable.

---

# Real-World Uses

Conditionals are used in:

- Login Systems
- ATM Machines
- Online Shopping
- Banking Software
- Video Games
- Mobile Apps
- Hospital Systems
- Artificial Intelligence

Every application makes decisions using conditionals.

---

# Summary

You learned:

- if
- if-else
- else-if
- Nested if
- switch
- Logical conditions
- Common mistakes

## Final Thought

Programming is not just about performing calculations.

It is also about making decisions.

Conditionals give your programs the ability to think, react, and choose different paths based on different situations.