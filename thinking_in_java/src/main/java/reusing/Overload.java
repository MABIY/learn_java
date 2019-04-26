package reusing;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a class with a method that is overloaded three times. Inherit a new
 * class, add a new overloading of the method, and show that all four methods are
 * available in the derived class.
 **/
class ThreeWay{
    void number(byte b) {
        print(b);
    }

    void number(short s) {
        print(s);
    }

    void number(int i) {
        print(i);
    }
}

public class Overload extends ThreeWay {
    void number(float f) {
        print(f);
    }

    public static void main(String[] args) {
        Overload ov = new Overload();
        ov.number((byte)0);
        ov.number((short)1);
        ov.number(2);
        ov.number(3.0f);
    }
}
