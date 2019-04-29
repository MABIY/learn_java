package polymorphism.music6;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Change Music3.java so that what() become the root Object method toString().
 * Try printing the Instrument objects System.out.println() without any casting.
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
    void play(Note n) {
        print("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }
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
        print("Adjusting Percussion");
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
        print("Adjusting Stringed");
    }
}

class Brass extends Wind {
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

class WoodWind extends Wind{
    @Override
    void play(Note n) {
        print("Woodwind.play() "+ n);
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}
public class Music6 {
    //Doesn't care about type, so new types
    // added to the system still work right:
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
                new WoodWind()
        };
        tuneAll(orchestra);
        for (Instrument i : orchestra) {
            System.out.println(i);
        }

    }
}

