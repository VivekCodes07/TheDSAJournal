package J08_ObjectOrientedProgramming.L09_Polymorphism;

class Animal {

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {

    // Dog provides its own version of makeSound().
    @Override
    void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {

    // Cat provides its own version of makeSound().
    @Override
    void makeSound() {
        System.out.println("Cat meows.");
    }
}

public class C02_MethodOverriding {

    public static void main(String[] args) {

        // Parent reference pointing to a Dog object.
        Animal dog = new Dog();

        // Parent reference pointing to a Cat object.
        Animal cat = new Cat();

        dog.makeSound();
        cat.makeSound();

        /*
        METHOD OVERRIDING

        The parent class defines:

            makeSound()

        The child classes provide their own
        implementations of the same method.

        Here:

            Animal dog = new Dog();

        Reference type → Animal
        Object type    → Dog

        So:

            dog.makeSound()
                    ↓
            Dog.makeSound()


        And:

            Animal cat = new Cat();

            cat.makeSound()
                    ↓
            Cat.makeSound()


        The same method call gives different
        behavior depending on the actual object.

        This decision happens at runtime.

        So:

            Method Overriding
                    ↓
            Runtime Polymorphism
        */
    }
}