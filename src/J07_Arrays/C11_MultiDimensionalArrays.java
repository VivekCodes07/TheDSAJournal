package J07_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class C11_MultiDimensionalArrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Initializes a 3x3 multi-dimensional array
        int[][] marks = new int[3][3];

        // Populating the array with user inputs
        for(int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            for(int j = 0; j < marks[i].length; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n--- Stored Marks Matrix ---");
        // Printing out the stored grid elements
        for(int i = 0; i < marks.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for(int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

/* =========================================================================
   DUDE, HERE IS HOW 2D ARRAYS ACTUALLY WORK (MY SECRET STUDY GUIDE)
   =========================================================================

   Okay, forget the word "Matrix" or "Grid". That's a trap.
   In Java, a 2D array is literally just an "Array that holds other Arrays".
   It’s a list of secret locations.

   -------------------------------------------------------------------------
   THE BEHIND-THE-SCENES MEMORY MAP
   -------------------------------------------------------------------------
   When you write `int[][] marks`, Java splits its brain into two parts:
   The Stack (Quick Notes) and The Heap (The Warehouse).

   THE STACK               THE HEAP (Where things actually live)
   ┌──────────┐           ┌──────────────────────────────────────────────┐
   │ marks  ──┼──────────>│ MASTER LIST (This is just a list of pointers)│
   └──────────┘           │ Total Rows (marks.length) = 3                │
                          ├──────────────────────────────────────────────┤
                          │ [0] ───> Points to Student 1's actual array  │
                          │ [1] ───> Points to Student 2's actual array  │
                          │ [2] ───> Points to Student 3's actual array  │
                          └──────────────────────────────────────────────┘
                                        │          │          │
         ┌──────────────────────────────┘          │          │
         │         ┌───────────────────────────────┘          │
         │         │         ┌────────────────────────────────┘
         ▼         ▼         ▼
       ┌────┬────┬────┐
 [0] ─>│ 85 │ 90 │ 78 │  <-- This is marks[0]. It has a length of 3 numbers.
       └────┴────┴────┘
       ┌────┬────┬────┐
 [1] ─>│ 92 │ 88 │ 95 │  <-- This is marks[1]. It has a length of 3 numbers.
       └────┴────┴────┘
       ┌────┬────┬────┐
 [2] ─>│ 70 │ 82 │ 80 │  <-- This is marks[2]. It has a length of 3 numbers.
       └────┴────┴────┘
         ▲    ▲    ▲
         │    │    │
        [0]  [1]  [2]   <-- This is the inner 'j' index tracking the marks!

   -------------------------------------------------------------------------
   BREAKING DOWN THE DRUID TALK (WHAT THE CODE SYMBOLS MEAN)
   -------------------------------------------------------------------------

   * marks
     -> The master key. It just points to the Master List.

   * marks.length
     -> "Hey, how many students are in the Master List?"
     -> Answer: 3. (This controls the outer loop).

   * marks[i]
     -> This means: "Go to the Master List, find row 'i', and follow the path
        to that specific student's personal array."

   * marks[i].length
     -> "Hey, look at Student 'i's personal array. How many marks are inside it?"
     -> Answer: 3. (This controls the inner loop).

   * marks[i][j]
     -> The holy grail. The exact spot where the actual number (like 92) sits.

   -------------------------------------------------------------------------
   THE "AHA!" MOMENT: WHY THIS MATTERS
   -------------------------------------------------------------------------
   Because Java rows are just independent arrays floating around, they don't
   even have to be the same size! You can have a "Jagged Array" where Student 1
   has 2 marks, and Student 2 has 5 marks.

   If we used hardcoded numbers like `j < 3`, a dynamic or uneven array would
   instantly crash our program with an out-of-bounds error.
   Using `marks[i].length` acts like an automatic safety net that checks the
   exact size of the row we are standing on before we touch it!
============================================================================ */