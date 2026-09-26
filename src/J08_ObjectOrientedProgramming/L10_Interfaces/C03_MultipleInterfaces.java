package J08_ObjectOrientedProgramming.L10_Interfaces;
/*
I am learning how a class can implement
more than one interface.

Each interface gives the class a different
set of responsibilities.
*/

interface Camera {

    void takePhoto();
}

interface MusicPlayer {

    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo.");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music.");
    }
}

public class C03_MultipleInterfaces {

    public static void main(String[] args) {

        /*
        Smartphone implements both interfaces.

        So the same object can provide
        both Camera and MusicPlayer behavior.
        */
        Smartphone phone = new Smartphone();

        phone.takePhoto();
        phone.playMusic();

        System.out.println();

        /*
        I can also use interface references.

        The reference type decides which
        interface behavior I can access.
        */
        Camera camera = phone;
        MusicPlayer musicPlayer = phone;

        camera.takePhoto();
        musicPlayer.playMusic();
    }
}