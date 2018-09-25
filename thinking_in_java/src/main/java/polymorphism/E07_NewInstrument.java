package polymorphism;

import polymorphism.music.Note;

import static access.util.Print.print;

class Electronic extends Instrument {
    @Override
    void play(Note n) {
        print("Electronic.play() " + n);
    }

    @Override
    public String toString() {
        return "Electronic{}";
    }
}
public class E07_NewInstrument {
    static Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind(),
            new Electronic()
    };

    public static void main(String[] args) {
        for (Instrument i : orchestra) {
            i.play(Note.MIDDLE_C);
            i.adjust();
            print(i);
        }
    }
}
