# 🧠 Java Arrays — Teaching Myself from the Memory POV

> **My goal:** I don't want to just know how to write arrays in Java.
> I want to understand what is actually happening when I create an array, access an element, copy an array, pass it to a method, and work with multidimensional arrays.
>
> If I understand the memory model, the syntax becomes easy.

---

# 01. First, Why Do I Even Need an Array?

Let me imagine I have the marks of 5 students.

Without an array, I could do this:

```java
int mark1 = 78;
int mark2 = 85;
int mark3 = 91;
int mark4 = 67;
int mark5 = 88;
```

This works.

But what if I have **10,000 students?**

Am I really going to create:

```text
mark1
mark2
mark3
...
mark10000
```

Obviously not.

So I need a way to say:

> "Java, give me one structure where I can store many values of the same type."

That's what an **array** gives me.

```java
int[] marks = {78, 85, 91, 67, 88};
```

Now I have one array instead of hundreds or thousands of separate variables.

---

# 02. My First Mental Picture of an Array

Whenever I hear **array**, I should imagine a row of boxes.

```text
          marks
            │
            ▼
      ┌────┬────┬────┬────┬────┐
      │ 78 │ 85 │ 91 │ 67 │ 88 │
      └────┴────┴────┴────┴────┘
        0    1    2    3    4
```

Each box contains one value.

Each box has an **index**.

So:

```java
marks[0]   → 78
marks[1]   → 85
marks[2]   → 91
```

The easiest way for me to remember this:

> **Index tells me which box I want.**

---

# 03. Why Does Java Start at 0?

This confused me when I first learned arrays.

Why not:

```text
1, 2, 3, 4, 5
```

Why:

```text
0, 1, 2, 3, 4
```

The memory-friendly way to think about it is:

> The first element is at an offset of **0** from the beginning of the array.

So:

```text
First element  → offset 0
Second element → offset 1
Third element  → offset 2
```

Therefore:

```text
index = position/offset from the beginning
```

I don't need to calculate actual memory addresses myself. The JVM handles that.

I just need to remember:

> **The first index is always 0.**

---

# 04. The Most Important Array Rule

Suppose:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

There are **5 elements**.

So:

```java
numbers.length
```

is:

```text
5
```

But the indexes are:

```text
0   1   2   3   4
```

Therefore:

```text
last index = length - 1
```

For this array:

```text
last index = 5 - 1
           = 4
```

So:

```java
numbers[4]
```

is valid.

But:

```java
numbers[5]
```

is invalid.

### I should permanently remember:

> **Size tells me HOW MANY elements exist.**
>
> **Index tells me WHICH element I want.**

---

# 05. `int[] arr` — What Does This Actually Mean?

This is where I need to stop thinking like a beginner.

If I write:

```java
int[] arr;
```

I should NOT think:

> "I created an array."

No.

I only created a **reference variable** capable of referring to an integer array.

At this moment, no array object has been created.

Conceptually:

```text
Stack

arr
 │
 ▼
null
```

So:

```java
int[] arr;
```

means:

> "I have a variable named `arr` that can refer to an `int` array."

---

# 06. Then What Does `new int[5]` Do?

Now I write:

```java
arr = new int[5];
```

Now Java actually creates an array object.

Conceptually:

```text
Stack                         Heap

arr ───────────────────────► [0][0][0][0][0]
```

So I can break:

```java
int[] arr = new int[5];
```

into:

```text
int[]    → what type of array can arr refer to?
arr      → name of my reference variable
new      → create a new object
int[5]   → array containing 5 integers
```

This distinction is VERY important.

---

# 07. The Memory Model I Need to Remember

For learning purposes, I should visualize Java like this:

```text
             JAVA MEMORY

        STACK                HEAP
          │                    │
          │                    │
       arr │─────────────────► │
          │                    ▼
          │              ┌───┬───┬───┬───┐
          │              │ 0 │ 0 │ 0 │ 0 │
          │              └───┴───┴───┴───┘
```

The important thing isn't memorizing every JVM implementation detail.

The important thing is:

> **The variable `arr` refers to an array object.**

So when I write:

```java
arr[2]
```

I'm basically saying:

> "Go to the array referred to by `arr` and give me the element at index 2."

---

# 08. Primitive Variable vs Array Variable

This is where the difference becomes clearer.

If I write:

```java
int age = 20;
```

I can mentally think:

```text
age → 20
```

But:

```java
int[] numbers = {10, 20, 30};
```

is more like:

```text
numbers ─────► [10][20][30]
```

So I need to remember:

> A normal primitive variable stores a primitive value.
>
> An array variable stores a **reference to an array object**.

This is why arrays behave differently from simple `int`, `double`, `char`, etc.

---

# 09. The Biggest "Aha!" Moment — Copying an Array

Suppose I write:

```java
int[] a = {10, 20, 30};

int[] b = a;
```

At first, I might think:

```text
a → [10][20][30]

b → [10][20][30]
```

That would mean two arrays.

But NO.

What actually happens is:

```text
a ─────────┐
           ▼
       [10][20][30]
           ▲
b ─────────┘
```

There is only **one array**.

I have simply made another reference point to the same array.

So I should remember:

> **`b = a` does NOT copy the array.**
>
> **It copies the reference.**

This is one of the most important things about arrays in Java.

---

# 10. Let Me Prove It to Myself

```java
int[] a = {10, 20, 30};

int[] b = a;

b[0] = 999;

System.out.println(a[0]);
```

What will I get?

```text
999
```

Why?

Because:

```text
a ─────────┐
           ▼
       [999][20][30]
           ▲
b ─────────┘
```

I changed the array through `b`.

But `a` is pointing to that **same array**.

Therefore:

```java
a[0]
```

also gives:

```text
999
```

---

# 11. So How Do I Actually Copy an Array?

If I want two separate arrays, I need to create another array object.

For example:

```java
int[] a = {10, 20, 30};

int[] b = new int[3];

for (int i = 0; i < a.length; i++) {
    b[i] = a[i];
}
```

Now:

```text
a ─────► [10][20][30]

b ─────► [10][20][30]
```

Looks the same.

But they're actually **two different objects**.

So:

```java
b[0] = 999;
```

gives:

```text
a ─────► [10][20][30]

b ─────► [999][20][30]
```

Now changing `b` doesn't affect `a`.

Later, I can use:

```java
Arrays.copyOf()
```

or other techniques to make copying easier.

---

# 12. What Happens When I Pass an Array to a Method?

This is another place where the reference model saves me.

Suppose:

```java
static void change(int[] arr) {
    arr[0] = 999;
}
```

And:

```java
int[] numbers = {10, 20, 30};

change(numbers);
```

I should imagine:

```text
main()

numbers ─────────┐
                 ▼
             [10][20][30]
                 ▲
                 │
method()         │
arr ─────────────┘
```

The method gets a **copy of the reference**.

So both references point to the same array.

Therefore:

```java
arr[0] = 999;
```

changes the same array.

---

# 13. Java Is Pass-by-Value

This is important:

> **Java is ALWAYS pass-by-value.**

When I pass an array:

```java
change(numbers);
```

Java passes a **copy of the reference value**.

It does NOT pass the original `numbers` variable itself.

That's why this works:

```java
arr[0] = 999;
```

but this doesn't change what `numbers` refers to:

```java
arr = new int[]{7, 8, 9};
```

---

# 14. The Method Reassignment Trap

Consider:

```java
static void change(int[] arr) {

    arr[0] = 999;

    arr = new int[]{7, 8, 9};

    arr[0] = 1000;
}
```

Suppose:

```java
int[] numbers = {10, 20, 30};

change(numbers);
```

Initially:

```text
numbers ─────┐
             ▼
         [10][20][30]
             ▲
             │
arr ─────────┘
```

After:

```java
arr[0] = 999;
```

we have:

```text
numbers ─────┐
             ▼
         [999][20][30]
             ▲
             │
arr ─────────┘
```

Then:

```java
arr = new int[]{7, 8, 9};
```

Now the method's reference changes:

```text
numbers ─────► [999][20][30]


arr ─────────► [7][8][9]
```

So:

```java
arr[0] = 1000;
```

changes:

```text
[1000][8][9]
```

But `numbers` still points to:

```text
[999][20][30]
```

### My mental rule:

> **Changing the object through the reference affects the object.**
>
> **Changing the reference itself only changes that local reference.**

---

# 15. What If My Array Reference Is `null`?

```java
int[] numbers = null;
```

Now:

```text
numbers ───► null
```

There is no array object.

So this:

```java
numbers[0]
```

makes no sense.

Java throws:

```text
NullPointerException
```

because I'm trying to access something through a reference that points to nothing.

---

# 16. Why Is Array Access So Fast?

Suppose:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

and I want:

```java
numbers[4]
```

I don't have to manually search:

```text
10 → 20 → 30 → 40 → 50
```

The array provides indexed access.

So:

```java
numbers[index]
```

is generally:

```text
O(1)
```

This means the access time doesn't grow linearly with the number of elements.

This is one of the reasons arrays are so important in DSA.

---

# 17. But Arrays Have a Weakness

Arrays are fixed-size.

If I create:

```java
int[] numbers = new int[5];
```

I get exactly 5 slots.

I cannot simply make that same array become:

```text
[10][20][30][40][50][60]
```

If I need a bigger array, I need a new array and then copy the data.

That's one reason Java provides structures such as:

```java
ArrayList
```

which can dynamically grow.

So my mental comparison is:

```text
Array
→ fixed size
→ very fast indexed access

ArrayList
→ dynamic size
→ built using array-based ideas internally
```

---

# 18. Now Let's Go One Level Deeper — 2D Arrays

Now that I understand references, multidimensional arrays become MUCH easier.

Suppose I write:

```java
int[][] matrix = {
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};
```

I might initially imagine one giant box:

```text
┌────┬────┬────┐
│ 10 │ 20 │ 30 │
├────┼────┼────┤
│ 40 │ 50 │ 60 │
├────┼────┼────┤
│ 70 │ 80 │ 90 │
└────┴────┴────┘
```

That's useful for visualizing the data.

But the **Java memory model** is more interesting.

---

# 19. A 2D Array Is Basically an Array of Arrays

Think:

```text
matrix
   │
   ▼
┌────────┬────────┬────────┐
│ row 0  │ row 1  │ row 2  │
│ ref    │ ref    │ ref    │
└───┬────┴───┬────┴───┬────┘
    │        │        │
    ▼        ▼        ▼
 [10][20][30]
 [40][50][60]
 [70][80][90]
```

So I should think:

> **A 2D array is an array whose elements are references to other arrays.**

This explains a LOT.

---

# 20. Why Do I Use Two Indexes?

Because:

```java
matrix
```

points to an array of rows.

Then each row points to another array.

So:

```java
matrix[i][j]
```

means:

> First go to row `i`, then go to index `j` inside that row.

Example:

```java
matrix[1][2]
```

First:

```text
row 1
```

Then:

```text
index 2
```

So:

```text
        0    1    2
     ┌────┬────┬────┐
  0  │ 10 │ 20 │ 30 │
     ├────┼────┼────┤
  1  │ 40 │ 50 │ 60 │
     ├────┼────┼────┤
  2  │ 70 │ 80 │ 90 │
     └────┴────┴────┘

matrix[1][2] → 60
```

---

# 21. Creating a 2D Array

```java
int[][] matrix = new int[3][4];
```

I should read this as:

> "Create an array containing 3 rows, and each row contains 4 integers."

Conceptually:

```text
matrix
   │
   ▼
 row references

┌──────────┐
│ row 0 ───┼──► [0][0][0][0]
├──────────┤
│ row 1 ───┼──► [0][0][0][0]
├──────────┤
│ row 2 ───┼──► [0][0][0][0]
└──────────┘
```

Therefore:

```java
matrix.length
```

means:

> How many rows do I have?

Answer:

```text
3
```

And:

```java
matrix[0].length
```

means:

> How many elements are in row 0?

Answer:

```text
4
```

---

# 22. The Cool Part — Jagged Arrays

Because each row is actually its own array, the rows don't have to be the same size.

For example:

```java
int[][] numbers = {
    {10, 20},
    {30, 40, 50},
    {60}
};
```

This is completely valid.

Memory mental model:

```text
numbers
   │
   ├────► [10][20]
   │
   ├────► [30][40][50]
   │
   └────► [60]
```

So:

```java
numbers[0].length → 2
numbers[1].length → 3
numbers[2].length → 1
```

This is called a **jagged array**.

---

# 23. Traversing a 2D Array

This is the standard pattern:

```java
for (int i = 0; i < matrix.length; i++) {

    for (int j = 0; j < matrix[i].length; j++) {

        System.out.println(matrix[i][j]);

    }
}
```

I should think:

```text
i → which row?
j → which element inside that row?
```

So:

```java
matrix[i][j]
```

means:

> Go to row `i`, then go to position `j` inside that row.

---

# 24. Why `matrix[i].length`?

Suppose:

```java
int[][] matrix = {
    {10, 20},
    {30, 40, 50},
    {60}
};
```

If I use:

```java
matrix[0].length
```

everywhere, I am assuming every row has the same length.

But that's not guaranteed.

Instead:

```java
matrix[i].length
```

asks:

> "How long is THIS particular row?"

So this is the safer traversal:

```java
for (int i = 0; i < matrix.length; i++) {

    for (int j = 0; j < matrix[i].length; j++) {

        System.out.print(matrix[i][j] + " ");

    }

    System.out.println();
}
```

---

# 25. 3D Arrays — Don't Let the Syntax Scare Me

I can keep extending the same idea.

```java
int[][][] data;
```

I don't need to memorize some complicated definition.

I just think:

```text
Array
  ↓
arrays
  ↓
arrays
  ↓
values
```

And:

```java
data[x][y][z]
```

means:

> Go through three levels of arrays until I reach the actual value.

The same reference concept is still underneath everything.

---

# 26. The Big Connection

Now I can see something important.

A normal array:

```java
int[] arr
```

means:

```text
reference → array of ints
```

A 2D array:

```java
int[][] arr
```

means:

```text
reference
    ↓
array of references
    ↓
arrays of ints
```

A 3D array:

```java
int[][][] arr
```

means:

```text
reference
    ↓
array of references
    ↓
arrays of references
    ↓
arrays of ints
```

So multidimensional arrays aren't some completely different feature.

They're just **arrays built using the same reference concept again and again.**

---

# 27. My Final Mental Model

If I see:

```java
int[] arr = new int[5];
```

I should immediately think:

```text
Reference
    │
    ▼
Array Object
[0][0][0][0][0]
```

If I see:

```java
int[] b = arr;
```

I should think:

```text
arr ──────┐
          ▼
        ARRAY
          ▲
b ────────┘
```

If I see:

```java
arr[index]
```

I should think:

> "Access one element."

If I see:

```java
int[][] matrix
```

I should think:

```text
matrix
   │
   ▼
array of row references
   │
   ├──► row array
   ├──► row array
   └──► row array
```

If I see:

```java
matrix[i][j]
```

I should think:

> "First choose the row, then choose an element inside that row."

---

# 🔥 What I Actually Need to Remember

I don't need to memorize 50 definitions.

These are the important ideas:

### 1.

> **An array is an object.**

### 2.

> **The array variable is a reference to that object.**

### 3.

> **Array indexes start at 0.**

### 4.

> **Last index = `length - 1`.**

### 5.

> **Array size is fixed after creation.**

### 6.

> **`arr[index]` gives me direct indexed access.**

### 7.

> **`int[] b = a` copies the reference, not the array.**

### 8.

> **Java passes the reference value by value when an array is passed to a method.**

### 9.

> **A 2D array is essentially an array of references to other arrays.**

### 10.

> **Jagged arrays are possible because each row is a separate array.**

---

# 🧠 The One Picture I Want to Remember

```text
                    JAVA ARRAYS
                         │
                         ▼
                ┌────────────────┐
                │ Reference      │
                │ Variable       │
                └───────┬────────┘
                        │
                        ▼
                  Array Object
                ┌───┬───┬───┬───┐
                │10 │20 │30 │40 │
                └───┴───┴───┴───┘
                  0   1   2   3
                        │
                        │
               ┌────────┴────────┐
               │                 │
             arr[2]          arr.length
               │                 │
               ▼                 ▼
              30                 4
```

And for multidimensional arrays:

```text
                    matrix
                       │
                       ▼
              Array of References
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
       Row 0         Row 1        Row 2
          │            │            │
          ▼            ▼            ▼
      [10][20]     [30][40][50]   [60]
```

---

# 🚀 Final Self-Test

Before I move on to DSA, I should be able to answer these **without running code**:

### Q1

What is the difference between:

```java
int[] arr;
```

and:

```java
int[] arr = new int[5];
```

---

### Q2

If:

```java
int[] a = {10, 20, 30};
int[] b = a;
```

how many array objects exist?

---

### Q3

What happens here?

```java
b[0] = 999;
```

What will `a[0]` contain?

---

### Q4

Why doesn't this create a copy?

```java
int[] b = a;
```

---

### Q5

What does this mean?

```java
arr = new int[]{7, 8, 9};
```

Does it change the caller's reference when done inside a method?

---

### Q6

Why does:

```java
matrix[i][j]
```

need two indexes?

---

### Q7

Why is this valid?

```java
int[][] arr = {
    {1, 2},
    {3, 4, 5},
    {6}
};
```

---

### Q8

What's the difference between:

```java
matrix.length
```

and:

```java
matrix[i].length
```

---

# 🏁 My Final Takeaway

> **I don't want to think of an array as just a bunch of values.**
>
> I want to think:
>
> **"I have a reference variable pointing to an array object. That object contains indexed elements. If I copy the reference, I get another way to reach the same object. A multidimensional array simply takes this reference idea one level further by storing references to other arrays."**
>
> Once I understand this, arrays stop being a syntax topic and become a **memory + reference topic**.
>
> And THAT is the understanding I want to carry into DSA.
