package polymorphism.music3;

import polymorphism.music.Note;

import static access.util.Print.print;

class Instrument{
    void play(Note n) {
        print("Instrument.play() " + n);
    }
    String what() {
        return "Instrument";
    }

    void adjust() {
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument{
    @Override
    void play(Note n) {
        print("Wind.play() " + n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        print("Adjusing Percussion");
    }

    void play(Note n) {
        print("Percussion.play() " + n);
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    String what() {
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
    void adjust() {
        print("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        print("Woodwind.play() " + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}
public class Music3 {
    //Doesn't care about type,so new types
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
        //Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };

        tuneAll(orchestra);
    }
}
