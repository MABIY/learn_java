package polymorphism;

import polymorphism.music.Note;

import static access.util.Print.print;

class Instrument {
    void play(Note n) {
        print("Instrument.play() " + n);
    }

    @Override
    public String toString() {
        return "Instrument{}";
    }

    void adjust() {
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        print("Wind.play() " +n);
    }

    @Override
    public String toString() {
        return "Wind{}";
    }
}

class Percussion extends Instrument {
    @Override
    public String toString() {
        return "Percussion{}";
    }

    @Override
    void play(Note n) {
        print("Percussion.play() " +n);
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        print("Stringed.play() " +n);
    }

    @Override
    public String toString() {
        return "Stringed{}";
    }
}

class Brass extends Wind{
    void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public String toString() {
        return "Brass{}";
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        print("Woodwind.play() " + n);
    }

    @Override
    public String toString() {
        return "Woodwind{}";
    }
}
public class E06_MusicToString {
    static Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
    };

    public static void printAll(Instrument[] orch) {
        for (Instrument i : orch) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printAll(orchestra);
    }
}
