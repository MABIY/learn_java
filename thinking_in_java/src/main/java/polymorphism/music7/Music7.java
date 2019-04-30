package polymorphism.music7;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Add a new Instrument to Music3.java and verify that polymorphism works for
 * your new type.
 **/
class Instrument{
    void play(Note n) {
        print("Instrument.play() " + n);
    }

    @Override
    public String toString() {
        return "Instrument";
    }

    void adjust() {
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        print("Wind.play()" + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        print("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        print("Adjusitng Percussion");
    }
}

class Stringed extends Instrument{
    @Override
    void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        print("Adjusting Keyboard");

    }
}
class Keyboard extends Instrument {
    @Override
    void play(Note n) {
        print("Keyboard.play() " + n);
    }

    @Override
    public String toString() {
        return "Keyboard";
    }

    @Override
    void adjust() {
        print("Adjusting Brass");
    }
}

class Brass extends Wind{
    @Override
    void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass";
    }

    @Override
    void adjust() {
        print("Adjusting Brass");
    }
}

class Woodwind extends Wind{
    @Override
    void play(Note n) {
        print("Woodwind.play() "+ n);
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}

class Piano extends Keyboard {
    @Override
    void play(Note n) {
        print("Piano.play() " + n);
    }

    @Override
    public String toString() {
        return "Piano";
    }
}
public class Music7 {
    //Doesn't care about type ,so new types
    //added to the system still work right:
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
                new Piano()
        };
        tuneAll(orchestra);
        for (Instrument i : orchestra) {
            System.out.println(i);
        }
    }
}
