package polymorphism.music8;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Music3.java so that is randomly creates Instrument objects the way
 * Shapes.java dose
 **/

class Instrument {
    void play(Note n) {
        print("INstrument.play() " + n);
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
        print("Wind.play() " + n);
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
        print("Adjusting Stringed");
    }
}

class Stringed extends Instrument {
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
        print("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        print("Adjusting Brass");
    }
}

class Brass extends Wind {
    @Override
    void adjust() {
        print("Adjusting Brass");
    }

    @Override
    void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        print("Woodwind.play() " + n);
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

public class Music8 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    private static RandomInstrumentGenerator gen = new RandomInstrumentGenerator();

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = new Instrument[20];
        // fill up orchestra array with instruments:
        for (int i = 0; i < orchestra.length; i++) {
            orchestra[i] = gen.next();
        }
        tuneAll(orchestra);
        for (Instrument i : orchestra) {
            System.out.println(i);
        }
    }
}
