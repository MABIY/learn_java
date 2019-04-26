package reusing;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Overloading a base-class method name in a deirved
 * class does not hide the base-class version
 **/
class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}
public class Hider {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
