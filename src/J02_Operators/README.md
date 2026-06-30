# Operators in Java

## Introduction

Before a program can make decisions or perform calculations, it needs a way to manipulate data.

Imagine creating a calculator.

To calculate:

```
10 + 5
```

the computer needs to know what **+** means.

Similarly, if you're checking whether a user entered the correct password, the computer needs a way to compare two values.

These symbols like `+`, `-`, `==`, `&&`, and `=` are called **operators**.

Operators are one of the most frequently used features in Java. Almost every Java program uses operators.

---

# What is an Operator?

An operator is a symbol that performs an operation on one or more values.

Example:

```java
int sum = 10 + 5;
```

Here,

- `+` performs addition.
- `=` assigns the result to a variable.

---

# Types of Operators in Java

Java provides several categories of operators.

- Arithmetic Operators
- Assignment Operators
- Relational Operators
- Logical Operators
- Increment & Decrement Operators
- Ternary Operator

Let's understand each one.

---

# Arithmetic Operators

These operators perform mathematical calculations.

| Operator | Meaning |
|----------|---------|
| + | Addition |
| - | Subtraction |
| * | Multiplication |
| / | Division |
| % | Modulus (Remainder) |

Example

```java
int a = 20;
int b = 3;

System.out.println(a + b);
System.out.println(a - b);
System.out.println(a * b);
System.out.println(a / b);
System.out.println(a % b);
```

Output

```
23
17
60
6
2
```

Notice that integer division removes the decimal part.

---

# Assignment Operators

Assignment operators store values into variables.

Basic assignment:

```java
int x = 10;
```

Compound assignments:

```java
x += 5;
x -= 2;
x *= 3;
x /= 2;
x %= 2;
```

These are shortcuts for writing shorter and cleaner code.

Example:

```java
x += 5;
```

is the same as

```java
x = x + 5;
```

---

# Relational Operators

These operators compare two values.

The result is always either

```
true
```

or

```
false
```

| Operator | Meaning |
|----------|---------|
| == | Equal to |
| != | Not Equal |
| > | Greater Than |
| < | Less Than |
| >= | Greater Than or Equal |
| <= | Less Than or Equal |

Example

```java
System.out.println(10 > 5);
System.out.println(10 == 5);
```

Output

```
true
false
```

---

# Logical Operators

Logical operators combine multiple conditions.

| Operator | Meaning |
|----------|---------|
| && | AND |
| \|\| | OR |
| ! | NOT |

Example

```java
int age = 20;
boolean hasLicense = true;

System.out.println(age >= 18 && hasLicense);
```

Output

```
true
```

---

# Increment and Decrement Operators

Increment increases a value by one.

```java
x++;
```

Decrement decreases a value by one.

```java
x--;
```

Example

```java
int x = 5;

x++;

System.out.println(x);
```

Output

```
6
```

---

# Prefix vs Postfix

Postfix

```java
x++
```

Use the value first, then increase it.

Prefix

```java
++x
```

Increase first, then use the value.

Example

```java
int x = 5;

System.out.println(x++);
System.out.println(x);
```

Output

```
5
6
```

---

# Ternary Operator

The ternary operator is a short form of an if-else statement.

Syntax

```java
condition ? value1 : value2;
```

Example

```java
int age = 20;

String result = age >= 18 ? "Adult" : "Minor";

System.out.println(result);
```

Output

```
Adult
```

---

# Operator Precedence

Java follows mathematical precedence rules.

Example

```java
System.out.println(5 + 2 * 3);
```

Output

```
11
```

because multiplication happens before addition.

Use parentheses to make expressions clearer.

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

inside conditions.

Forgetting that integer division removes decimals.

Misunderstanding `&&` and `||`.

Confusing prefix and postfix increment.

---

# Summary

You learned:

- Arithmetic Operators
- Assignment Operators
- Relational Operators
- Logical Operators
- Increment & Decrement
- Ternary Operator
- Operator Precedence

Operators are the building blocks of calculations and decision-making in Java.