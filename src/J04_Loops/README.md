# Loops in Java

## Introduction

Imagine I ask you to print the word **Hello** five times.

One way is to write:

```java
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
```

This works.

But what if I ask you to print it **1,000 times?**

Would you write `System.out.println()` one thousand times?

Of course not.

This is exactly why loops exist.

A **loop** allows us to execute the same block of code repeatedly without writing it again and again.

Think of a loop as giving the computer an instruction like:

> "Keep doing this until I tell you to stop."

---

# What is a Loop?

A loop is a control structure that executes a block of code repeatedly as long as a given condition is true.

A loop always follows the same cycle:

```
Check Condition
      ↓
Condition is True?
      ↓
Execute Code
      ↓
Update Something
      ↓
Go Back and Check Again
```

When the condition becomes **false**, the loop stops.

---

# Why Do We Need Loops?

Loops help us avoid repetition.

Instead of writing:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

we simply write:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Both programs produce the same output, but the second one is much shorter, cleaner, and easier to maintain.

---

# Types of Loops in Java

Java provides three main loops.

- `for` loop
- `while` loop
- `do-while` loop

Each loop performs the same job—repeating code—but each is designed for a different situation.

---

# The for Loop

The **for loop** is the most commonly used loop.

Use it when you already know **how many times** something should repeat.

### Syntax

```java
for (initialization; condition; update) {

    // Code to repeat

}
```

At first, this syntax looks confusing, but it's actually made of only three parts.

---

## 1. Initialization

```java
int i = 1;
```

This creates the loop variable.

It runs **only once**, before the loop starts.

---

## 2. Condition

```java
i <= 5
```

Before every iteration, Java checks this condition.

If the condition is true, the loop continues.

If it becomes false, the loop ends.

---

## 3. Update

```java
i++
```

After each iteration, Java updates the loop variable.

Without this update, the condition may never become false, resulting in an infinite loop.

---

## Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

### Output

```
1
2
3
4
5
```

---

# Dry Run

Let's see what Java actually does.

### Initial Value

```
i = 1
```

Check:

```
1 <= 5
```

True.

Print:

```
1
```

Increase:

```
i becomes 2
```

Again:

```
2 <= 5
```

True.

Print:

```
2
```

This continues until:

```
i = 6
```

Now Java checks:

```
6 <= 5
```

False.

The loop immediately stops.

---

# The while Loop

A **while loop** is used when you **don't know how many times** the loop should execute.

### Syntax

```java
while (condition) {

    // Code

}
```

Example:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Output

```
1
2
3
4
5
```

Notice that unlike a `for` loop, we must create and update the variable ourselves.

---

# The do-while Loop

The **do-while loop** is almost the same as a while loop.

The difference is that it executes the code **before checking the condition**.

### Syntax

```java
do {

    // Code

} while (condition);
```

Example

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

Output

```
1
2
3
4
5
```

---

# What's Special About do-while?

Even if the condition is false initially, the loop still executes once.

Example:

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Output

```
10
```

This happens because Java checks the condition **after** executing the loop body.

---

# Which Loop Should You Use?

Use a **for loop** when the number of iterations is known.

Example:

- Print numbers from 1 to 100
- Print multiplication tables

Use a **while loop** when the number of iterations is unknown.

Example:

- Keep asking the user for a password until it is correct.
- Read data until the end of a file.

Use a **do-while loop** when the code must run at least once.

Example:

- Display a menu before asking whether the user wants to continue.

---

# Infinite Loops

An infinite loop is a loop that never ends.

Example:

```java
while (true) {
    System.out.println("Hello");
}
```

Since the condition is always true, this loop runs forever.

Another common mistake is forgetting to update the loop variable.

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

Since `i` never changes, the condition remains true forever.

---

# break Statement

The `break` statement immediately exits the loop.

Example:

```java
for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

Output

```
1
2
3
4
```

The loop stops as soon as `i` becomes `5`.

---

# continue Statement

The `continue` statement skips the current iteration and moves directly to the next one.

Example

```java
for (int i = 1; i <= 5; i++) {

    if (i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output

```
1
2
4
5
```

Notice that only the current iteration is skipped. The loop itself continues.

---

# Common Beginner Mistakes

### Forgetting to update the loop variable

```java
while (i <= 5) {

    System.out.println(i);

}
```

This creates an infinite loop.

---

### Using the wrong condition

```java
for (int i = 1; i >= 5; i++)
```

This loop never executes because the condition is already false.

---

### Off-by-One Error

```java
for (int i = 1; i < 5; i++)
```

Output

```
1
2
3
4
```

Many beginners expect `5` to be printed.

Remember:

- `<` means **less than**
- `<=` means **less than or equal to**

---

# Real-Life Uses of Loops

Loops are everywhere in programming.

They are used to:

- Process thousands of records in a database
- Read files line by line
- Display items in a shopping cart
- Create game loops
- Search through arrays
- Generate reports
- Train machine learning models
- Build animations
- Handle repeated user input

Almost every software application you use today contains hundreds or even thousands of loops.

---

# Summary

After reading this guide, you should understand:

- Why loops exist
- What a loop is
- How a loop works internally
- The difference between `for`, `while`, and `do-while`
- When to use each loop
- What `break` and `continue` do
- How infinite loops happen
- Common beginner mistakes

## Final Thought

Whenever you find yourself writing the same piece of code repeatedly, stop and ask yourself:

> **"Can I solve this using a loop?"**

Most of the time, the answer is **yes**.

Learning loops is one of the biggest milestones in programming because once you understand them, you can automate repetitive tasks and solve much more interesting problems.