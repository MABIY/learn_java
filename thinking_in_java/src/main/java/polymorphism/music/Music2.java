package polymorphism.music;


import static access.util.Print.print;

class Stringed extends Instrument{
    @Override
    public void play(Note n) {
        print("Stringed.paly() " + n);
    }
}

class Brass extends Instrument{
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }
}
public class Music2 {
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Brass i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute); // no upcasting
        tune(violin);
        tune(frenchHorn);
    }
}
