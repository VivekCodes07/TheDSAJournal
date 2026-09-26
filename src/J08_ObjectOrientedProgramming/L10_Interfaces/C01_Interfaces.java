package J08_ObjectOrientedProgramming.L10_Interfaces;
/*
I am learning the basic structure of an interface.

The interface defines WHAT should be done.
The implementing class defines HOW it should be done.

Here Printable is the common contract,
and Document provides the actual implementation.
*/

interface Printable {

    void print();

    void preview();
}

class Document implements Printable {

    @Override
    public void print() {
        System.out.println("Printing the document...");
    }

    @Override
    public void preview() {
        System.out.println("Showing document preview...");
    }
}

public class C01_Interfaces {

    public static void main(String[] args) {

        /*
        Document implements Printable,
        so it must provide implementations
        for all methods defined in Printable.
        */
        Document document = new Document();

        document.print();
        document.preview();
    }
}