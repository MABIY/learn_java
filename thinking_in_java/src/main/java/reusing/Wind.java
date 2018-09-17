package reusing;

class Instrument{
     void play() {
    }

    static void tun(Instrument i) {
        i.play();
    }
}

//Wind objects are instruments
//because they have the same  interface
public class Wind extends Instrument {

    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tun(flute); //Upcasting
    }
}
