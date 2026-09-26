package J08_ObjectOrientedProgramming.L10_Interfaces;
/*
I am learning the difference between a class reference
and an interface reference.

The reference type decides what I can access.
The actual object decides which implementation runs.
*/

interface Animal {

    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks.");
    }

    public void fetch() {
        System.out.println("Dog is fetching.");
    }
}

class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("Cat meows.");
    }
}

public class C02_InterfaceReferences {

    public static void main(String[] args) {

        /*
        Class reference:

        Reference type -> Dog
        Actual object  -> Dog

        So I can access both the interface method
        and the Dog-specific method.
        */
        Dog dog = new Dog();

        dog.sound();
        dog.fetch();

        System.out.println();

        /*
        Interface reference:

        Reference type -> Animal
        Actual object  -> Dog

        Now I can access only the behavior
        defined by Animal.
        */
        Animal animal = new Dog();

        animal.sound();

        System.out.println();

        /*
        The same interface reference type
        can point to different objects.

        The method that runs depends on
        the actual object.
        */
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.sound();
        animal2.sound();
    }
}