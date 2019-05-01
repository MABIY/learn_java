package interfaces.music10;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Music5.java by adding a Playable interface. Move the play() declaration
 * from Instrument to Playable. Add Playable to the derived classes by including
 * it in the implements list. Change tune() so that it takes a Playable instead of
 * and Instrument
 **/

interface Instrument {
    // Compile-time constant
    int VALUE = 5; // static and final and public

    // Cannot have method definitions
    void adjust();

}

interface Playable {
    void play(Note n); // Automatically public
}

class Wind implements Instrument, Playable {
    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }
}

class Percussion implements Instrument, Playable {
    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    public void play(Note n) {
        print(this +".play()" + n);
    }
}

class Stringed implements Instrument, Playable {
    @Override
    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwing";
    }
}
public class Music10 {
    // Doesn't care about type ,so new types
    // added to the system will work right:
    static void tune(Playable p) {
        p.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) {
        for (Playable p : e) {
            tune(p);
        }
    }

    public static void main(String[] args) {
        //Upcasting during addition to the array:
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
