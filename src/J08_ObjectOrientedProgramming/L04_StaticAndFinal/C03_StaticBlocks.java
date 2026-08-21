package J08_ObjectOrientedProgramming.L04_StaticAndFinal;

class Library {

    String bookName;
    int bookId;

    static String libraryName;

    static {

        libraryName = "City Central Library";

        System.out.println("Library information initialized.");
    }

    Library(String bookName, int bookId) {

        this.bookName = bookName;
        this.bookId = bookId;
    }

    void displayBookDetails() {

        System.out.println("Book: " + this.bookName);
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Library: " + Library.libraryName);
        System.out.println();
    }
}

public class C03_StaticBlocks {

    public static void main(String[] args) {

        Library book1 = new Library("Java Programming", 101);

        Library book2 = new Library("Database Systems", 102);

        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}

/*
 A static block is used for class-level initialization.

 It runs when the class is initialized,
 before the main code uses the class.


 FLOW

     Library class is initialized
              ↓
        static block runs
              ↓
     libraryName is initialized
              ↓
        main() continues
              ↓
     Library objects are created


 The static block:

     static {

         libraryName = "City Central Library";
     }

 initializes the static variable only once.


 WHY STATIC?

 libraryName belongs to the Library class.

 Every Library object uses the same library name.


 MEMORY PERSPECTIVE

     Library Class
          |
          ├── libraryName
          |
          └── static block
                 ↓
          initializes libraryName


     Heap

     book1 → Library Object
             bookName = "Java Programming"
             bookId = 101

     book2 → Library Object
             bookName = "Database Systems"
             bookId = 102


 The static variable is shared by both objects.


 IMPORTANT

 The static block does NOT run every time
 I create a new Library object.

 It runs when the class is initialized.


 SIMPLE RULE

     static variable
          ↓
     One shared class-level value

     static block
          ↓
     One-time class-level initialization
*/