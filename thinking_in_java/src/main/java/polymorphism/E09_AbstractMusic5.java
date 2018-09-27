package polymorphism;

import polymorphism.music.Note;

import static access.util.Print.print;

abstract class Instrument9 {
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    public void adjust() {
        print(this + ".adjust()");
    }

    @Override
    public abstract String toString();
}

class Wind9 extends Instrument9{
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion9 extends Instrument9{
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed9 extends Instrument9 {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass9 extends Wind9 {
    @Override
    public String toString() {
        return "Brass9";
    }
}

class Woodwind9 extends Wind9 {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class E09_AbstractMusic5 {
    static void tune(Instrument9 i) {
        i.adjust();
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument9[] e) {
        for (Instrument9 i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument9[] orchestra = {
                new Wind9(),
                new Percussion9(),
                new Stringed9(),
                new Brass9(),
                new Woodwind9()
        };

        tuneAll(orchestra);
    }
}
