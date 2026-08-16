# 🧠 Java Methods (Functions) — My Memory Notes

> **Goal:** Never memorize methods like a definition. Always visualize what happens in memory.

---

# What is a Method?

A method is a **named piece of logic** that Java executes whenever I call it.

Instead of writing the same code repeatedly, I write it once and reuse it.

Think of it like a **machine**.

```text
Input → Method → Processing → Output
```

Example:

```java
static int add(int a, int b){
    return a + b;
}
```

The method takes two numbers, adds them, and gives the answer back.

---

# The Anatomy of a Method

```java
static int add(int a, int b){
    return a + b;
}
```

Break it apart.

```text
static       int       add      (int a, int b)
  │           │         │             │
  │           │         │             └── Parameters
  │           │         └──────────────── Method Name
  │           └────────────────────────── Return Type
  └────────────────────────────────────── Modifier
```

Inside the braces is the **method body**, where the actual work happens.

---

# The Most Important Memory Rule

Whenever a method is called,

> **Java creates a new Stack Frame.**

Every method gets its own temporary memory.

Example:

```java
public class Main{

    static int add(int a,int b){
        return a+b;
    }

    public static void main(String[] args){

        int result=add(10,20);

        System.out.println(result);
    }
}
```

### Memory Visualization

Before calling `add()`:

```text
STACK

┌────────────────────┐
│ main()             │
│ result             │
└────────────────────┘
```

During `add(10,20)`:

```text
STACK

┌────────────────────┐
│ add()              │
│ a = 10             │
│ b = 20             │
├────────────────────┤
│ main()             │
│ result             │
└────────────────────┘
```

After `return 30`:

```text
STACK

┌────────────────────┐
│ main()             │
│ result = 30        │
└────────────────────┘
```

The `add()` frame disappears.

> Every method creates its own temporary memory and destroys it after finishing.

---

# Parameters vs Arguments

I should never confuse these.

Method:

```java
static int add(int a,int b)
```

`a` and `b` are **Parameters**.

Call:

```java
add(10,20);
```

`10` and `20` are **Arguments**.

Memory:

```text
Parameters

a → 10
b → 20
```

Easy rule:

| Parameter | Argument |
|------------|----------|
| Variable inside method | Actual value passed |
| Empty box | Value inside box |

---

# The Four Types of Methods

I only need to remember two questions.

- Does it take input?
- Does it return output?

## Type 1 — No Input, No Return

```java
static void greet(){
    System.out.println("Hello");
}
```

Simply performs an action.

---

## Type 2 — Input, No Return

```java
static void greet(String name){
    System.out.println("Hello "+name);
}
```

Receives information but doesn't return anything.

---

## Type 3 — No Input, Return

```java
static int getNumber(){
    return 10;
}
```

Returns a value without needing input.

---

## Type 4 — Input and Return ⭐

```java
static int multiply(int a,int b){
    return a*b;
}
```

This is the most common type.

---

# Understanding `void`

`void` means:

> This method performs work but gives nothing back.

Example:

```java
static void printMessage(){
    System.out.println("Done");
}
```

Correct:

```java
printMessage();
```

Wrong:

```java
int x=printMessage();
```

Why?

Because `printMessage()` returns nothing.

---

# Understanding `return`

`return` has two jobs.

1. Sends a value back.
2. Immediately ends the method.

Example:

```java
static int square(int n){
    return n*n;
}
```

Memory:

```text
square(5)

n=5

5×5=25

return 25
```

After returning,

the method completely exits.

Wrong example:

```java
return 10;
        System.out.println("Hello");
```

The print statement never executes.

---

# Local Variables Live Inside Their Method

Example:

```java
static int add(int a,int b){

    int sum=a+b;

    return sum;
}
```

Memory:

```text
add()

a=10
b=20
sum=30
```

After returning,

`a`, `b`, and `sum` disappear.

They belong only to that method call.

Think of a method as a room.

```text
┌──────────────────────┐
│ add()                │
│                      │
│ sum = 30             │
│                      │
└──────────────────────┘
```

Variables inside cannot be accessed from outside.

---

# Scope

Scope simply means,

> Where a variable is allowed to exist.

Example:

```java
static void test(){
    int x=10;
}
```

This is wrong.

```java
System.out.println(x);
```

Why?

Because `x` exists only inside `test()`.

---

# Methods Calling Methods

Methods can build bigger logic by calling other methods.

Example:

```java
static int square(int n){
    return n*n;
}

static int calculate(int x){
    return square(x)+10;
}
```

Memory:

```text
main()

↓

calculate()

↓

square()

↓

return 25

↓

calculate()

25+10=35

↓

return 35
```

This chaining becomes extremely important in DSA.

---

# The Call Stack

Every method call is placed on the stack.

Example:

```text
main()

↓

methodA()

↓

methodB()
```

Memory:

```text
        STACK

┌──────────────┐
│ methodB()    │
├──────────────┤
│ methodA()    │
├──────────────┤
│ main()       │
└──────────────┘
```

When `methodB()` finishes,

```text
        STACK

┌──────────────┐
│ methodA()    │
├──────────────┤
│ main()       │
└──────────────┘
```

This follows **LIFO**.

> Last In, First Out.

Imagine stacking plates.

```text
Top

[methodB]

[methodA]

[main]
```

The last plate placed is removed first.

---

# Static Methods

Most beginner methods look like this.

```java
static void hello(){}
```

For now,

I only need one memory rule.

> `static` means the method belongs to the class, so `main()` can call it directly.

Example:

```java
class Main{

    static void hello(){
        System.out.println("Hello");
    }

    public static void main(String[] args){
        hello();
    }
}
```

Both `main()` and `hello()` belong to the same class.

---

# Methods and Arrays

A method can receive an entire array.

Example:

```java
static int findMax(int[] arr){

    int max=arr[0];

    for(int i=1;i<arr.length;i++){

        if(arr[i]>max){
            max=arr[i];
        }

    }

    return max;
}
```

Call:

```java
int[] numbers={10,40,20,90,30};

int max=findMax(numbers);
```

Memory:

```text
numbers

      │
      ▼

┌────┬────┬────┬────┬────┐
│10  │40  │20  │90  │30  │
└────┴────┴────┴────┴────┘
          ▲
         arr
```

The method receives a reference to the same array.

---

# Methods and Strings

Strings can also be passed.

```java
static void greet(String name){
    System.out.println("Hello "+name);
}
```

Call:

```java
greet("Vivek");
```

Memory:

```text
name

↓

"Vivek"
```

Output:

```text
Hello Vivek
```

---

# Common Beginner Mistakes

### Forgetting `return`

Wrong:

```java
static int add(int a,int b){
    a+b;
}
```

Correct:

```java
return a+b;
```

---

### Returning from a `void` method

Wrong:

```java
static void greet(){
    return 10;
}
```

`void` methods cannot return a value.

---

### Using local variables outside their scope

Wrong:

```java
static void test(){
    int x=5;
}

System.out.println(x);
```

`x` no longer exists.

---

### Mixing Parameters and Arguments

Method:

```java
add(int a,int b)
```

Call:

```java
add(5,10)
```

Remember:

- `a,b` → Parameters
- `5,10` → Arguments

---

# My Memory Cheat Code

Whenever I read a method,

I ask these five questions.

```text
1. What is its name?

↓

2. What does it receive?

↓

3. What memory (stack frame) gets created?

↓

4. What work happens inside?

↓

5. What gets returned?
```

Example:

```java
static int multiply(int a,int b){

    int result=a*b;

    return result;
}
```

My brain should automatically visualize this.

```text
main()

↓

multiply(5,4)

↓

Stack Frame

a=5
b=4
result=20

↓

return 20

↓

Stack Frame disappears

↓

main receives 20
```

---

# The One Diagram I Should Never Forget

```text
                 main()

                   │

                   │ calls

                   ▼

        ┌────────────────────┐
        │ multiply(5,4)       │
        │                     │
        │ a=5                 │
        │ b=4                 │
        │ result=20           │
        │                     │
        │ return 20           │
        └────────────────────┘

                   │

                   ▼

            main receives 20
```

---

# One-Line Revision

- A method is a named block of reusable logic.
- Every method call creates a new stack frame.
- Parameters receive arguments.
- `void` performs work but returns nothing.
- `return` sends a value back and immediately exits the method.
- Local variables exist only inside their method.
- The call stack follows **LIFO (Last In, First Out)**.
- `static` methods belong to the class and can be called directly from `main()`.
- Arrays and Strings can be passed to methods.
- Always visualize memory instead of memorizing definitions.