package typeinfo1;

interface Instrument{
    void play();

    String what();

    void adjust();

    void prepareInstrument();
}

class Wind implements Instrument {
    @Override
    public void play() {
        System.out.println("Wind.play()");
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {
    }

    public void clearSpitValue() {
        System.out.println("Wind.clearSpitValue");
    }
    @Override
    public void prepareInstrument() {
        clearSpitValue();
    }
}

class Percussion implements Instrument {
    @Override
    public void play() {
        System.out.println("Percussion.play()");
    }

    @Override
    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {

    }

    @Override
    public void prepareInstrument() {
        System.out.println("Percussion.prepareInstrument");
    }
}

class Stringed implements Instrument {
    @Override
    public void play() {
        System.out.println("Stringed.play()");
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {

    }

    @Override
    public void prepareInstrument() {
        System.out.println("Stringed.prepareInstrument");
    }
}

class Brass extends Wind {
    @Override
    public void play() {
        System.out.println("Brass.play()");
    }

    @Override
    public void adjust() {
        System.out.println("Brass.adjust()");
    }

    @Override
    public void clearSpitValue() {
        System.out.println("Brass.clearSpitValue");
    }
}

class Woodwind extends Wind {
    @Override
    public void play() {
        System.out.println("Woodwind.play()");
    }

    @Override
    public String what() {
        return "Woodwind";
    }

    @Override
    public void clearSpitValue() {
        System.out.println("Woodwind.clearSpitValue");
    }
}

class Music5 {
    static void tune(Instrument i) {
        i.play();
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument instrument : e) {
            tune(instrument);
        }
    }

    static void prepareAll(Instrument[] e) {
        for (Instrument instrument : e) {
            instrument.prepareInstrument();
        }
    }
}
public class E26_ClearSpitValve {
    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(), new Percussion(),
                new Stringed(), new Brass(),
                new Woodwind()
        };

        Music5.prepareAll(orchestra);
        Music5.tuneAll(orchestra);
    }
}
